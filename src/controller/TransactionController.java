package controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.List;

import database.PcBookModel;
import database.TransactionModel;
import database.UserModel;
import model.PcBook;
import model.TransactionDetail;
import model.TransactionHeader;
import model.User;
import view.LoginPage.LoginVar;
import view.OperatorPage;
import view.OperatorPage.OperatorVar;
import javafx.scene.control.cell.PropertyValueFactory;
import view.ViewTransactionHistoryPage.ViewTransactionHistoryVar;

//public class TransactionController {
//	PCBookModel pcbM = new PCBookModel();
//	TransactionModel tm = new TransactionModel();
//	UserModel um = new UserModel();
//	User user;
//
//	TransactionDetail td;
//	TransactionHeader th;
//
//	public void handling_addTransaction(OperatorVar ov, LoginVar lv) {
//		ov.finishBook.setOnAction(e -> {
//			LocalDate selectedDate = ov.dp2.getValue();
//			long now = System.currentTimeMillis();
//			java.sql.Date todayDate = new Date(now);
//			java.sql.Date sqlSelectedDate = java.sql.Date.valueOf(selectedDate);
//
//			if (sqlSelectedDate.before(todayDate)) {
//				int id = 0;
//
//				String staffName = lv.username_tf.getText();
//				ResultSet rs = um.getUserByUsername(staffName);
//				User cu = null;
//				try {
//					rs.next();
//					cu = new User(rs.getInt("UserID"), rs.getString("UserName"), rs.getString("UserPassword"),
//							rs.getInt("UserAge"), rs.getString("UserRole"));
//				} catch (Exception e2) {
//					// TODO: handle exception
//				}
//				int staffID = cu.getUserID(); //
//				System.out.println(staffID);
//				tm.addTransactionTH(new TransactionHeader(id, staffID, staffName, sqlSelectedDate));
//				
//				// DETAIL
//				
//				ResultSet rs2 = pcbM.getBookedPCbyBookedDate(sqlSelectedDate);
//				PCBook pc = null;
//				try {
//					rs2.next();
//					pc = new PCBook(rs2.getInt("BookID"), 
//							rs2.getString("PC_ID"),
//							rs2.getInt("UserID"), 
//							rs2.getDate("BookedDate"));
//				} catch (Exception e2) {
//					// TODO: handle exception
//				}
//				
//				String pc_id = pc.getPC_ID();
//				int custID = pc.getUserID();
//				
//				ResultSet rs3 = um.getUserbyUserID(custID);
//				User cs = null;
//				try {
//					rs3.next();
//					cs = new User(rs3.getInt("UserID"),
//							  rs3.getString("UserName"),
//							  rs3.getString("UserPassword"),
//							  rs3.getInt("UserAge"),
//							  rs3.getString("UserRole"));
//				} catch (Exception e2) {
//					// TODO: handle exception
//				}
//				
//				String custName = cs.getUserName();
//				
//				tm.addTransactionTD(new TransactionDetail(0, pc_id, custName, sqlSelectedDate));
//				pcbM.finishBook(sqlSelectedDate);
//			} else if (sqlSelectedDate.after(todayDate)) {
//				ov.alertPickedDate.showAndWait();
//			}
//		});
//	}
//}=======



public class TransactionController {
	PcBookModel pcbM = new PcBookModel();
	TransactionModel tm = new TransactionModel();
	UserModel um = new UserModel();
	User user;
	TransactionModel transactionModel = new TransactionModel();
	
	TransactionDetail td;
	TransactionHeader th;

