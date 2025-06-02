package library;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class Admin {
	 public List<User> getAllUsers() {
	        List<User> users = new ArrayList<>();
	        try (Connection conn = DBConnection.getConnection()) {
	            String sql = "SELECT * FROM USER_DETAILS";
	            Statement stmt = conn.createStatement();
	            ResultSet rs = stmt.executeQuery(sql);
	            while (rs.next()) {
	               users.add(new User(rs.getString("user_name"),rs.getBoolean("sub"),rs.getString("pass")));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return users;
	    }
}

