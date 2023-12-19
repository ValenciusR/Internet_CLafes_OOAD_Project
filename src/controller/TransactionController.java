package controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import database.TransactionModel;
import database.UserModel;
import javafx.scene.control.cell.PropertyValueFactory;
import model.TransactionHistory;
import model.User;
import view.ViewTransactionHistoryPage.ViewTransactionHistoryVar;

public class TransactionController {
	TransactionModel transactionModel = new TransactionModel();
	UserModel userModel = new UserModel();

	public void handling_showTransactiontoTable(ViewTransactionHistoryVar viewTransactionHistoryVar, User cu) {

////		for (User user : new UserModel().getUser()) {
//			for (TransactionHistory tH : new TransactionModel().getTransaction(cu)) {
//				//if (userequals(tH.getCustomerName())) {
//					viewTransactionHistoryVar.tvTH.getItems().add(tH);
//				}
//				viewTransactionHistoryVar.TiD_col
//						.setCellValueFactory(new PropertyValueFactory<TransactionHistory, Integer>("TransactionID"));
//				viewTransactionHistoryVar.pc_id_col
//						.setCellValueFactory(new PropertyValueFactory<TransactionHistory, String>("PC_ID"));
//				viewTransactionHistoryVar.customer_name_col
//						.setCellValueFactory(new PropertyValueFactory<TransactionHistory, String>("CustomerName"));
//				viewTransactionHistoryVar.book_time_col
//						.setCellValueFactory(new PropertyValueFactory<TransactionHistory, Date>("BookTime"));
//			}
//
//		}
	ArrayList<TransactionHistory> th = new ArrayList<>();
	ResultSet rs = transactionModel.getTransaction(cu);
	

	try {
		while (rs.next()) {
			int transactionID = rs.getInt("TransactionID");
			String pc_id = rs.getString("PC_ID");
			String customerName = rs.getString("CustomerName");
			Date bookTime = rs.getDate("BookTime");
			th.add(new TransactionHistory(transactionID, pc_id, customerName, bookTime));
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	for (TransactionHistory data : th) {
		viewTransactionHistoryVar.tvTH.getItems().add(data);
	}
	viewTransactionHistoryVar.TiD_col.setCellValueFactory(new PropertyValueFactory<>("TransactionID"));
	viewTransactionHistoryVar.pc_id_col.setCellValueFactory(new PropertyValueFactory<>("PC_ID"));
	viewTransactionHistoryVar.customer_name_col.setCellValueFactory(new PropertyValueFactory<>("CustomerName"));
	viewTransactionHistoryVar.book_time_col.setCellValueFactory(new PropertyValueFactory<>("BookTime"));
	}
}
