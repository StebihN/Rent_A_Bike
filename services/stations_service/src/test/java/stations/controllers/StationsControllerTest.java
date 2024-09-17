package stations.controllers;


import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import stations.mq.BikeMessage;
import stations.mq.Producer;
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

    @MockBean
    private Producer producer;

    @Test
    public void testFindAll() {
        List<Station> mockedStations = List.of( new Station("City", "Street", 12.1, 12.2, 20),
                new Station("City", "Street_2", 6.1, 6.2, 15));

        when(stationRepository.findAll()).thenReturn(mockedStations);

        List<Station> result = stationController.getAll();

        verify(stationRepository).findAll();
        assertEquals(result, mockedStations);
    }

    @Test
    public void testFindById() {
        Station mockedStation = new Station("City", "Street", 12.1, 12.2, 20);

        when(stationRepository.findById("StationId")).thenReturn(Optional.of(mockedStation));

        Station result = stationController.getById("StationId");

        verify(stationRepository).findById("StationId");
        assertEquals("City", result.getCity());
        assertEquals("Street", result.getStreet());
        assertEquals(12.1, result.getLatitude());
        assertEquals(12.2, result.getLongitude());
        assertEquals(20, result.getSlotCount());
        assertEquals(0, result.getBikeCount());
    }

    @Test
    public void testCreate() {
        Station mockedStation = new Station("City", "Street", 12.1, 12.2, 20);

        when(stationRepository.insert(mockedStation)).thenReturn(mockedStation);

        Station result = stationController.createStation(mockedStation);

        verify(stationRepository).insert(mockedStation);
        assertEquals(result, mockedStation);
    }

    @Test
    public void testUpdateById(){
        Station mockedStation = new Station("City", "Street", 12.1, 12.2, 20);
        mockedStation.setId("StationId");

        when(stationRepository.existsById("StationId")).thenReturn(true);
        when(stationRepository.save(mockedStation)).thenReturn(mockedStation);

        Station result = stationController.updateStation(mockedStation);

        verify(stationRepository).save(mockedStation);
        assertEquals(result, mockedStation);
    }

    @Test
    public void testDeleteAll(){
        stationController.deleteAll();

        verify(stationRepository).deleteAll();
    }

    @Test
    public void testDeleteById(){
        when(stationRepository.existsById("StationId")).thenReturn(true);

        stationController.deleteById("StationId");

        verify(stationRepository).deleteById("StationId");
    }

    @Test
    public void testAddBike(){
        BikeMessage mockMessage = new BikeMessage(1, "StationId");
        Station mockedStation = new Station("City", "Street", 12.1, 12.2, 20);
        mockedStation.setId("StationId");
        mockedStation.setBikeCount(5);

        when(stationRepository.findById("StationId")).thenReturn(Optional.of(mockedStation));
        when(stationRepository.existsById("StationId")).thenReturn(true);
        when(stationRepository.save(mockedStation)).thenReturn(mockedStation);

        BikeMessage result = stationController.addBike(mockMessage);

        verify(producer).sendMessage(mockMessage);
        assertEquals(result, mockMessage);
    }

    @Test
    public void testRemoveBike(){
        BikeMessage mockMessage = new BikeMessage(1, "StationId");
        Station mockedStation = new Station("City", "Street", 12.1, 12.2, 20);
        mockedStation.setId("StationId");
        mockedStation.setBikeCount(5);

        when(stationRepository.findById("StationId")).thenReturn(Optional.of(mockedStation));
        when(stationRepository.existsById("StationId")).thenReturn(true);
        when(stationRepository.save(mockedStation)).thenReturn(mockedStation);

        BikeMessage result = stationController.removeBike(mockMessage);

        verify(producer).sendMessage(mockMessage);
        assertEquals(result, mockMessage);
    }

}
