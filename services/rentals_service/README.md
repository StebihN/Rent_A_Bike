
![SpringBoot](https://img.shields.io/badge/SpringBoot-black?logo=Springboot)
![MongoDB](https://img.shields.io/badge/MongoDB-white?logo=mongodb)


# Rentals Management
This microservice manages bike rentals. It provides functionalities to fetch, create, update and delete rentals.

Each rental has the following properties:
- id,
- user id
- bike id,
- rented on,



## API Endpoints

#### Get All rentals

```http
  GET /rentals/get/all
```

#### Get Rental By Id

```http
  GET /rentals/get/:id
```

| Parameter | Type     | Description                    |
| :-------- | :------- |:-------------------------------|
| `id`      | `string` | **Required**. Id of the Rental |

#### Get Rental By User Id

```http
  GET /rentals/get/by_user/:id
```

| Parameter | Type  | Description                  |
| :-------- |:------|:-----------------------------|
| `id`      | `int` | **Required**. Id of the User |

#### Check if Rental exists By User Id 

```http
  GET /rentals/exists/by_user/:id
```

| Parameter | Type  | Description                  |
| :-------- |:------|:-----------------------------|
| `id`      | `int` | **Required**. Id of the User |


#### Create New Rental

```http
  POST /rentals/create
```

| Parameter   | Type     | Description                                                                                           |
|:------------|:---------|:------------------------------------------------------------------------------------------------------|
| `userId`    | `int`    | **Required**. Id of the user renting the bike                                                         |
| `bikeId`    | `int`    | **Required**. Id of the bike rented                                                                   |
| `rentedOn`  | `long`   | **Required**. Time of rental in ms, defined as the midnight at the beginning of January 1, 1970, UTC. |


#### Update Rental

```http
  PUT /rentals/update
```
| Parameter   | Type     | Description                                                                                           |
|:------------|:---------|:------------------------------------------------------------------------------------------------------|
| `id`        | `string` | **Required**. Id of the rental to update                                                              |
| `userId`    | `int`    | **Required**. Id of the user renting the bike                                                         |
| `bikeId`    | `int`    | **Required**. Id of the bike rented                                                                   |
| `rentedOn`  | `long`   | **Required**. Time of rental in ms, defined as the midnight at the beginning of January 1, 1970, UTC. |

#### Delete Rental By Id

```http
  DELETE /rentals/delete/:id
```

| Parameter | Type     | Description                    |
| :-------- | :------- |:-------------------------------|
| `id`      | `string` | **Required**. Id of the Rental |

#### Delete All Rentals

```http
  DELETE /rentals/delete/all
```


## Database
This app requires a running MongoDB database to store data (MongoDB community server, MongoDB Atlas, MongoDB docker image,...).

## Environment Variables

To run this project, you will need to add the following environment variables to your `src/main/resources/application.properties` file

| Variable                  | Description   |
|:--------------------------|:--------------|
| `spring.data.mongodb.uri` | Database URI  |


## Running the app
The app can be run using mvn or as a docker container

1. **Using mvn**

Run the app

```bash
  mvn spring-boot:run
```

2. **As a docker container**

Package the app
```
mvn package
```
Build a docker image

```bash
  docker build -f Dockerfile -t rentals-service . 
``` 

Run the container

```bash
  docker run -p 8081:8081 --name rentals-service rentals-service 
``` 



