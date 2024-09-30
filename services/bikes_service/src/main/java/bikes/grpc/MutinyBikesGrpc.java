package bikes.grpc;

import static bikes.grpc.BikesGrpc.getServiceDescriptor;
import static io.grpc.stub.ServerCalls.asyncUnaryCall;
import static io.grpc.stub.ServerCalls.asyncServerStreamingCall;
import static io.grpc.stub.ServerCalls.asyncClientStreamingCall;
import static io.grpc.stub.ServerCalls.asyncBidiStreamingCall;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: bikes.proto")
public final class MutinyBikesGrpc implements io.quarkus.grpc.MutinyGrpc {

    private MutinyBikesGrpc() {
    }

    public static MutinyBikesStub newMutinyStub(io.grpc.Channel channel) {
        return new MutinyBikesStub(channel);
    }

    public static class MutinyBikesStub extends io.grpc.stub.AbstractStub<MutinyBikesStub> implements io.quarkus.grpc.MutinyStub {

        private BikesGrpc.BikesStub delegateStub;

        private MutinyBikesStub(io.grpc.Channel channel) {
            super(channel);
            delegateStub = BikesGrpc.newStub(channel);
        }

        private MutinyBikesStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            super(channel, callOptions);
            delegateStub = BikesGrpc.newStub(channel).build(channel, callOptions);
        }

        @Override
        protected MutinyBikesStub build(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
            return new MutinyBikesStub(channel, callOptions);
        }

