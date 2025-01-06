

![Node_JS](https://img.shields.io/badge/Node_JS-black?logo=npm) ![Express_JS](https://img.shields.io/badge/Express_JS-gray?logo=express) ![MySQL](https://img.shields.io/badge/MySQL-white?logo=mysql)

# User Management
This service takes care of user management. It provides functionality to fetch, create, update and delete user data.

Each user has the following properties:
 - name,
 - surname,
 - email, 
 - password,
 - password salt,
 - bikes rented


## API Endpoints

#### Get All Users

```http
  GET /users/get
```

#### Get User By Id

```http
  GET /users/get/:id
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

| Parameter | Type  | Description                       |
| :-------- | :---- | :-------------------------------- |
| `id`      | `int` | **Required**. Id of the user to update |

#### Delete user

```http
  DELETE /users/delete/:id
```

| Parameter | Type     | Description                            |
| :-------- | :------- | :------------------------------------- |
| `id`      | `string` | **Required**. Id of the user to delete |

#### Delete all users

```http
  DELETE /users/delete/
```



## Database
This app requires a running MySQL database to store data (Windows Service, Docker Container,...). It requires a database with a table that has the following columns:

| Name             | Type         |
|:-----------------|:-------------|
| `id `            | INT          |
| `name `          | VARCHAR(45)  |
| `surname `       | VARCHAR(45)  |
| `email `         | VARCHAR(45)  |
| `password `      | VARCHAR(255) |
| `password_salt ` | VARCHAR(255) |
| `bikes_rented `  | INT          |

## Environment Variables

To run this project, you will need to add the following environment variables to your .env file

| Variable     | description              |
|:-------------|:-------------------------|
| `MYSQL_HOST` | Database host IP address |
| `MYSQL_USER` | Database Username        |
| `MYSQL_PASS` | Database Password        |
| `MYSQL_DB`   | Database name            |
| `MYSQL_PORT` | Database access port     |


## Running the app
The app can be run using npm or as a docker container

1. **Using npm**

Install dependencies

```bash
  npm install
```

Start the server

```bash
  npm run start
```

2. **As a docker container**

Build the container

```bash
  docker build -f Dockerfile -t  users-service .
```

Run the container

```bash
  docker run -p 3001:3001 --name users-service users-service 
```

