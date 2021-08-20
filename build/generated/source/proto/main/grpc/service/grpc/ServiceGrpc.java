package service.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.39.0)",
    comments = "Source: service/grpc/service.proto")
public final class ServiceGrpc {

  private ServiceGrpc() {}

  public static final String SERVICE_NAME = "service.grpc.Service";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<service.grpc.HelloRequest,
      service.grpc.HelloReply> getSayHelloMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHello",
      requestType = service.grpc.HelloRequest.class,
      responseType = service.grpc.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<service.grpc.HelloRequest,
      service.grpc.HelloReply> getSayHelloMethod() {
    io.grpc.MethodDescriptor<service.grpc.HelloRequest, service.grpc.HelloReply> getSayHelloMethod;
    if ((getSayHelloMethod = ServiceGrpc.getSayHelloMethod) == null) {
      synchronized (ServiceGrpc.class) {
        if ((getSayHelloMethod = ServiceGrpc.getSayHelloMethod) == null) {
          ServiceGrpc.getSayHelloMethod = getSayHelloMethod =
              io.grpc.MethodDescriptor.<service.grpc.HelloRequest, service.grpc.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayHello"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.grpc.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.grpc.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceMethodDescriptorSupplier("SayHello"))
              .build();
        }
      }
    }
    return getSayHelloMethod;
  }

  private static volatile io.grpc.MethodDescriptor<service.grpc.HelloRequest,
      service.grpc.HelloReply> getSayHellosMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "SayHellos",
      requestType = service.grpc.HelloRequest.class,
      responseType = service.grpc.HelloReply.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<service.grpc.HelloRequest,
      service.grpc.HelloReply> getSayHellosMethod() {
    io.grpc.MethodDescriptor<service.grpc.HelloRequest, service.grpc.HelloReply> getSayHellosMethod;
    if ((getSayHellosMethod = ServiceGrpc.getSayHellosMethod) == null) {
      synchronized (ServiceGrpc.class) {
        if ((getSayHellosMethod = ServiceGrpc.getSayHellosMethod) == null) {
          ServiceGrpc.getSayHellosMethod = getSayHellosMethod =
              io.grpc.MethodDescriptor.<service.grpc.HelloRequest, service.grpc.HelloReply>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "SayHellos"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.grpc.HelloRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
                  service.grpc.HelloReply.getDefaultInstance()))
              .setSchemaDescriptor(new ServiceMethodDescriptorSupplier("SayHellos"))
              .build();
        }
      }
    }
    return getSayHellosMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceStub>() {
        @java.lang.Override
        public ServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceStub(channel, callOptions);
        }
      };
    return ServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceBlockingStub>() {
        @java.lang.Override
        public ServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceBlockingStub(channel, callOptions);
        }
      };
    return ServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<ServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<ServiceFutureStub>() {
        @java.lang.Override
        public ServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new ServiceFutureStub(channel, callOptions);
        }
      };
    return ServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class ServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void sayHello(service.grpc.HelloRequest request,
        io.grpc.stub.StreamObserver<service.grpc.HelloReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSayHelloMethod(), responseObserver);
    }

    /**
     */
    public void sayHellos(service.grpc.HelloRequest request,
        io.grpc.stub.StreamObserver<service.grpc.HelloReply> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getSayHellosMethod(), responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getSayHelloMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                service.grpc.HelloRequest,
                service.grpc.HelloReply>(
                  this, METHODID_SAY_HELLO)))
          .addMethod(
            getSayHellosMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                service.grpc.HelloRequest,
                service.grpc.HelloReply>(
                  this, METHODID_SAY_HELLOS)))
          .build();
    }
  }

  /**
   */
  public static final class ServiceStub extends io.grpc.stub.AbstractAsyncStub<ServiceStub> {
    private ServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceStub(channel, callOptions);
    }

    /**
     */
    public void sayHello(service.grpc.HelloRequest request,
        io.grpc.stub.StreamObserver<service.grpc.HelloReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getSayHelloMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void sayHellos(service.grpc.HelloRequest request,
        io.grpc.stub.StreamObserver<service.grpc.HelloReply> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getSayHellosMethod(), getCallOptions()), request, responseObserver);
    }
  }

  /**
   */
  public static final class ServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<ServiceBlockingStub> {
    private ServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public service.grpc.HelloReply sayHello(service.grpc.HelloRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getSayHelloMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<service.grpc.HelloReply> sayHellos(
        service.grpc.HelloRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getSayHellosMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class ServiceFutureStub extends io.grpc.stub.AbstractFutureStub<ServiceFutureStub> {
    private ServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new ServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<service.grpc.HelloReply> sayHello(
        service.grpc.HelloRequest request) {
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
    private final ServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_SAY_HELLO:
          serviceImpl.sayHello((service.grpc.HelloRequest) request,
              (io.grpc.stub.StreamObserver<service.grpc.HelloReply>) responseObserver);
          break;
        case METHODID_SAY_HELLOS:
          serviceImpl.sayHellos((service.grpc.HelloRequest) request,
              (io.grpc.stub.StreamObserver<service.grpc.HelloReply>) responseObserver);
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

  private static abstract class ServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {
    ServiceBaseDescriptorSupplier() {}

    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return service.grpc.ServiceOuterClass.getDescriptor();
    }

    @java.lang.Override
    public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
      return getFileDescriptor().findServiceByName("Service");
    }
  }

  private static final class ServiceFileDescriptorSupplier
      extends ServiceBaseDescriptorSupplier {
    ServiceFileDescriptorSupplier() {}
  }

  private static final class ServiceMethodDescriptorSupplier
      extends ServiceBaseDescriptorSupplier
      implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {
    private final String methodName;

    ServiceMethodDescriptorSupplier(String methodName) {
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
      synchronized (ServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ServiceFileDescriptorSupplier())
              .addMethod(getSayHelloMethod())
              .addMethod(getSayHellosMethod())
              .build();
        }
      }
    }
    return result;
  }
}
