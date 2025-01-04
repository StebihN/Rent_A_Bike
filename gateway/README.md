![Node_JS](https://img.shields.io/badge/Node_JS-black?logo=npm) 
![Express_JS](https://img.shields.io/badge/Express_JS-gray?logo=express) 

# Desktop API gateway
This is an API gateway that provides joined access to all other microservices.



## API Endpoints

### User Management


#### Get All Users

```http
  GET /users/all
```

#### Get User By Id

```http
  GET /users/by_id/:id
```

| Parameter | Type  | Description                       |
| :-------- | :---- | :-------------------------------- |
| `id`      | `int` | **Required**. Id of user to fetch |

#### User Log In

```http
  POST /users/login/
```

| Parameter  | Type     | Description                        |
| :--------- | :------- | :--------------------------------- |
| `email`    | `string` | **Required**. email of the user    |
| `password` | `string` | **Required**. password of the user |

#### Register User / Create New User

```http
  POST /users/create
```

| Parameter  | Type     | Description                        |
| :--------- | :------- | :--------------------------------- |
| `name`     | `string` | **Required**. name of the user     |
| `surname`  | `string` | **Required**. surname of the user  |
| `email`    | `string` | **Required**. email of the user    |
| `password` | `string` | **Required**. password of the user |

#### Update User

```http
  PUT /users/update/:id
```

| Parameter | Type     | Description                            |
| :-------- | :------- | :------------------------------------- |
| `id`      | `int`    | **Required**. Id of the user to update |
| `name`    | `string` | **Required**. name of the user         |
| `surname` | `string` | **Required**. surname of the user      |
| `email`   | `string` | **Required**. email of the user        |

#### Update Password

```http
  PUT /users/update/password/:id
```

| Parameter     | Type     | Description                            |
| :------------ | :------- | :------------------------------------- |
| `id`          | `int`    | **Required**. Id of the user to update |
| `oldPassword` | `string` | **Required**. old password             |
| `newPassword` | `string` | **Required**. newPassword              |

#### Update Users rent count

```http
  PUT /users/update/rent/:id
```

| Parameter | Type  | Description                            |
| :-------- | :---- | :------------------------------------- |
| `id`      | `int` | **Required**. Id of the user to update |

#### Delete user

```http
  DELETE /users/delete/by_id/:id
```

| Parameter | Type     | Description                            |
| :-------- | :------- | :------------------------------------- |
| `id`      | `string` | **Required**. Id of the user to delete |

#### Delete all users

```http
  DELETE /users/delete/all
```


### Station Management

#### Get All Stations

```http
  GET /stations/all
```

#### Get Stations with free spots

```http
  GET /stations/free
```

#### Get Station By Id

```http
  GET /stations/by_id/:id
```

| Parameter | Type     | Description                     |
| :-------- | :------- | :------------------------------ |
| `id`      | `string` | **Required**. Id of the Station |


#### Create New Station

```http
  POST /stations/create
```

| Parameter   | Type     | Description                               |
| :---------- | :------- | :---------------------------------------- |
| `id`        | `string` | **Required**. Id of the station to update |
| `name`      | `string` | **Required**. Name of the station         |
| `latitude`  | `string` | **Required**. Latitude of the station     |
| `longitude` | `string` | **Required**. Longitude of the locatio    |
| `slotCount` | `int`    | **Required**. No. of slots at the station |
| `bikeCount` | `int`    | **Required**. No. of bikes at the station |

#### Update Station

```http
  PUT /stations/update
```
| Parameter   | Type     | Description                               |
| :---------- | :------- | :---------------------------------------- |
| `name`      | `string` | **Required**. Name of the station         |
| `latitude`  | `string` | **Required**. Latitude of the station     |
| `longitude` | `string` | **Required**. Longitude of the locatio    |
| `slotCount` | `int`    | **Required**. No. of slots at the station |
| `bikeCount` | `int`    | **Required**. No. of bikes at the station |

#### Delete Station By Id

```http
  DELETE /stations/delete/by_id/:id
```

| Parameter | Type     | Description                               |
| :-------- | :------- | :---------------------------------------- |
| `id`      | `string` | **Required**. Id of the station to delete |

#### Delete All Stations

```http
  DELETE /stations/delete/all
```

#### Rent bike from Station

```http
  POST /stations/rent/:id
```

| Parameter | Type     | Description                                                  |
| :-------- | :------- | :----------------------------------------------------------- |
| `id`      | `string` | **Required**. Id of the Station where a bike is being rented |

#### Return bike to Station

```http
  POST /stations/return/:id
```

| Parameter | Type     | Description                                                    |
| :-------- | :------- | :------------------------------------------------------------- |
| `id`      | `string` | **Required**. Id of the Station where a bike is being returned |

### Bike Management

#### Get All Bikes

```http
  GET /gateway/bikes/all
```

#### Get Bike By Id

```http
  GET /gateway/bikes/by_id/:id
```

| Parameter | Type    | Description         |
| --------- | ------- | ------------------- |
| `id`      | `int32` | The ID of the bike. |

#### Get All Bikes At Station

```http
  GET /gateway/by_location/:location
```

| Parameter  | Type     | Description                           |
| ---------- | -------- | ------------------------------------- |
| `location` | `string` | The location of the bike.(Station ID) |

#### Create New Bike

```http
  POST /gateway/bikes/create
```

| Parameter    | Type     | Description                           |
| ------------ | -------- | ------------------------------------- |
| `locationId` | `string` | The location of the bike.(Station ID) |


#### Update Bike By Id

```http
  PUT /gateway/bikes/update
  
```

| Parameter           | Type     | Description                           |
|---------------------|----------|---------------------------------------|
| `id`                | `int32`  | The ID of the bike.                   |
| `locationId`        | `string` | The location of the bike.(Station ID) |
| `rating`            | `double` | **Optional** The rating of the bike   |
| `totalTimeRented`   | `int64`  | **Optional** Total time rented        |


#### Delete All Bikes

```http
  PUT /gateway/bikes/delete/all
```

#### Delete Bikes By Location

```http
  PUT /gateway/bikes/delete/by_location/:location
```

| Parameter  | Type     | Description                           |
| ---------- | -------- | ------------------------------------- |
| `location` | `string` | The location of the bike.(Station ID) |


#### Delete Bike By Id

```http
  PUT /gateway/bikes/delete/by_id/:id
```

| Parameter | Type    | Description         |
| --------- | ------- | ------------------- |
| `id`      | `int32` | The ID of the bike. |


#### Bike to service

```http
  POST /gateway/bikes/to_service
```

| Parameter   | Type     | Description                                          |
| ----------- | -------- | ---------------------------------------------------- |
| `id`        | `int32`  | The ID of the bike.                                  |
| `stationId` | `string` | The id of the station the bike is being removed from |

#### Bike To Station

```http
  POST /gateway/bikes/to_station
```

| Parameter   | Type     | Description                                      |
| ----------- | -------- | ------------------------------------------------ |
| `id`        | `int32`  | The ID of the bike.                              |
| `stationId` | `string` | The id of the station the bike is being added to |

#### Rent Bike

```http
  POST /gateway/bikes/rent
```

| Parameter   | Type     | Description                                                                             |
| :---------- | :------- | :-------------------------------------------------------------------------------------- |
| `userId`    | `int`    | Id of the user renting the bike                                                         |
| `bikeId`    | `int`    | Id of the bike rented                                                                   |
| `stationId` | `string` | The id of the station the bike is being rented from                                     |
| `rentedOn`  | `long`   | Time of rental in ms, defined as the midnight at the beginning of January 1, 1970, UTC. |

#### Return Bike

```http
  POST /gateway/bikes/return
```

| Parameter   | Type     | Description                                                                             |
| :---------- | :------- | :-------------------------------------------------------------------------------------- |
| `userId`    | `int`    | Id of the user returning the bike                                                       |
| `bikeId`    | `int`    | Id of the bike rented                                                                   |
| `stationId` | `string` | The id of the station the bike is being returned to                                     |
| `rentedOn`  | `long`   | Time of rental in ms, defined as the midnight at the beginning of January 1, 1970, UTC. |

### Rentals Management

#### Get All rentals

```http
  GET /rentals/get/all
```

#### Get Rental By Id

```http
  GET /rentals/get/:id
```

| Parameter | Type     | Description                    |
| :-------- | :------- | :----------------------------- |
| `id`      | `string` | **Required**. Id of the Rental |

#### Get Rental By User Id

```http
  GET /rentals/get/user/:id
```

| Parameter | Type  | Description                  |
| :-------- | :---- | :--------------------------- |
| `id`      | `int` | **Required**. Id of the User |

#### Get Rental By User Id

```http
  GET /rentals/exists/:id
```

| Parameter | Type  | Description                  |
| :-------- | :---- | :--------------------------- |
| `id`      | `int` | **Required**. Id of the User |


#### Create New Rental

```http
  POST /rentals/create
```

| Parameter  | Type   | Description                                                                                           |
| :--------- | :----- | :---------------------------------------------------------------------------------------------------- |
| `userId`   | `int`  | **Required**. Id of the user renting the bike                                                         |
| `bikeId`   | `int`  | **Required**. Id of the bike rented                                                                   |
| `rentedOn` | `long` | **Required**. Time of rental in ms, defined as the midnight at the beginning of January 1, 1970, UTC. |


#### Update Rental

```http
  PUT /rentals/update/:id
```
| Parameter  | Type     | Description                                                                                           |
| :--------- | :------- | :---------------------------------------------------------------------------------------------------- |
| `id`       | `string` | **Required**. Id of the rental to update                                                              |
| `userId`   | `int`    | **Required**. Id of the user renting the bike                                                         |
| `bikeId`   | `int`    | **Required**. Id of the bike rented                                                                   |
| `rentedOn` | `long`   | **Required**. Time of rental in ms, defined as the midnight at the beginning of January 1, 1970, UTC. |

#### Delete Rental By Id

```http
  DELETE /rentals/delete/:id
```

| Parameter | Type     | Description                    |
| :-------- | :------- | :----------------------------- |
| `id`      | `string` | **Required**. Id of the Rental |

#### Delete All Rentals

```http
  DELETE /rentals/delete/all
```



