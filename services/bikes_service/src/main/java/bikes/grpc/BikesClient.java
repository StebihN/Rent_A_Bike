package bikes.grpc;

import java.util.function.BiFunction;
import io.quarkus.grpc.MutinyClient;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: bikes.proto")
public class BikesClient implements Bikes, MutinyClient<MutinyBikesGrpc.MutinyBikesStub> {

    private final MutinyBikesGrpc.MutinyBikesStub stub;

    public BikesClient(String name, io.grpc.Channel channel, BiFunction<String, MutinyBikesGrpc.MutinyBikesStub, MutinyBikesGrpc.MutinyBikesStub> stubConfigurator) {
        this.stub = stubConfigurator.apply(name, MutinyBikesGrpc.newMutinyStub(channel));
    }

    private BikesClient(MutinyBikesGrpc.MutinyBikesStub stub) {
        this.stub = stub;
    }

    public BikesClient newInstanceWithStub(MutinyBikesGrpc.MutinyBikesStub stub) {
        return new BikesClient(stub);
    }

    @Override
    public MutinyBikesGrpc.MutinyBikesStub getStub() {
        return stub;
    }

    @Override
    public io.smallrye.mutiny.Uni<bikes.grpc.BikeList> getAll(com.google.protobuf.Empty request) {
        return stub.getAll(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<bikes.grpc.BikeList> getByLocation(com.google.protobuf.StringValue request) {
        return stub.getByLocation(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<bikes.grpc.Bike> getById(com.google.protobuf.Int32Value request) {
        return stub.getById(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<bikes.grpc.Bike> updateById(bikes.grpc.BikeRequest request) {
        return stub.updateById(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<bikes.grpc.Bike> create(bikes.grpc.BikeRequest request) {
        return stub.create(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.google.protobuf.Empty> deleteById(com.google.protobuf.Int32Value request) {
        return stub.deleteById(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.google.protobuf.Empty> deleteAll(com.google.protobuf.Empty request) {
        return stub.deleteAll(request);
    }

    @Override
    public io.smallrye.mutiny.Uni<com.google.protobuf.Empty> deleteByLocation(com.google.protobuf.StringValue request) {
        return stub.deleteByLocation(request);
    }

    @Override
    public io.smallrye.mutiny.Multi<bikes.grpc.Bike> getAllStream(com.google.protobuf.Empty request) {
        return stub.getAllStream(request);
    }

    @Override
    public io.smallrye.mutiny.Multi<bikes.grpc.Bike> getByLocationStream(com.google.protobuf.StringValue request) {
        return stub.getByLocationStream(request);
    }
}
