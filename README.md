# Java WebFlux CRUD Application: Department and Employee Management (R2DBC)

## HomePage : http://localhost:8080/

### Sample Data

#### Department
| id | name        |
|----|-------------|
| 1  | account     |
| 2  | engineering |
| 3  | hr          |


#### Employee
| id | name    | age | email           |
|----|---------|-----|-----------------|
| 1  | alice   | 30  | alice@test.com   |
| 2  | bob     | 40  | bob@test.com     |
| 3  | charlie | 50  | charlie@test.com |


#### Employee_Department
| emp_id      | dep_id          |
|-------------|-----------------|
| 1 (alice)   | 1 (account)     |
| 2 (bob)     | 2 (engineering) |
| 3 (charlie) | 2 (account)     |
| 3 (charlie) | 2 (engineering) |

### Techstack
- Spring Boot
- WebFlux
- Spring Data R2DBC
- H2
- Lombok
- Maven




