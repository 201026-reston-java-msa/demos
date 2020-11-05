package revature.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import revature.models.Album;
import revature.models.Artist;
import revature.util.ConnectionFactory;

public class ArtistDAOImpl implements ArtistDAO {

	@Override
	public ArrayList<Artist> getAllArtists() {
		
		ArrayList<Artist> artists = new ArrayList<>();

		try (Connection conn = ConnectionFactory.getConnection();) {
			
			String sql = "SELECT * FROM \"Artist\"";
			
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				Artist temp = new Artist();
				temp.setArtistId(rs.getInt(1));
				temp.setName(rs.getString("name"));
				artists.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return artists;
		
	}

	@Override
	public ArrayList<Artist> getArtistsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Artist getArtistById(int id) {
		
		Artist artist = new Artist();
		
		try (Connection conn = ConnectionFactory.getConnection();) {
			
			String sql = "SELECT * FROM artist WHERE artistid = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, id);
			
			ResultSet rs = pstmt.executeQuery();
			
			while(rs.next()) {
				artist.setArtistId(id);
				artist.setName(rs.getString(2));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return artist;
	}

	@Override
	public Artist addArtist(Artist newArtist) {
		
		Artist artist = new Artist();
		
		try (Connection conn = ConnectionFactory.getConnection();) {
			
			conn.setAutoCommit(false);
			
			String sql = "INSERT INTO artist (name) VALUES (?)";
			
			String[] keys = new String[1];
			keys[0] = "artistId";
			
			PreparedStatement pstmt = conn.prepareStatement(sql, keys);
			pstmt.setString(1, newArtist.getName());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			ResultSet rs = pstmt.getGeneratedKeys();
			
			if(rowsUpdated != 0) {
				
				while(rs.next()) {
					artist.setArtistId(rs.getInt(1));
				}
				
				artist.setName(newArtist.getName());
				conn.commit();
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return artist;
	}

	@Override
	public boolean updateArtist(Artist updatedArtist) {
		
		try (Connection conn = ConnectionFactory.getConnection();) {
			
			conn.setAutoCommit(false);
			
			String sql = "UPDATE artist SET name = ? WHERE artistid = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, updatedArtist.getName());
			pstmt.setInt(2, updatedArtist.getArtistId());
			
			int rowsUpdated = pstmt.executeUpdate();
			
			if (rowsUpdated != 0) {
				conn.commit();
				return true;
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
	}

	@Override
	public boolean removeArtistById(Artist artistForRemoval) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean removeArtistsByName(String artistName) {
		// TODO Auto-generated method stub
		return false;
	}

	// This is a callable statement!!!!!!!!!!!!!!
	@Override
	public ArrayList<Album> getArtistAlbums(Artist selectedArtist) {
		
		ArrayList<Album> artistAlbums = new ArrayList<>();
		
		try(Connection conn = ConnectionFactory.getConnection();) {
			
			// this callable statement gets all of the albums that belong to that artist
			String sql = "{CALL get_artist_albums(?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			
			// Setting parameters is the same as we would if we were working with a PreparedStatement
			cstmt.setInt(1, selectedArtist.getArtistId());
			
			// define the index of our second parameter, and its type (which is a cursor)
			cstmt.registerOutParameter(2, java.sql.Types.REF_CURSOR);
			
			// execute our callable statement
			cstmt.execute();
			
			ResultSet rs = (ResultSet) cstmt.getObject(2);
			
			while(rs.next()) {
				Album temp = new Album();
				temp.setAlbumId(rs.getInt("albumId"));
				temp.setTitle(rs.getString("title"));
				temp.setArtistId(rs.getInt("artistId"));
				artistAlbums.add(temp);
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return artistAlbums;
	}

}
