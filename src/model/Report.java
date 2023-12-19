package model;

import java.sql.Date;

public class Report {
	
	private int ReportID;
//	private User user;
//	private Pc pc;
	private String UserRole;
	private String PC_ID;
	private String ReportNote;
	private Date ReportDate;
	
	public Report(int reportID, String userRole, String pcID, String reportNote, Date reportDate) {
		super();
		ReportID = reportID;
		UserRole = userRole;
		PC_ID = pcID;
//		UserRole = user.getUserRole();
//		pcID = pc.getPC_ID();
		ReportNote = reportNote;
		ReportDate = reportDate;
	}

	public int getReportID() {
		return ReportID;
	}

	public void setReportID(int reportID) {
		ReportID = reportID;
	}

	public String getUserRole() {
		return UserRole;
	}

	public void setUserRole(String userRole) {
		UserRole = userRole;
	}

	public String getPC_ID() {
		return PC_ID;
	}

	public void setPC_ID(String pC_ID) {
		PC_ID = pC_ID;
	}

	public String getReportNote() {
		return ReportNote;
	}

	public void setReportNote(String reportNote) {
		ReportNote = reportNote;
	}

	public Date getReportDate() {
		return ReportDate;
	}

	public void setReportDate(Date reportDate) {
		ReportDate = reportDate;
	}

}