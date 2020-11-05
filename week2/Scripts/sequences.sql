/*
Sequences are exactly the same in SQL as they are in math
It's asequence of values of type INTEGER
**/
--DROP TABLE account;
CREATE TABLE account (
	account_id INTEGER PRIMARY KEY,
	balance NUMERIC(50, 2)
);

CREATE SEQUENCE IF NOT EXISTS account_number_sequence
	MINVALUE 100
	NO MAXVALUE
	START WITH 100
	NO CYCLE
	OWNED BY account.account_id;

CREATE OR REPLACE FUNCTION set_account_number() 
RETURNS TRIGGER
AS
$$
	BEGIN
		NEW.account_id = NEXTVAL('account_number_sequence');
		RETURN NEW;
	END
$$ LANGUAGE plpgsql; 

CREATE TRIGGER trg_account_number
BEFORE INSERT
ON account
	FOR EACH ROW
		EXECUTE PROCEDURE set_account_number();

SELECT * FROM ACCOUNT;
INSERT INTO ACCOUNT (balance)
	VALUES (20.45);

INSERT INTO ACCOUNT(balance)
	VALUES (36.00);


/*
	Cursors are a datatype in SQL kind of similar to iterators in Java.
	They will retrieve query results only a few records at a time.
	Which is sometimes needed, if the query returns many GBs of data.
	There is currently a lack of functionality with the postgres JDBC driver
	where it is currently not able to take advantage of cursors.
	They can still be used, but the JDBC driver will simply grab all of the
	information all at once anyways. So using cursors through JDBC is currently
	not effective. According to PostgreSQL, this problem can be fixed, but they
	haven't had the time.
	
	In JDBC, we jabe seen Statements and PreparedStatements, but there is also
	a CallableStatement, that allows you to directly invoke Stored Procedures/functions.
	You can even receive returned values back as a result.
	Many use-cases regarding CallableStatements revolve around using cursors.
	But you can of course invoke simple or even built-in functions through them.
*/




