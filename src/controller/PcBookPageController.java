package controller;

import java.sql.Date;
import java.time.LocalDate;

import database.PcBookModel;
import database.PcModel;
import javafx.scene.control.DatePicker;
import model.Book;
import model.Pc;
import model.User;
import view.PcBookPage.PcBookVar;

public class PcBookPageController {
//	PcModel pcModel = new PcModel();
	PcBookModel pcBookModel = new PcBookModel();
	PcModel pc = new PcModel();

	public void handling_book(PcBookVar pcBookVar, User cu) {
		pcBookVar.button_book.setOnAction(e -> {
			int bookID = 0;
			String pc_id = null;
			Date date1 = null;
			int user_id = 0;
			if (pcBookVar.pc_id_tf.getText().isEmpty() || pcBookVar.date.getValue() == null) {
				pcBookVar.emptyAlert.showAndWait();
			} else {
				date1 = Date.valueOf(pcBookVar.date.getValue());
				pc_id = pcBookVar.pc_id_tf.getText();
				user_id = cu.getUserID();

			}

//			pcBookModel.book(new Book(bookID, pc_id, user_id, date1));
//			if (pc_id.length() <= 0 || date1 == null) {
//				pcBookVar.emptyAlert.showAndWait();
//			} else {
//				for (Book book : new PcBookModel().getBook()) {
//					for (Pc pc : new PcModel().getPc()) {
//						if (!pc.getPC_Condition().equals("Usable") && !pc.getPC_ID().equals(pc_id)
//								&& book.getDate().equals(date1) && book.getPC_ID().equals(pc_id)) {
//							pcBookVar.alert.showAndWait();
//						} else {
//							pcBookModel.book(new Book(bookID, pc_id, user_id, date1));
//						}
//					}
//
//				}
//
//			}
			if (pc_id.length() <= 0 || date1 == null) {

				pcBookVar.emptyAlert.showAndWait();
			} else {
				for (Pc pc : new PcModel().getPc()) {
//					System.out.println(pc.getPC_ID());
//					System.out.println(pc.getPC_Condition());
//					System.out.println(" ");
					if (pc.getPC_ID().equals(pc_id) && pc.getPC_Condition().equals("Usable")) {
						if (new PcBookModel().getBook().size() == 0) {
//							System.out.println("w");
							pcBookModel.book(new Book(bookID, pc_id, user_id, date1));
							return;
						} else {
//							System.out.println("y");
							for (Book book : new PcBookModel().getBook()) {
								System.out.println("");
								if (book.getDate().equals(date1) && book.getPC_ID().equals(pc_id)) {
									pcBookVar.alert.setContentText("PC has been Booked!");
									pcBookVar.alert.showAndWait();
									return;
								} 

							}
							pcBookModel.book(new Book(bookID, pc_id, user_id, date1));
						}

					} else if (pc.getPC_ID().equals(pc_id) && !pc.getPC_Condition().equals("Usable")) {
						pcBookVar.alert.setContentText("PC is Under Maintanance or Broken");
						pcBookVar.alert.showAndWait();
					}

				}

			}

		});
	}
}
