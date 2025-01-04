package rentals.controllers;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import rentals.entities.Rental;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import rentals.repositories.RentalRepository;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.CONFLICT;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
@RequestMapping("/rentals")
public class RentalController {

    @Autowired
    RentalRepository rentalRepository;

    @GetMapping("/get/{id}")
    public Rental getById(@PathVariable("id") String id){
        Optional<Rental> optionalRental = rentalRepository.findById(id);
        if(!optionalRental.isPresent()){
            throw new ResponseStatusException(NOT_FOUND);
        }
        return optionalRental.get();
    }

    @GetMapping("/get/all")
    public List<Rental> getAll(){
        return rentalRepository.findAll();
    }

    @PutMapping("/update/{id}")
    public Rental updateRental(@PathVariable("id") String id, @RequestBody Rental requestRental){
      if(!rentalRepository.existsById(id)){
         throw new ResponseStatusException(NOT_FOUND);
      }
        return rentalRepository.save(requestRental);
    }

    @PostMapping("/create")
    public Rental createRental(@RequestBody Rental rental){
        Optional<Rental> optionalRental = rentalRepository.findByUserId(rental.getUserId());
        if(optionalRental.isPresent()){
           throw new ResponseStatusException(CONFLICT);
        }
        return rentalRepository.insert(rental);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteRentalById(@PathVariable("id") String id){
        if(!rentalRepository.existsById(id)){
            throw new ResponseStatusException(NOT_FOUND);
        }
        rentalRepository.deleteById(id);
    }

    @DeleteMapping("/delete/all")
    public void deleteAllRentals(){
        rentalRepository.deleteAll();
    }

    @GetMapping("/get/by_user/{id}")
    public ResponseEntity<Rental> getByUserId(@PathVariable("id") int id){
        Optional<Rental> rental = rentalRepository.findByUserId(id);
        return rental.map(value -> new ResponseEntity<>(value, HttpStatus.OK)).orElseGet(() -> new ResponseEntity<>(HttpStatus.NO_CONTENT));
    }
    @GetMapping("/exists/by_user/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void exists(@PathVariable("id") int id){
        Optional<Rental> optionalRental = rentalRepository.findByUserId(id);
        if(optionalRental.isPresent()){
            throw new ResponseStatusException(CONFLICT);
        }
    }
}
