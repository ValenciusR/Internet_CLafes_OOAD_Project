package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.User;

public class UserModel {
	public void regis(User user) {
		Connect con = Connect.getInstance();
		
		String query = "INSERT INTO User VALUES(?,?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatment(query);
		
		
		try {
			ps.setInt(1, user.getUserID());
			ps.setString(2, user.getUserName());
			ps.setString(3, user.getUserPassword());
			ps.setInt(4, user.getUserAge());
			ps.setString(5, user.getUserRole());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
