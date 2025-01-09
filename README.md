![Node_JS](https://img.shields.io/badge/Node_JS-black?logo=npm)
![Express_JS](https://img.shields.io/badge/Express_JS-gray?logo=express)
![SpringBoot](https://img.shields.io/badge/SpringBoot-black?logo=Springboot)
![Quarkus](https://img.shields.io/badge/Quarkus-white?logo=quarkus)
![MySQL](https://img.shields.io/badge/MySQL-white?logo=mysql)
![MongoDB](https://img.shields.io/badge/MongoDB-white?logo=mongodb)
![PostgreSQL](https://img.shields.io/badge/PostgreSQL-white?logo=postgresql)
![React](https://img.shields.io/badge/React-black?logo=react)
![Webpack](https://img.shields.io/badge/Webpack-white?logo=webpack)
![Axios](https://img.shields.io/badge/Axios-black?logo=axios)

[![Test and Package](https://github.com/StebihN/Rent_A_Bike/actions/workflows/main.yml/badge.svg)](https://github.com/StebihN/Rent_A_Bike/actions/workflows/main.yml)

# Bike Rental Sytem
An app for a bike rental company. It provides functionalities for viewing, creating, updating and deleting bikes, bike stations and users. users can view and rent bikes at stations. 

## Motivation

The motivation behind this project was to learn various technologies listed in the badges above and to learn about microservices, microfrontends, gateways and other concepts.

## Running the app
This app can be run by setting up each app seperatly or by running a docker compose file.

1. **Setting up each app separately**

Setup up each app separately by following these instructions:
- [Users service](https://github.com/StebihN/Rent_A_Bike/blob/main/services/users_service/README.md)
- [Bikes service](https://github.com/StebihN/Rent_A_Bike/blob/main/services/bikes_service/README.md)
- [Stations service](https://github.com/StebihN/Rent_A_Bike/blob/main/services/stations_service/README.md)
- [Rentals service](https://github.com/StebihN/Rent_A_Bike/blob/main/services/rentals_service/README.md)
- [API Gateway](https://github.com/StebihN/Rent_A_Bike/blob/main/gateway/README.md)
- [Users microfrontend](https://github.com/StebihN/Rent_A_Bike/blob/main/frontend/users/README.md)
- [Bikes microfrontend](https://github.com/StebihN/Rent_A_Bike/blob/main/frontend/bikes/README.md)
- [Stations microfrontend](https://github.com/StebihN/Rent_A_Bike/blob/main/frontend/stations/README.md)
- [Frontend host](https://github.com/StebihN/Rent_A_Bike/blob/main/frontend/host/README.md)

1. **As a docker container**

In the root folder of this project run:

```bash
  docker compose up -d
```

## Images from the app

1. **Login**
![log_in](https://github.com/user-attachments/assets/168147fa-4836-4955-b44d-4884e75b0d95)
2. **Register**
![register](https://github.com/user-attachments/assets/310076a9-b6b2-4e23-83fa-6806eac3b00d)
3. **Homepage**
![homepage](https://github.com/user-attachments/assets/de952ce1-0d9c-4672-a6fb-4b09298b4fbc)
4. **View bikes**
![homepage_bikes](https://github.com/user-attachments/assets/00deed8d-b8d1-45f1-9cbf-cd3138459590)
5. **Renting a bike**
![homepage_rent](https://github.com/user-attachments/assets/1e0dad53-c617-4d6c-b8d1-477bf10a6df1)
6. **Return bike**
![homepage_return](https://github.com/user-attachments/assets/ebbb9b78-8b57-4041-87f4-b95a35d014f1)
7. **Edit profile**
![profile](https://github.com/user-attachments/assets/55f86f7f-9259-489f-9f93-a8935cb62364)
8. **Admin view for stations**
![stations](https://github.com/user-attachments/assets/0e82352e-acd5-48de-b49b-a17a366e6def)
9. **Create a new station**
![stations_add](https://github.com/user-attachments/assets/7cf4188e-d3d0-4388-b16f-fde0831ae56a)
9. **Admin view for bikes**
![bikes](https://github.com/user-attachments/assets/d0406e15-d8c6-42fc-b129-0ebf00b75b64)
10. **Create a new bike**
![bikes_add](https://github.com/user-attachments/assets/2e04e8c8-c2fc-4488-b7fc-6fd90cbd20a3)
11. **Admin view for users**
![users](https://github.com/user-attachments/assets/2e3a6033-6d7b-4ac8-b64c-4df319be42aa)
12. **Create a new user**
![users_add](https://github.com/user-attachments/assets/cbd1ccc7-065d-413f-89c8-0883c8e7d7ae)
