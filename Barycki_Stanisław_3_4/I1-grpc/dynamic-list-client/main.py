import grpc
from grpc_reflection.v1alpha import reflection_pb2, reflection_pb2_grpc
from google.protobuf import descriptor_pb2, descriptor_pool, message_factory, empty_pb2


def fetch_file_descriptors(channel, symbol, pool):
    stub = reflection_pb2_grpc.ServerReflectionStub(channel)
    req = reflection_pb2.ServerReflectionRequest(file_containing_symbol=symbol)
    for resp in stub.ServerReflectionInfo(iter([req])):
        for fd_proto in resp.file_descriptor_response.file_descriptor_proto:
            pool.Add(descriptor_pb2.FileDescriptorProto.FromString(fd_proto))


def main():
    channel = grpc.insecure_channel('localhost:50051')

    pool = descriptor_pool.Default()
    fetch_file_descriptors(channel, 'dynamic.ListManager', pool)

    AddDigitReq = message_factory.GetMessageClass(
        pool.FindMessageTypeByName('dynamic.AddDigitRequest'))
    AddNumberReq = message_factory.GetMessageClass(
        pool.FindMessageTypeByName('dynamic.AddNumberRequest'))
    ListResp = message_factory.GetMessageClass(
        pool.FindMessageTypeByName('dynamic.ListResponse'))
    OperationReq = message_factory.GetMessageClass(
        pool.FindMessageTypeByName('dynamic.OperationRequest'))
    OperationResp = message_factory.GetMessageClass(
        pool.FindMessageTypeByName('dynamic.OperationResponse'))
    ListElem = message_factory.GetMessageClass(
        pool.FindMessageTypeByName('dynamic.ListElement'))

    add_digit = channel.unary_unary(
        '/dynamic.ListManager/AddDigitToList',
        request_serializer=AddDigitReq.SerializeToString,
        response_deserializer=ListResp.FromString
    )

    add_digit_stream = channel.stream_unary(
        '/dynamic.ListManager/AddDigitToListStream',
        request_serializer=AddDigitReq.SerializeToString,
        response_deserializer=ListResp.FromString
    )
    add_number = channel.unary_unary(
        '/dynamic.ListManager/AddNumberToEach',
        request_serializer=AddNumberReq.SerializeToString,
        response_deserializer=ListResp.FromString
    )
    compute = channel.unary_unary(
        '/dynamic.ListManager/Compute',
        request_serializer=OperationReq.SerializeToString,
        response_deserializer=OperationResp.FromString
    )
    stream_list = channel.unary_stream(
        '/dynamic.ListManager/StreamList',
        request_serializer=empty_pb2.Empty.SerializeToString,
        response_deserializer=ListElem.FromString
    )

    print("==== AddDigitToList (single) test ====")
    resp = add_digit(AddDigitReq(digit=5))
    print("--> Lista =", resp.elements)
    resp = add_digit(AddDigitReq(digit=2))
    print("--> Lista =", resp.elements)

    print("==== AddDigitToListStream (stream) ====")

    def gen_digits():
        for d in [7, 9, 3]:
            print("--> Wysyłam:", d)
            yield AddDigitReq(digit=d)

    final = add_digit_stream(gen_digits())
    print("--> Końcowa lista:", final.elements)

    print("==== AddNumberToEach ====")
    resp = add_number(AddNumberReq(number=3))
    print("--> Po dodaniu 3:", resp.elements)

    print("==== Compute ====")
    ops = {'SUM': 0, 'MIN': 1, 'MAX': 2, 'AVG': 3}
    for name, code in ops.items():
        r = compute(OperationReq(op=code))
        print(f"  {name} =", r.result)

    print("==== StreamList (server-stream) ====")
    for elem in stream_list(empty_pb2.Empty()):
        print("->", elem.value)


if __name__ == '__main__':
    main()
