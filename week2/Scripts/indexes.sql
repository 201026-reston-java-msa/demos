-- Indexes
-- Indexes are a common way to enhance database performance
-- and index is a structure or object by which we can retireve specific rows or data faster.

EXPLAIN SELECT * FROM "Customer" WHERE "SupportRepId" = 4; 
-- The above query utilizes an index so our data is retrieved faster/more effieciently
-- iF WE USE THE EXPLAIN command, we're able to see the filter applied to querying this
-- specific data.

EXPLAIN SELECT * FROM "Customer" WHERE "City" = 'Paris';