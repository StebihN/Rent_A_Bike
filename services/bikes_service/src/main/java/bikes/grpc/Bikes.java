package bikes.grpc;

import io.quarkus.grpc.MutinyService;

@jakarta.annotation.Generated(value = "by Mutiny Grpc generator", comments = "Source: bikes.proto")
public interface Bikes extends MutinyService {

    io.smallrye.mutiny.Uni<bikes.grpc.BikeList> getAll(com.google.protobuf.Empty request);

    io.smallrye.mutiny.Uni<bikes.grpc.BikeList> getByLocation(com.google.protobuf.StringValue request);

    io.smallrye.mutiny.Uni<bikes.grpc.Bike> getById(com.google.protobuf.Int32Value request);

    io.smallrye.mutiny.Uni<bikes.grpc.Bike> updateById(bikes.grpc.BikeRequest request);

    io.smallrye.mutiny.Uni<bikes.grpc.Bike> create(bikes.grpc.BikeRequest request);

    io.smallrye.mutiny.Uni<com.google.protobuf.Empty> deleteById(com.google.protobuf.Int32Value request);

    io.smallrye.mutiny.Uni<com.google.protobuf.Empty> deleteAll(com.google.protobuf.Empty request);

    io.smallrye.mutiny.Uni<com.google.protobuf.Empty> deleteByLocation(com.google.protobuf.StringValue request);

    io.smallrye.mutiny.Multi<bikes.grpc.Bike> getAllStream(com.google.protobuf.Empty request);

    io.smallrye.mutiny.Multi<bikes.grpc.Bike> getByLocationStream(com.google.protobuf.StringValue request);
}
