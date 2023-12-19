package controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.time.LocalDate;
import database.PCBookModel;
import database.PcModel;
import database.TransactionModel;
import database.UserModel;
import javafx.scene.control.cell.PropertyValueFactory;
import model.PCBook;
import model.Pc;
import model.TransactionHeader;
import model.User;
import view.LoginPage.LoginVar;
import view.OperatorPage.OperatorVar;
import view.PCManagementPage.PCManagementVar;

public class PcBookController {
	PCBookModel pcbM = new PCBookModel();
	TransactionModel tm = new TransactionModel();
	UserModel um = new UserModel();
	TransactionController tc = new TransactionController();

	public void handling_showBookedPC(OperatorVar ov) {
		for (PCBook pc : new PCBookModel().getBookedPC()) {
			ov.table.getItems().add(pc);
		}
		ov.book_idCol.setCellValueFactory(new PropertyValueFactory<PCBook, Integer>("BookID"));
		ov.pc_idCol.setCellValueFactory(new PropertyValueFactory<PCBook, String>("PC_ID"));
		ov.user_idCol.setCellValueFactory(new PropertyValueFactory<PCBook, Integer>("UserID"));
		ov.date_Col.setCellValueFactory(new PropertyValueFactory<PCBook, Date>("BookedDate"));
	}

	public void handling_cancelBook(OperatorVar ov) { 
		ov.cancelBook.setOnAction(e -> {
			LocalDate selectedDate = ov.dp.getValue();
			long now = System.currentTimeMillis();
			java.sql.Date todayDate = new Date(now);
			java.sql.Date sqlSelectedDate = java.sql.Date.valueOf(selectedDate);

			if (sqlSelectedDate.after(todayDate)) {
				pcbM.cancelBook(sqlSelectedDate);
			} else if (sqlSelectedDate.before(todayDate)) {
				ov.alertPickedDate.showAndWait();
			}
		});
	}

	public void handling_showassignUser(OperatorVar ov) {
		for (PCBook pb : new PCBookModel().getBookedPC()) {
			for(Pc pc : new PcModel().getPC()) {
				ov.pcBook_cb.getItems().add(pc.getPC_ID());
			}
			ov.userID_cb.getItems().add(pb.getUserID());
		}
	}
	
	public void handling_assignUser(OperatorVar ov) {
		ov.assignUser.setOnAction(e->{
			String pc_id = ov.pcBook_cb.getValue();
			Integer userID = ov.userID_cb.getValue();
			int id = 0;
			long now = System.currentTimeMillis();
			Date today = new Date(now);
			
			for(PCBook pb : new PCBookModel().getBookedPC()) {
				if(!pb.getPC_ID().equals(pc_id) && pb.getUserID() != userID) {
					pcbM.book(new PCBook(id, pc_id, userID, today));
				}else if(pb.getPC_ID().equals(pc_id)) {
					ov.alertBookedPC.showAndWait();
				}
			}
		});
	}
}
