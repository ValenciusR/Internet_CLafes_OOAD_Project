package database;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Pc;
import model.Report;
import model.User;

public class ReportModel {
	
	User user;
	Pc pc;
	
	public void makeReport(Report report) {
		Connect con = Connect.getInstance();
		
		String query = "INSERT INTO report VALUES(?,?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatment(query);
		
		try {
			ps.setInt(1, report.getReportID());
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

}
