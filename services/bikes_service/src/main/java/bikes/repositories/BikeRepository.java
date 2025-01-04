package bikes.repositories;

import bikes.entities.BikeEntity;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;
import java.util.stream.Stream;


@ApplicationScoped
public class BikeRepository implements PanacheRepositoryBase<BikeEntity, Integer> {
    public List<BikeEntity> getByStation(String stationId){
        return list("stationId", stationId);
    }

    public Stream<BikeEntity> getByStationStream(String stationId){
        return stream("stationId", stationId);
    }

    public void deleteByStation(String stationId){
        delete("stationId", stationId);
    }
}
