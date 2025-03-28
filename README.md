# Microservice-Based Spring Boot Project

This project is a microservice-based application using Spring Boot, where users can give ratings to hotels and fetch hotel and rating details using their user ID.

## Features
- **User Management**: Users can fetch their details and corresponding hotel ratings.
- **Hotel Management**: Manage hotel information.
- **Rating Management**: Users can give ratings and fetch their rating details.
- **API Gateway**: Central gateway to manage all microservices.
- **Config Server**: Centralized configuration management.
- **Service Registry**: Service discovery using Eureka.
- **Circuit Breaker**: Implemented using Resilience4j to prevent cascading failures.
- **Retry Mechanism**: Ensures reliability by retrying failed requests.
- **Rate Limiting**: Prevents abuse by limiting the number of requests per user.

## Microservices
1. **API Gateway** - Handles incoming requests and routes them to appropriate services.
2. **Config Server** - Provides configuration to all microservices.
3. **Service Registry** - Registers and discovers services using Eureka.
4. **User Service** - Manages user-related operations.
5. **Hotel Service** - Manages hotel-related operations.
6. **Rating Service** - Handles rating-related operations.

## Tools and Technologies
- Java
- Spring Boot
- Spring Cloud
- Resilience4j (Circuit Breaker, Retry)
- Eureka Server
- Spring Cloud Config
- API Gateway
- PostgreSQL / MySQL
- Docker (Optional)

## Installation and Setup
1. Clone the repository:
    ```bash
    git clone <repository-url>
    ```
2. Configure the application.properties or application.yml files in respective microservices.
3. Start the services in the following order:
    - Config Server
    - Service Registry
    - API Gateway
    - Other microservices (UserService, HotelService, RatingService)
4. Access the API Gateway at `http://localhost:8080`.

## Author
Special thanks to **Durgesh** from the YouTube channel **Learn Code with Durgesh** for helpful guidance.

---
Feel free to contribute and submit pull requests!

