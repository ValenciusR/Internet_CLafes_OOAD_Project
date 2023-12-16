package database;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import model.Report;

public class ReportModel {
	public Vector<Report> getReport() {
		Connect con = Connect.getInstance();
		
		String query = "SELECT * FROM report";
		ResultSet rs = con.selectData(query);
		Vector<Report> vectReport = new Vector<>();
		
		try {
			while(rs.next()) {
				vectReport.add(new Report(rs.getInt("Report_ID"),
									  rs.getString("UserRole"),
									  rs.getString("PC_ID"),
									  rs.getString("ReportNote"),	  
									  rs.getDate("ReportDate")
						));
				
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return vectReport;
	}
}
