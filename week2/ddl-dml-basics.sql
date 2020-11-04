-- This is a comment in SQL
-- I will use DDL (Data Defintion Language)

-- This is the syntax to create a table...
-- the SERIAL datatype will be automatically generated for us
-- and will be incremented by 1 each time

drop table if exists employee cascade;
create table employee (
	emp_id SERIAL primary key,
	first_name VARCHAR(50) not null,
	last_name VARCHAR(50) not null,
	email VARCHAR(50),
	salary numeric(50, 2) default 0,
	-- NUMERIC is a decimal valued number type
	-- The 50 represents the total number of digits
	-- the 2 represents the number of digits to the right of the . ...like 0.00
	supervisor INTEGER
);

-- We can declare constraints like in the line above...
-- we can also ALTER the table (use DDL) and add constraints
-- Below we've created a constraint names 'supervisor_employee_fk' which 
-- is the foregin key from supervisor to emp_id in employee table
alter table employee
	add constraint supervisor_employee_fk
	foreign key (supervisor) references employee (emp_id);

DROP TABLE IF EXISTS phonenumber CASCADE;
CREATE TABLE phonenumber (
	phone_id SERIAL PRIMARY KEY,
	emp_id INTEGER NOT NULL REFERENCES public.employee (emp_id),
	home VARCHAR (20),
	MOBILE VARCHAR(20),
	work_num VARCHAR(20)
);

-- TRUNCATE TABLE will delete all data WITHIN the table, but
-- not the table itself...

-- DQL: Querying!...use the SELECT keyword
SELECT * FROM employee;

-- DML: Data Manipulation Language
INSERT INTO employee (first_name, last_name, email, salary)
	VALUES ('Larry', 'King', 'larry@gmail.com', 10000);

INSERT INTO employee (first_name, last_name, email, salary, supervisor)
	VALUES ('Mary', 'Queen', 'mary@gmail.com', 5000, 1);

-- REFERENTIAL INTEGRITY
-- Referential integrity maintains the relationships between
-- tables to avoid logical corruption of data
-- It is composed of a combo of a Primary Key and a Foreign Key.
-- Referential Integrity does not allow the data structure to
-- add any record in a table with a foreign key unless
-- the corresponding table has the primary key.

CREATE SCHEMA project;

CREATE TABLE project.employee (
	id SERIAL PRIMARY KEY,
	full_name VARCHAR(150) NOT NULL 
);

DROP SCHEMA project CASCADE;

INSERT INTO public.employee (first_name, last_name, email, salary) 
	VALUES ('Barry', 'Smith', 'bsmith@gmail.com', 1000000000);

-- We will set Larry's supervisor to Barry
UPDATE employee SET supervisor = 3 WHERE first_name = 'Larry';

SELECT * FROM employee;

SELECT first_name || ' ' || last_name AS full_name FROM employee
	WHERE salary=5000; 

-- TRUNCATE TABLE employee CASCADE;

-- ORDER BY clause allows you to declare a column
-- which you will order your results by
-- you can choose ascending or descending, but
-- ascending is DEFAULT
SELECT * FROM employee ORDER BY salary DESC;












