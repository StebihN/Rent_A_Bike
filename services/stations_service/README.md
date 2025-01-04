
![SpringBoot](https://img.shields.io/badge/SpringBoot-black?logo=Springboot)
![MongoDB](https://img.shields.io/badge/MongoDB-white?logo=mongodb)


# Station Management
This microservice manages bike stations. It provides functionalities to fetch, create, update and delete stations. 

Each station the following properties:  
- id, 
- name
- latitude, 
- longitude,
- slot count, 
- bike count


## API Endpoints

#### Get All Stations

```http
  GET /stations/get/all
```

#### Get Stations with free spots

```http
  GET /stations/get/free
```

#### Get Station By Id

```http
  GET /stations/get/:id
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of the Station  |


#### Create New Station

```http
  POST /stations/create
```

| Parameter   | Type     | Description                               |
|:------------|:---------|:------------------------------------------|
| `name`      | `string` | **Required**. Name of the station         |
| `latitude`  | `string` | **Required**. Latitude of the station     |
| `longitude` | `string` | **Required**. Longitude of the locatio    |
| `slotCount` | `int`    | **Required**. No. of slots at the station |


#### Update Station

```http
  PUT /stations/update
```
| Parameter   | Type     | Description                               |
|:------------|:---------|:------------------------------------------|
| `id`        | `string` | **Required**. Id of the station to update |
| `name`      | `string` | **Required**. Name of the station         |
| `latitude`  | `string` | **Required**. Latitude of the station     |
| `longitude` | `string` | **Required**. Longitude of the locatio    |
| `slotCount` | `int`    | **Required**. No. of slots at the station |

#### Delete Station By Id

```http
  DELETE /stations/delete/:id
```

| Parameter | Type     | Description                               |
| :-------- | :------- |:------------------------------------------|
| `id`      | `string` | **Required**. Id of the station to delete |

#### Delete All Stations

```http
  DELETE /stations/delete/all
```

####  Rent bike from Station

```http
  PATCH /stations/rent/:id
```

| Parameter | Type     | Description                                                  |
| :-------- | :------- |:-------------------------------------------------------------|
| `id`      | `string` | **Required**. Id of the Station where a bike is being rented |

#### Return bike to Station

```http
  PATCH /stations/return/:id
```

| Parameter | Type     | Description                                                    |
| :-------- | :------- |:---------------------------------------------------------------|
| `id`      | `string` | **Required**. Id of the Station where a bike is being returned |


