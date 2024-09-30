package bikes.grpc;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@io.quarkus.Generated(value = "by gRPC proto compiler (version 1.65.1)", comments = "Source: bikes.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class BikesGrpc {

    private BikesGrpc() {
    }

    public static final java.lang.String SERVICE_NAME = "Bikes";

    // Static method descriptors that strictly reflect the proto.
    private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty, bikes.grpc.Bike> getGetAllStreamMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/' + "GetAllStream", requestType = com.google.protobuf.Empty.class, responseType = bikes.grpc.Bike.class, methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
    public static io.grpc.MethodDescriptor<com.google.protobuf.Empty, bikes.grpc.Bike> getGetAllStreamMethod() {
        io.grpc.MethodDescriptor<com.google.protobuf.Empty, bikes.grpc.Bike> getGetAllStreamMethod;
        if ((getGetAllStreamMethod = BikesGrpc.getGetAllStreamMethod) == null) {
            synchronized (BikesGrpc.class) {
                if ((getGetAllStreamMethod = BikesGrpc.getGetAllStreamMethod) == null) {
                    BikesGrpc.getGetAllStreamMethod = getGetAllStreamMethod = io.grpc.MethodDescriptor.<com.google.protobuf.Empty, bikes.grpc.Bike>newBuilder().setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING).setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAllStream")).setSampledToLocalTracing(true).setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.Empty.getDefaultInstance())).setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(bikes.grpc.Bike.getDefaultInstance())).setSchemaDescriptor(new BikesMethodDescriptorSupplier("GetAllStream")).build();
                }
            }
        }
        return getGetAllStreamMethod;
    }

    private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty, bikes.grpc.BikeList> getGetAllMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/' + "GetAll", requestType = com.google.protobuf.Empty.class, responseType = bikes.grpc.BikeList.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.google.protobuf.Empty, bikes.grpc.BikeList> getGetAllMethod() {
        io.grpc.MethodDescriptor<com.google.protobuf.Empty, bikes.grpc.BikeList> getGetAllMethod;
        if ((getGetAllMethod = BikesGrpc.getGetAllMethod) == null) {
            synchronized (BikesGrpc.class) {
                if ((getGetAllMethod = BikesGrpc.getGetAllMethod) == null) {
                    BikesGrpc.getGetAllMethod = getGetAllMethod = io.grpc.MethodDescriptor.<com.google.protobuf.Empty, bikes.grpc.BikeList>newBuilder().setType(io.grpc.MethodDescriptor.MethodType.UNARY).setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetAll")).setSampledToLocalTracing(true).setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.Empty.getDefaultInstance())).setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(bikes.grpc.BikeList.getDefaultInstance())).setSchemaDescriptor(new BikesMethodDescriptorSupplier("GetAll")).build();
                }
            }
        }
        return getGetAllMethod;
    }

    private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue, bikes.grpc.Bike> getGetByLocationStreamMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/' + "GetByLocationStream", requestType = com.google.protobuf.StringValue.class, responseType = bikes.grpc.Bike.class, methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
    public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue, bikes.grpc.Bike> getGetByLocationStreamMethod() {
        io.grpc.MethodDescriptor<com.google.protobuf.StringValue, bikes.grpc.Bike> getGetByLocationStreamMethod;
        if ((getGetByLocationStreamMethod = BikesGrpc.getGetByLocationStreamMethod) == null) {
            synchronized (BikesGrpc.class) {
                if ((getGetByLocationStreamMethod = BikesGrpc.getGetByLocationStreamMethod) == null) {
                    BikesGrpc.getGetByLocationStreamMethod = getGetByLocationStreamMethod = io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, bikes.grpc.Bike>newBuilder().setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING).setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetByLocationStream")).setSampledToLocalTracing(true).setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.StringValue.getDefaultInstance())).setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(bikes.grpc.Bike.getDefaultInstance())).setSchemaDescriptor(new BikesMethodDescriptorSupplier("GetByLocationStream")).build();
                }
            }
        }
        return getGetByLocationStreamMethod;
    }

    private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue, bikes.grpc.BikeList> getGetByLocationMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/' + "GetByLocation", requestType = com.google.protobuf.StringValue.class, responseType = bikes.grpc.BikeList.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue, bikes.grpc.BikeList> getGetByLocationMethod() {
        io.grpc.MethodDescriptor<com.google.protobuf.StringValue, bikes.grpc.BikeList> getGetByLocationMethod;
        if ((getGetByLocationMethod = BikesGrpc.getGetByLocationMethod) == null) {
            synchronized (BikesGrpc.class) {
                if ((getGetByLocationMethod = BikesGrpc.getGetByLocationMethod) == null) {
                    BikesGrpc.getGetByLocationMethod = getGetByLocationMethod = io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, bikes.grpc.BikeList>newBuilder().setType(io.grpc.MethodDescriptor.MethodType.UNARY).setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetByLocation")).setSampledToLocalTracing(true).setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.StringValue.getDefaultInstance())).setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(bikes.grpc.BikeList.getDefaultInstance())).setSchemaDescriptor(new BikesMethodDescriptorSupplier("GetByLocation")).build();
                }
            }
        }
        return getGetByLocationMethod;
    }

    private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Int32Value, bikes.grpc.Bike> getGetByIdMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/' + "GetById", requestType = com.google.protobuf.Int32Value.class, responseType = bikes.grpc.Bike.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.google.protobuf.Int32Value, bikes.grpc.Bike> getGetByIdMethod() {
        io.grpc.MethodDescriptor<com.google.protobuf.Int32Value, bikes.grpc.Bike> getGetByIdMethod;
        if ((getGetByIdMethod = BikesGrpc.getGetByIdMethod) == null) {
            synchronized (BikesGrpc.class) {
                if ((getGetByIdMethod = BikesGrpc.getGetByIdMethod) == null) {
                    BikesGrpc.getGetByIdMethod = getGetByIdMethod = io.grpc.MethodDescriptor.<com.google.protobuf.Int32Value, bikes.grpc.Bike>newBuilder().setType(io.grpc.MethodDescriptor.MethodType.UNARY).setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetById")).setSampledToLocalTracing(true).setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.Int32Value.getDefaultInstance())).setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(bikes.grpc.Bike.getDefaultInstance())).setSchemaDescriptor(new BikesMethodDescriptorSupplier("GetById")).build();
                }
            }
        }
        return getGetByIdMethod;
    }

    private static volatile io.grpc.MethodDescriptor<bikes.grpc.BikeRequest, bikes.grpc.Bike> getUpdateByIdMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/' + "UpdateById", requestType = bikes.grpc.BikeRequest.class, responseType = bikes.grpc.Bike.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<bikes.grpc.BikeRequest, bikes.grpc.Bike> getUpdateByIdMethod() {
        io.grpc.MethodDescriptor<bikes.grpc.BikeRequest, bikes.grpc.Bike> getUpdateByIdMethod;
        if ((getUpdateByIdMethod = BikesGrpc.getUpdateByIdMethod) == null) {
            synchronized (BikesGrpc.class) {
                if ((getUpdateByIdMethod = BikesGrpc.getUpdateByIdMethod) == null) {
                    BikesGrpc.getUpdateByIdMethod = getUpdateByIdMethod = io.grpc.MethodDescriptor.<bikes.grpc.BikeRequest, bikes.grpc.Bike>newBuilder().setType(io.grpc.MethodDescriptor.MethodType.UNARY).setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateById")).setSampledToLocalTracing(true).setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(bikes.grpc.BikeRequest.getDefaultInstance())).setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(bikes.grpc.Bike.getDefaultInstance())).setSchemaDescriptor(new BikesMethodDescriptorSupplier("UpdateById")).build();
                }
            }
        }
        return getUpdateByIdMethod;
    }

    private static volatile io.grpc.MethodDescriptor<bikes.grpc.BikeRequest, bikes.grpc.Bike> getCreateMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/' + "Create", requestType = bikes.grpc.BikeRequest.class, responseType = bikes.grpc.Bike.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<bikes.grpc.BikeRequest, bikes.grpc.Bike> getCreateMethod() {
        io.grpc.MethodDescriptor<bikes.grpc.BikeRequest, bikes.grpc.Bike> getCreateMethod;
        if ((getCreateMethod = BikesGrpc.getCreateMethod) == null) {
            synchronized (BikesGrpc.class) {
                if ((getCreateMethod = BikesGrpc.getCreateMethod) == null) {
                    BikesGrpc.getCreateMethod = getCreateMethod = io.grpc.MethodDescriptor.<bikes.grpc.BikeRequest, bikes.grpc.Bike>newBuilder().setType(io.grpc.MethodDescriptor.MethodType.UNARY).setFullMethodName(generateFullMethodName(SERVICE_NAME, "Create")).setSampledToLocalTracing(true).setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(bikes.grpc.BikeRequest.getDefaultInstance())).setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(bikes.grpc.Bike.getDefaultInstance())).setSchemaDescriptor(new BikesMethodDescriptorSupplier("Create")).build();
                }
            }
        }
        return getCreateMethod;
    }

    private static volatile io.grpc.MethodDescriptor<bikes.grpc.BikeUpdateRatingRequest, bikes.grpc.Bike> getUpdateRatingByIdMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/' + "UpdateRatingById", requestType = bikes.grpc.BikeUpdateRatingRequest.class, responseType = bikes.grpc.Bike.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<bikes.grpc.BikeUpdateRatingRequest, bikes.grpc.Bike> getUpdateRatingByIdMethod() {
        io.grpc.MethodDescriptor<bikes.grpc.BikeUpdateRatingRequest, bikes.grpc.Bike> getUpdateRatingByIdMethod;
        if ((getUpdateRatingByIdMethod = BikesGrpc.getUpdateRatingByIdMethod) == null) {
            synchronized (BikesGrpc.class) {
                if ((getUpdateRatingByIdMethod = BikesGrpc.getUpdateRatingByIdMethod) == null) {
                    BikesGrpc.getUpdateRatingByIdMethod = getUpdateRatingByIdMethod = io.grpc.MethodDescriptor.<bikes.grpc.BikeUpdateRatingRequest, bikes.grpc.Bike>newBuilder().setType(io.grpc.MethodDescriptor.MethodType.UNARY).setFullMethodName(generateFullMethodName(SERVICE_NAME, "UpdateRatingById")).setSampledToLocalTracing(true).setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(bikes.grpc.BikeUpdateRatingRequest.getDefaultInstance())).setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(bikes.grpc.Bike.getDefaultInstance())).setSchemaDescriptor(new BikesMethodDescriptorSupplier("UpdateRatingById")).build();
                }
            }
        }
        return getUpdateRatingByIdMethod;
    }

    private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Int32Value, com.google.protobuf.Empty> getDeleteByIdMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/' + "DeleteById", requestType = com.google.protobuf.Int32Value.class, responseType = com.google.protobuf.Empty.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.google.protobuf.Int32Value, com.google.protobuf.Empty> getDeleteByIdMethod() {
        io.grpc.MethodDescriptor<com.google.protobuf.Int32Value, com.google.protobuf.Empty> getDeleteByIdMethod;
        if ((getDeleteByIdMethod = BikesGrpc.getDeleteByIdMethod) == null) {
            synchronized (BikesGrpc.class) {
                if ((getDeleteByIdMethod = BikesGrpc.getDeleteByIdMethod) == null) {
                    BikesGrpc.getDeleteByIdMethod = getDeleteByIdMethod = io.grpc.MethodDescriptor.<com.google.protobuf.Int32Value, com.google.protobuf.Empty>newBuilder().setType(io.grpc.MethodDescriptor.MethodType.UNARY).setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteById")).setSampledToLocalTracing(true).setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.Int32Value.getDefaultInstance())).setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.Empty.getDefaultInstance())).setSchemaDescriptor(new BikesMethodDescriptorSupplier("DeleteById")).build();
                }
            }
        }
        return getDeleteByIdMethod;
    }

    private static volatile io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.google.protobuf.Empty> getDeleteAllMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/' + "DeleteAll", requestType = com.google.protobuf.Empty.class, responseType = com.google.protobuf.Empty.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.google.protobuf.Empty> getDeleteAllMethod() {
        io.grpc.MethodDescriptor<com.google.protobuf.Empty, com.google.protobuf.Empty> getDeleteAllMethod;
        if ((getDeleteAllMethod = BikesGrpc.getDeleteAllMethod) == null) {
            synchronized (BikesGrpc.class) {
                if ((getDeleteAllMethod = BikesGrpc.getDeleteAllMethod) == null) {
                    BikesGrpc.getDeleteAllMethod = getDeleteAllMethod = io.grpc.MethodDescriptor.<com.google.protobuf.Empty, com.google.protobuf.Empty>newBuilder().setType(io.grpc.MethodDescriptor.MethodType.UNARY).setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteAll")).setSampledToLocalTracing(true).setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.Empty.getDefaultInstance())).setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.Empty.getDefaultInstance())).setSchemaDescriptor(new BikesMethodDescriptorSupplier("DeleteAll")).build();
                }
            }
        }
        return getDeleteAllMethod;
    }

    private static volatile io.grpc.MethodDescriptor<com.google.protobuf.StringValue, com.google.protobuf.Empty> getDeleteByLocationMethod;

    @io.grpc.stub.annotations.RpcMethod(fullMethodName = SERVICE_NAME + '/' + "DeleteByLocation", requestType = com.google.protobuf.StringValue.class, responseType = com.google.protobuf.Empty.class, methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
    public static io.grpc.MethodDescriptor<com.google.protobuf.StringValue, com.google.protobuf.Empty> getDeleteByLocationMethod() {
        io.grpc.MethodDescriptor<com.google.protobuf.StringValue, com.google.protobuf.Empty> getDeleteByLocationMethod;
        if ((getDeleteByLocationMethod = BikesGrpc.getDeleteByLocationMethod) == null) {
            synchronized (BikesGrpc.class) {
                if ((getDeleteByLocationMethod = BikesGrpc.getDeleteByLocationMethod) == null) {
                    BikesGrpc.getDeleteByLocationMethod = getDeleteByLocationMethod = io.grpc.MethodDescriptor.<com.google.protobuf.StringValue, com.google.protobuf.Empty>newBuilder().setType(io.grpc.MethodDescriptor.MethodType.UNARY).setFullMethodName(generateFullMethodName(SERVICE_NAME, "DeleteByLocation")).setSampledToLocalTracing(true).setRequestMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.StringValue.getDefaultInstance())).setResponseMarshaller(io.grpc.protobuf.ProtoUtils.marshaller(com.google.protobuf.Empty.getDefaultInstance())).setSchemaDescriptor(new BikesMethodDescriptorSupplier("DeleteByLocation")).build();
                }
            }
        }
        return getDeleteByLocationMethod;
    }

    /**
     * Creates a new async stub that supports all call types for the service
     */
    public static BikesStub newStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<BikesStub> factory = new io.grpc.stub.AbstractStub.StubFactory<BikesStub>() {

            @java.lang.Override
            public BikesStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new BikesStub(channel, callOptions);
            }
        };
        return BikesStub.newStub(factory, channel);
    }

    /**
     * Creates a new blocking-style stub that supports unary and streaming output calls on the service
     */
    public static BikesBlockingStub newBlockingStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<BikesBlockingStub> factory = new io.grpc.stub.AbstractStub.StubFactory<BikesBlockingStub>() {

            @java.lang.Override
            public BikesBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new BikesBlockingStub(channel, callOptions);
            }
        };
        return BikesBlockingStub.newStub(factory, channel);
    }

    /**
     * Creates a new ListenableFuture-style stub that supports unary calls on the service
     */
    public static BikesFutureStub newFutureStub(io.grpc.Channel channel) {
        io.grpc.stub.AbstractStub.StubFactory<BikesFutureStub> factory = new io.grpc.stub.AbstractStub.StubFactory<BikesFutureStub>() {

            @java.lang.Override
            public BikesFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
                return new BikesFutureStub(channel, callOptions);
            }
        };
        return BikesFutureStub.newStub(factory, channel);
    }

    /**
     */
    public interface AsyncService {

        /**
         */
        default void getAllStream(com.google.protobuf.Empty request, io.grpc.stub.StreamObserver<bikes.grpc.Bike> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllStreamMethod(), responseObserver);
        }

        /**
         */
        default void getAll(com.google.protobuf.Empty request, io.grpc.stub.StreamObserver<bikes.grpc.BikeList> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetAllMethod(), responseObserver);
        }

        /**
         */
        default void getByLocationStream(com.google.protobuf.StringValue request, io.grpc.stub.StreamObserver<bikes.grpc.Bike> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetByLocationStreamMethod(), responseObserver);
        }

        /**
         */
        default void getByLocation(com.google.protobuf.StringValue request, io.grpc.stub.StreamObserver<bikes.grpc.BikeList> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetByLocationMethod(), responseObserver);
        }

        /**
         */
        default void getById(com.google.protobuf.Int32Value request, io.grpc.stub.StreamObserver<bikes.grpc.Bike> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetByIdMethod(), responseObserver);
        }

        /**
         */
        default void updateById(bikes.grpc.BikeRequest request, io.grpc.stub.StreamObserver<bikes.grpc.Bike> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateByIdMethod(), responseObserver);
        }

        /**
         */
        default void create(bikes.grpc.BikeRequest request, io.grpc.stub.StreamObserver<bikes.grpc.Bike> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getCreateMethod(), responseObserver);
        }

        /**
         */
        default void updateRatingById(bikes.grpc.BikeUpdateRatingRequest request, io.grpc.stub.StreamObserver<bikes.grpc.Bike> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getUpdateRatingByIdMethod(), responseObserver);
        }

        /**
         */
        default void deleteById(com.google.protobuf.Int32Value request, io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteByIdMethod(), responseObserver);
        }

        /**
         */
        default void deleteAll(com.google.protobuf.Empty request, io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteAllMethod(), responseObserver);
        }

        /**
         */
        default void deleteByLocation(com.google.protobuf.StringValue request, io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
            io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getDeleteByLocationMethod(), responseObserver);
        }
    }

    /**
     * Base class for the server implementation of the service Bikes.
     */
    public static abstract class BikesImplBase implements io.grpc.BindableService, AsyncService {

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return BikesGrpc.bindService(this);
        }
    }

    /**
     * A stub to allow clients to do asynchronous rpc calls to service Bikes.
     */
    public static class BikesStub extends io.grpc.stub.AbstractAsyncStub<BikesStub> {

        private BikesStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected BikesStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BikesStub(channel, callOptions);
        }

        /**
         */
        public void getAllStream(com.google.protobuf.Empty request, io.grpc.stub.StreamObserver<bikes.grpc.Bike> responseObserver) {
            io.grpc.stub.ClientCalls.asyncServerStreamingCall(getChannel().newCall(getGetAllStreamMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void getAll(com.google.protobuf.Empty request, io.grpc.stub.StreamObserver<bikes.grpc.BikeList> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(getChannel().newCall(getGetAllMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void getByLocationStream(com.google.protobuf.StringValue request, io.grpc.stub.StreamObserver<bikes.grpc.Bike> responseObserver) {
            io.grpc.stub.ClientCalls.asyncServerStreamingCall(getChannel().newCall(getGetByLocationStreamMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void getByLocation(com.google.protobuf.StringValue request, io.grpc.stub.StreamObserver<bikes.grpc.BikeList> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(getChannel().newCall(getGetByLocationMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void getById(com.google.protobuf.Int32Value request, io.grpc.stub.StreamObserver<bikes.grpc.Bike> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(getChannel().newCall(getGetByIdMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void updateById(bikes.grpc.BikeRequest request, io.grpc.stub.StreamObserver<bikes.grpc.Bike> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(getChannel().newCall(getUpdateByIdMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void create(bikes.grpc.BikeRequest request, io.grpc.stub.StreamObserver<bikes.grpc.Bike> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(getChannel().newCall(getCreateMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void updateRatingById(bikes.grpc.BikeUpdateRatingRequest request, io.grpc.stub.StreamObserver<bikes.grpc.Bike> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(getChannel().newCall(getUpdateRatingByIdMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void deleteById(com.google.protobuf.Int32Value request, io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(getChannel().newCall(getDeleteByIdMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void deleteAll(com.google.protobuf.Empty request, io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(getChannel().newCall(getDeleteAllMethod(), getCallOptions()), request, responseObserver);
        }

        /**
         */
        public void deleteByLocation(com.google.protobuf.StringValue request, io.grpc.stub.StreamObserver<com.google.protobuf.Empty> responseObserver) {
            io.grpc.stub.ClientCalls.asyncUnaryCall(getChannel().newCall(getDeleteByLocationMethod(), getCallOptions()), request, responseObserver);
        }
    }

    /**
     * A stub to allow clients to do synchronous rpc calls to service Bikes.
     */
    public static class BikesBlockingStub extends io.grpc.stub.AbstractBlockingStub<BikesBlockingStub> {

        private BikesBlockingStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected BikesBlockingStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BikesBlockingStub(channel, callOptions);
        }

        /**
         */
        public java.util.Iterator<bikes.grpc.Bike> getAllStream(com.google.protobuf.Empty request) {
            return io.grpc.stub.ClientCalls.blockingServerStreamingCall(getChannel(), getGetAllStreamMethod(), getCallOptions(), request);
        }

        /**
         */
        public bikes.grpc.BikeList getAll(com.google.protobuf.Empty request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(getChannel(), getGetAllMethod(), getCallOptions(), request);
        }

        /**
         */
        public java.util.Iterator<bikes.grpc.Bike> getByLocationStream(com.google.protobuf.StringValue request) {
            return io.grpc.stub.ClientCalls.blockingServerStreamingCall(getChannel(), getGetByLocationStreamMethod(), getCallOptions(), request);
        }

        /**
         */
        public bikes.grpc.BikeList getByLocation(com.google.protobuf.StringValue request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(getChannel(), getGetByLocationMethod(), getCallOptions(), request);
        }

        /**
         */
        public bikes.grpc.Bike getById(com.google.protobuf.Int32Value request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(getChannel(), getGetByIdMethod(), getCallOptions(), request);
        }

        /**
         */
        public bikes.grpc.Bike updateById(bikes.grpc.BikeRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(getChannel(), getUpdateByIdMethod(), getCallOptions(), request);
        }

        /**
         */
        public bikes.grpc.Bike create(bikes.grpc.BikeRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(getChannel(), getCreateMethod(), getCallOptions(), request);
        }

        /**
         */
        public bikes.grpc.Bike updateRatingById(bikes.grpc.BikeUpdateRatingRequest request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(getChannel(), getUpdateRatingByIdMethod(), getCallOptions(), request);
        }

        /**
         */
        public com.google.protobuf.Empty deleteById(com.google.protobuf.Int32Value request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(getChannel(), getDeleteByIdMethod(), getCallOptions(), request);
        }

        /**
         */
        public com.google.protobuf.Empty deleteAll(com.google.protobuf.Empty request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(getChannel(), getDeleteAllMethod(), getCallOptions(), request);
        }

        /**
         */
        public com.google.protobuf.Empty deleteByLocation(com.google.protobuf.StringValue request) {
            return io.grpc.stub.ClientCalls.blockingUnaryCall(getChannel(), getDeleteByLocationMethod(), getCallOptions(), request);
        }
    }

    /**
     * A stub to allow clients to do ListenableFuture-style rpc calls to service Bikes.
     */
    public static class BikesFutureStub extends io.grpc.stub.AbstractFutureStub<BikesFutureStub> {

        private BikesFutureStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
        }

        @java.lang.Override
        protected BikesFutureStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new BikesFutureStub(channel, callOptions);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<bikes.grpc.BikeList> getAll(com.google.protobuf.Empty request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(getChannel().newCall(getGetAllMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<bikes.grpc.BikeList> getByLocation(com.google.protobuf.StringValue request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(getChannel().newCall(getGetByLocationMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<bikes.grpc.Bike> getById(com.google.protobuf.Int32Value request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(getChannel().newCall(getGetByIdMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<bikes.grpc.Bike> updateById(bikes.grpc.BikeRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(getChannel().newCall(getUpdateByIdMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<bikes.grpc.Bike> create(bikes.grpc.BikeRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(getChannel().newCall(getCreateMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<bikes.grpc.Bike> updateRatingById(bikes.grpc.BikeUpdateRatingRequest request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(getChannel().newCall(getUpdateRatingByIdMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteById(com.google.protobuf.Int32Value request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(getChannel().newCall(getDeleteByIdMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteAll(com.google.protobuf.Empty request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(getChannel().newCall(getDeleteAllMethod(), getCallOptions()), request);
        }

        /**
         */
        public com.google.common.util.concurrent.ListenableFuture<com.google.protobuf.Empty> deleteByLocation(com.google.protobuf.StringValue request) {
            return io.grpc.stub.ClientCalls.futureUnaryCall(getChannel().newCall(getDeleteByLocationMethod(), getCallOptions()), request);
        }
    }

    private static final int METHODID_GET_ALL_STREAM = 0;

    private static final int METHODID_GET_ALL = 1;

    private static final int METHODID_GET_BY_LOCATION_STREAM = 2;

    private static final int METHODID_GET_BY_LOCATION = 3;

    private static final int METHODID_GET_BY_ID = 4;

    private static final int METHODID_UPDATE_BY_ID = 5;

    private static final int METHODID_CREATE = 6;

    private static final int METHODID_UPDATE_RATING_BY_ID = 7;

    private static final int METHODID_DELETE_BY_ID = 8;

    private static final int METHODID_DELETE_ALL = 9;

    private static final int METHODID_DELETE_BY_LOCATION = 10;

    private static final class MethodHandlers<Req, Resp> implements io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>, io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>, io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {

        private final AsyncService serviceImpl;

        private final int methodId;

        MethodHandlers(AsyncService serviceImpl, int methodId) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch(methodId) {
                case METHODID_GET_ALL_STREAM:
                    serviceImpl.getAllStream((com.google.protobuf.Empty) request, (io.grpc.stub.StreamObserver<bikes.grpc.Bike>) responseObserver);
                    break;
                case METHODID_GET_ALL:
                    serviceImpl.getAll((com.google.protobuf.Empty) request, (io.grpc.stub.StreamObserver<bikes.grpc.BikeList>) responseObserver);
                    break;
                case METHODID_GET_BY_LOCATION_STREAM:
                    serviceImpl.getByLocationStream((com.google.protobuf.StringValue) request, (io.grpc.stub.StreamObserver<bikes.grpc.Bike>) responseObserver);
                    break;
                case METHODID_GET_BY_LOCATION:
                    serviceImpl.getByLocation((com.google.protobuf.StringValue) request, (io.grpc.stub.StreamObserver<bikes.grpc.BikeList>) responseObserver);
                    break;
                case METHODID_GET_BY_ID:
                    serviceImpl.getById((com.google.protobuf.Int32Value) request, (io.grpc.stub.StreamObserver<bikes.grpc.Bike>) responseObserver);
                    break;
                case METHODID_UPDATE_BY_ID:
                    serviceImpl.updateById((bikes.grpc.BikeRequest) request, (io.grpc.stub.StreamObserver<bikes.grpc.Bike>) responseObserver);
                    break;
                case METHODID_CREATE:
                    serviceImpl.create((bikes.grpc.BikeRequest) request, (io.grpc.stub.StreamObserver<bikes.grpc.Bike>) responseObserver);
                    break;
                case METHODID_UPDATE_RATING_BY_ID:
                    serviceImpl.updateRatingById((bikes.grpc.BikeUpdateRatingRequest) request, (io.grpc.stub.StreamObserver<bikes.grpc.Bike>) responseObserver);
                    break;
                case METHODID_DELETE_BY_ID:
                    serviceImpl.deleteById((com.google.protobuf.Int32Value) request, (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
                    break;
                case METHODID_DELETE_ALL:
                    serviceImpl.deleteAll((com.google.protobuf.Empty) request, (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
                    break;
                case METHODID_DELETE_BY_LOCATION:
                    serviceImpl.deleteByLocation((com.google.protobuf.StringValue) request, (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver);
                    break;
                default:
                    throw new AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch(methodId) {
                default:
                    throw new AssertionError();
            }
        }
    }

    public static io.grpc.ServerServiceDefinition bindService(AsyncService service) {
        return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor()).addMethod(getGetAllStreamMethod(), io.grpc.stub.ServerCalls.asyncServerStreamingCall(new MethodHandlers<com.google.protobuf.Empty, bikes.grpc.Bike>(service, METHODID_GET_ALL_STREAM))).addMethod(getGetAllMethod(), io.grpc.stub.ServerCalls.asyncUnaryCall(new MethodHandlers<com.google.protobuf.Empty, bikes.grpc.BikeList>(service, METHODID_GET_ALL))).addMethod(getGetByLocationStreamMethod(), io.grpc.stub.ServerCalls.asyncServerStreamingCall(new MethodHandlers<com.google.protobuf.StringValue, bikes.grpc.Bike>(service, METHODID_GET_BY_LOCATION_STREAM))).addMethod(getGetByLocationMethod(), io.grpc.stub.ServerCalls.asyncUnaryCall(new MethodHandlers<com.google.protobuf.StringValue, bikes.grpc.BikeList>(service, METHODID_GET_BY_LOCATION))).addMethod(getGetByIdMethod(), io.grpc.stub.ServerCalls.asyncUnaryCall(new MethodHandlers<com.google.protobuf.Int32Value, bikes.grpc.Bike>(service, METHODID_GET_BY_ID))).addMethod(getUpdateByIdMethod(), io.grpc.stub.ServerCalls.asyncUnaryCall(new MethodHandlers<bikes.grpc.BikeRequest, bikes.grpc.Bike>(service, METHODID_UPDATE_BY_ID))).addMethod(getCreateMethod(), io.grpc.stub.ServerCalls.asyncUnaryCall(new MethodHandlers<bikes.grpc.BikeRequest, bikes.grpc.Bike>(service, METHODID_CREATE))).addMethod(getUpdateRatingByIdMethod(), io.grpc.stub.ServerCalls.asyncUnaryCall(new MethodHandlers<bikes.grpc.BikeUpdateRatingRequest, bikes.grpc.Bike>(service, METHODID_UPDATE_RATING_BY_ID))).addMethod(getDeleteByIdMethod(), io.grpc.stub.ServerCalls.asyncUnaryCall(new MethodHandlers<com.google.protobuf.Int32Value, com.google.protobuf.Empty>(service, METHODID_DELETE_BY_ID))).addMethod(getDeleteAllMethod(), io.grpc.stub.ServerCalls.asyncUnaryCall(new MethodHandlers<com.google.protobuf.Empty, com.google.protobuf.Empty>(service, METHODID_DELETE_ALL))).addMethod(getDeleteByLocationMethod(), io.grpc.stub.ServerCalls.asyncUnaryCall(new MethodHandlers<com.google.protobuf.StringValue, com.google.protobuf.Empty>(service, METHODID_DELETE_BY_LOCATION))).build();
    }

    private static abstract class BikesBaseDescriptorSupplier implements io.grpc.protobuf.ProtoFileDescriptorSupplier, io.grpc.protobuf.ProtoServiceDescriptorSupplier {

        BikesBaseDescriptorSupplier() {
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.FileDescriptor getFileDescriptor() {
            return bikes.grpc.BikesOuterClass.getDescriptor();
        }

        @java.lang.Override
        public com.google.protobuf.Descriptors.ServiceDescriptor getServiceDescriptor() {
            return getFileDescriptor().findServiceByName("Bikes");
        }
    }

    private static final class BikesFileDescriptorSupplier extends BikesBaseDescriptorSupplier {

        BikesFileDescriptorSupplier() {
        }
    }

    private static final class BikesMethodDescriptorSupplier extends BikesBaseDescriptorSupplier implements io.grpc.protobuf.ProtoMethodDescriptorSupplier {

        private final java.lang.String methodName;

        BikesMethodDescriptorSupplier(java.lang.String methodName) {
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
            synchronized (BikesGrpc.class) {
                result = serviceDescriptor;
                if (result == null) {
                    serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME).setSchemaDescriptor(new BikesFileDescriptorSupplier()).addMethod(getGetAllStreamMethod()).addMethod(getGetAllMethod()).addMethod(getGetByLocationStreamMethod()).addMethod(getGetByLocationMethod()).addMethod(getGetByIdMethod()).addMethod(getUpdateByIdMethod()).addMethod(getCreateMethod()).addMethod(getUpdateRatingByIdMethod()).addMethod(getDeleteByIdMethod()).addMethod(getDeleteAllMethod()).addMethod(getDeleteByLocationMethod()).build();
                }
            }
        }
        return result;
    }
}
