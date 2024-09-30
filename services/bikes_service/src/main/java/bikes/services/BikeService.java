package bikes.services;

import bikes.broker.BikeMessage;
import bikes.entities.BikeEntity;
import bikes.grpc.*;
import bikes.mappings.BikeMapper;
import bikes.repositories.BikeRepository;
import com.google.protobuf.Int32Value;
import com.google.protobuf.StringValue;
import jakarta.annotation.Nonnull;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.context.control.ActivateRequestContext;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Stream;


@ApplicationScoped
public class BikeService {
    private final BikeRepository bikeRepository;
    private final BikeMapper bikeMapper;

    public BikeService(BikeRepository bikeRepository, BikeMapper bikeMapper) {
        this.bikeRepository = bikeRepository;
        this.bikeMapper = bikeMapper;
    }

    @ActivateRequestContext
    public List<Bike> getAll() {
        List<BikeEntity> bikes = bikeRepository.listAll();
        return this.bikeMapper.toDomainList(bikes);
    }
    @ActivateRequestContext
    public Bike getById(@Nonnull Int32Value id) {
        BikeEntity bike = bikeRepository.findById(id.getValue());
        return this.bikeMapper.toDomain(bike);
    }

    @ActivateRequestContext
    public List<Bike> getByLocation (StringValue locationId){
        List<BikeEntity> bikes = bikeRepository.getByLocation(locationId.getValue());
        return this.bikeMapper.toDomainList(bikes);
    }

    @Transactional
    public Bike create (BikeRequest bike) {
        BikeEntity entity = bikeMapper.toEntityFromDomainDto(bike);
        entity.setRating(2.5);
        entity.setRentCount(0);
        entity.setRateCount(1);
        entity.setTimeTravelled(0.0);
        bikeRepository.persist(entity);
        return bikeMapper.toDomain(entity);
    }

    @Transactional
    public Bike update (BikeRequest bike) {
        Optional<BikeEntity> optionalEntity = bikeRepository.findByIdOptional(bike.getId());

        if(optionalEntity.isPresent()) {
            BikeEntity entity = optionalEntity.get();

            bikeMapper.updateEntityFromDomainDto(bike, entity);
            bikeRepository.persist(entity);

            return bikeMapper.toDomain(entity);
        }
        return null;
    }

    @Transactional
    public Bike updateRating (BikeUpdateRatingRequest bike) {
        Optional<BikeEntity> optionalEntity = bikeRepository.findByIdOptional(bike.getId());

        if(optionalEntity.isPresent()) {
            BikeEntity entity = optionalEntity.get();
            Double rating = (entity.getRating() * entity.getRateCount() + bike.getRating()) / (entity.getRateCount() + 1);

            entity.setRating(rating);
            entity.setRateCount(entity.getRateCount() + 1);

            bikeRepository.persist(entity);
            return bikeMapper.toDomain(entity);
        }
            return null;

    }
    @Transactional
    public void deleteAll() {
        bikeRepository.deleteAll();
    }

    @Transactional
    public void deleteByLocation(StringValue locationId) {
        bikeRepository.deleteByLocation(locationId.getValue());
    }

    @Transactional
    public Long deleteById (Int32Value id){
        return bikeRepository.delete("id", id.getValue());
    }

    @ActivateRequestContext
    public Stream<Bike> streamAll() {
        return bikeRepository.streamAll().map(bikeMapper::toDomain);
    }

    @ActivateRequestContext
    public Stream<Bike> getByLocationStream (StringValue locationId){
        return bikeRepository.getByLocationStream(locationId.getValue()).map(bikeMapper::toDomain);
    }
    @Transactional
    public void changeLocation(BikeMessage bikeMessage){
        BikeEntity bikeEntity = bikeRepository.findById(bikeMessage.getId());
        bikeEntity.setLocationId(bikeMessage.getLocationId());
        bikeRepository.persist(bikeEntity);
    }


}
