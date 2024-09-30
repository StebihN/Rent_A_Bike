package bikes.grpc;

import io.grpc.BindableService;
import io.quarkus.grpc.GrpcService;
import io.quarkus.grpc.MutinyBean;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: bikes.proto")
public class BikesBean extends MutinyBikesGrpc.BikesImplBase implements BindableService, MutinyBean {

    private final Bikes delegate;

    BikesBean(@GrpcService Bikes delegate) {
        this.delegate = delegate;
    }

    @Override
    public io.smallrye.mutiny.Uni<bikes.grpc.BikeList> getAll(com.google.protobuf.Empty request) {
        try {
            return delegate.getAll(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<bikes.grpc.BikeList> getByLocation(com.google.protobuf.StringValue request) {
        try {
            return delegate.getByLocation(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<bikes.grpc.Bike> getById(com.google.protobuf.Int32Value request) {
        try {
            return delegate.getById(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<bikes.grpc.Bike> updateById(bikes.grpc.BikeRequest request) {
        try {
            return delegate.updateById(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<bikes.grpc.Bike> create(bikes.grpc.BikeRequest request) {
        try {
            return delegate.create(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<bikes.grpc.Bike> updateRatingById(bikes.grpc.BikeUpdateRatingRequest request) {
        try {
            return delegate.updateRatingById(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.google.protobuf.Empty> deleteById(com.google.protobuf.Int32Value request) {
        try {
            return delegate.deleteById(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.google.protobuf.Empty> deleteAll(com.google.protobuf.Empty request) {
        try {
            return delegate.deleteAll(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Uni<com.google.protobuf.Empty> deleteByLocation(com.google.protobuf.StringValue request) {
        try {
            return delegate.deleteByLocation(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Multi<bikes.grpc.Bike> getAllStream(com.google.protobuf.Empty request) {
        try {
            return delegate.getAllStream(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }

    @Override
    public io.smallrye.mutiny.Multi<bikes.grpc.Bike> getByLocationStream(com.google.protobuf.StringValue request) {
        try {
            return delegate.getByLocationStream(request);
        } catch (UnsupportedOperationException e) {
            throw new io.grpc.StatusRuntimeException(io.grpc.Status.UNIMPLEMENTED);
        }
    }
}
