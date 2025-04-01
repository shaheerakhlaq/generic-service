# Generic Service Implementation in Java with Spring Boot and JPA

## Introduction
In modern enterprise applications, designing a reusable and well-structured service layer is crucial. A well-implemented generic service layer ensures consistency, reduces redundancy, and enhances maintainability.

This article provides a comprehensive guide to implementing a **generic service layer** in Java using **Spring Boot and Spring Data JPA**. The implementation will cover:

* **CRUD operations**
* **Soft deletion**
* **Dynamic search**
* **DTO (Data Transfer Object) mapping**

## Prerequisites:
Ensure you have the following software installed on your system:

* **JDK** 21
* **Maven** 3.6.*
* **Spring Boot** 3.4.0
* **Postgres** 15.*

## Project Installation and Build
1. **Clone or Download the Project**:
    * Download or clone the project from the repository.
    * Open a terminal and navigate to the project's root folder.
2. **Build the project**:
   * Run the following Maven command to clean and package the project:
   * ```mvn clean package```
3. **Set Up the Database**
   * Navigate to the db directory inside the project. 
   * Create a PostgreSQL database named sw_fp. 
   * Execute the provided DDL scripts to set up the schema.

## Organization
### Find cURL

```
curl --location 'http://localhost:9099/fp/api/v_1/organization/find' \
--header 'Content-Type: application/json'
--data '{
    "pageNumber": 1,
    "pageSize": 10
}'
```

## User
### Find cURL

```
curl --location 'http://localhost:9099/fp/api/v_1/user/find' \
--header 'Content-Type: application/json'
--data '{
    "pageNumber": 1,
    "pageSize": 10
}'
```

## Conclusion
By implementing a generic service layer, we achieve:
* **Code Reusability**: Centralized business logic.
* **Maintainability**: Simplified service extension.
* **Scalability**: Generic filtering and DTO mapping.

> This approach ensures a clean, scalable, and consistent service layer in Spring Boot applications.