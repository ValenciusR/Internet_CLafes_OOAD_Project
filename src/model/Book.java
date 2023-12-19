package model;

import java.sql.Date;
import java.time.LocalDate;

import javafx.scene.control.DatePicker;

public class Book {
	private int BookID;
	private String PC_ID;
	private int UserID;
	private Date date;
	public Book(int bookID, String pC_ID, int userID, Date date) {
		super();
		BookID = bookID;
		PC_ID = pC_ID;
		UserID = userID;
		this.date = date;
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
	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	
	
	
	
}
