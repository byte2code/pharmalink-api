# PharmaLink API

Spring Boot REST API for location-aware user management with MySQL persistence, JWT authentication, and role-based security.

## Overview

This project demonstrates a compact Spring Boot API for a pharmacy-link style service. It focuses on secure user registration and login, role-protected user management, and storing user coordinates that can support location-based pharmacy discovery workflows.

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
- DTO and exception groundwork for external medical-store integration

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
3. Run `mvn test`.
4. Run `mvn spring-boot:run`.
5. Register a user with `POST /user/register`.
6. Obtain a JWT with `POST /auth/login`.
7. Call protected endpoints with `Authorization: Bearer <token>`.

Available endpoints:

- `POST /auth/login`
- `GET /user`
- `POST /user/register`

Access notes:

- `/user/register` and `/auth/login` are public
- `GET /user` is restricted to `ADMIN`
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
- Stores user coordinates as a foundation for future location-based pharmacy lookup features
- Keeps the API compact and focused while still covering authentication, authorization, persistence, and DTO-based input flow

## GitHub Metadata

- Suggested repository description: `Spring Boot REST API for location-aware user management with MySQL persistence, JWT authentication, and role-based security.`
- Suggested topics: `java`, `java-17`, `spring-boot`, `spring-security`, `spring-data-jpa`, `mysql`, `rest-api`, `jwt`, `location-based-services`, `pharmacy`, `maven`, `learning-project`, `portfolio-project`
