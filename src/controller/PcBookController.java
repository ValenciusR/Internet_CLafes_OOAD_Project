package controller;


import java.sql.Date;
import java.time.LocalDate;
import database.PcBookModel;
import database.PcModel;
import database.TransactionModel;
import database.UserModel;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Pc;
import model.PcBook;
import view.OperatorPage.OperatorVar;

public class PcBookController {
	PcBookModel pcbM = new PcBookModel();
	TransactionModel tm = new TransactionModel();
	UserModel um = new UserModel();
	TransactionController tc = new TransactionController();

	public void handling_showBookedPC(OperatorVar ov) {
		for (PcBook pc : new PcBookModel().getBookedPC()) {
			ov.table.getItems().add(pc);
		}
		ov.book_idCol.setCellValueFactory(new PropertyValueFactory<PcBook, Integer>("BookID"));
		ov.pc_idCol.setCellValueFactory(new PropertyValueFactory<PcBook, String>("PC_ID"));
		ov.user_idCol.setCellValueFactory(new PropertyValueFactory<PcBook, Integer>("UserID"));
		ov.date_Col.setCellValueFactory(new PropertyValueFactory<PcBook, Date>("BookedDate"));
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
		for (PcBook pb : new PcBookModel().getBookedPC()) {
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
			
			for(PcBook pb : new PcBookModel().getBookedPC()) {
				if(!pb.getPC_ID().equals(pc_id) && pb.getUserID() != userID) {
					pcbM.book(new PcBook(id, pc_id, userID, today));
				}else if(pb.getPC_ID().equals(pc_id)) {
					ov.alertBookedPC.showAndWait();
				}
			}
		});
	}
}
