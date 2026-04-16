# PharmaLink API

Spring Boot REST API for location-aware user management with MySQL persistence, JWT authentication, and external medical-store discovery integration.

## Overview

This project demonstrates a compact Spring Boot API for a pharmacy-link style service. It focuses on secure user registration and login, stores user coordinates, and delegates nearby-store and medicine-based search to a separate store-finder service through inter-service communication.

## Concepts and Features Covered

- Spring Boot REST API setup
- Spring Data JPA repository pattern
- MySQL-backed persistence
- Spring Security with JWT authentication
- Stateless session handling with a custom JWT filter
- Method-level authorization with `@PreAuthorize`
- PBKDF2 password encoding with configured pepper, iterations, and hash width
- Public user registration and token-based login flow
- Role-backed `UserDetails` integration
- Coordinate-aware user registration using `xCoordinate` and `yCoordinate`
- Admin-only user listing endpoint
- Inter-service communication using `RestTemplate`
- External medical-store lookup by distance and medicine name

## Tech Stack

- Java 17
- Spring Boot 2.7
- Spring Web
- Spring Data JPA
- Spring Security
- Spring Validation
- MySQL
- Maven
- Lombok
- JJWT

## Project Structure

```text
PharmaLinkTemplate/
├── CHANGELOG.md
├── README.md
├── pom.xml
├── mvnw
├── mvnw.cmd
└── src/
    └── main/
        ├── java/com/CN/PharmaLink/
        │   ├── communicator/
        │   ├── config/
        │   ├── controller/
        │   ├── dto/
        │   ├── exceptions/
        │   ├── jwt/
        │   ├── model/
        │   ├── repository/
        │   ├── security/
        │   ├── service/
        │   └── PharmaLinkApplication.java
        └── resources/
            └── application.yml
```

## How to Run

1. Open a terminal in the project root.
2. Replace the placeholder MySQL values in `src/main/resources/application.yml`.
3. Ensure the companion store-finder service is available on `http://localhost:8081`.
4. Run `mvn test`.
5. Run `mvn spring-boot:run`.
6. Register a user with `POST /user/register`.
7. Obtain a JWT with `POST /auth/login`.
8. Use the lookup endpoints to retrieve nearby stores or stores carrying a medicine.

Available endpoints:

- `POST /auth/login`
- `GET /user`
- `POST /user/register`
- `GET /user/getNearestStores/{userId}/{distance}/{token}`
- `GET /user/getStoresWithMedicine/{medicine}/{token}`

Access notes:

- `/user/register` and `/auth/login` are public
- `GET /user` is restricted to `ADMIN`
- store-finder lookup calls are proxied to an external service by the provided communicator
- newly registered users are currently assigned the `ROLE_ADMIN` authority by the provided service logic

Example request body for registration:

```json
{
  "username": "john",
  "password": "john123",
  "xcoordinate": 120,
  "ycoordinate": 340
}
```

Example request body for login:

```json
{
  "username": "john",
  "password": "john123"
}
```

## Learning Highlights

- Demonstrates JWT-secured Spring Boot APIs with stateless request authentication
- Shows how PBKDF2 password encoding can be configured explicitly for stronger credential handling
- Uses stored user coordinates as the basis for location-aware pharmacy discovery
- Introduces inter-service communication through a dedicated `RestTemplate` communicator

## GitHub Metadata

- Suggested repository description: `Spring Boot REST API for location-aware user management with MySQL persistence, JWT authentication, and external medical-store discovery integration.`
- Suggested topics: `java`, `java-17`, `spring-boot`, `spring-security`, `spring-data-jpa`, `mysql`, `rest-api`, `jwt`, `location-based-services`, `pharmacy`, `resttemplate`, `microservices`, `maven`, `learning-project`, `portfolio-project`