        public io.smallrye.mutiny.Uni<bikes.grpc.BikeList> getAll(com.google.protobuf.Empty request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::getAll);
        }

        public io.smallrye.mutiny.Uni<bikes.grpc.BikeList> getByLocation(com.google.protobuf.StringValue request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::getByLocation);
        }

        public io.smallrye.mutiny.Uni<bikes.grpc.Bike> getById(com.google.protobuf.Int32Value request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::getById);
        }

        public io.smallrye.mutiny.Uni<bikes.grpc.Bike> updateById(bikes.grpc.BikeRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::updateById);
        }

        public io.smallrye.mutiny.Uni<bikes.grpc.Bike> create(bikes.grpc.BikeRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::create);
        }

        public io.smallrye.mutiny.Uni<bikes.grpc.Bike> updateRatingById(bikes.grpc.BikeUpdateRatingRequest request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::updateRatingById);
        }

        public io.smallrye.mutiny.Uni<com.google.protobuf.Empty> deleteById(com.google.protobuf.Int32Value request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::deleteById);
        }

        public io.smallrye.mutiny.Uni<com.google.protobuf.Empty> deleteAll(com.google.protobuf.Empty request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::deleteAll);
        }

        public io.smallrye.mutiny.Uni<com.google.protobuf.Empty> deleteByLocation(com.google.protobuf.StringValue request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToOne(request, delegateStub::deleteByLocation);
        }

        public io.smallrye.mutiny.Multi<bikes.grpc.Bike> getAllStream(com.google.protobuf.Empty request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToMany(request, delegateStub::getAllStream);
        }

        public io.smallrye.mutiny.Multi<bikes.grpc.Bike> getByLocationStream(com.google.protobuf.StringValue request) {
            return io.quarkus.grpc.stubs.ClientCalls.oneToMany(request, delegateStub::getByLocationStream);
        }
    }

    public static abstract class BikesImplBase implements io.grpc.BindableService {

        private String compression;

        /**
         * Set whether the server will try to use a compressed response.
         *
         * @param compression the compression, e.g {@code gzip}
         */
        public BikesImplBase withCompression(String compression) {
            this.compression = compression;
            return this;
        }

        public io.smallrye.mutiny.Uni<bikes.grpc.BikeList> getAll(com.google.protobuf.Empty request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public io.smallrye.mutiny.Uni<bikes.grpc.BikeList> getByLocation(com.google.protobuf.StringValue request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public io.smallrye.mutiny.Uni<bikes.grpc.Bike> getById(com.google.protobuf.Int32Value request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public io.smallrye.mutiny.Uni<bikes.grpc.Bike> updateById(bikes.grpc.BikeRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public io.smallrye.mutiny.Uni<bikes.grpc.Bike> create(bikes.grpc.BikeRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public io.smallrye.mutiny.Uni<bikes.grpc.Bike> updateRatingById(bikes.grpc.BikeUpdateRatingRequest request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public io.smallrye.mutiny.Uni<com.google.protobuf.Empty> deleteById(com.google.protobuf.Int32Value request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public io.smallrye.mutiny.Uni<com.google.protobuf.Empty> deleteAll(com.google.protobuf.Empty request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public io.smallrye.mutiny.Uni<com.google.protobuf.Empty> deleteByLocation(com.google.protobuf.StringValue request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public io.smallrye.mutiny.Multi<bikes.grpc.Bike> getAllStream(com.google.protobuf.Empty request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        public io.smallrye.mutiny.Multi<bikes.grpc.Bike> getByLocationStream(com.google.protobuf.StringValue request) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }

        @java.lang.Override
        public io.grpc.ServerServiceDefinition bindService() {
            return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor()).addMethod(bikes.grpc.BikesGrpc.getGetAllStreamMethod(), asyncServerStreamingCall(new MethodHandlers<com.google.protobuf.Empty, bikes.grpc.Bike>(this, METHODID_GET_ALL_STREAM, compression))).addMethod(bikes.grpc.BikesGrpc.getGetAllMethod(), asyncUnaryCall(new MethodHandlers<com.google.protobuf.Empty, bikes.grpc.BikeList>(this, METHODID_GET_ALL, compression))).addMethod(bikes.grpc.BikesGrpc.getGetByLocationStreamMethod(), asyncServerStreamingCall(new MethodHandlers<com.google.protobuf.StringValue, bikes.grpc.Bike>(this, METHODID_GET_BY_LOCATION_STREAM, compression))).addMethod(bikes.grpc.BikesGrpc.getGetByLocationMethod(), asyncUnaryCall(new MethodHandlers<com.google.protobuf.StringValue, bikes.grpc.BikeList>(this, METHODID_GET_BY_LOCATION, compression))).addMethod(bikes.grpc.BikesGrpc.getGetByIdMethod(), asyncUnaryCall(new MethodHandlers<com.google.protobuf.Int32Value, bikes.grpc.Bike>(this, METHODID_GET_BY_ID, compression))).addMethod(bikes.grpc.BikesGrpc.getUpdateByIdMethod(), asyncUnaryCall(new MethodHandlers<bikes.grpc.BikeRequest, bikes.grpc.Bike>(this, METHODID_UPDATE_BY_ID, compression))).addMethod(bikes.grpc.BikesGrpc.getCreateMethod(), asyncUnaryCall(new MethodHandlers<bikes.grpc.BikeRequest, bikes.grpc.Bike>(this, METHODID_CREATE, compression))).addMethod(bikes.grpc.BikesGrpc.getUpdateRatingByIdMethod(), asyncUnaryCall(new MethodHandlers<bikes.grpc.BikeUpdateRatingRequest, bikes.grpc.Bike>(this, METHODID_UPDATE_RATING_BY_ID, compression))).addMethod(bikes.grpc.BikesGrpc.getDeleteByIdMethod(), asyncUnaryCall(new MethodHandlers<com.google.protobuf.Int32Value, com.google.protobuf.Empty>(this, METHODID_DELETE_BY_ID, compression))).addMethod(bikes.grpc.BikesGrpc.getDeleteAllMethod(), asyncUnaryCall(new MethodHandlers<com.google.protobuf.Empty, com.google.protobuf.Empty>(this, METHODID_DELETE_ALL, compression))).addMethod(bikes.grpc.BikesGrpc.getDeleteByLocationMethod(), asyncUnaryCall(new MethodHandlers<com.google.protobuf.StringValue, com.google.protobuf.Empty>(this, METHODID_DELETE_BY_LOCATION, compression))).build();
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

        private final BikesImplBase serviceImpl;

        private final int methodId;

        private final String compression;

        MethodHandlers(BikesImplBase serviceImpl, int methodId, String compression) {
            this.serviceImpl = serviceImpl;
            this.methodId = methodId;
            this.compression = compression;
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch(methodId) {
                case METHODID_GET_ALL_STREAM:
                    io.quarkus.grpc.stubs.ServerCalls.oneToMany((com.google.protobuf.Empty) request, (io.grpc.stub.StreamObserver<bikes.grpc.Bike>) responseObserver, compression, serviceImpl::getAllStream);
                    break;
                case METHODID_GET_ALL:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.google.protobuf.Empty) request, (io.grpc.stub.StreamObserver<bikes.grpc.BikeList>) responseObserver, compression, serviceImpl::getAll);
                    break;
                case METHODID_GET_BY_LOCATION_STREAM:
                    io.quarkus.grpc.stubs.ServerCalls.oneToMany((com.google.protobuf.StringValue) request, (io.grpc.stub.StreamObserver<bikes.grpc.Bike>) responseObserver, compression, serviceImpl::getByLocationStream);
                    break;
                case METHODID_GET_BY_LOCATION:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.google.protobuf.StringValue) request, (io.grpc.stub.StreamObserver<bikes.grpc.BikeList>) responseObserver, compression, serviceImpl::getByLocation);
                    break;
                case METHODID_GET_BY_ID:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.google.protobuf.Int32Value) request, (io.grpc.stub.StreamObserver<bikes.grpc.Bike>) responseObserver, compression, serviceImpl::getById);
                    break;
                case METHODID_UPDATE_BY_ID:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((bikes.grpc.BikeRequest) request, (io.grpc.stub.StreamObserver<bikes.grpc.Bike>) responseObserver, compression, serviceImpl::updateById);
                    break;
                case METHODID_CREATE:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((bikes.grpc.BikeRequest) request, (io.grpc.stub.StreamObserver<bikes.grpc.Bike>) responseObserver, compression, serviceImpl::create);
                    break;
                case METHODID_UPDATE_RATING_BY_ID:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((bikes.grpc.BikeUpdateRatingRequest) request, (io.grpc.stub.StreamObserver<bikes.grpc.Bike>) responseObserver, compression, serviceImpl::updateRatingById);
                    break;
                case METHODID_DELETE_BY_ID:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.google.protobuf.Int32Value) request, (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver, compression, serviceImpl::deleteById);
                    break;
                case METHODID_DELETE_ALL:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.google.protobuf.Empty) request, (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver, compression, serviceImpl::deleteAll);
                    break;
                case METHODID_DELETE_BY_LOCATION:
                    io.quarkus.grpc.stubs.ServerCalls.oneToOne((com.google.protobuf.StringValue) request, (io.grpc.stub.StreamObserver<com.google.protobuf.Empty>) responseObserver, compression, serviceImpl::deleteByLocation);
                    break;
                default:
                    throw new java.lang.AssertionError();
            }
        }

        @java.lang.Override
        @java.lang.SuppressWarnings("unchecked")
        public io.grpc.stub.StreamObserver<Req> invoke(io.grpc.stub.StreamObserver<Resp> responseObserver) {
            switch(methodId) {
                default:
                    throw new java.lang.AssertionError();
            }
        }
    }
}
