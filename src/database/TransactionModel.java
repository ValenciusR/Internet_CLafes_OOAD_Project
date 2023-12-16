package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import model.TransactionDetail;
import model.TransactionHeader;

public class TransactionModel {
	public Vector<TransactionHeader> getTransactionHeader() {
		Connect con = Connect.getInstance();
		
		String query = "SELECT * FROM transactionheader";
		ResultSet rs = con.selectData(query);
		Vector<TransactionHeader> vectTransaction = new Vector<>();
		
		try {
			while(rs.next()) {
				vectTransaction.add(new TransactionHeader(rs.getInt("TransactionID"),
									  rs.getInt("StaffID"),
									  rs.getString("StaffName"),
									  rs.getDate("TransactionDate")
						));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return vectTransaction;
	}
	
	public Vector<TransactionDetail> getTransactionDetail() {
		Connect con = Connect.getInstance();
		
		String query = "SELECT * FROM transactiondetail";
		ResultSet rs = con.selectData(query);
		Vector<TransactionDetail> vectTransaction = new Vector<>();
		
		try {
			while(rs.next()) {
				vectTransaction.add(new TransactionDetail(rs.getInt("TransactionID"),
									  rs.getString("PC_ID"),
									  rs.getString("CustomerName"),
									  rs.getDate("BookTime")
						));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return vectTransaction;
	}
	
	
}
