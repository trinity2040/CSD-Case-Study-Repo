-- Create Departments Table
CREATE TABLE departments
  (
     department_id NUMBER PRIMARY KEY,
     name          VARCHAR2(100) NOT NULL
  );

-- Create Positions Table
CREATE TABLE positions
  (
     position_id NUMBER PRIMARY KEY,
     title       VARCHAR2(100) NOT NULL
  );

-- Create Employees Table
CREATE TABLE employees
  (
     employee_id   NUMBER PRIMARY KEY,
     first_name    VARCHAR2(50) NOT NULL,
     last_name     VARCHAR2(50) NOT NULL,
     dob           DATE NOT NULL,
     gender        VARCHAR2(10),
     email         VARCHAR2(100) UNIQUE,
     phone_number  VARCHAR2(15),
     department_id NUMBER,
     position_id   NUMBER,
     salary        NUMBER,
     FOREIGN KEY (department_id)references departments (department_id),
     FOREIGN KEY (position_id) references positions(position_id)
  );

-- Create Salary_Updates Table
CREATE TABLE salary_updates
  (
     salary_update_id NUMBER PRIMARY KEY,
     employee_id      NUMBER,
     old_salary       NUMBER,
     new_salary       NUMBER,
     effective_date   DATE,
     FOREIGN KEY (employee_id) REFERENCES employees(employee_id)
  ); 

-- Insert Data into first table Departments
INSERT INTO departments
            (department_id,name)
VALUES      (1,'Human Resources');

INSERT INTO departments
            (department_id,name)
VALUES      (2,'Finance');

INSERT INTO departments
            (department_id,name)
VALUES      (3,'IT');

INSERT INTO departments
            (department_id,name)
VALUES      (4,'IT');

INSERT INTO departments
            (department_id,name)
VALUES      (5,'Marketing');

-- Insert Data into second table Positions
INSERT INTO positions
            (position_id,title)
VALUES      (1,'Manager');

INSERT INTO positions
            (position_id,title)
VALUES      (2,'Analyst');

INSERT INTO positions
            (position_id,title)
VALUES      (3,'Database Adminstrator');

INSERT INTO positions
            (position_id,title)
VALUES      (4,'Developer');

INSERT INTO positions
            (position_id,title)
VALUES      (5,'Sales Executive');

-- Insert Data into thirld table Employees
INSERT INTO employees
            (employee_id,first_name,last_name,dob,gender,email,phone_number,
             department_id,
             position_id,salary)
VALUES      (1,'Ankit','Nainwal',To_date('2002-07-09', 'YYYY-MM-DD'),'Male',
             'ankit.nainwal@example.com','1234512345',1,2,45000);

INSERT INTO employees
            (employee_id,first_name,last_name,dob,gender,email,phone_number,
             department_id,
             position_id,salary)
VALUES      (2,'Amit','Singh',To_date('1991-07-23', 'YYYY-MM-DD'),'Male',
             'amit.singh@example.com','1234523456',2,1,55000);

INSERT INTO employees
            (employee_id,first_name,last_name,dob,gender,email,phone_number,
             department_id,
             position_id,salary)
VALUES      (3,'Ravi','Kumar',To_date('1995-10-05', 'YYYY-MM-DD'),'Male',
             'ravi.kumar@example.com','1234534567',3,3,60000);

INSERT INTO employees
            (employee_id,first_name,last_name,dob,gender,email,phone_number,
             department_id,
             position_id,salary)
VALUES      (4,'Mayank','Raj',To_date('1993-12-14', 'YYYY-MM-DD'),'Male',
             'mayank.raj@example.com','1234545678',4,4,48000);

INSERT INTO employees
            (employee_id,first_name,last_name,dob,gender,email,phone_number,
             department_id,
             position_id,salary)
VALUES      (5,'Shyaam','Singh',To_date('1990-06-30', 'YYYY-MM-DD'),'Male',
             'shyaam.singh@example.com','1234556789',2,2,52000);


-- Insert Data into last table Salary_Updates
INSERT INTO salary_updates
            (salary_update_id,employee_id,old_salary,new_salary,effective_date)
VALUES      (1,1,50000,55000,To_date('2024-01-01', 'YYYY-MM-DD')); 

-- Insert Salary Update for EMPLOYEE_ID = 2 with an increase of 6500 on 10-May-2024
INSERT INTO salary_updates
            (salary_update_id,employee_id,old_salary,new_salary,effective_date)
VALUES      (2,2,55000,61500,To_date('2024-05-10', 'YYYY-MM-DD')); 




