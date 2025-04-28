package dynamic;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.71.0)",
    comments = "Source: dynamic-list.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class ListManagerGrpc {

  private ListManagerGrpc() {}

  public static final java.lang.String SERVICE_NAME = "dynamic.ListManager";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<dynamic.DynamicList.AddDigitRequest,
      dynamic.DynamicList.ListResponse> getAddDigitToListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddDigitToList",
      requestType = dynamic.DynamicList.AddDigitRequest.class,
      responseType = dynamic.DynamicList.ListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dynamic.DynamicList.AddDigitRequest,
      dynamic.DynamicList.ListResponse> getAddDigitToListMethod() {
    io.grpc.MethodDescriptor<dynamic.DynamicList.AddDigitRequest, dynamic.DynamicList.ListResponse> getAddDigitToListMethod;
    if ((getAddDigitToListMethod = ListManagerGrpc.getAddDigitToListMethod) == null) {
      synchronized (ListManagerGrpc.class) {
        if ((getAddDigitToListMethod = ListManagerGrpc.getAddDigitToListMethod) == null) {
          ListManagerGrpc.getAddDigitToListMethod = getAddDigitToListMethod =
              io.grpc.MethodDescriptor.<dynamic.DynamicList.AddDigitRequest, dynamic.DynamicList.ListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddDigitToList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamic.DynamicList.AddDigitRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamic.DynamicList.ListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ListManagerMethodDescriptorSupplier("AddDigitToList"))
              .build();
        }
      }
    }
    return getAddDigitToListMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dynamic.DynamicList.AddDigitRequest,
      dynamic.DynamicList.ListResponse> getAddDigitToListStreamMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddDigitToListStream",
      requestType = dynamic.DynamicList.AddDigitRequest.class,
      responseType = dynamic.DynamicList.ListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<dynamic.DynamicList.AddDigitRequest,
      dynamic.DynamicList.ListResponse> getAddDigitToListStreamMethod() {
    io.grpc.MethodDescriptor<dynamic.DynamicList.AddDigitRequest, dynamic.DynamicList.ListResponse> getAddDigitToListStreamMethod;
    if ((getAddDigitToListStreamMethod = ListManagerGrpc.getAddDigitToListStreamMethod) == null) {
      synchronized (ListManagerGrpc.class) {
        if ((getAddDigitToListStreamMethod = ListManagerGrpc.getAddDigitToListStreamMethod) == null) {
          ListManagerGrpc.getAddDigitToListStreamMethod = getAddDigitToListStreamMethod =
              io.grpc.MethodDescriptor.<dynamic.DynamicList.AddDigitRequest, dynamic.DynamicList.ListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddDigitToListStream"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamic.DynamicList.AddDigitRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamic.DynamicList.ListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ListManagerMethodDescriptorSupplier("AddDigitToListStream"))
              .build();
        }
      }
    }
    return getAddDigitToListStreamMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dynamic.DynamicList.AddNumberRequest,
      dynamic.DynamicList.ListResponse> getAddNumberToEachMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "AddNumberToEach",
      requestType = dynamic.DynamicList.AddNumberRequest.class,
      responseType = dynamic.DynamicList.ListResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dynamic.DynamicList.AddNumberRequest,
      dynamic.DynamicList.ListResponse> getAddNumberToEachMethod() {
    io.grpc.MethodDescriptor<dynamic.DynamicList.AddNumberRequest, dynamic.DynamicList.ListResponse> getAddNumberToEachMethod;
    if ((getAddNumberToEachMethod = ListManagerGrpc.getAddNumberToEachMethod) == null) {
      synchronized (ListManagerGrpc.class) {
        if ((getAddNumberToEachMethod = ListManagerGrpc.getAddNumberToEachMethod) == null) {
          ListManagerGrpc.getAddNumberToEachMethod = getAddNumberToEachMethod =
              io.grpc.MethodDescriptor.<dynamic.DynamicList.AddNumberRequest, dynamic.DynamicList.ListResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "AddNumberToEach"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamic.DynamicList.AddNumberRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamic.DynamicList.ListResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ListManagerMethodDescriptorSupplier("AddNumberToEach"))
              .build();
        }
      }
    }
    return getAddNumberToEachMethod;
  }

  private static volatile io.grpc.MethodDescriptor<dynamic.DynamicList.OperationRequest,
      dynamic.DynamicList.OperationResponse> getComputeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "Compute",
      requestType = dynamic.DynamicList.OperationRequest.class,
      responseType = dynamic.DynamicList.OperationResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<dynamic.DynamicList.OperationRequest,
      dynamic.DynamicList.OperationResponse> getComputeMethod() {
    io.grpc.MethodDescriptor<dynamic.DynamicList.OperationRequest, dynamic.DynamicList.OperationResponse> getComputeMethod;
    if ((getComputeMethod = ListManagerGrpc.getComputeMethod) == null) {
      synchronized (ListManagerGrpc.class) {
        if ((getComputeMethod = ListManagerGrpc.getComputeMethod) == null) {
          ListManagerGrpc.getComputeMethod = getComputeMethod =
              io.grpc.MethodDescriptor.<dynamic.DynamicList.OperationRequest, dynamic.DynamicList.OperationResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "Compute"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamic.DynamicList.OperationRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamic.DynamicList.OperationResponse.getDefaultInstance()))
              .setSchemaDescriptor(new ListManagerMethodDescriptorSupplier("Compute"))
              .build();
        }
      }
    }
    return getComputeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      dynamic.DynamicList.ListElement> getStreamListMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "StreamList",
      requestType = com.google.protobuf.Empty.class,
      responseType = dynamic.DynamicList.ListElement.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.google.protobuf.Empty,
      dynamic.DynamicList.ListElement> getStreamListMethod() {
    io.grpc.MethodDescriptor<com.google.protobuf.Empty, dynamic.DynamicList.ListElement> getStreamListMethod;
    if ((getStreamListMethod = ListManagerGrpc.getStreamListMethod) == null) {
      synchronized (ListManagerGrpc.class) {
        if ((getStreamListMethod = ListManagerGrpc.getStreamListMethod) == null) {
          ListManagerGrpc.getStreamListMethod = getStreamListMethod =
              io.grpc.MethodDescriptor.<com.google.protobuf.Empty, dynamic.DynamicList.ListElement>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "StreamList"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  com.google.protobuf.Empty.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  dynamic.DynamicList.ListElement.getDefaultInstance()))
              .setSchemaDescriptor(new ListManagerMethodDescriptorSupplier("StreamList"))
              .build();
        }
      }
    }
    return getStreamListMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ListManagerStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ListManagerStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ListManagerStub>() {
        @java.lang.Override
        public ListManagerStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ListManagerStub(channel, callOptions);
        }
      };
    return ListManagerStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports all types of calls on the service
   */
  public static ListManagerBlockingV2Stub newBlockingV2Stub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ListManagerBlockingV2Stub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ListManagerBlockingV2Stub>() {
        @java.lang.Override
        public ListManagerBlockingV2Stub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ListManagerBlockingV2Stub(channel, callOptions);
        }
      };
    return ListManagerBlockingV2Stub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ListManagerBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ListManagerBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ListManagerBlockingStub>() {
        @java.lang.Override
        public ListManagerBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ListManagerBlockingStub(channel, callOptions);
        }
      };
    return ListManagerBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ListManagerFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ListManagerFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ListManagerFutureStub>() {
        @java.lang.Override
        public ListManagerFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ListManagerFutureStub(channel, callOptions);
        }
      };
    return ListManagerFutureStub.newStub(factory, channel);
  }

  /**
   */
  public interface AsyncService {

    /**
     */
    default void addDigitToList(dynamic.DynamicList.AddDigitRequest request,
        io.grpc.stub.StreamObserver<dynamic.DynamicList.ListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddDigitToListMethod(), responseObserver);
    }

    /**
     */
    default io.grpc.stub.StreamObserver<dynamic.DynamicList.AddDigitRequest> addDigitToListStream(
        io.grpc.stub.StreamObserver<dynamic.DynamicList.ListResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getAddDigitToListStreamMethod(), responseObserver);
    }

    /**
     */
    default void addNumberToEach(dynamic.DynamicList.AddNumberRequest request,
        io.grpc.stub.StreamObserver<dynamic.DynamicList.ListResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getAddNumberToEachMethod(), responseObserver);
    }

    /**
     */
    default void compute(dynamic.DynamicList.OperationRequest request,
        io.grpc.stub.StreamObserver<dynamic.DynamicList.OperationResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getComputeMethod(), responseObserver);
    }

    /**
     */
    default void streamList(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<dynamic.DynamicList.ListElement> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getStreamListMethod(), responseObserver);
    }
  }

  /**
   * Base class for the server implementation of the service ListManager.
   */
  public static abstract class ListManagerImplBase
      implements io.grpc.BindableService, AsyncService {

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return ListManagerGrpc.bindService(this);
    }
  }

  /**
   * A stub to allow clients to do asynchronous rpc calls to service ListManager.
   */
  public static final class ListManagerStub
      extends io.grpc.stub.AbstractAsyncStub<ListManagerStub> {
    private ListManagerStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ListManagerStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ListManagerStub(channel, callOptions);
    }

    /**
     */
    public void addDigitToList(dynamic.DynamicList.AddDigitRequest request,
        io.grpc.stub.StreamObserver<dynamic.DynamicList.ListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddDigitToListMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<dynamic.DynamicList.AddDigitRequest> addDigitToListStream(
        io.grpc.stub.StreamObserver<dynamic.DynamicList.ListResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getAddDigitToListStreamMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public void addNumberToEach(dynamic.DynamicList.AddNumberRequest request,
        io.grpc.stub.StreamObserver<dynamic.DynamicList.ListResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getAddNumberToEachMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void compute(dynamic.DynamicList.OperationRequest request,
        io.grpc.stub.StreamObserver<dynamic.DynamicList.OperationResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getComputeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void streamList(com.google.protobuf.Empty request,
        io.grpc.stub.StreamObserver<dynamic.DynamicList.ListElement> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getStreamListMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   * A stub to allow clients to do synchronous rpc calls to service ListManager.
   */
  public static final class ListManagerBlockingV2Stub
      extends io.grpc.stub.AbstractBlockingStub<ListManagerBlockingV2Stub> {
    private ListManagerBlockingV2Stub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ListManagerBlockingV2Stub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ListManagerBlockingV2Stub(channel, callOptions);
    }

    /**
     */
    public dynamic.DynamicList.ListResponse addDigitToList(dynamic.DynamicList.AddDigitRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddDigitToListMethod(), getCallOptions(), request);
    }

    /**
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<dynamic.DynamicList.AddDigitRequest, dynamic.DynamicList.ListResponse>
        addDigitToListStream() {
      return io.grpc.stub.ClientCalls.blockingClientStreamingCall(
          getChannel(), getAddDigitToListStreamMethod(), getCallOptions());
    }

    /**
     */
    public dynamic.DynamicList.ListResponse addNumberToEach(dynamic.DynamicList.AddNumberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddNumberToEachMethod(), getCallOptions(), request);
    }

    /**
     */
    public dynamic.DynamicList.OperationResponse compute(dynamic.DynamicList.OperationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getComputeMethod(), getCallOptions(), request);
    }

    /**
     */
    @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/10918")
    public io.grpc.stub.BlockingClientCall<?, dynamic.DynamicList.ListElement>
        streamList(com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingV2ServerStreamingCall(
          getChannel(), getStreamListMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do limited synchronous rpc calls to service ListManager.
   */
  public static final class ListManagerBlockingStub
      extends io.grpc.stub.AbstractBlockingStub<ListManagerBlockingStub> {
    private ListManagerBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ListManagerBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ListManagerBlockingStub(channel, callOptions);
    }

    /**
     */
    public dynamic.DynamicList.ListResponse addDigitToList(dynamic.DynamicList.AddDigitRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddDigitToListMethod(), getCallOptions(), request);
    }

    /**
     */
    public dynamic.DynamicList.ListResponse addNumberToEach(dynamic.DynamicList.AddNumberRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getAddNumberToEachMethod(), getCallOptions(), request);
    }

    /**
     */
    public dynamic.DynamicList.OperationResponse compute(dynamic.DynamicList.OperationRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getComputeMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<dynamic.DynamicList.ListElement> streamList(
        com.google.protobuf.Empty request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getStreamListMethod(), getCallOptions(), request);
    }
  }

  /**
   * A stub to allow clients to do ListenableFuture-style rpc calls to service ListManager.
   */
  public static final class ListManagerFutureStub
      extends io.grpc.stub.AbstractFutureStub<ListManagerFutureStub> {
    private ListManagerFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ListManagerFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ListManagerFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dynamic.DynamicList.ListResponse> addDigitToList(
        dynamic.DynamicList.AddDigitRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddDigitToListMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dynamic.DynamicList.ListResponse> addNumberToEach(
        dynamic.DynamicList.AddNumberRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getAddNumberToEachMethod(), getCallOptions()), request);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<dynamic.DynamicList.OperationResponse> compute(
        dynamic.DynamicList.OperationRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getComputeMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_DIGIT_TO_LIST = 0;
  private static final int METHODID_ADD_NUMBER_TO_EACH = 1;
  private static final int METHODID_COMPUTE = 2;
  private static final int METHODID_STREAM_LIST = 3;
  private static final int METHODID_ADD_DIGIT_TO_LIST_STREAM = 4;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final AsyncService serviceImpl;
    private final int methodId;

    MethodHandlers(AsyncService serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_DIGIT_TO_LIST:
          serviceImpl.addDigitToList((dynamic.DynamicList.AddDigitRequest) request,
              (io.grpc.stub.StreamObserver<dynamic.DynamicList.ListResponse>) responseObserver);
          break;
        case METHODID_ADD_NUMBER_TO_EACH:
          serviceImpl.addNumberToEach((dynamic.DynamicList.AddNumberRequest) request,
              (io.grpc.stub.StreamObserver<dynamic.DynamicList.ListResponse>) responseObserver);
          break;
        case METHODID_COMPUTE:
          serviceImpl.compute((dynamic.DynamicList.OperationRequest) request,
              (io.grpc.stub.StreamObserver<dynamic.DynamicList.OperationResponse>) responseObserver);
          break;
        case METHODID_STREAM_LIST:
          serviceImpl.streamList((com.google.protobuf.Empty) request,
              (io.grpc.stub.StreamObserver<dynamic.DynamicList.ListElement>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_DIGIT_TO_LIST_STREAM:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.addDigitToListStream(
              (io.grpc.stub.StreamObserver<dynamic.DynamicList.ListResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  public static final io.grpc.ServerServiceDefinition bindService(AsyncService service) {
    return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
        .addMethod(
          getAddDigitToListMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              dynamic.DynamicList.AddDigitRequest,
              dynamic.DynamicList.ListResponse>(
                service, METHODID_ADD_DIGIT_TO_LIST)))
        .addMethod(
          getAddDigitToListStreamMethod(),
          io.grpc.stub.ServerCalls.asyncClientStreamingCall(
            new MethodHandlers<
              dynamic.DynamicList.AddDigitRequest,
              dynamic.DynamicList.ListResponse>(
                service, METHODID_ADD_DIGIT_TO_LIST_STREAM)))
        .addMethod(
          getAddNumberToEachMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              dynamic.DynamicList.AddNumberRequest,
              dynamic.DynamicList.ListResponse>(
                service, METHODID_ADD_NUMBER_TO_EACH)))
        .addMethod(
          getComputeMethod(),
          io.grpc.stub.ServerCalls.asyncUnaryCall(
            new MethodHandlers<
              dynamic.DynamicList.OperationRequest,
              dynamic.DynamicList.OperationResponse>(
                service, METHODID_COMPUTE)))
        .addMethod(
          getStreamListMethod(),
          io.grpc.stub.ServerCalls.asyncServerStreamingCall(
            new MethodHandlers<
              com.google.protobuf.Empty,
              dynamic.DynamicList.ListElement>(
                service, METHODID_STREAM_LIST)))
        .build();
  }

  private static abstract class ListManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ListManagerBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return dynamic.DynamicList.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("ListManager");
    }
  }

  private static final class ListManagerFileDescriptorSupplier
      extends ListManagerBaseDescriptorSupplier {
    ListManagerFileDescriptorSupplier() {}
  }

  private static final class ListManagerMethodDescriptorSupplier
      extends ListManagerBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final java.lang.String methodName;

    ListManagerMethodDescriptorSupplier(java.lang.String methodName) {
      this.methodName = methodName;
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.MethodDescriptor getMethodDescriptor() {
      return getServiceDescriptor().findMethodByName(methodName);
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ListManagerGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ListManagerFileDescriptorSupplier())
              .addMethod(getAddDigitToListMethod())
              .addMethod(getAddDigitToListStreamMethod())
              .addMethod(getAddNumberToEachMethod())
              .addMethod(getComputeMethod())
              .addMethod(getStreamListMethod())
              .build();
        }
      }
    }
    return result;
  }
}
