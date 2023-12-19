package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import model.Pc;
import model.TransactionHistory;
import model.User;

public class TransactionModel {
	public ResultSet getTransaction(User cu) {
		Connect con = Connect.getInstance();
		ResultSet rs = null;
		String query = "SELECT * FROM transactiondetail WHERE CustomerName = ?";
		PreparedStatement ps = con.prepareStatment(query);
		

		try {
			ps.setString(1, cu.getUserName());
			

			rs = ps.executeQuery();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return rs;
//		Vector<TransactionHistory> vectTH = new Vector<>();
//
//		try {
//			while (rs.next()) {
//				vectTH.add(new TransactionHistory(rs.getInt("TransactionID"), rs.getString("PC_ID"),
//						rs.getString("CustomerName"), rs.getDate("BookTime")));
//
//			}
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return vectTH;
	}
}
