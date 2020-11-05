CREATE OR REPLACE PROCEDURE get_artist_albums(
    artist_id   IN  artist.artistid%TYPE,
    my_cursor   OUT SYS_REFCURSOR)
AS
BEGIN
    OPEN my_cursor FOR
    SELECT *
    FROM album
    WHERE artistid = artist_id;
END;



CREATE OR REPLACE PROCEDURE get_artist_albums (artist_id IN artist."ArtistId", my_cursor OUT CURSOR)
AS 
BEGIN 
	my_cursor FOR 
	SELECT * FROM 
	"Album" WHERE artistId = artist_id;
	
END
LANGUAGE PLPGSQL;

-- use dollar quotes ($$) to wrap up logic for plpgsql functions/procedures
create or replace function get_last_track() 
returns text 
as $$

	declare 
		last_id integer;
		track_name text;
		retrieved_result text;
		
	begin 
		
		select max("TrackId")
		into last_id
		from "Track";
	
		select "Name"
		into track_name
		from "Track"
		where "TrackId" = last_id;
	
		-- assignment = walrus operator    :=
		retrieved_result := last_id || ' - ' || track_name;
	
		return retrieved_result;
		
	end

$$ language plpgsql;


SELECT get_last_track();

select *
from "Track" t
order by "TrackId" desc;




