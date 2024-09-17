
![SpringBoot](https://img.shields.io/badge/SpringBoot-black?logo=Springboot)
![MongoDB](https://img.shields.io/badge/MongoDB-white?logo=mongodb)
![ActiveMQ Artemis](https://img.shields.io/badge/ActiveMQ%20Artemis-red)


# Station Management
This microservice manages bike stations. It provides functionalities to fetch, create, update and delete stations. 

Each station the following properties:  
- id, 
- city, 
- street, 
- latitude, 
- longitude,
- slot count, 
- bike count



## API Endpoints

#### Get All Stations

```http
  GET /stations/all
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |

#### Get Station By Id

```http
  GET /stations/:id
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of the Station  |


#### Create New Station

```http
  POST /stations/create
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
  PUT /stations/update
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
  DELETE /stations/:id
```

| Parameter | Type     | Description                               |
| :-------- | :------- |:------------------------------------------|
| `id`      | `string` | **Required**. Id of the station to delete |

#### Delete All Stations

```http
  DELETE /stations/all
```

| Parameter | Type     | Description                               |
| :-------- | :------- |:------------------------------------------|


#### Add bike to Station

```http
  POST /stations/add
```

| Parameter   | Type     | Description                                        |
|:------------|:---------|:---------------------------------------------------|
| `id`        | `string` | **Required**. Id of the bike to add                |
| `stationId` | `string` | **Required**. Id of the station to add the bike to |

#### Remove bike from Station

```http
  POST /stations/remove
```

| Parameter   | Type     | Description                                             |
|:------------|:---------|:--------------------------------------------------------|
| `id`        | `string` | **Required**. Id of the bike to remove                  |
| `stationId` | `string` | **Required**. Id of the station to remove the bike from |


