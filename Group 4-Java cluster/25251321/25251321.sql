-- Creating Employees table 
create table Employees (
    EMPLOYEE_ID number primary key,
    FIRST_NAME varchar2(50),
    LAST_NAME varchar2(50),
    DEPARTMENT varchar2(50),
    POSITION varchar2(50),
    JOIN_DATE date
);

-- Inserting sample data in Employees table 
insert into Employees (
EMPLOYEE_ID, 
FIRST_NAME, 
LAST_NAME, 
DEPARTMENT, 
POSITION, 
JOIN_DATE )
VALUES (1, 'Rahul', 'Sharma', 'Sales', 'Manager', to_date(
'2021-06-15', 
'YYYY-MM-DD'));

insert into Employees (
EMPLOYEE_ID, 
FIRST_NAME, 
LAST_NAME, 
DEPARTMENT, 
POSITION, 
JOIN_DATE )
values (2, 'Aman', 'Dhatarwal', 'IT', 'Software Developer', to_date(
'2019-03-22', 'YYYY-MM-DD'));

insert into Employees (
EMPLOYEE_ID, 
FIRST_NAME, 
LAST_NAME, 
DEPARTMENT, 
POSITION, 
JOIN_DATE )
values (3, 'Shraddha', 'Sriv', 'IT', 'Associate Developer', to_date(
'2020-04-22', 'YYYY-MM-DD'));

-- Creating Attendance Table
create table Attendance (
    ATTENDANCE_ID number primary key,
    EMPLOYEE_ID number,
    ATTENDANCE_DATE date,
    STATUS varchar2(50),
    REMARKS varchar2(200),
    foreign key (EMPLOYEE_ID) references Employees(EMPLOYEE_ID)
);

-- Inserting sample data in Attendance table 
insert into Attendance (
ATTENDANCE_ID, EMPLOYEE_ID, ATTENDANCE_DATE, STATUS, REMARKS)
values (1, 1, TO_DATE('2024-08-01', 'YYYY-MM-DD'), 'Present', 'On time');

insert into Attendance (
ATTENDANCE_ID, EMPLOYEE_ID, ATTENDANCE_DATE, STATUS, REMARKS)
values (2, 2, TO_DATE('2024-08-01', 'YYYY-MM-DD'), 'Absent', 'Sick leave');

insert into Attendance (
ATTENDANCE_ID, EMPLOYEE_ID, ATTENDANCE_DATE, STATUS, REMARKS)
values (3, 3, TO_DATE('2024-08-01', 'YYYY-MM-DD'), 'Present', '2 Hours Late');

-- Creating Leaves Table
create table Leaves (
    LEAVE_ID number primary key,
    EMPLOYEE_ID number,
    LEAVE_TYPE varchar2(20),
    START_DATE date,
    END_DATE date,
    STATUS varchar2(20),
    foreign key (EMPLOYEE_ID) references Employees(EMPLOYEE_ID)
);

-- Inserting sample data in Leaves table 
insert into Leaves (
LEAVE_ID, EMPLOYEE_ID, LEAVE_TYPE, START_DATE, END_DATE, STATUS)
values (1, 2, 'Sick - Fever', 
to_date('2024-08-01', 'YYYY-MM-DD'), 
to_date('2024-08-06', 'YYYY-MM-DD'), 'Approved');

insert into Leaves (
LEAVE_ID, EMPLOYEE_ID, LEAVE_TYPE, START_DATE, END_DATE, STATUS)
values (2, 3, 'Travel', 
to_date('2024-08-01', 'YYYY-MM-DD'), 
to_date('2024-08-03', 'YYYY-MM-DD'), 'Cancelled Leave');

-- Creating a sequence which will increment the IDs by 1 for employees
create sequence employee_seq
start with 4
increment by 1
nocache
nocycle;

-- Procedure to create or update the records in the Employees table
CREATE OR REPLACE PROCEDURE CreateUpdateEmpFunction (
    co_employee_id NUMBER DEFAULT NULL, -- Input parameter
    co_first_name VARCHAR2,
    co_last_name VARCHAR2,
    co_department VARCHAR2,
    co_position VARCHAR2,
    co_join_date DATE
) AS
    new_employee_id NUMBER; -- Variable to hold the new employee ID
