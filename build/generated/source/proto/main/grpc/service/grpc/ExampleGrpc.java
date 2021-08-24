package service.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: service/grpc/example.proto")
public final class ExampleGrpc {

  private ExampleGrpc() {}

  public static final String SERVICE_NAME = "service.grpc.Example";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<service.grpc.ExampleRequest,
      service.grpc.ExampleReply> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHello",
      requestType = service.grpc.ExampleRequest.class,
      responseType = service.grpc.ExampleReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.grpc.ExampleRequest,
      service.grpc.ExampleReply> getSayHelloMethod() {
    io.grpc.MethodDescriptor<service.grpc.ExampleRequest, service.grpc.ExampleReply> getSayHelloMethod;
    if ((getSayHelloMethod = ExampleGrpc.getSayHelloMethod) == null) {
      synchronized (ExampleGrpc.class) {
        if ((getSayHelloMethod = ExampleGrpc.getSayHelloMethod) == null) {
          ExampleGrpc.getSayHelloMethod = getSayHelloMethod =
              io.grpc.MethodDescriptor.<service.grpc.ExampleRequest, service.grpc.ExampleReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.grpc.ExampleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.grpc.ExampleReply.getDefaultInstance()))
              .setSchemaDescriptor(new ExampleMethodDescriptorSupplier("SayHello"))
              .build();
        }
      }
    }
    return getSayHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<service.grpc.ExampleRequest,
      service.grpc.ExampleReply> getSayHellosMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHellos",
      requestType = service.grpc.ExampleRequest.class,
      responseType = service.grpc.ExampleReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<service.grpc.ExampleRequest,
      service.grpc.ExampleReply> getSayHellosMethod() {
    io.grpc.MethodDescriptor<service.grpc.ExampleRequest, service.grpc.ExampleReply> getSayHellosMethod;
    if ((getSayHellosMethod = ExampleGrpc.getSayHellosMethod) == null) {
      synchronized (ExampleGrpc.class) {
        if ((getSayHellosMethod = ExampleGrpc.getSayHellosMethod) == null) {
          ExampleGrpc.getSayHellosMethod = getSayHellosMethod =
              io.grpc.MethodDescriptor.<service.grpc.ExampleRequest, service.grpc.ExampleReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayHellos"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.grpc.ExampleRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.grpc.ExampleReply.getDefaultInstance()))
              .setSchemaDescriptor(new ExampleMethodDescriptorSupplier("SayHellos"))
              .build();
        }
      }
    }
    return getSayHellosMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ExampleStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExampleStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExampleStub>() {
        @java.lang.Override
        public ExampleStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExampleStub(channel, callOptions);
        }
      };
    return ExampleStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ExampleBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExampleBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExampleBlockingStub>() {
        @java.lang.Override
        public ExampleBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExampleBlockingStub(channel, callOptions);
        }
      };
    return ExampleBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ExampleFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ExampleFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ExampleFutureStub>() {
        @java.lang.Override
        public ExampleFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ExampleFutureStub(channel, callOptions);
        }
      };
    return ExampleFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ExampleImplBase implements io.grpc.BindableService {

    /**
     */
    public void sayHello(service.grpc.ExampleRequest request,
        io.grpc.stub.StreamObserver<service.grpc.ExampleReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    /**
     */
    public void sayHellos(service.grpc.ExampleRequest request,
        io.grpc.stub.StreamObserver<service.grpc.ExampleReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSayHellosMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                service.grpc.ExampleRequest,
                service.grpc.ExampleReply>(
                  this, METHODID_SAY_HELLO)))
          .addMethod(
            getSayHellosMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                service.grpc.ExampleRequest,
                service.grpc.ExampleReply>(
                  this, METHODID_SAY_HELLOS)))
          .build();
    }
  }

  /**
   */
  public static final class ExampleStub extends io.grpc.stub.AbstractAsyncStub<ExampleStub> {
    private ExampleStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExampleStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExampleStub(channel, callOptions);
    }

    /**
     */
    public void sayHello(service.grpc.ExampleRequest request,
        io.grpc.stub.StreamObserver<service.grpc.ExampleReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sayHellos(service.grpc.ExampleRequest request,
        io.grpc.stub.StreamObserver<service.grpc.ExampleReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSayHellosMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ExampleBlockingStub extends io.grpc.stub.AbstractBlockingStub<ExampleBlockingStub> {
    private ExampleBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExampleBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExampleBlockingStub(channel, callOptions);
    }

    /**
     */
    public service.grpc.ExampleReply sayHello(service.grpc.ExampleRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<service.grpc.ExampleReply> sayHellos(
        service.grpc.ExampleRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSayHellosMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ExampleFutureStub extends io.grpc.stub.AbstractFutureStub<ExampleFutureStub> {
    private ExampleFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ExampleFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ExampleFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.grpc.ExampleReply> sayHello(
        service.grpc.ExampleRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_SAY_HELLO = 0;
  private static final int METHODID_SAY_HELLOS = 1;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ExampleImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ExampleImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((service.grpc.ExampleRequest) request,
              (io.grpc.stub.StreamObserver<service.grpc.ExampleReply>) responseObserver);
          break;
        case METHODID_SAY_HELLOS:
          serviceImpl.sayHellos((service.grpc.ExampleRequest) request,
              (io.grpc.stub.StreamObserver<service.grpc.ExampleReply>) responseObserver);
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
        default:
          throw new AssertionError();
      }
    }
  }

  private static abstract class ExampleBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ExampleBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return service.grpc.ExampleOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Example");
    }
  }

  private static final class ExampleFileDescriptorSupplier
      extends ExampleBaseDescriptorSupplier {
    ExampleFileDescriptorSupplier() {}
  }

  private static final class ExampleMethodDescriptorSupplier
      extends ExampleBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ExampleMethodDescriptorSupplier(String methodName) {
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
      synchronized (ExampleGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ExampleFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .addMethod(getSayHellosMethod())
              .build();
        }
      }
    }
    return result;
  }
}
