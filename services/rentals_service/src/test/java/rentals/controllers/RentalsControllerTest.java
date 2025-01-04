package rentals.controllers;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import rentals.entities.Rental;
import rentals.repositories.RentalRepository;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@SpringBootTest
class RentalsControllerTest {

    @Autowired
    private RentalController rentalController;

    @MockitoBean
    private RentalRepository rentalRepository;

    @Test
    public void testFindAll() {
        List<Rental> mockedRental = List.of(
                new Rental(1, 2, 1000),
                new Rental(1, 2, 1000));

        when(rentalRepository.findAll()).thenReturn(mockedRental);

        List<Rental> result = rentalController.getAll();

        verify(rentalRepository).findAll();
        assertEquals(result, mockedRental);
    }

    @Test
    public void testFindById(){
        Rental mockedRental =  new Rental(1, 2, 1000);

        when(rentalRepository.findById("rentalId")).thenReturn(Optional.of(mockedRental));

        Rental result = rentalController.getById("rentalId");

        verify(rentalRepository).findById("rentalId");
        assertEquals(1, result.getUserId());
        assertEquals(2, result.getBikeId());
        assertEquals(1000, result.getRentedOn());
    }

    @Test
    public void testFindByUserId(){
        Rental mockedRental =  new Rental(1, 2, 1000);

        when(rentalRepository.findByUserId(1)).thenReturn(Optional.of(mockedRental));

        ResponseEntity<Rental> result = rentalController.getByUserId(1);
        assertEquals(1, result.getBody().getUserId());
        assertEquals(2, result.getBody().getBikeId());
        assertEquals(1000, result.getBody().getRentedOn());
    }

    @Test
    public void testCreate(){
        Rental mockedRental =  new Rental(1, 2, 1000);

        when(rentalRepository.insert(mockedRental)).thenReturn(mockedRental);

        Rental result = rentalController.createRental(mockedRental);

        verify(rentalRepository).insert(mockedRental);
        assertEquals(1, result.getUserId());
        assertEquals(2, result.getBikeId());
        assertEquals(1000, result.getRentedOn());
    }

    @Test
    public void testUpdate(){
        Rental mockedRental =  new Rental(1, 2, 1000);
        mockedRental.setId("rentalId");

        when(rentalRepository.existsById("rentalId")).thenReturn(true);
        when(rentalRepository.save(mockedRental)).thenReturn(mockedRental);

        Rental result = rentalController.updateRental("rentalId", mockedRental);
        assertEquals(1, result.getUserId());
        assertEquals(2, result.getBikeId());
        assertEquals(1000, result.getRentedOn());
    }

    @Test
    public void testDeleteAll(){
        rentalController.deleteAllRentals();

        verify(rentalRepository).deleteAll();
    }

    @Test
    public void testDeleteById(){
        when(rentalRepository.existsById("rentalId")).thenReturn(true);

        rentalController.deleteRentalById("rentalId");

        verify(rentalRepository).deleteById("rentalId");
    }
}
