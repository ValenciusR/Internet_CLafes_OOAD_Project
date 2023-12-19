package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import model.Pc;
import model.User;

public class PcModel {
//	public void regis(User user) {
//		Connect con = Connect.getInstance();
//		
//		String query = "INSERT INTO User VALUES(?,?,?,?,?)";
//		
//		PreparedStatement ps = con.prepareStatment(query);
//		
//		
//		try {
//			ps.setInt(1, user.getUserID());
//			ps.setString(2, user.getUserName());
//			ps.setString(3, user.getUserPassword());
//			ps.setInt(4, user.getUserAge());
//			ps.setString(5, user.getUserRole());
//			
//			ps.executeUpdate();
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
	public Vector<Pc> getPc() {
		Connect con = Connect.getInstance();

		String query = "SELECT * FROM pc";
		ResultSet rs = con.selectData(query);
		Vector<Pc> vectPc = new Vector<>();

		try {
			while (rs.next()) {
				vectPc.add(new Pc(rs.getString("PC_ID"), rs.getString("PC_Condition")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vectPc;
	}
}
