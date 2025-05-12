# REST API - Employees MS

## Summary:
This is a demo RESTful API built with Spring Boot. It provides CRUD operations for managing employee records. The API is designed to be easily extendable and can serve as a backend for a CRM system or any employee management application.

## Used Technologies:
1. Java 21
2. Spring Boot 3.4.5
3. Spring Data JPA
4. Spring Data REST
5. Spring Security
6. MySQL 8
7. Hibernate/JPA
8. Maven

## How to run the project:
1. Clone the repository:
<pre>git clone https://github.com/geccatta/RESTful-API-Employees.git
cd RESTful-API-Employees</pre>
2. Configure the database:
   - Update the application.properties file with your MySQL database credentials:
     <pre>spring.datasource.url=jdbc:mysql://localhost:3306/employee_directory
     spring.datasource.username=your_username
     spring.datasource.password=your_password
     spring.jpa.hibernate.ddl-auto=update</pre>
3. Build and run: ```mvn spring-boot:run```
4. Access the API:  ```http://localhost:8080/api/employees```

## Features:
- **CRUD Operations:** Create, Read, Update, and Delete employee records.
- **Pagination & Sorting:** Easily paginate and sort employee data.
- **RESTful Endpoints:** Adheres to REST principles for resource management.
### Newest Feature: Added Spring Security with Role-Based Access Control
-  Integrated Spring Security framework into the application.
-  Passwords are now securely stored using the ***BCrypt hashing algorithm***.
-  Implemented user roles **(EMPLOYEE, MANAGER, ADMIN)** to control access to API endpoints.
-  CRUD operations are restricted based on assigned roles *(e.g., EMPLOYEE can only read; MANAGER can read, create and update; ADMIN has full access)*.
-  Unauthorized or unauthenticated requests receive proper HTTP responses.
-  ***NOTE***: You can get the usernames for testing from `user` table in the `spring-boot-employee-sql-script/user-role-directory` directory, the password is *test123*.

## Testing the API:
You can use tool like [Postman](https://www.postman.com/) to test the API endpoints. 
