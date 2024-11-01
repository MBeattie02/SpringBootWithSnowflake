# Database and Schema Setup for Spring Boot Application

This document outlines the steps to initialize Snowflake for the Spring Boot application.

## Step 1: Create the Database

Execute the following SQL commands to create and select the database:

```sql
CREATE DATABASE springboot_db;
USE springboot_db;
```

## Step 2: Create the Schema

```sql
CREATE SCHEMA springboot_schema;
USE SCHEMA springboot_db.springboot_schema;
```

## Step 3: Create the Employee Table

```sql
CREATE TABLE employee (
  id BIGINT AUTO_INCREMENT PRIMARY KEY,
  name STRING,
  department STRING
);
```

## Step 4: Create Role and User

```sql
CREATE ROLE springboot_role;
CREATE USER springboot_user PASSWORD = 'password'
  DEFAULT_ROLE = springboot_role
  DEFAULT_NAMESPACE = springboot_db.springboot_schema;
GRANT ROLE springboot_role TO USER springboot_user;
```

## Step 5: Set Permissions

```sql
GRANT USAGE ON DATABASE springboot_db TO ROLE springboot_role;
GRANT USAGE ON SCHEMA springboot_db.springboot_schema TO ROLE springboot_role;
GRANT SELECT, INSERT, UPDATE, DELETE ON TABLE springboot_db.springboot_schema.employee TO ROLE springboot_role;
```

## Sample Data Insertion

```sql
USE DATABASE springboot_db;
USE SCHEMA springboot_schema;

INSERT INTO employee (id, name, department)
VALUES
  (1, 'John Doe', 'Engineering'),
  (2, 'Jane Smith', 'Marketing'),
  (3, 'Alice Johnson', 'Finance'),
  (4, 'Robert Brown', 'Human Resources'),
  (5, 'Michael Williams', 'Sales');
```

### Querying the Employee Table

```sql
SELECT * FROM employee LIMIT 10;
```

# Employee API Endpoints

The following endpoints are available for managing employees:

- **Get All Employees**:  
  `GET http://localhost:8080/employees`

- **Get an Employee by ID**:  
  `GET http://localhost:8080/employees/{id}`

- **Add a New Employee**:  
  `POST http://localhost:8080/employees`  
  *(Pass JSON data in the request body)*

- **Delete an Employee by ID**:  
  `DELETE http://localhost:8080/employees/{id}`

