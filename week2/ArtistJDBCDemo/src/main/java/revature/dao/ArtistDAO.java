package revature.dao;

import java.util.ArrayList;

import revature.models.Album;
import revature.models.Artist;

public interface ArtistDAO {
	
	public ArrayList<Artist> getAllArtists();
	public ArrayList<Artist> getArtistsByName(String name);
	public Artist getArtistById(int id);
	
	public Artist addArtist(Artist newArtist);
	public boolean updateArtist(Artist updatedArtist);
	
	public boolean removeArtistById(Artist artistForRemoval);
	public boolean removeArtistsByName(String artistName);
	
	public ArrayList<Album> getArtistAlbums(Artist selectedArtist);

}
