![Node_JS](https://img.shields.io/badge/Node_JS-black?logo=npm) 
![React](https://img.shields.io/badge/React-black?logo=react)
![Webpack](https://img.shields.io/badge/Webpack-white?logo=webpack)
![Axios](https://img.shields.io/badge/Axios-black?logo=axios)


# Stations Microfrontend
This is a Microfrontend that provides a user interface for viewing, updating, creating and deleting stations.



## Environment Variables

To run this project, you will need to add the following environment variables to your .env file

| Variable      | Description                    |
| :------------ | :----------------------------- |
| `GATEWAY_URI` | API Gateway host IP address    |
| `PUBLIC_PATH` | IP Adress of this app          |
| `HOST_URI`    | IP Adress of the host frontend |



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
  docker build -f Dockerfile -t  stations-front .
```

Run the container

```bash
  docker run -p 2002:2002 --name stations-front stations-front 
```