package rentals.repositories;

import rentals.entities.Rental;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface RentalRepository extends MongoRepository<Rental, String> {
    Optional<Rental> findByUserId(int userId);
}
