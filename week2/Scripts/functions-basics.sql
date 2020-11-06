/*
There's a SQL construct called a stored procedure or a FUNCTION...
Some SQL dialects have 1 or both. OracleSQL has both, and there
is a fairly sugnificant difference between them.

However, in PostgreSQL, there are really only functions..
Stored procedures are effectively fucntions that don't return
anything...but postgresql functions accomplish this through 
the void keyword.  

Each dialect may have a slightly different syntax for decalring
stored procedures/functions:
*/

-- WE USE crearte or replace to denote 
-- that we may want rerun this script multipl times
CREATE OR REPLACE FUNCTION get_current_time() RETURNS
	TIME WITH TIME ZONE
AS
$$
	-- current_time is a built in values, which is just the current time
	-- we do not need a return statment since the function
	-- will just return the last statement's result by default
	SELECT CURRENT_TIME;
$$ LANGUAGE SQL;

SELECT get_current_time();

CREATE OR REPLACE FUNCTION get_string_literal() RETURNS VARCHAR(40)
AS
$func$
	SELECT 'Hello World!';
$func$ LANGUAGE SQL;

SELECT get_string_literal();













