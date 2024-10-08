package com.example.reminderJob.api;

import static io.grpc.stub.ClientCalls.asyncUnaryCall;
import static io.grpc.stub.ClientCalls.asyncServerStreamingCall;
import static io.grpc.stub.ClientCalls.asyncClientStreamingCall;
import static io.grpc.stub.ClientCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ClientCalls.blockingUnaryCall;
import static io.grpc.stub.ClientCalls.blockingServerStreamingCall;
import static io.grpc.stub.ClientCalls.futureUnaryCall;
import static io.grpc.MethodDescriptor.generateFullMethodName;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall;
import static io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall;

/**
 * <pre>
 *定义一个类
 * </pre>
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.6.1)",
    comments = "Source: ReminderJobService.proto")
public final class ReminderJobServiceGrpc {

  private ReminderJobServiceGrpc() {}

  public static final String SERVICE_NAME = "ReminderJobService";

  // Static method descriptors that strictly reflect the proto.
  @io.grpc.ExperimentalApi("https://github.com/grpc/grpc-java/issues/1901")
  public static final io.grpc.MethodDescriptor<com.example.reminderJob.protos.GrpcParams.ReminderJobReq,
      com.example.reminderJob.protos.GrpcParams.ReminderJobResponse> METHOD_ADD_REMINDER_JOB =
      io.grpc.MethodDescriptor.<com.example.reminderJob.protos.GrpcParams.ReminderJobReq, com.example.reminderJob.protos.GrpcParams.ReminderJobResponse>newBuilder()
          .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
          .setFullMethodName(generateFullMethodName(
              "ReminderJobService", "addReminderJob"))
          .setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.example.reminderJob.protos.GrpcParams.ReminderJobReq.getDefaultInstance()))
          .setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(
              com.example.reminderJob.protos.GrpcParams.ReminderJobResponse.getDefaultInstance()))
          .build();

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static ReminderJobServiceStub newStub(io.grpc.Channel channel) {
    return new ReminderJobServiceStub(channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static ReminderJobServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    return new ReminderJobServiceBlockingStub(channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static ReminderJobServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    return new ReminderJobServiceFutureStub(channel);
  }

  /**
   * <pre>
   *定义一个类
   * </pre>
   */
  public static abstract class ReminderJobServiceImplBase implements io.grpc.BindableService {

    /**
     * <pre>
     *定义一个gRPC方法，参数为HelloRequest，返回结果为HelloResponse
     * </pre>
     */
    public void addReminderJob(com.example.reminderJob.protos.GrpcParams.ReminderJobReq request,
        io.grpc.stub.StreamObserver<com.example.reminderJob.protos.GrpcParams.ReminderJobResponse> responseObserver) {
      asyncUnimplementedUnaryCall(METHOD_ADD_REMINDER_JOB, responseObserver);
    }

    @java.lang.Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            METHOD_ADD_REMINDER_JOB,
            asyncUnaryCall(
              new MethodHandlers<
                com.example.reminderJob.protos.GrpcParams.ReminderJobReq,
                com.example.reminderJob.protos.GrpcParams.ReminderJobResponse>(
                  this, METHODID_ADD_REMINDER_JOB)))
          .build();
    }
  }

  /**
   * <pre>
   *定义一个类
   * </pre>
   */
  public static final class ReminderJobServiceStub extends io.grpc.stub.AbstractStub<ReminderJobServiceStub> {
    private ReminderJobServiceStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReminderJobServiceStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReminderJobServiceStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReminderJobServiceStub(channel, callOptions);
    }

    /**
     * <pre>
     *定义一个gRPC方法，参数为HelloRequest，返回结果为HelloResponse
     * </pre>
     */
    public void addReminderJob(com.example.reminderJob.protos.GrpcParams.ReminderJobReq request,
        io.grpc.stub.StreamObserver<com.example.reminderJob.protos.GrpcParams.ReminderJobResponse> responseObserver) {
      asyncUnaryCall(
          getChannel().newCall(METHOD_ADD_REMINDER_JOB, getCallOptions()), request, responseObserver);
    }
  }

  /**
   * <pre>
   *定义一个类
   * </pre>
   */
  public static final class ReminderJobServiceBlockingStub extends io.grpc.stub.AbstractStub<ReminderJobServiceBlockingStub> {
    private ReminderJobServiceBlockingStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReminderJobServiceBlockingStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReminderJobServiceBlockingStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReminderJobServiceBlockingStub(channel, callOptions);
    }

    /**
     * <pre>
     *定义一个gRPC方法，参数为HelloRequest，返回结果为HelloResponse
     * </pre>
     */
    public com.example.reminderJob.protos.GrpcParams.ReminderJobResponse addReminderJob(com.example.reminderJob.protos.GrpcParams.ReminderJobReq request) {
      return blockingUnaryCall(
          getChannel(), METHOD_ADD_REMINDER_JOB, getCallOptions(), request);
    }
  }

  /**
   * <pre>
   *定义一个类
   * </pre>
   */
  public static final class ReminderJobServiceFutureStub extends io.grpc.stub.AbstractStub<ReminderJobServiceFutureStub> {
    private ReminderJobServiceFutureStub(io.grpc.Channel channel) {
      super(channel);
    }

    private ReminderJobServiceFutureStub(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @java.lang.Override
    protected ReminderJobServiceFutureStub build(io.grpc.Channel channel,
        io.grpc.CallOptions callOptions) {
      return new ReminderJobServiceFutureStub(channel, callOptions);
    }

    /**
     * <pre>
     *定义一个gRPC方法，参数为HelloRequest，返回结果为HelloResponse
     * </pre>
     */
    public com.google.common.util.concurrent.ListenableFuture<com.example.reminderJob.protos.GrpcParams.ReminderJobResponse> addReminderJob(
        com.example.reminderJob.protos.GrpcParams.ReminderJobReq request) {
      return futureUnaryCall(
          getChannel().newCall(METHOD_ADD_REMINDER_JOB, getCallOptions()), request);
    }
  }

  private static final int METHODID_ADD_REMINDER_JOB = 0;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final ReminderJobServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(ReminderJobServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @java.lang.Override
    @java.lang.SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_ADD_REMINDER_JOB:
          serviceImpl.addReminderJob((com.example.reminderJob.protos.GrpcParams.ReminderJobReq) request,
              (io.grpc.stub.StreamObserver<com.example.reminderJob.protos.GrpcParams.ReminderJobResponse>) responseObserver);
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

  private static final class ReminderJobServiceDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier {
    @java.lang.Override
    public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
      return com.example.reminderJob.api.ReminderJobGrpcClient.getDescriptor();
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (ReminderJobServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .setSchemaDescriptor(new ReminderJobServiceDescriptorSupplier())
              .addMethod(METHOD_ADD_REMINDER_JOB)
              .build();
        }
      }
    }
    return result;
  }
}
