# AgileEngineChallenge

## Overview
This project is a Spring Boot application that connects to a PostgreSQL database.

## Prerequisites
- Java 21
- Maven
- Docker and Docker Compose

## Setup

### 1. Build the project
```shell
docker-compose up --build
```

## Profiles
- `dev`: Development profile - works with a localhost PostgreSQL database
- `prod`: (Default) Production profile - works with a PostgreSQL database running in a Docker container

## Build and Run with dev profile
### 1. Have a PostgreSQL database running on localhost and create a database called `ecommerce`
### 2. Run the following command
```shell
mvn clean install -Dspring.profiles.active=dev
```

## Accessing the Application
The application will be accessible at http://localhost:8080/api

## Examples

### Get all products
```shell
curl -X GET http://localhost:8080/api/products
```

### Get product by ID
```shell
curl -X GET http://localhost:8080/api/products/{id}
```

### Create a product
```shell
curl -X POST http://localhost:8080/api/products -H "Content-Type: application/json" -d '{"name": "Product Name", "description": "Product Description", "price": 100.00, "stock": 10}'
```

### JSON Body
```json
{
  "name": "Product Name",
  "description": "Product Description",
  "price": 100.00,
  "stock": 10
}
```


### This project still need more tests and improvements, but I hope you like it! :)
