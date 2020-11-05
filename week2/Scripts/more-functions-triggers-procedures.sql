-- PG-PL/SQL = PostgreSQL Procedural Language extension of SQL
-- **PL/pgSQL = Procedural Langauge extension of PostGreSQL
-- PL/SQL = Procedural Lanaguage extension of SQL

-- NOT a sublanguage of SQL, but rather an extension
-- Stored Functions (Procedures)

-- syntax breakdown of a function
--CREATE [OR REPLACE] FUNCTION [name] ([params])
--RETURNS [type]
--AS '

--	BEGIN
-- 		[logic]
--	END 
-- 
-- ' LANGUAGE: plpgsql

CREATE OR REPLACE FUNCTION multiply(x NUMERIC, y NUMERIC)
RETURNS NUMERIC 
AS '
	BEGIN
		return x * y;
	END
' LANGUAGE plpgsql;

SELECT multiply(10, 2);

CREATE OR REPLACE FUNCTION get_last_track()
RETURNS TEXT
AS $$

	DECLARE
		last_id INTEGER;
		track_name TEXT;
		retrieved_result TEXT;
	
	BEGIN
		SELECT max("TrackId")
		INTO last_id
		FROM "Track";
		
		SELECT "Name"
		INTO track_name FROM "Track"
		WHERE "TrackId" = last_id;
	
		-- assignment = walrus operator
		retrieved_result := last_id || ' - ' || track_name;
		
		RETURN retrieved_result;
	END
$$ LANGUAGE plpgsql;

SELECT get_last_track();


SELECT * FROM "Track" t ORDER BY "TrackId" DESC;

-- There are 3types of parameters that are passed to stored functions & procedures

/*
 * IN param - input value - it's read but it's not going to be chaged or returned
 * OUT param - output vlaue: not taken in or read within the function but it will be changed/returned
 * INOUT param - borth an input AND output value that's taken in, read, and returned 
 * 
 */

CREATE TABLE temp_table (
	track_id int,
	track_name TEXT
);

SELECT * FROM temp_table;

-- anonymous PL/SQL statement (not stored in DBMS memory)
-- the return type is ALWAYS void
DO $$

	DECLARE 
		last_id int;
		track_name TEXT;
	
	BEGIN
		SELECT max("TrackId")
		INTO last_id
		FROM "Track";
	
		SELECT "Name"
		INTO track_name FROM "Track"
		WHERE "TrackId" = last_id;
	
		INSERT INTO temp_table VALUES (last_id, track_name);
		
	END;
	
$$ language plpgsql;

-- Stored procedures (do not have a declared return type, effectively void...
-- to invoke a stored procedure, you use the CALL keyword 

CREATE OR REPLACE PROCEDURE insert_track_into_temp_table(id integer, t_name text)
AS $$

	BEGIN 
		INSERT INTO temp_table VALUES(id, t_name);
	END;
	
$$ language plpgsql;

CALL insert_track_into_temp_table(119, 'Roadrunner');

SELECT * FROM temp_table;

-- use JDBC's CallableStatement Interface to invoke stored procedures and functions
-- since it extends PreparedStatment, it also supports parameterized queries.

/*
 * Triggers:
 * 
 * 	procedural code that is automatically executed in response to certain events
 * associtated with a table or DB.
 * 
 * SYNTAX BREAKDOWN:
 * 
 * CREATE TRIGGER [name]
 * [before][after][instead of]  [insert][update][delete]  on [table]
 * for each [row|statement]
 * execute function [fucntion-name|procedure-name]
 */

CREATE TABLE colors (
	id INTEGER PRIMARY KEY,
	color TEXT
);

INSERT INTO colors
	VALUES
		(1, 'red'),
		(2, 'orange'),
		(3, 'yellow'),
		(4, 'green'),
		(5, 'blue'),
		(6, 'violet');

SELECT * FROM colors;

-- the new keyword contains info about the statement being executed
CREATE OR REPLACE FUNCTION no_more_blues()
RETURNS TRIGGER
AS $$

	BEGIN
		IF (NEW.color = 'blue') THEN
		RETURN NULL; -- this will cancel the execution of the original statement
		END IF;
	
		RETURN NEW; -- this will return to the trigger without halting the original statement
	END
	
$$ language plpgsql;

-- create a trigger that will execute the previous declared function
-- BEFORE an insert or update statement is executed on the colors table

CREATE TRIGGER no_blues
BEFORE INSERT OR UPDATE ON colors
FOR EACH ROW EXECUTE FUNCTION no_more_blues();

SELECT * FROM COLORS;

INSERT INTO COLORS VALUES (7, 'fuscia');
UPDATE colors SET color = 'blue' WHERE id = 7;


INSERT INTO colors VALUES (8, 'blue');



















































-- 