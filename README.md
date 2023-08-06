# Login Application - Backend
A simple backend login application built with Spring Boot and Java 17.

## Getting Started
This project uses maven as a build tool.
The easiest way to get started using the application is with an IDE. I recommend IntelliJ IDEA.
After cloning the project, start the application by calling the main method in LoginApplication.java.

## Project Description
The login functionality is built with Spring Security featuring JWT Token-based authentication.

## API
* [POST] /authenticate
  *   No authorization headers required. Accepts a JSON body, taking fields for "username" (String) and "password" (String). If the correct username/password pair is provided, it will return an access token to the caller.
* [GET] /employee/{username}
  *   Requires a bearer-token within the Authorization Header with "USER" role. Returns the employee associated with the username provided in the path url, or "Not Found" if the employee does not exist.
* [GET] /employee/getAll
  *   Requires a bearer-token within the Authorization Header with "MANAGER" role. Returns a list of all employees inside the users table.
* [POST] /employee
  *   Requires a bearer-token within the Authorization Header with "MANAGER" role. Accepts a JSON body, taking fields for "userName" (String), "password" (String), "fullName" (String) and "isManager" (tinyint). If creation of employee is successful, returns "Created"
 
## Test Accounts
To test out the application, you may use the following test accounts:
* username: testEmployee, password: pass
* username: testManager, password: pass
