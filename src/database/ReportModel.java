package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Pc;
import model.Report;
import model.User;
import java.sql.ResultSet;
import java.util.Vector;

public class ReportModel {
	
	User user;
	Pc pc;
	
	public void makeReport(Report report) {
		Connect con = Connect.getInstance();
		
		String query = "INSERT INTO report VALUES(?,?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatment(query);
		
		try {
			ps.setInt(1, report.getReport_ID());
			ps.setString(2, report.getUserRole());
			ps.setString(3, report.getPcID());
			ps.setString(4, report.getReportNote());
			ps.setDate(5, report.getReportDate());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
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

