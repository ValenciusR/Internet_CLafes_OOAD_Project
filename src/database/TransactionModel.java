package database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.TransactionDetail;
import model.TransactionHeader;

public class TransactionModel {
	
	// Transaction Header
//	private int TransactionID;
//	private int StaffID;
//	private String StaffName;
//	private Date TransactionDate;
	
	// Transaction Detail
//	private String PC_ID;
//	private String CustomerName;
//	private Date BookTime;
	
	public void addTransactionTH(TransactionHeader th) {
		Connect con = Connect.getInstance();
		
		String query = "INSERT INTO TransactionHeader VALUES(?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatment(query);
		
		try {
			ps.setInt(1, th.getTransactionID());
			ps.setInt(2, th.getStaffID());
			ps.setString(3, th.getStaffName());
			ps.setDate(4,  th.getTransactionDate());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	public void addTransactionTD(TransactionDetail td) {
		Connect con = Connect.getInstance();
		
		String query = "INSERT INTO TransactionDetail VALUES(?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatment(query);
		
		try {
			
			ps.setInt(1, td.getTransactionID());
			ps.setString(2, td.getPC_ID());
			ps.setString(3, td.getCustomerName());
			ps.setDate(4,  td.getBookTime());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
	
	 
}
