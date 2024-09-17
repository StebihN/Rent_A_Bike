package stations.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;
import stations.entities.Station;

public interface StationRepository extends MongoRepository<Station, String> {

}
