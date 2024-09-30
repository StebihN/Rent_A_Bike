![Node_JS](https://img.shields.io/badge/Node_JS-black?logo=npm) 
![Express_JS](https://img.shields.io/badge/Express_JS-gray?logo=express) 

# Desktop API gateway
This is an API gateway that provides joined access to all other microservices.



## API Endpoints

### User Management


#### Get All Users

```http
  GET /gateway/users/all
```

#### Get User By Id

```http
  GET /gateway/users/by_id/:id
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of user to fetch |

#### User Log In

```http
  POST /gateway/users/login/
```

| Parameter  | Type     | Description                        |
| :--------- | :------- | :--------------------------------- |
| `email`    | `string` | **Required**. email of the user    |
| `password` | `string` | **Required**. password of the user |

#### Register User / Create New User

```http
  POST /gateway/users/create
```

| Parameter  | Type     | Description                        |
| :--------- | :------- | :--------------------------------- |
| `name`     | `string` | **Required**. name of the user     |
| `surname`  | `string` | **Required**. surname of the user  |
| `email`    | `string` | **Required**. email of the user    |
| `password` | `string` | **Required**. password of the user |

#### Update User

```http
  PUT /gateway/users/update/:id
```

| Parameter  | Type     | Description                            |
| :--------- | :------- | :------------------------------------- |
| `id`       | `string` | **Required**. Id of the user to update |
| `name`     | `string` | **Required**. name of the user         |
| `surname`  | `string` | **Required**. surname of the user      |
| `email`    | `string` | **Required**. email of the user        |
| `password` | `string` | **Required**. password of the user     |

#### Delete user by Id

```http
  DELETE /gateway/users/delete/by_id/:id
```

| Parameter | Type     | Description                            |
| :-------- | :------- | :------------------------------------- |
| `id`      | `string` | **Required**. Id of the user to update |

#### Delete all users

```http
  DELETE /gateway/users/delete/all
```

| Parameter | Type | Description |
| :-------- | :--- | :---------- |

### Station Management

#### Get All Stations

```http
  GET /gateway/stations/all
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |

#### Get Station By Id

```http
  GET /gateway/stations/by_id/:id
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of the Station  |


#### Create New Station

```http
  POST /gateway/stations/create
```

| Parameter          | Type     | Description                                          |
|:-------------------|:---------|:-----------------------------------------------------|
| `id`               | `string` | **Required**. Id of the station to update            |
| `city`             | `string` | **Required**. City in which the station is located   |
| `street`           | `string` | **Required**. Street in which the station is located |
| `latitude`         | `string` | **Required**. Latitude of the station                |
| `longitude`        | `string` | **Required**. Longitude of the locatio               |
| `numberOfStations` | `int`    | **Required**. No. of stations at the station         |
| `numberOfBikes`    | `int`    | **Required**. No. of bikes at the station            |

#### Update Station

```http
  PUT /gateway/stations/update
```

| Parameter         | Type     | Description                               |
|:------------------| :------- |:------------------------------------------|
| `id`              | `string` | **Required**. Id of the station to update |
| `city`            | `string` | City in which the station is located      |
| `street`          | `string` | Street in which the station is located    |
| `latitude`        | `string` | Latitude of the station                   |
| `longitude`       | `string` | Longitude of the locatio                  |
| `numberOfStations`| `int`    | No. of stations at the station            |
| `numberOfBikes`   | `int`    | No. of bikes at the station               |

#### Delete Station By Id

```http
  DELETE /gateway/stations/delete/by_id/:id
```

| Parameter | Type     | Description                               |
| :-------- | :------- |:------------------------------------------|
| `id`      | `string` | **Required**. Id of the station to delete |

#### Delete All Stations

```http
  DELETE /gateway/stations/delete/all
```

| Parameter | Type     | Description                               |
| :-------- | :------- |:------------------------------------------|


#### Add bike to Station

```http
  POST /gateway/stations/add
```

| Parameter   | Type     | Description                                        |
|:------------|:---------|:---------------------------------------------------|
| `id`        | `string` | **Required**. Id of the bike to add                |
| `stationId` | `string` | **Required**. Id of the station to add the bike to |

#### Remove bike from Station

```http
  POST /gateway/stations/remove
```

| Parameter   | Type     | Description                                             |
|:------------|:---------|:--------------------------------------------------------|
| `id`        | `string` | **Required**. Id of the bike to remove                  |
| `stationId` | `string` | **Required**. Id of the station to remove the bike from |

### Bike Management

#### Get All Bikes

```http
  GET /gateway/bikes/all
```

#### Get Bike By Id

```http
  GET /gateway/bikes/by_id/:id
```

| Parameter | Type | Description         |
|-----------|------|-------------------- |
| id        | int32| The ID of the bike. |

#### Get All Bikes At Station

```http
  GET /gateway/by_location/:location
```

| Parameter | Type   | Description                           |
|-----------|--------|---------------------------------------|
| location  | string | The location of the bike.(Station ID) |

#### Create New Bike

```http
  POST /gateway/bikes/create
```

| Parameter  | Type   | Description                           |
|------------|--------|---------------------------------------|
| locationId | string | The location of the bike.(Station ID) |
| name       | string | The name of the bike                  |


#### Update Bike By Id

```http
  PUT /gateway/bikes/update
  
```

| Parameter  | Type   | Description                           |
|------------|--------|---------------------------------------|
| id         | int32  | The ID of the bike.                   |
| locationId | string | The location of the bike.(Station ID) |
| name       | string | The name of the bike                  |

#### Update Bike Rating

```http
  PUT /gateway/bikes/update/rating
```

| Parameter | Type   | Description          |
|-----------|--------|----------------------|
| id        | int32  | The ID of the bike.  |
| rating    | double | Bike rating          |


#### Delete All Bikes

```http
  PUT /gateway/bikes/delete/all
```

#### Delete Bikes By Location

```http
  PUT /gateway/bikes/delete/by_location/:location
```

| Parameter | Type   | Description                           |
|-----------|--------|---------------------------------------|
| location  | string | The location of the bike.(Station ID) |


#### Delete Bike By Id

```http
  PUT /gateway/bikes/delete/by_id/:id
```


| Parameter | Type | Description         |
|-----------|------|-------------------- |
| id        | int32| The ID of the bike. |
