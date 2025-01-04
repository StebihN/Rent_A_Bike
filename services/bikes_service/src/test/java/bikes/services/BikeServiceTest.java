package bikes.services;

import bikes.entities.BikeEntity;

import bikes.grpc.Bike;
import bikes.grpc.BikeRequest;
import bikes.repositories.BikeRepository;

import java.util.List;
import java.util.Optional;
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

    @InjectMock
    private  BikeRepository bikeRepository;


    @BeforeEach
    void configure(){
        BikeEntity mockEntity = new BikeEntity();
        mockEntity.setId(1);
        mockEntity.setStationId("station");
        mockEntity.setTimesRented(0);
        mockEntity.setTotalTimeRented(0);
        mockEntity.setRating(2.5);
        mockEntity.setTimesRated(1);

        Mockito.when(bikeRepository.listAll()).thenReturn(List.of(mockEntity));
        Mockito.when(bikeRepository.findById(1)).thenReturn(mockEntity);
        Mockito.when(bikeRepository.findByIdOptional(1)).thenReturn(Optional.of(mockEntity));
        Mockito.when(bikeRepository.getByStation("station")).thenReturn(List.of(mockEntity));
        Mockito.when(bikeRepository.streamAll()).thenReturn(Stream.of(mockEntity));
        Mockito.when(bikeRepository.getByStationStream("station")).thenReturn(Stream.of(mockEntity));
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

        Assertions.assertEquals(result.getStationId(), "station");
        Assertions.assertEquals(result.getRating(), 2.5);
        Assertions.assertEquals(result.getTimesRented(), 0);
        Assertions.assertEquals(result.getTimesRated(), 1);
        Assertions.assertEquals(result.getTotalTimeRented(), 0.0);
    }

    @Test
    void getByLocation() {

        List<Bike> result = bikeService.getByLocation(StringValue.of("station"));

        Mockito.verify(bikeRepository).getByStation("station");
        Assertions.assertEquals(result.size(), 1);

    }

    @Test
    void create() {
        BikeRequest mockBikeRequest = BikeRequest.newBuilder()
                .setId(1)
                .setStationId("station")
                .build();


        Bike result = bikeService.create(mockBikeRequest);

        ArgumentCaptor<BikeEntity> captor = ArgumentCaptor.forClass(BikeEntity.class);
        Mockito.verify(bikeRepository).persist(captor.capture());

        Assertions.assertEquals(captor.getValue().getId(), 1);
        Assertions.assertEquals(captor.getValue().getStationId(), "station");
        Assertions.assertEquals(captor.getValue().getRating(), 2.5);
        Assertions.assertEquals(captor.getValue().getTimesRented(), 0);
        Assertions.assertEquals(captor.getValue().getTimesRated(), 1);
        Assertions.assertEquals(captor.getValue().getTotalTimeRented(), 0);

        Assertions.assertEquals(result.getId(), 1);
        Assertions.assertEquals(result.getStationId(), "station");
        Assertions.assertEquals(result.getRating(), 2.5);
        Assertions.assertEquals(result.getTimesRented(), 0);
        Assertions.assertEquals(result.getTimesRated(), 1);
        Assertions.assertEquals(result.getTotalTimeRented(), 0);
    }

    @Test
    void update() {
        BikeRequest mockBikeRequest = BikeRequest.newBuilder()
                .setId(1)
                .setStationId("station")
                .setRating(5)
                .setTotalTimeRented(1000)
                .build();

        Bike result = bikeService.update(mockBikeRequest);

        ArgumentCaptor<BikeEntity> captor = ArgumentCaptor.forClass(BikeEntity.class);
        Mockito.verify(bikeRepository).persist(captor.capture());

        Assertions.assertEquals(captor.getValue().getId(), 1);
        Assertions.assertEquals(captor.getValue().getStationId(), "station");
        Assertions.assertEquals(captor.getValue().getRating(), 3.75);
        Assertions.assertEquals(captor.getValue().getTimesRented(), 1);
        Assertions.assertEquals(captor.getValue().getTimesRated(), 2);
        Assertions.assertEquals(captor.getValue().getTotalTimeRented(), 1000);

        Assertions.assertEquals(result.getId(), 1);
        Assertions.assertEquals(result.getStationId(), "station");
        Assertions.assertEquals(result.getRating(), 3.75);
        Assertions.assertEquals(result.getTimesRented(), 1);
        Assertions.assertEquals(result.getTimesRated(), 2);
        Assertions.assertEquals(result.getTotalTimeRented(), 1000);
    }

    @Test
    void deleteAll() {
        bikeService.deleteAll();

        Mockito.verify(bikeRepository).deleteAll();
    }

    @Test
    void deleteByLocation() {
        bikeService.deleteByLocation(StringValue.of("station"));

        Mockito.verify(bikeRepository).deleteByStation("station");
    }

    @Test
    void deleteById() {
        bikeService.deleteById(Int32Value.of(1));

        Mockito.verify(bikeRepository).deleteById(1);
    }

    @Test
    void streamAll() {
        Stream<Bike> result = bikeService.streamAll();

        Mockito.verify(bikeRepository).streamAll();
        Assertions.assertEquals(result.toList().size(), 1);
    }

    @Test
    void getByLocationStream() {
        Stream<Bike> result = bikeService.getByLocationStream(StringValue.of("station"));

        Mockito.verify(bikeRepository).getByStationStream("station");
        Assertions.assertEquals(result.toList().size(), 1);
    }
}