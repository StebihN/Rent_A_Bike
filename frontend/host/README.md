![Node_JS](https://img.shields.io/badge/Node_JS-black?logo=npm) 
![React](https://img.shields.io/badge/React-black?logo=react)
![Webpack](https://img.shields.io/badge/Webpack-white?logo=webpack)
![Axios](https://img.shields.io/badge/Axios-black?logo=axios)


# Host Microfrontend
This is a host Microfrontend that that joins all other microfrontends into a single frontend.



## Environment Variables

To run this project, you will need to add the following environment variables to your .env file

| Variable       | Description                         |
| :------------- | :---------------------------------- |
| `PUBLIC_PATH`  | IP Adress of this app               |
| `USERS_URI`    | IP Adress of users microfrontend    |
| `BIKES_URI`    | IP Adress of bikes microfrontend    |
| `STATIONS_URI` | IP Adress of stations microfrontend |



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
  docker build -f Dockerfile -t  host-front .
```

Run the container

```bash
  docker run -p 2000:2000 --name host-front host-front 
```