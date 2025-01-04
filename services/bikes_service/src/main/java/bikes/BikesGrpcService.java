package bikes;

import bikes.grpc.*;
import bikes.services.BikeService;
import com.google.protobuf.Empty;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import io.grpc.Status;
import io.grpc.StatusRuntimeException;
import io.quarkus.grpc.GrpcService;
import io.smallrye.common.annotation.Blocking;
import jakarta.inject.Inject;
import lombok.extern.slf4j.Slf4j;
import io.smallrye.mutiny.Multi;
import io.smallrye.mutiny.Uni;

import java.util.List;
import java.util.NoSuchElementException;


@Slf4j
@GrpcService
public class BikesGrpcService implements Bikes {

    @Inject
    BikeService bikeService;


    @Override
    @Blocking
    public Uni<BikeList> getAll(Empty request) {
        log.info("Getting all bikes");
        List<Bike> bikes = bikeService.getAll();
        return Uni.createFrom().item(BikeList.newBuilder().addAllBikes(bikes).build());
    }

    @Override
    @Blocking
    public Uni<BikeList> getByLocation(StringValue request) {
        log.info("getting bikes at location " + request.getValue());
        List<Bike> bikes = bikeService.getByLocation(request);
        return Uni.createFrom().item(BikeList.newBuilder().addAllBikes(bikes).build());
    }

    @Override
    @Blocking
    public Uni<Bike> getById(Int32Value request) {
        log.info("getting bike with id " + request.getValue());
        return Uni.createFrom().item(bikeService.getById(request)).onItem().ifNull().switchTo(
                Uni.createFrom().failure(new StatusRuntimeException(
                        Status.NOT_FOUND.withDescription("Bike with id " + request.getValue() + " not found"))));
    }

    @Override
    @Blocking
    public Uni<Bike> updateById(BikeRequest request) {
        log.info("updating bike with id" + request.getId());
        Bike bike = bikeService.update(request);
        return Uni.createFrom().item(bike).onItem().ifNull().switchTo(
                Uni.createFrom().failure(new StatusRuntimeException(
                        Status.NOT_FOUND.withDescription("Bike with id " + request.getId() + " not found"))));


    }


    @Override
    @Blocking
    public Uni<Bike> create(BikeRequest request) {
        log.info("creating bike");
        Bike bike = bikeService.create(request);
        return Uni.createFrom().item(bike);
    }

    @Override
    @Blocking
    public Uni<Empty> deleteAll(Empty request) {
        log.info("deleting all bikes");
        bikeService.deleteAll();
        return Uni.createFrom().item(Empty.newBuilder().build());
    }

    @Override
    @Blocking
    public Uni<Empty> deleteByLocation(StringValue request) {
        log.info("deleting bikes at station:" + request.getValue());
        bikeService.deleteByLocation(request);
        return Uni.createFrom().item(Empty.newBuilder().build());
    }

    @Override
    @Blocking
    public Uni<Empty> deleteById(Int32Value request) {
        log.info("deleting bike with id " + request.getValue());
        bikeService.deleteById(request);
        return Uni.createFrom().item(Empty.newBuilder().build());
    }

    @Override
    @Blocking
    public Multi<Bike> getAllStream(Empty request) {
        log.info("streaming all bikes");
        return Multi.createFrom().items(bikeService.streamAll());
    }

    @Override
    @Blocking
    public Multi<Bike> getByLocationStream(StringValue request) {
        log.info("streaming all bikes at location " + request.getValue());
        return Multi.createFrom().items(bikeService.getByLocationStream(request));
    }
}
