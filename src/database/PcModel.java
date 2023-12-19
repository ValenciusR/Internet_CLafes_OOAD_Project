package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import model.Pc;

public class PcModel {
	public void addPC(Pc pc) {
		Connect con = Connect.getInstance();
		
		String query = "INSERT INTO pc VALUES(?,?)";
		
		PreparedStatement ps = con.prepareStatment(query);
		
		try {
			ps.setString(1, pc.getPC_ID());
			ps.setString(2, pc.getPC_Condition());
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deletePC(String pc_id) {
		Connect con = Connect.getInstance();
		
		String query = "DELETE FROM pc WHERE PC_ID=?";
		
		PreparedStatement ps = con.prepareStatment(query);
		
		try {
			ps.setString(1, pc_id);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updatePC(Pc pc) {
		Connect con = Connect.getInstance();
		
		String query = "UPDATE pc SET PC_CONDITION=? WHERE PC_ID = ?";
		
		PreparedStatement ps = con.prepareStatment(query);
		
		
		try {
			ps.setString(1, pc.getPC_Condition());
			ps.setString(2, pc.getPC_ID());
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Vector<Pc> getPC() {
		Connect con = Connect.getInstance();
		
		String query = "SELECT * FROM pc";
		ResultSet rs = con.selectData(query);
		Vector<Pc> vectPc = new Vector<>();
		
		try {
			while(rs.next()) {
				vectPc.add(new Pc(rs.getString("PC_ID"),
									  rs.getString("PC_Condition")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return vectPc;
	}
}