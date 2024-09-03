# Employee Salary Management System

## Project Overview

The **Employee Salary Management System** is a database management project designed using Oracle SQL and PL/SQL. It allows managing employee data, department details, job positions, and salary records efficiently. This system provides functionalities for hiring employees, updating salaries, and generating comprehensive reports.

## Key Features

- **Employee Management**: Add, update, delete, and search for employee records.
- **Salary Management**: Record and track salary changes over time.
- **Reporting**: Generate detailed reports on employees, including their personal details, department, position, and salary history.

## Database Schema

The database schema consists of the following tables:

1. **Employees Table**:
   - `EMPLOYEE_ID`: Number, Primary Key
   - `FIRST_NAME`: Varchar2(50)
   - `LAST_NAME`: Varchar2(50)
   - `DOB`: Date
   - `GENDER`: Varchar2(10)
   - `EMAIL`: Varchar2(100)
   - `PHONE_NUMBER`: Varchar2(15)
   - `DEPARTMENT_ID`: Number, Foreign Key References Departments(DEPARTMENT_ID)
   - `POSITION_ID`: Number, Foreign Key References Positions(POSITION_ID)
   - `SALARY`: Number

2. **Departments Table**:
   - `DEPARTMENT_ID`: Number, Primary Key
   - `NAME`: Varchar2(100)

3. **Positions Table**:
   - `POSITION_ID`: Number, Primary Key
   - `TITLE`: Varchar2(100)

4. **Salary_Updates Table**:
   - `SALARY_UPDATE_ID`: Number, Primary Key
   - `EMPLOYEE_ID`: Number, Foreign Key References Employees(EMPLOYEE_ID)
   - `OLD_SALARY`: Number
   - `NEW_SALARY`: Number
   - `EFFECTIVE_DATE`: Date

## Setup Instructions

## Setup Instructions

1. Execute 28703837.sql script.
2. All the create table queries, Inserting on sample data, procedure queries are written in this file.

## Sample Data

Below are examples of entries that can be added to the `Employees` table:

- **Ankit Nainwal**:
  - `EMPLOYEE_ID`: 1
  - `FIRST_NAME`: Ankit
  - `LAST_NAME`: Nainwal
  - `DOB`: 1988-03-12
  - `GENDER`: Male
  - `EMAIL`: ankit.nainwal@example.com
  - `PHONE_NUMBER`: 1234512345
  - `DEPARTMENT_ID`: 1
  - `POSITION_ID`: 2
  - `SALARY`: 45000

- **Ravi Kumar**:
  - `EMPLOYEE_ID`: 3
  - `FIRST_NAME`: Ravi
  - `LAST_NAME`: Kumar
  - `DOB`: 1995-10-05
  - `GENDER`: Male
  - `EMAIL`: ravi.kumar@example.com
  - `PHONE_NUMBER`: 1234534567
  - `DEPARTMENT_ID`: 3
  - `POSITION_ID`: 3
  - `SALARY`: 60000

## Example of Salary Update

Below is an example of a salary update entry:

- **Employee ID**: 2 (Amit Singh)
- **Old Salary**: 55000
- **New Salary**: 61500
- **Effective Date**: May 10, 2024

```sql
INSERT INTO Salary_Updates (SALARY_UPDATE_ID, EMPLOYEE_ID, OLD_SALARY, NEW_SALARY, EFFECTIVE_DATE)
VALUES (2, 2, 55000, 61500, TO_DATE('2024-05-10', 'YYYY-MM-DD'));
