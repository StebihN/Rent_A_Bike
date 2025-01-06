
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


## Database
This app requires a running PostgreSQL database to store data (Windows Service, Docker Container,...). It requires a database scheme with a table that has the following columns:

| Name                | Type                   | Description                     |
|:--------------------|:-----------------------|:--------------------------------|
| `id `               | INT                    | Bike id                         |
| `station_id `       | CHARACTER VARYING(255) | Bike location                   |
| `rating `           | DOUBLE PRECISION       | Bike rating (1-5)               |
| `times_rated`       | INT                    | Number of ratings               |
| `times_rented`      | INT                    | Number of rents                 |
| `total_time_rented` | BIGINT                 | Total time the bikes was rented |

## Message Broker
To communicate with the locations microservice, this app uses ActiveMQ Artemis.
## Environment Variables

To run this project, you will need to add the following environment variables to your `src/main/resources/application.properties` file

| Variable                      | Description               |
|:------------------------------|:--------------------------|
| `quarkus.datasource.jdbc.url` | Database Host IP Address  |
| `quarkus.datasource.username` | Database Username         |
| `quarkus.datasource.password` | Database Password         |



## Running the app
The app can be run using npm or as a docker container

1. **Running the application in dev mode**
   You can run your application in dev mode that enables live coding using:
```shell script
./mvnw compile quarkus:dev
```

2. **Packaging and running the application**

The application can be packaged using:
```shell script
./mvnw package
```
It produces the `quarkus-run.jar` file in the `target/quarkus-app/` directory.
Be aware that it’s not an _über-jar_ as the dependencies are copied into the `target/quarkus-app/lib/` directory.

The application is now runnable using `java -jar target/quarkus-app/quarkus-run.jar`.

If you want to build an _über-jar_, execute the following command:
```shell script
./mvnw package -Dquarkus.package.type=uber-jar
```

The application, packaged as an _über-jar_, is now runnable using `java -jar target/*-runner.jar`.

3. **Creating a native executable**

You can create a native executable using:
```shell script
./mvnw package -Pnative
```

Or, if you don't have GraalVM installed, you can run the native executable build in a container using:
```shell script
./mvnw package -Pnative -Dquarkus.native.container-build=true
```

You can then execute your native executable with: `./target/bikes-service-1.0.0-SNAPSHOT-runner`

4. **Running the application as a docker container**

Package the
```shell script
./mvnw package 
```

Build the image
```shell script
docker build -f src/main/docker/Dockerfile.jvm -t bikes-service .
```

Run the container
```shell script
docker run -p 9000:9000 --name bikes-service bikes-service
```
*If you want to include the debug port into your docker image
you will have to expose the debug port (default 5005) like this:
EXPOSE 9000 5005*

Run the container
```shell script
docker run -p 9000:9000 --name bikes-service bikes-service
```

