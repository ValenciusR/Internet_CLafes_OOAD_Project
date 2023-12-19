package model;

import java.sql.Date;

public class TransactionDetail {
	private int TransactionID;
	private String PC_ID;
	private String CustomerName;
	private Date BookTime;

	public TransactionDetail(int transactionID, String pC_ID, String customerName, Date bookTime) {
		super();
		TransactionID = transactionID;
		PC_ID = pC_ID;
		CustomerName = customerName;
		BookTime = bookTime;
	}

	public int getTransactionID() {
		return TransactionID;
	}

	public void setTransactionID(int transactionID) {
		TransactionID = transactionID;
	}

	public String getPC_ID() {
		return PC_ID;
	}

	public void setPC_ID(String pC_ID) {
		PC_ID = pC_ID;
	}

	public String getCustomerName() {
		return CustomerName;
	}

	public void setCustomerName(String customerName) {
		CustomerName = customerName;
	}

	public Date getBookTime() {
		return BookTime;
	}

	public void setBookTime(Date bookTime) {
		BookTime = bookTime;
	}

}
