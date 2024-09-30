package bikes.services;

import bikes.broker.BikeMessage;
import bikes.entities.BikeEntity;

import bikes.grpc.Bike;
import bikes.grpc.BikeRequest;
import bikes.grpc.BikeUpdateRatingRequest;
import bikes.mappings.BikeMapper;
import bikes.repositories.BikeRepository;

import java.util.List;
import java.util.stream.Stream;

import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import jakarta.inject.Inject;

import org.mockito.ArgumentCaptor;
import org.mockito.Mockito;
import io.quarkus.test.InjectMock;
import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;




@QuarkusTest
class BikeServiceTest {
    @Inject
    BikeService bikeService;

    @Inject
    BikeMapper bikeMapper;
    @InjectMock
    private BikeRepository bikeRepository;


    @BeforeEach
    void configure(){
        BikeEntity mockEntity = new BikeEntity();
        mockEntity.setId(1);
        mockEntity.setName("name");
        mockEntity.setLocationId("location");
        mockEntity.setRentCount(0);
        mockEntity.setTimeTravelled(0.0);
        mockEntity.setRating(2.5);
        mockEntity.setRateCount(1);

        Mockito.when(bikeRepository.listAll()).thenReturn(List.of(mockEntity));
        Mockito.when(bikeRepository.findById(1)).thenReturn(mockEntity);
        Mockito.when(bikeRepository.getByLocation("location")).thenReturn(List.of(mockEntity));
        Mockito.when(bikeRepository.streamAll()).thenReturn(Stream.of(mockEntity));
        Mockito.when(bikeRepository.getByLocationStream("location")).thenReturn(Stream.of(mockEntity));
    }

    @Test
    void getAll() {
        List<Bike> result = bikeService.getAll();

        Mockito.verify(bikeRepository).listAll();
        Assertions.assertEquals(result.size(), 1);
    }

    @Test
    void getById() {
        Bike result = bikeService.getById(Int32Value.of(1));

        Mockito.verify(bikeRepository).findById(1);
        Assertions.assertEquals(result.getId(), 1);
        Assertions.assertEquals(result.getName(), "name");
        Assertions.assertEquals(result.getLocationId(), "location");
        Assertions.assertEquals(result.getRating(), 2.5);
        Assertions.assertEquals(result.getRentCount(), 0);
        Assertions.assertEquals(result.getRatingCount(), 1);
        Assertions.assertEquals(result.getTimeTravelled(), 0.0);
    }

    @Test
    void getByLocation() {

        List<Bike> result = bikeService.getByLocation(StringValue.of("location"));

        Mockito.verify(bikeRepository).getByLocation("location");
        Assertions.assertEquals(result.size(), 1);

    }

    @Test
    void create() {
        BikeRequest mockBikeRequest = BikeRequest.newBuilder()
                .setId(1)
                .setName("name")
                .setLocationId("location")
                .build();


        Bike result = bikeService.create(mockBikeRequest);

        ArgumentCaptor<BikeEntity> captor = ArgumentCaptor.forClass(BikeEntity.class);
        Mockito.verify(bikeRepository).persist(captor.capture());

        Assertions.assertEquals(captor.getValue().getId(), 1);
        Assertions.assertEquals(captor.getValue().getName(), "name");
        Assertions.assertEquals(captor.getValue().getLocationId(), "location");
        Assertions.assertEquals(captor.getValue().getRating(), 2.5);
        Assertions.assertEquals(captor.getValue().getRentCount(), 0);
        Assertions.assertEquals(captor.getValue().getRateCount(), 1);
        Assertions.assertEquals(captor.getValue().getTimeTravelled(), 0.0);

        Assertions.assertEquals(result.getId(), 1);
        Assertions.assertEquals(result.getName(), "name");
        Assertions.assertEquals(result.getLocationId(), "location");
        Assertions.assertEquals(result.getRating(), 2.5);
        Assertions.assertEquals(result.getRentCount(), 0);
        Assertions.assertEquals(result.getRatingCount(), 1);
        Assertions.assertEquals(result.getTimeTravelled(), 0.0);
    }

