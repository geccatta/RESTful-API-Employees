# REST API - Employees MS

## Summary:
This is a demo RESTful API built with Spring Boot, Spring Data JPA, and Spring Data REST. It provides CRUD operations for managing employee records. The API is designed to be easily extendable and can serve as a backend for a CRM system or any employee management application.

## Used Technologies:
1. Java 21
2. Spring Boot 3.4.5
3. Spring Data JPA
4. Spring Data REST
5. MySQL 8
6. Hibernate/JPA
7. Maven

## How to run the project:
1. Clone the repository:
<pre>git clone https://github.com/geccatta/RESTful-API-Employees.git
cd RESTful-API-Employees</pre>
2. The demo DB is included in the project along with its creditionals, so you don't need to update anything on ```application.properties```;
3. Build and run: ```mvn spring-boot:run```
4. Access the API:  ```http://localhost:8080/api/employees```

## Features:
- **CRUD Operations:** Create, Read, Update, and Delete employee records.
- **Pagination & Sorting:** Easily paginate and sort employee data.
- **RESTful Endpoints:** Adheres to REST principles for resource management.

## Testing the API:
You can use tool like [Postman](https://www.postman.com/) to test the API endpoints. 
