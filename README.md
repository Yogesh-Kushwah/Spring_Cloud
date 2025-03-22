# Spring_Cloud

# Microservices Project - Hotel Rating System

This is a microservices-based project developed using Spring Boot. The main objective of this project is to allow users to give ratings to hotels and fetch hotel and rating details using their user ID.

## Project Overview
The project consists of the following microservices:

1. **API Gateway** - Acts as an entry point for all client requests and routes them to appropriate microservices.
2. **Config Server** - Manages external configurations centrally for all microservices.
3. **Service Registry (Eureka)** - Provides service discovery to help microservices communicate with each other.
4. **User Service** - Handles user-related operations like fetching user details.
5. **Hotel Service** - Manages hotel information.
6. **Rating Service** - Handles hotel rating operations.

## Features
- Users can submit ratings for hotels.
- Users can fetch hotel details and ratings using their user ID.
- API Gateway ensures seamless communication between services.
- Centralized configuration management using Config Server.
- Service discovery and registration using Eureka.

## Technology Stack
- **Spring Boot** for building microservices
- **Spring Cloud** for service discovery, configuration management, and API Gateway
- **Eureka Server** for service registration and discovery
- **PostgreSQL / MySQL** for database management
- **RestTemplate / FeignClient** for inter-service communication

## Setup and Installation
1. Clone the repository:
    ```bash
    git clone <repository-url>
    ```
2. Navigate to the project directory and build the services using Maven:
    ```bash
    mvn clean install
    ```
3. Start the Config Server:
    ```bash
    cd config-server
    mvn spring-boot:run
    ```
4. Start the Eureka Service Registry:
    ```bash
    cd service-registry
    mvn spring-boot:run
    ```
5. Start the API Gateway:
    ```bash
    cd api-gateway
    mvn spring-boot:run
    ```
6. Start all other microservices in a similar way.

## API Endpoints
- **User Service**: `/users/{userId}` - Fetch user details
- **Hotel Service**: `/hotels/{hotelId}` - Fetch hotel details
- **Rating Service**: `/ratings/{userId}` - Fetch user ratings

## Author and Acknowledgement
This project has been created with guidance from **Durgesh** through his YouTube channel **Learn Code with Durgesh**.

## License
This project is licensed under the MIT License. Feel free to use and modify it.

## Contact
For further information or questions, please contact: **Yogesh Kushwah** at [yogeshkushwah775@gmail.com](mailto:yogeshkushwah775@gmail.com).


