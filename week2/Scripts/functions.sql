SELECT * FROM "Employee";

-- THIS IS  a particular function in which 
-- you pass in a birth year as a parameter and return all
-- employees who were born before the specified year
CREATE OR REPLACE FUNCTION employees_born_before_year(some_year INTEGER) RETURNS SETOF "Employee"
AS
$$
SELECT * FROM "Employee" WHERE EXTRACT(YEAR FROM "BirthDate") < some_year;
$$ LANGUAGE SQL;

SELECT * FROM employees_born_before_year(1970);