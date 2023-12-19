package controller;

import database.PcModel;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Pc;
import view.ViewAllPcPage.ViewAllPcVar;

public class PcViewController {
	PcModel pcModel = new PcModel();

	public void handling_showPctoTable(ViewAllPcVar viewAllPcVar) {
		for (Pc pc : new PcModel().getPc()) {
			viewAllPcVar.tvPc.getItems().add(pc);
		}
		viewAllPcVar.pc_id_col.setCellValueFactory(new PropertyValueFactory<Pc, String>("PC_ID"));
		viewAllPcVar.pc_condition_col.setCellValueFactory(new PropertyValueFactory<Pc, String>("PC_Condition"));
	}
}
