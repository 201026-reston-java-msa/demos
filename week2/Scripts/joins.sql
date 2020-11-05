-- A JOINS clause returns records that have matching values in both tables
-- INNER JOIN
-- LEFT JOIN
-- RIGHT JOIN
-- FULL JOIN

INSERT INTO phonenumber (emp_id)
	VALUES (3);

INSERT INTO phonenumber (emp_id, home)
 VALUES (2, '973-203-7748');

SELECT * FROM employee;
SELECT * FROM phonenumber;

SELECT * FROM employee
	INNER JOIN phonenumber ON employee.emp_id = phonenumber.emp_id;

-- Get all the info for employees that don't have a home phone number
SELECT * FROM employee INNER JOIN phonenumber ON employee.emp_id =
phonenumber.emp_id WHERE home IS NULL;

-- THIS IS A nested query that does the same exact thing
SELECT * FROM employee INNER JOIN (
	SELECT * FROM phonenumber WHERE home IS NULL) 
AS my_result ON employee.emp_id = my_result.emp_id;

-- let's get name and phone number for all employees whose salary
-- is greater than 5000;
SELECT first_name || ' ' || last_name AS full_name, mobile FROM 	
employee INNER JOIN phonenumber ON employee.emp_id = phonenumber.emp_id
WHERE employee.salary > 5000;


-- This could be an alternative to an JOIN 
SELECT first_name || ' ' || last_name AS full_name, mobile FROM 	
employee, phonenumber WHERE employee.emp_id = phonenumber.emp_id AND
employee.salary > 5000;








