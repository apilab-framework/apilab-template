package app.grpc;

import app.grpc.v1.GreeterGrpc;
import app.grpc.v1.Hello.HelloReply;
import app.grpc.v1.Hello.HelloRequest;
import io.grpc.stub.StreamObserver;

public class GreeterService extends GreeterGrpc.GreeterImplBase {

  @Override
  public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
    HelloReply reply = HelloReply.newBuilder().setMessage("Hello " + request.getName()).build();
    responseObserver.onNext(reply);
    responseObserver.onCompleted();
  }

}
