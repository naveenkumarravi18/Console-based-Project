package library;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Userdetails {
	 public void addUser(User user) {
	        try (Connection conn = DBConnection.getConnection()) {
	            String sql = "INSERT INTO USER_DETAILS (USER_NAME,sub,PASS) VALUES (?, ?,?)";
	            PreparedStatement stmt = conn.prepareStatement(sql);
	            stmt.setString(1, user.getName());
	           // stmt.setLong(2, user.getId());
	            stmt.setBoolean(2,user.isSubscription());
	            stmt.setString(3,user.getPass());
	            stmt.executeUpdate();
	            System.out.println("USER added successfully.");
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	 public boolean searchUser(String na, String pa) {
		    try (Connection conn = DBConnection.getConnection()) {
		        String sql = "SELECT * FROM user_details WHERE USER_NAME LIKE ? AND PASS = ?";
		        PreparedStatement stmt = conn.prepareStatement(sql);
		        stmt.setString(1, na);
		        stmt.setString(2, pa);

		        ResultSet rs = stmt.executeQuery();
		        
		        if (rs.next()) {
		            return true;
		        }
		    } catch (SQLException e) {
		        e.printStackTrace();
		    }
		    return false;
		}
	
}
