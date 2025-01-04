

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