-- Procedure to Hire Employees
CREATE OR REPLACE PROCEDURE Hire_Employee (
    p_first_name IN Employees.FIRST_NAME%TYPE,
    p_last_name IN Employees.LAST_NAME%TYPE,
    p_dob IN Employees.DOB%TYPE,
    p_gender IN Employees.GENDER%TYPE,
    p_email IN Employees.EMAIL%TYPE,
    p_phone_number IN Employees.PHONE_NUMBER%TYPE,
    p_department_id IN Employees.DEPARTMENT_ID%TYPE,
    p_position_id IN Employees.POSITION_ID%TYPE,
    p_salary IN Employees.SALARY%TYPE
) IS
BEGIN
    INSERT INTO Employees (
        EMPLOYEE_ID, FIRST_NAME, LAST_NAME, DOB, GENDER, EMAIL, PHONE_NUMBER, DEPARTMENT_ID, POSITION_ID, SALARY
    ) VALUES (
        Employees_SEQ.NEXTVAL, p_first_name, p_last_name, p_dob, p_gender, p_email, p_phone_number, p_department_id, p_position_id, p_salary
    );
    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Employee hired successfully.');
END Hire_Employee;
/


/**
 * Updates the salary of an employee.
 */
 CREATE OR REPLACE PROCEDURE Update_Salary (
    p_employee_id IN Employees.EMPLOYEE_ID%TYPE,
    p_new_salary IN Employees.SALARY%TYPE
) IS
    v_old_salary Employees.SALARY%TYPE;
BEGIN
    SELECT SALARY INTO v_old_salary FROM Employees WHERE EMPLOYEE_ID = p_employee_id;

    -- Update salary
    UPDATE Employees
    SET SALARY = p_new_salary
    WHERE EMPLOYEE_ID = p_employee_id;

    -- Insert into Salary_Updates table
    INSERT INTO Salary_Updates (
        SALARY_UPDATE_ID, EMPLOYEE_ID, OLD_SALARY, NEW_SALARY, EFFECTIVE_DATE
    ) VALUES (
        Salary_Updates_SEQ.NEXTVAL, p_employee_id, v_old_salary, p_new_salary, SYSDATE
    );

    COMMIT;
    DBMS_OUTPUT.PUT_LINE('Salary updated successfully.');
END Update_Salary;
/

--Procedure to Generate Employee Reports
CREATE OR REPLACE PROCEDURE Generate_Employee_Report (
    p_employee_id IN Employees.EMPLOYEE_ID%TYPE
) IS
    v_first_name Employees.FIRST_NAME%TYPE;
    v_last_name Employees.LAST_NAME%TYPE;
    v_department_name Departments.NAME%TYPE;
    v_position_title Positions.TITLE%TYPE;
    v_current_salary Employees.SALARY%TYPE;
    CURSOR c_salary_history IS
        SELECT OLD_SALARY, NEW_SALARY, EFFECTIVE_DATE
        FROM Salary_Updates
        WHERE EMPLOYEE_ID = p_employee_id;
BEGIN
    SELECT e.FIRST_NAME, e.LAST_NAME, d.NAME, p.TITLE, e.SALARY
    INTO v_first_name, v_last_name, v_department_name, v_position_title, v_current_salary
    FROM Employees e
    JOIN Departments d ON e.DEPARTMENT_ID = d.DEPARTMENT_ID
    JOIN Positions p ON e.POSITION_ID = p.POSITION_ID
    WHERE e.EMPLOYEE_ID = p_employee_id;

    DBMS_OUTPUT.PUT_LINE('Employee Report for ' || v_first_name || ' ' || v_last_name);
    DBMS_OUTPUT.PUT_LINE('Department: ' || v_department_name);
    DBMS_OUTPUT.PUT_LINE('Position: ' || v_position_title);
    DBMS_OUTPUT.PUT_LINE('Current Salary: ' || v_current_salary);
    DBMS_OUTPUT.PUT_LINE('Salary History:');

    FOR r IN c_salary_history LOOP
        DBMS_OUTPUT.PUT_LINE('Old Salary: ' || r.OLD_SALARY || ', New Salary: ' || r.NEW_SALARY || ', Effective Date: ' || r.EFFECTIVE_DATE);
    END LOOP;
END Generate_Employee_Report;
/


--Test the System
-- Hire a new employee

BEGIN
    Hire_Employee(
        'Alice', 'Brown', TO_DATE('1995-04-25', 'YYYY-MM-DD'), 'Female', 'alice.brown@example.com', '5551234567', 2, 2, 45000
    );
END;
/

-- Update the salary of an employee
BEGIN
    Update_Salary(1, 58000);
END;
/

-- Generate a report for an employee
BEGIN
    Generate_Employee_Report(1);
END;
/

