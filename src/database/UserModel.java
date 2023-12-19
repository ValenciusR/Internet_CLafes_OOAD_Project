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
	
	public void updateUserRole(Integer userId, String role) {
		Connect con = Connect.getInstance();

		String query = "UPDATE user SET UserRole=? WHERE UserID = ?";

		PreparedStatement ps = con.prepareStatment(query);


		try {
			ps.setString(1, role);
			ps.setInt(2, userId);

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
									  rs.getString("UserRole")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return vectUser;
	}
	
	public ResultSet getUserByUsername(String username) {
		Connect con = Connect.getInstance();
		
		String query = "SELECT * FROM user where UserName = ?";
		PreparedStatement ps = con.prepareStatment(query);
		ResultSet rs = null;
		
		try {
			ps.setString(1, username);
			rs = ps.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet getUserbyUserID(Integer userID) {
		Connect con = Connect.getInstance();
		
		String query = "SELECT * FROM user where UserID = ?";
		PreparedStatement ps = con.prepareStatment(query);
		ResultSet rs = null;
		
		try {
			ps.setInt(1, userID);
			rs = ps.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
}
