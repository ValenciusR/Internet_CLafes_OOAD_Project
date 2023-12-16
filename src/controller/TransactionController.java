package controller;

import java.sql.Date;

import database.PcModel;
import database.TransactionModel;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Main;
import model.Pc;
import model.TransactionDetail;
import model.TransactionHeader;
import view.PCManagementPage;
import view.ViewTransactionHistoryPage.ViewTransactionHistoryVar;

public class TransactionController {
	TransactionModel transactionModel = new TransactionModel();
	
	public void handling_showTransactionHeader(ViewTransactionHistoryVar viewTransactionHistoryVar) {
		for (TransactionHeader tr : new TransactionModel().getTransactionHeader()) {
			viewTransactionHistoryVar.table.getItems().add(tr);
		}
		
		viewTransactionHistoryVar.transaction_idCol.setCellValueFactory(new PropertyValueFactory<TransactionHeader, Integer>("TransactionID"));
		viewTransactionHistoryVar.staff_idCol.setCellValueFactory(new PropertyValueFactory<TransactionHeader, Integer>("StaffID"));
		viewTransactionHistoryVar.staff_nameCol.setCellValueFactory(new PropertyValueFactory<TransactionHeader, String>("StaffName"));
		viewTransactionHistoryVar.transaction_dateCol.setCellValueFactory(new PropertyValueFactory<TransactionHeader, Date>("TransactionDate"));
	}
	
	public void handling_showTransactionDetail(ViewTransactionHistoryVar viewTransactionHistoryVar) {
		viewTransactionHistoryVar.button_detail.setOnAction(e->{
			Integer transactionId = Integer.parseInt(viewTransactionHistoryVar.transactionID_tf.getText());
			
			if(transactionId<= 0) {
			} else {
				viewTransactionHistoryVar.table2.getItems().clear();
				for (TransactionDetail td : new TransactionModel().getTransactionDetail()) {
					if(td.getTransactionID() == transactionId)
					viewTransactionHistoryVar.table2.getItems().add(td);
				}
				viewTransactionHistoryVar.pc_idCol.setCellValueFactory(new PropertyValueFactory<TransactionDetail, String>("PC_ID"));
				viewTransactionHistoryVar.customer_nameCol.setCellValueFactory(new PropertyValueFactory<TransactionDetail, String>("CustomerName"));
				viewTransactionHistoryVar.book_timeCol.setCellValueFactory(new PropertyValueFactory<TransactionDetail, Date>("BookTime"));
			}
		});
		
		
		
	}
	
	
}