BEGIN
    IF co_employee_id IS NOT NULL THEN
    -- Update the existing employee's information
        UPDATE Employees
        SET FIRST_NAME = co_first_name,
            LAST_NAME = co_last_name,
            DEPARTMENT = co_department,
            POSITION = co_position,
            JOIN_DATE = co_join_date
        WHERE EMPLOYEE_ID = co_employee_id;
        -- Output to show the update is successful
        DBMS_OUTPUT.PUT_LINE('Successfully Updated. EMPLOYEE_ID: ' || co_employee_id);
    ELSE
        -- Using employee_seq sequence to increment the ID
        SELECT employee_seq.NEXTVAL INTO new_employee_id FROM dual;

        INSERT INTO Employees (EMPLOYEE_ID, FIRST_NAME, LAST_NAME, DEPARTMENT, POSITION, JOIN_DATE)
        VALUES (new_employee_id, co_first_name, co_last_name, co_department, co_position, co_join_date);
        -- Output to show the creation is successful
        DBMS_OUTPUT.PUT_LINE('Successfully Created. EMPLOYEE_ID: ' || new_employee_id);
    END IF;
END;
/

-- Updating the record of an employee, basically executing the procedure
DECLARE
  v_employee_id NUMBER := 2;
BEGIN
  CreateUpdateEmpFunction (
    co_employee_id => v_employee_id,
    co_first_name  => 'Aman',
    co_last_name   => 'Dhat',
    co_department  => 'IT',
    co_position    => 'Software Developer',
    co_join_date   => SYSDATE
  );
END;

DECLARE
  new_employee_id NUMBER;
BEGIN
  CreateUpdateEmpFunction (
    co_employee_id => new_employee_id,
    co_first_name  => 'David',
    co_last_name   => 'Brown',
    co_department  => 'Marketing',
    co_position    => 'Coordinator',
    co_join_date   => SYSDATE
  );
END;

-- Fetching the Employee table
select * from Employees;

-- Procedure to record the attendance of an employee.
CREATE OR REPLACE PROCEDURE MarkingEmpAttendance (
    co_employee_id NUMBER,
    co_attendance_date DATE,
    co_status VARCHAR2,
    co_remarks VARCHAR2
) AS
    e_attendance_id NUMBER;
BEGIN
    -- Generates a unique ID for the new attendance record
    SELECT employee_seq.NEXTVAL INTO e_attendance_id FROM dual;

    -- Insert the new attendance record
    INSERT INTO Attendance (ATTENDANCE_ID, EMPLOYEE_ID, 
    ATTENDANCE_DATE, STATUS, REMARKS)
    VALUES (e_attendance_id, co_employee_id, 
    co_attendance_date, co_status, co_remarks);

    DBMS_OUTPUT.PUT_LINE('Attendance marked - Employee ID: ' 
    || co_employee_id);
END;
/

-- Enables the display of output from DBMS_OUTPUT.PUT_LINE
SET SERVEROUTPUT ON;

-- Executing the procedure for marking Attendance
BEGIN
  MarkingEmpAttendance(
    co_employee_id => 2,
    co_attendance_date => TO_DATE('2024-08-02', 'YYYY-MM-DD'),
    co_status => 'Present',
    co_remarks => 'On time'
  );
END;

BEGIN
  MarkingEmpAttendance(
    co_employee_id => 1,
    co_attendance_date => TO_DATE('2024-08-02', 'YYYY-MM-DD'),
    co_status => 'Absent',
    co_remarks => 'Medical Leave - Sick'
  );
END;

-- Fetching the Attendance table
SELECT * FROM Attendance;

-- Procedure to handle employee leave requests
CREATE OR REPLACE PROCEDURE RequestEmpLeave (
    co_employee_id NUMBER,
    co_leave_type VARCHAR2,
    co_start_date DATE,
    co_end_date DATE,
    co_status VARCHAR2
) AS
    e_leave_id NUMBER;
