package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import model.Pc;
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
	
	public Vector<User> getUser() {
		Connect con = Connect.getInstance();
		
		String query = "SELECT * FROM user";
		ResultSet rs = con.selectData(query);
		Vector<User> vectUser = new Vector<>();
		
		try {
			while(rs.next()) {
				vectUser.add(new User(rs.getInt("UserID"),
									  rs.getString("UserName"),
									  rs.getString("UserPassword"),
									  rs.getInt("UserAge"),	  
									  rs.getString("UserRole")
						));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return vectUser;
	}
}
