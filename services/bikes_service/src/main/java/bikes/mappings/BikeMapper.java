package bikes.mappings;

import bikes.entities.BikeEntity;

import bikes.grpc.Bike;
import bikes.grpc.BikeRequest;
import org.mapstruct.*;
import java.util.List;

@Mapper(componentModel = "jakarta")
public interface BikeMapper {
    List<Bike> toDomainList(List<BikeEntity> entities);

    Bike toDomain (BikeEntity entity);
    @InheritInverseConfiguration(name = "toDomain")
    BikeEntity toEntity(Bike bike);
    BikeEntity toEntityFromDomainDto(BikeRequest createDto);

    void updateEntityFromDomainDto(BikeRequest grpcDto, @MappingTarget BikeEntity entity);

}
