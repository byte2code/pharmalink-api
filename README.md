# PharmaLink API

Spring Boot REST API for finding nearby medical stores with MySQL persistence, JWT-ready security configuration, and location-aware store search.

## Overview

This project demonstrates a compact Spring Boot API for pharmacy-store discovery. It models medical stores with coordinates and medicine availability, then exposes lookup endpoints for nearby stores and medicine-based filtering. It builds on the earlier PharmaLink security and user-location concepts by introducing the actual store-finder module.

## Concepts and Features Covered

- Spring Boot REST API setup
- Spring Data JPA repository pattern
- MySQL-backed persistence
- Spring Security configuration with JWT filter integration
- Location-based nearest-store search using stored user and store coordinates
- Medicine-availability filtering across medical stores
- Medical store create, read, update, and delete endpoints
- DTO-based input handling for store creation and updates
- Coordinate-aware store records using `xCoordinate` and `yCoordinate`
- JPA `@ElementCollection` for medicine lists

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
        ├── java/com/CN/StoreFinder/
        │   ├── config/
        │   ├── controller/
        │   ├── dto/
        │   ├── jwt/
        │   ├── model/
        │   ├── repository/
        │   ├── security/
        │   ├── service/
        │   └── StoreFinderApplication.java
        └── resources/
            └── application.yml
```

## How to Run

1. Open a terminal in the project root.
2. Replace the placeholder MySQL values in `src/main/resources/application.yml`.
3. Run `mvn test`.
4. Run `mvn spring-boot:run`.
5. Use the API under `http://localhost:8081`.

Available endpoints:

- `POST /store/create`
- `GET /store/{id}`
- `GET /store/all`
- `GET /store/getNearestStores/{userId}/{distance}`
- `GET /store/getStoresWithMedicine/{medicine}`
- `PUT /store/update/{id}`
- `DELETE /store/delete/{id}`

Example request body for store creation:

```json
{
  "name": "City Care Pharmacy",
  "contact": 9876543210,
  "area": "Sector 18",
  "xCoordinate": 120,
  "yCoordinate": 340,
  "medicines": ["Paracetamol", "Vitamin C", "Insulin"]
}
```

## Learning Highlights

- Demonstrates a simple location-based search flow using stored user and store coordinates
- Shows how medicine availability can be modeled with JPA collection mapping
- Extends a user-location concept into a practical nearby-store lookup API
- Keeps the project compact while covering CRUD, filtering, and location-driven retrieval

## GitHub Metadata

- Suggested repository description: `Spring Boot REST API for finding nearby medical stores with MySQL persistence, location-aware lookup, and medicine-based filtering.`
- Suggested topics: `java`, `java-17`, `spring-boot`, `spring-data-jpa`, `mysql`, `rest-api`, `location-based-services`, `store-finder`, `pharmacy`, `jwt`, `maven`, `learning-project`, `portfolio-project`