	public void handling_showTransactionHeader(ViewTransactionHistoryVar viewTransactionHistoryVar) {
		for (TransactionHeader tr : new TransactionModel().getTransactionHeader()) {
			viewTransactionHistoryVar.table.getItems().add(tr);
		}

		viewTransactionHistoryVar.transaction_idCol
				.setCellValueFactory(new PropertyValueFactory<TransactionHeader, Integer>("TransactionID"));
		viewTransactionHistoryVar.staff_idCol
				.setCellValueFactory(new PropertyValueFactory<TransactionHeader, Integer>("StaffID"));
		viewTransactionHistoryVar.staff_nameCol
				.setCellValueFactory(new PropertyValueFactory<TransactionHeader, String>("StaffName"));
		viewTransactionHistoryVar.transaction_dateCol
				.setCellValueFactory(new PropertyValueFactory<TransactionHeader, Date>("TransactionDate"));
	}

	public void handling_showTransactionDetail(ViewTransactionHistoryVar viewTransactionHistoryVar) {
		viewTransactionHistoryVar.button_detail.setOnAction(e -> {
			Integer transactionId = Integer.parseInt(viewTransactionHistoryVar.transactionID_tf.getText());

			if (transactionId <= 0) {
			} else {
				viewTransactionHistoryVar.table2.getItems().clear();
				for (TransactionDetail td : new TransactionModel().getTransactionDetail()) {
					if (td.getTransactionID() == transactionId)
						viewTransactionHistoryVar.table2.getItems().add(td);
				}
				viewTransactionHistoryVar.pc_idCol
						.setCellValueFactory(new PropertyValueFactory<TransactionDetail, String>("PC_ID"));
				viewTransactionHistoryVar.customer_nameCol
						.setCellValueFactory(new PropertyValueFactory<TransactionDetail, String>("CustomerName"));
				viewTransactionHistoryVar.book_timeCol
						.setCellValueFactory(new PropertyValueFactory<TransactionDetail, Date>("BookTime"));
			}
		});
	}

	public void handling_addTransaction(OperatorVar ov, LoginVar lv) {
		ov.finishBook.setOnAction(e -> {
			LocalDate selectedDate = ov.dp2.getValue();
			long now = System.currentTimeMillis();
			java.sql.Date todayDate = new Date(now);
			java.sql.Date sqlSelectedDate = java.sql.Date.valueOf(selectedDate);

			if (sqlSelectedDate.before(todayDate)) {
				int id = 0;

				String staffName = lv.username_tf.getText();
				ResultSet rs = um.getUserByUsername(staffName);
				User cu = null;
				try {
					rs.next();
					cu = new User(rs.getInt("UserID"), rs.getString("UserName"), rs.getString("UserPassword"),
							rs.getInt("UserAge"), rs.getString("UserRole"));
				} catch (Exception e2) {
					// TODO: handle exception
				}
				int staffID = cu.getUserID(); //
				System.out.println(staffID);
				tm.addTransactionTH(new TransactionHeader(id, staffID, staffName, sqlSelectedDate));

				// DETAIL

				ResultSet rs2 = pcbM.getBookedPCbyBookedDate(sqlSelectedDate);
				PcBook pc = null;
				try {
					rs2.next();
					pc = new PcBook(rs2.getInt("BookID"), rs2.getString("PC_ID"), rs2.getInt("UserID"),
							rs2.getDate("BookedDate"));
				} catch (Exception e2) {
					// TODO: handle exception
				}

				String pc_id = pc.getPC_ID();
				int custID = pc.getUserID();

				ResultSet rs3 = um.getUserbyUserID(custID);
				User cs = null;
				try {
					rs3.next();
					cs = new User(rs3.getInt("UserID"), rs3.getString("UserName"), rs3.getString("UserPassword"),
							rs3.getInt("UserAge"), rs3.getString("UserRole"));
				} catch (Exception e2) {
					// TODO: handle exception
				}

				String custName = cs.getUserName();

				tm.addTransactionTD(new TransactionDetail(0, pc_id, custName, sqlSelectedDate));
				pcbM.finishBook(sqlSelectedDate);
			} else if (sqlSelectedDate.after(todayDate)) {
				ov.alertPickedDate.showAndWait();
			}
		});
	}

}
