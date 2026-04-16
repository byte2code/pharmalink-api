# Changelog

All notable changes to this project are documented in this file.

## [v3.0.0] - 2026-04-16

### Summary
Third version of the PharmaLink API that reconnects the project to the PharmaLink domain and adds external store-finder integration through a dedicated communicator.

### Highlights

- Added `StoreFinderCommunicator` for calling the external store-finder service.
- Added `GET /user/getNearestStores/{userId}/{distance}/{token}` for distance-based store lookup through PharmaLink.
- Added `GET /user/getStoresWithMedicine/{medicine}/{token}` for medicine-based filtering through PharmaLink.
- Added a `RestTemplate` bean to the security configuration for service communication.
- Refreshed the README to position the project as a JWT-secured gateway for location-aware pharmacy lookup.

### Notes

This version expands the project from standalone user management into a simple cross-service pharmacy-discovery workflow.

## [v2.0.0] - 2026-04-16

### Summary
Second version of the PharmaLink API that adds the actual medical-store finder module with nearest-store and medicine-based lookup flows.

### Highlights

- Added `MedicalStore` entity and repository support.
- Added `MedicalStoreController` and `MedicalStoreService` for store CRUD operations.
- Added `GET /store/getNearestStores/{userId}/{distance}` for distance-based store discovery.
- Added `GET /store/getStoresWithMedicine/{medicine}` for medicine-based filtering.
- Refreshed the README to position the project as a pharmacy store-finder API.

### Notes

This version expands the project from user-location groundwork into a more practical location-aware pharmacy discovery workflow.

## [v1.0.0] - 2026-04-12

### Summary
Initial publication of the PharmaLink API as a clean, portfolio-ready Spring Boot REST project.

### Highlights

- Added a recruiter-friendly README with API overview, features, run steps, security flow, and project structure.
- Added a changelog for future version tracking.
- Cleaned IDE files, build artifacts, and helper files before publishing.
- Preserved the original JWT auth, password encoding, and coordinate-aware user registration workflows.

### Notes

This version establishes the project as a compact learning showcase for JWT-secured, location-aware user APIs built with Spring Boot and JPA.
