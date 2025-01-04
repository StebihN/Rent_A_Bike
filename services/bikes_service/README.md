
![Quarkus](https://img.shields.io/badge/Quarkus-white?logo=quarkus)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-white?logo=postgresql)

# Bike Management
This service manages bike data. It provides functionalities to fetch, create, update or delete bike data.

Each bike has the following properties:
 - id,
 - station id,
 - rating, 
 - times rated,
 - times rented, 
 - total time rented

## RPC services
This app uses the gRPC communication protocol. These are the provided services:

### Services

| Service               | Accepts                                               | Returns                 |
|:----------------------|:------------------------------------------------------|:------------------------|
| `GetAllStream`        | `google.protobuf.Empty`                               | stream `Bike`           |
| `GetAll`              | `google.protobuf.Empty`                               | `BikeList`              |
| `GetByLocationStream` | `google.protobuf.StringValue`                         | stream `Bike`           |
| `GetByLocation`       | `google.protobuf.StringValue`                         | `BikeList`              |
| `GetById`             | `google.protobuf.Int32Value`                          | `Bike`                  |
| `UpdateById`          | `BikeRequest`                                         | `Bike`                  |
| `Create`              | `BikeRequest`                                         | `Bike`                  |
| `DeleteById`          | `google.protobuf.Int32Value`                          | `google.protobuf.Empty` |
| `DeleteAll`           | `google.protobuf.Empty`                               | `google.protobuf.Empty` |
| `DeleteByLocation`    | `google.protobuf.StringValue`                         | `google.protobuf.Empty` |

### Messages

#### BikeRequest

| Parameter       | Type   | Description                         |
|-----------------|--------|-------------------------------------|
| id              | int32  | The ID of the bike.                 |
| stationId       | string | The ID of the location              |
| rating          | double | **Optional** The rating of the bike |
| totalTimeRented | int64  | **Optional**  Total time rented     |


#### Bike

| Parameter       | Type   | Description                     |
|-----------------|--------|---------------------------------|
| id              | int32  | The ID of the bike.             |
| stationId       | string | The ID of the location.         |
| rating          | double | The rating of the bike. (1-5)   |
| timesRated      | int32  | Number of ratings for the bike  |
| rentCount       | int32  | Number of times rented          |
| totalTimeRented | int64  | Total time rented               |


#### BikeList

| Parameter | Type | Description   |
|-----------|------|---------------|
| bikes     | Bike | List of bikes |

