-- Create SCHEMA advanced;

CREATE TABLE department(
	dept_id Serial PRIMARY KEY,
	d_name VARCHAR(50) UNIQUE NOT NULL
);

CREATE TABLE employee(
	emp_id SERIAL PRIMARY KEY ,
	first_name VARCHAR(50) NOT NULL,
	last_name VARCHAR(50) NOT NULL,
	salary NUMERIC(50, 2),
	department INTEGER NOT NULL REFERENCES advanced.department (dept_id)
);

INSERT INTO department (d_name) VALUES ('Sales');
INSERT INTO department (d_name) VALUES ('HR');
INSERT INTO department (d_name) VALUES ('Accounting');
INSERT INTO department (d_name) VALUES ('Marketing');

INSERT INTO employee (first_name, last_name, salary, department)
	VALUES ('Dolly', 'Parton', 70000, 1);
	
INSERT INTO employee (first_name, last_name, salary, department)
	VALUES ('Kieth', 'Richards', 90000, 1);

INSERT INTO employee (first_name, last_name, salary, department)
	VALUES ('Beyonce', 'Knowles', 200000, 2);

INSERT INTO employee (first_name, last_name, salary, department)
	VALUES ('Bruno', 'Mars', 50000, 3);

INSERT INTO employee (first_name, last_name, salary, department)
	VALUES ('Taylor', 'Swift', 80000, 4);

INSERT INTO employee (first_name, last_name, salary, department)
	VALUES ('Lupe', 'Fiasco', 80000, 1);

INSERT INTO employee (first_name, last_name, salary, department)
	VALUES ('Bob', 'Dylan', 80000000, 1);

-- AGGREGATE FUNCTIONS!
-- agg functions are used to reduce an entire column into a single value
-- they can be used in conjunction with the GROUP BY clause
SELECT avg(salary) FROM employee;

SELECT d_name, avg(salary) FROM advanced.employee INNER JOIN advanced.department
	ON advanced.department.dept_id = advanced.employee.department GROUP BY department.d_name;

-- SCALAR FUNCTIONS!
-- Scalar Functions give back a result for EACH input
-- so the result will be a column, and the input will be a column...
SELECT upper(first_name || ' ' || last_name) FROM advanced.employee;
SELECT reverse(first_name || ' ' || last_name) FROM advanced.employee;

