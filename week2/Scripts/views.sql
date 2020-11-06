/*
 * Views :
 * 
 * Whwenevr we execute a query, the DBMA generates a result set for us that
 * contains information based upon our query.
 * 
 * Sometimes we  want to use that result set as a base for executing 
 * other queries.  Views are effectively just a schema object that contains a saved result set
 * and can be used as a sort of virtual table...

 */
SELECT e."EmployeeId", e."FirstName", e."LastName", (em."FirstName" || ' ' || em."LastName") AS manager
FROM "Employee" e
JOIN "Employee" em
ON e."ReportsTo" = em."EmployeeId";

CREATE VIEW employee_and_managers AS 
SELECT e."EmployeeId", e."FirstName", e."LastName", (em."FirstName" || ' ' || em."LastName") AS manager
FROM "Employee" e
JOIN "Employee" em
ON e."ReportsTo" = em."EmployeeId";

SELECT * FROM employee_and_managers WHERE "EmployeeId" > 5;

--   Detail: Views that do not select from a single table or view are not 
-- automatically updatable.
--  Hint: To enable inserting into the view, provide an INSTEAD OF INSERT trigger 
-- or an unconditional ON INSERT DO INSTEAD rule.
INSERT INTO employee_and_managers VALUES (8, 'Alice', 'Anderson', 'Andrew Adams');
SELECT * FROM CHINOOK."Employee";


-- manipulating the table associated with a view will cause that view to be updates 

SELECT * FROM "Artist" ORDER BY "ArtistId" DESC;

CREATE VIEW all_artists AS
SELECT * FROM "Artist";

SELECT * FROM all_artists ORDER BY "ArtistId" DESC;

INSERT INTO "Artist" VALUES (276, 'Counting Crows');

SELECT * FROM all_artists ORDER BY "ArtistId" DESC;




