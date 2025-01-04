package stations.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import stations.entities.Station;
import stations.repositories.StationRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
public class StationsControllerTest {

    @Autowired
    private StationController stationController;

    @MockBean
    private StationRepository stationRepository;


    @Test
    public void testFindAll() {
        List<Station> mockedStations = List.of(new Station("Station", 12.3, 12.3, 20),
                new Station("StationTwo", 45.6, 45.6, 30));

        when(stationRepository.findAll()).thenReturn(mockedStations);

        List<Station> result = stationController.getAll();

        verify(stationRepository).findAll();
        assertEquals(result, mockedStations);
    }
    @Test
    public void TestFindFree(){
        List<Station> mockedStations = List.of(new Station("Station", 12.3, 12.3, 20),
                new Station("StationTwo", 45.6, 45.6, 30));

        mockedStations.get(0).setBikeCount(20);
        mockedStations.get(1).setBikeCount(20);

        when(stationRepository.findAll()).thenReturn(mockedStations);

        List<Station> result = stationController.getFree();

        verify(stationRepository).findAll();
        assertEquals(result, List.of(mockedStations.get(1)));
    }
    @Test
    public void testFindById() {
        Station mockedStation = new Station("Station", 12.3, 12.3, 20);

        when(stationRepository.findById("StationId")).thenReturn(Optional.of(mockedStation));

        Station result = stationController.getById("StationId");

        verify(stationRepository).findById("StationId");
        assertEquals("Station", result.getName());
        assertEquals(12.3, result.getLatitude());
        assertEquals(12.3, result.getLongitude());
        assertEquals(20, result.getSlotCount());
        assertEquals(0, result.getBikeCount());
    }

    @Test
    public void testCreate() {
        Station mockedStation = new Station("Station", 12.3, 12.3, 20);

        when(stationRepository.insert(mockedStation)).thenReturn(mockedStation);

        Station result = stationController.createStation(mockedStation);

        verify(stationRepository).insert(mockedStation);
        assertEquals("Station", result.getName());
        assertEquals(12.3, result.getLatitude());
        assertEquals(12.3, result.getLongitude());
        assertEquals(20, result.getSlotCount());
        assertEquals(0, result.getBikeCount());
    }

    @Test
    public void testUpdateById() {
        Station mockedStation = new Station("Station", 12.3, 12.3, 20);
        mockedStation.setId("StationId");

        when(stationRepository.findById("StationId")).thenReturn(Optional.of(mockedStation));
        when(stationRepository.save(mockedStation)).thenReturn(mockedStation);

        Station result = stationController.updateStation(mockedStation);

        verify(stationRepository).save(mockedStation);
        assertEquals("Station", result.getName());
        assertEquals(12.3, result.getLatitude());
        assertEquals(12.3, result.getLongitude());
        assertEquals(20, result.getSlotCount());
        assertEquals(0, result.getBikeCount());
    }

    @Test
    public void testDeleteAll() {
        stationController.deleteAll();

        verify(stationRepository).deleteAll();
    }

    @Test
    public void testDeleteById() {
        Station mockedStation = new Station("Station", 12.3, 12.3, 20);

        when(stationRepository.findById("StationId")).thenReturn(Optional.of(mockedStation));

        stationController.deleteById("StationId");

        verify(stationRepository).deleteById("StationId");
    }

    @Test
    public void rentBike() {
        Station mockedStation = new Station("Station", 12.3, 12.3, 20);

        when(stationRepository.findById("StationId")).thenReturn(Optional.of(mockedStation));

        stationController.returnBike("StationId");

        verify(stationRepository).save(mockedStation);
    }

    @Test
    public void returnBike() {
        Station mockedStation = new Station("Station", 12.3, 12.3, 20);
        mockedStation.setBikeCount(1);

        when(stationRepository.findById("StationId")).thenReturn(Optional.of(mockedStation));

        stationController.rentBike("StationId");

        verify(stationRepository).save(mockedStation);
    }

}
