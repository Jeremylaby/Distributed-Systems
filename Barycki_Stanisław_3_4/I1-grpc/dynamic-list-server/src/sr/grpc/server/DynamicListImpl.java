package sr.grpc.server;

import com.google.protobuf.Empty;
import dynamic.DynamicList;
import dynamic.ListManagerGrpc;
import io.grpc.stub.StreamObserver;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DynamicListImpl extends ListManagerGrpc.ListManagerImplBase {
    private final List<Integer> list = new ArrayList<>();

    @Override
    public void addDigitToList(DynamicList.AddDigitRequest req,
                               StreamObserver<DynamicList.ListResponse> obs) {
        System.out.println("addDigitToList called with digit=" + req.getDigit());
        list.add(req.getDigit());
        System.out.println("Current list: " + list);
        DynamicList.ListResponse resp = DynamicList.ListResponse.newBuilder()
                .addAllElements(list)
                .build();
        obs.onNext(resp);
        obs.onCompleted();
    }

    @Override
    public StreamObserver<DynamicList.AddDigitRequest> addDigitToListStream(
            final StreamObserver<DynamicList.ListResponse> responseObserver) {
        System.out.println("addDigitToListStream called");
        return new StreamObserver<>() {
            @Override
            public void onNext(DynamicList.AddDigitRequest req) {
                System.out.println("onNext: adding digit=" + req.getDigit());
                list.add(req.getDigit());
            }

            @Override
            public void onError(Throwable t) {
                System.err.println("addDigitToListStream onError: " + t.getMessage());
                t.printStackTrace();
            }

            @Override
            public void onCompleted() {
                System.out.println("addDigitToListStream onCompleted, final list: " + list);
                DynamicList.ListResponse resp = DynamicList.ListResponse.newBuilder()
                        .addAllElements(list)
                        .build();
                responseObserver.onNext(resp);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public void addNumberToEach(DynamicList.AddNumberRequest req,
                                StreamObserver<DynamicList.ListResponse> obs) {
        System.out.println("addNumberToEach called with number=" + req.getNumber());
        int n = req.getNumber();
        for (int i = 0; i < list.size(); ++i) {
            list.set(i, list.get(i) + n);
        }
        System.out.println("After addNumberToEach, list: " + list);
        DynamicList.ListResponse resp = DynamicList.ListResponse.newBuilder()
                .addAllElements(list)
                .build();
        obs.onNext(resp);
        obs.onCompleted();
    }

    @Override
    public void compute(DynamicList.OperationRequest req,
                        StreamObserver<DynamicList.OperationResponse> obs) {
        System.out.println("compute called with op=" + req.getOp());
        if (list.isEmpty()) {
            System.out.println("List is empty; returning 0");
            obs.onNext(DynamicList.OperationResponse.newBuilder()
                    .setResult(0)
                    .build());
            obs.onCompleted();
            return;
        }

        double result;
        switch (req.getOp()) {
            case SUM:
                result = list.stream().mapToInt(Integer::intValue).sum();
                break;
            case MIN:
                result = Collections.min(list);
                break;
            case MAX:
                result = Collections.max(list);
                break;
            case AVG:
                result = list.stream().mapToInt(Integer::intValue).average().orElse(0);
                break;
            default:
                result = 0;
        }
        System.out.println("compute result: " + result);

        DynamicList.OperationResponse response = DynamicList.OperationResponse.newBuilder()
                .setResult(result)
                .build();
        obs.onNext(response);
        obs.onCompleted();
    }

    @Override
    public void streamList(Empty req,
                           StreamObserver<DynamicList.ListElement> obs) {
        System.out.println("streamList called");
        for (int v : list) {
            System.out.println("streamList sending element: " + v);
            obs.onNext(DynamicList.ListElement.newBuilder().setValue(v).build());
        }
        obs.onCompleted();
        System.out.println("streamList completed");
    }
}
