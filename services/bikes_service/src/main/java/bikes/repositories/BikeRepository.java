package bikes.repositories;

import bikes.entities.BikeEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Stream;


@ApplicationScoped
public class BikeRepository implements PanacheRepositoryBase<BikeEntity, Integer> {
    public List<BikeEntity> getByLocation(String locationId){
        return list("locationId", locationId);
    }

    public Stream<BikeEntity> getByLocationStream(String locationId){
        return stream("locationId", locationId);
    }

    public void deleteByLocation(String locationId){
        delete("locationId", locationId);
    }
}
