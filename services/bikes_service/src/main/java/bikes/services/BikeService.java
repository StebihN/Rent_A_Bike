package bikes.services;


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
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

@Slf4j
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
    public List<Bike> getByLocation(StringValue locationId) {
        List<BikeEntity> bikes = bikeRepository.getByStation(locationId.getValue());
        return this.bikeMapper.toDomainList(bikes);
    }

    @Transactional
    public Bike create(BikeRequest bike) {
        BikeEntity entity = bikeMapper.toEntityFromDomainDto(bike);
        entity.setRating(2.5);
        entity.setTimesRated(1);
        entity.setTimesRented(0);
        entity.setTotalTimeRented(0);
        bikeRepository.persist(entity);
        return bikeMapper.toDomain(entity);
    }

    @Transactional
    public Bike update(BikeRequest bike) {
        Optional<BikeEntity> optionalEntity = bikeRepository.findByIdOptional(bike.getId());
        if (optionalEntity.isPresent()) {
            BikeEntity entity = optionalEntity.get();
            entity.setStationId(bike.getStationId());

            if(bike.hasRating()){
                Double rating = (entity.getRating() * entity.getTimesRated() + bike.getRating()) / (entity.getTimesRated() + 1);
                entity.setRating(rating);
                entity.setTimesRated(entity.getTimesRated() + 1);
            }
            if(bike.hasTotalTimeRented()){
                entity.setTotalTimeRented(entity.getTotalTimeRented() + bike.getTotalTimeRented());
                entity.setTimesRented(entity.getTimesRented() + 1);
            }
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
        bikeRepository.deleteByStation(locationId.getValue());
    }

    @Transactional
    public void deleteById(Int32Value id) {
        Optional <BikeEntity> optionalBikeEntity = bikeRepository.findByIdOptional(id.getValue());
        if(optionalBikeEntity.isPresent()) {
            bikeRepository.deleteById(id.getValue());
        }
    }

    @ActivateRequestContext
    public Stream<Bike> streamAll() {
        return bikeRepository.streamAll().map(bikeMapper::toDomain);
    }

    @ActivateRequestContext
    public Stream<Bike> getByLocationStream(StringValue locationId) {
        return bikeRepository.getByStationStream(locationId.getValue()).map(bikeMapper::toDomain);
    }

}
