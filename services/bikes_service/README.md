
![Quarkus](https://img.shields.io/badge/Quarkus-white?logo=quarkus)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-white?logo=postgresql)
![ActiveMQ Artemis](https://img.shields.io/badge/ActiveMQ%20Artemis-red)

# Bike Management
This service manages bike data. It provides functionalities to fetch, create, update or delete bike data.

Each bike has the following properties:
 - id,
 - name,
 - location id,
 - time travelled, 
 - rent count (times rented),
 - rating,
 - rate count (times rated)

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
| `UpdateRatingById`    | `BikeUpdateRatingRequest`                             | `Bike`                  |
| `Create`              | `BikeRequest`                                         | `Bike`                  |
| `DeleteById`          | `google.protobuf.Int32Value`                          | `google.protobuf.Empty` |
| `DeleteAll`           | `google.protobuf.Empty`                               | `google.protobuf.Empty` |
| `DeleteByLocation`    | `google.protobuf.StringValue`                         | `google.protobuf.Empty` |

### Messages

#### BikeUpdateRatingRequest

| Parameter | Type   | Description                  |
|-----------|--------|------------------------------|
| id        | int32  | The ID of the bike           |
| rating    | double | The rating of the bike (1-5) |

#### BikeRequest

| Parameter  | Type   | Description            |
|------------|--------|------------------------|
| id         | int32  | The ID of the bike.    |
| locationId | string | The ID of the location |
| name       | string | The name of the bike   |


#### Bike

| Parameter     | Type   | Description                    |
|---------------|--------|--------------------------------|
| id            | int32  | The ID of the bike.            |
| locationId    | string | The ID of the location.        |
| name          | string | The name of the bike           |
| rating        | double | The rating of the bike. (1-5)  |
| ratingCount   | int32  | Number of ratings for the bike |
| timeTravelled | double | Time spent travelling          |
| rentCount     | int32  | Number of times rented         |


#### BikeList

| Parameter | Type | Description   |
|-----------|------|---------------|
| bikes     | Bike | List of bikes |