    @Test
    void update() {
        BikeRequest mockBikeRequest = BikeRequest.newBuilder()
            .setId(1)
            .setName("newName")
            .setLocationId("newLocation")
            .build();

        Bike result = bikeService.update(mockBikeRequest);


        ArgumentCaptor<BikeEntity> captor = ArgumentCaptor.forClass(BikeEntity.class);
        Mockito.verify(bikeRepository).persist(captor.capture());

        Assertions.assertEquals(captor.getValue().getId(), 1);
        Assertions.assertEquals(captor.getValue().getName(), "newName");
        Assertions.assertEquals(captor.getValue().getLocationId(), "newLocation");
        Assertions.assertEquals(captor.getValue().getRating(), 2.5);
        Assertions.assertEquals(captor.getValue().getRentCount(), 0);
        Assertions.assertEquals(captor.getValue().getRateCount(), 1);
        Assertions.assertEquals(captor.getValue().getTimeTravelled(), 0.0);

        Assertions.assertEquals(result.getId(), 1);
        Assertions.assertEquals(result.getName(), "newName");
        Assertions.assertEquals(result.getLocationId(), "newLocation");
        Assertions.assertEquals(result.getRating(), 2.5);
        Assertions.assertEquals(result.getRentCount(), 0);
        Assertions.assertEquals(result.getRatingCount(), 1);
        Assertions.assertEquals(result.getTimeTravelled(), 0.0);
    }

    @Test
    void updateRating() {
        BikeUpdateRatingRequest mockBikeRequest = BikeUpdateRatingRequest.newBuilder()
                .setId(1)
                .setRating(5)
                .build();

        Bike result = bikeService.updateRating(mockBikeRequest);


        ArgumentCaptor<BikeEntity> captor = ArgumentCaptor.forClass(BikeEntity.class);
        Mockito.verify(bikeRepository).persist(captor.capture());

        Assertions.assertEquals(captor.getValue().getId(), 1);
        Assertions.assertEquals(captor.getValue().getName(), "name");
        Assertions.assertEquals(captor.getValue().getLocationId(), "location");
        Assertions.assertEquals(captor.getValue().getRating(), 3.75);
        Assertions.assertEquals(captor.getValue().getRentCount(), 0);
        Assertions.assertEquals(captor.getValue().getRateCount(), 2);
        Assertions.assertEquals(captor.getValue().getTimeTravelled(), 0.0);

        Assertions.assertEquals(result.getId(), 1);
        Assertions.assertEquals(result.getName(), "name");
        Assertions.assertEquals(result.getLocationId(), "location");
        Assertions.assertEquals(result.getRating(), 3.75);
        Assertions.assertEquals(result.getRatingCount(), 2);
        Assertions.assertEquals(result.getRentCount(), 0);
        Assertions.assertEquals(result.getTimeTravelled(), 0.0);
    }

    @Test
    void deleteAll() {
        bikeService.deleteAll();

        Mockito.verify(bikeRepository).deleteAll();
    }

    @Test
    void deleteByLocation() {
        bikeService.deleteByLocation(StringValue.of("location"));

        Mockito.verify(bikeRepository).deleteByLocation("location");
    }

    @Test
    void deleteById() {
        bikeService.deleteById(Int32Value.of(1));

        Mockito.verify(bikeRepository).delete("id", 1);
    }

    @Test
    void streamAll() {
        Stream<Bike> result = bikeService.streamAll();

        Mockito.verify(bikeRepository).streamAll();
        Assertions.assertEquals(result.toList().size(), 1);
    }

    @Test
    void getByLocationStream() {
        Stream<Bike> result = bikeService.getByLocationStream(StringValue.of("location"));

        Mockito.verify(bikeRepository).getByLocationStream("location");
        Assertions.assertEquals(result.toList().size(), 1);
    }

    @Test
    void changeLocation() {
        BikeMessage mockMessage = new BikeMessage(1, "location2");

        bikeService.changeLocation(mockMessage);

        Mockito.verify(bikeRepository).findById(1);
        ArgumentCaptor<BikeEntity> captor = ArgumentCaptor.forClass(BikeEntity.class);
        Mockito.verify(bikeRepository).persist(captor.capture());

        Assertions.assertEquals(captor.getValue().getId(), 1);
        Assertions.assertEquals(captor.getValue().getName(), "name");
        Assertions.assertEquals(captor.getValue().getLocationId(), "location2");
        Assertions.assertEquals(captor.getValue().getRating(), 2.5);
        Assertions.assertEquals(captor.getValue().getRentCount(), 0);
        Assertions.assertEquals(captor.getValue().getRateCount(), 1);
        Assertions.assertEquals(captor.getValue().getTimeTravelled(), 0.0);
    }
}