BEGIN
    SELECT NVL(MAX(LEAVE_ID), 0) + 1 INTO e_leave_id FROM Leaves;
--  SELECT leave_seq.NEXTVAL INTO e_leave_id FROM dual;
    -- Insert the new leave record
    INSERT INTO Leaves (
    LEAVE_ID, EMPLOYEE_ID, LEAVE_TYPE, START_DATE, END_DATE, STATUS)
    VALUES (e_leave_id, co_employee_id, 
    co_leave_type, co_start_date, co_end_date, co_status);

    DBMS_OUTPUT.PUT_LINE('Leave has been granted for Employee ID: ' 
    || co_employee_id);
END;
/
-- Executing the procedure for Leave requests
BEGIN
    RequestEmpLeave(
        co_employee_id => 4,
        co_leave_type => 'Personal Reasons',
        co_start_date => TO_DATE('2024-09-10', 'YYYY-MM-DD'),
        co_end_date => TO_DATE('2024-10-15', 'YYYY-MM-DD'),
        co_status => 'Pending Currently'
    );
END;
/

BEGIN
    RequestEmpLeave(
        co_employee_id => 2,
        co_leave_type => 'Professional Reasons',
        co_start_date => TO_DATE('2024-06-10', 'YYYY-MM-DD'),
        co_end_date => TO_DATE('2024-10-15', 'YYYY-MM-DD'),
        co_status => 'Approved Currently'
    );
END;
/

-- Fetching the Leaves table
SELECT * FROM LEAVES;

-- Procedure to generate an attendance summary
CREATE OR REPLACE PROCEDURE AttendanceSummaryMonthBasis (
    co_employee_id NUMBER,
    co_month VARCHAR2,
    co_year VARCHAR2
) AS
    e_total_days NUMBER;
    e_days_present NUMBER;
    e_days_absent NUMBER;
    e_days_on_leave NUMBER;
BEGIN
    -- Calculating the total number of attendance records for the given employee
    SELECT COUNT(*) INTO e_total_days
    FROM Attendance
    WHERE EMPLOYEE_ID = co_employee_id
      AND TO_CHAR(ATTENDANCE_DATE, 'MM-YYYY') = co_month || '-' || co_year;

    -- Calculating the number of days the employee was present during the specified month
    SELECT COUNT(*) INTO e_days_present
    FROM Attendance
    WHERE EMPLOYEE_ID = co_employee_id
      AND STATUS = 'Present'
      AND TO_CHAR(ATTENDANCE_DATE, 'MM-YYYY') = co_month || '-' 
      || co_year;

    -- Calculating the number of days the employee was absent during the specified month
    SELECT COUNT(*) INTO e_days_absent
    FROM Attendance
    WHERE EMPLOYEE_ID = co_employee_id
      AND STATUS = 'Absent'
      AND TO_CHAR(ATTENDANCE_DATE, 'MM-YYYY') = co_month || '-' 
      || co_year;

    -- Calculating the number of days the employee was on leave during the specified month
    SELECT COUNT(*) INTO e_days_on_leave
    FROM Leaves
    WHERE EMPLOYEE_ID = co_employee_id
      AND TO_CHAR(START_DATE, 'MM-YYYY') = co_month || '-' 
      || co_year;

    -- Outputs
    DBMS_OUTPUT.PUT_LINE('Attendance Summary for Employee ID: ' 
    || co_employee_id);
    DBMS_OUTPUT.PUT_LINE('Total Days: ' || e_total_days);
    DBMS_OUTPUT.PUT_LINE('Days Present: ' || e_days_present);
    DBMS_OUTPUT.PUT_LINE('Days Absent: ' || e_days_absent);
    DBMS_OUTPUT.PUT_LINE('Days on Leave: ' || e_days_on_leave);
END;
/
-- Executing the procedure for Attendance summary
BEGIN
    AttendanceSummaryMonthBasis(
        co_employee_id => 1,  
        co_month => '08',     
        co_year => '2024'
    );
END;
/

