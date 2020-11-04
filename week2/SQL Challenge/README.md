# Chinook SQL Lab
In this exercise you will practice populating a database by running the provided `chinook.sql` scripts in sequential order within DBeaver.  Use SQL Sublanguages to return the requested information below:

## 1.0 Build the Chinook Schema
* In DBeaver, under `postgres` > `Schemas` > Create a new schema called **Chinook**.
* Run the provided `chinook.sql` scripts in sequential order within your new schema. 
* Refresh the schema.
* Open a new SQL editor and run the following queries:

#### 2.1 SELECT
* Select all records from the Employee table.
* Select all records from the Employee table where last name is King.
* Select all records from the Employee table where first name is Andrew and REPORTSTO is NULL.

#### 2.2 ORDER BY
* Select all albums in Album table and sort result set in descending order by title.
* Select first name from Customer and sort result set in ascending order by city

#### 2.3 INSERT INTO
* Insert two new records into Genre table 
* Insert two new records into Employee table
* Insert two new records into Customer table

#### 2.4 UPDATE
* Update Aaron Mitchell in Customer table to Robert Walter
* Update name of artist in the Artist table “Creedence Clearwater Revival” to “CCR”	

#### 2.5 LIKE
* Select all invoices with a billing address like “T%” 

#### 2.6 BETWEEN
* Select all invoices that have a total between 15 and 50
* Select all employees hired between 1st of June 2003 and 1st of March 2004

#### 2.7 DELETE
* Delete a record in Customer table where the name is Robert Walter (There may be constraints that rely on this, find out how to resolve them).
