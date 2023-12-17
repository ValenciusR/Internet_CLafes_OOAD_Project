package model;

import java.sql.Date;

public class PcBook {
	private int BookID;
	private String PC_ID;
	private int UserID;
	private Date BookedDate;

	public PcBook(int bookID, String pC_ID, int userID, Date bookedDate) {
		super();
		BookID = bookID;
		PC_ID = pC_ID;
		UserID = userID;
		BookedDate = bookedDate;
	}

	public int getBookID() {
		return BookID;
	}

	public void setBookID(int bookID) {
		BookID = bookID;
	}

	public String getPC_ID() {
		return PC_ID;
	}

	public void setPC_ID(String pC_ID) {
		PC_ID = pC_ID;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public Date getBookedDate() {
		return BookedDate;
	}

	public void setBookedDate(Date bookedDate) {
		BookedDate = bookedDate;
	}

}
