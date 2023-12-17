package controller;


import java.sql.Date;

import database.PcBookModel;
import database.PcModel;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Main;
import model.Pc;
import model.PcBook;
import view.JobManagemenPage.JobManagementVar;
import view.PCManagementPage;
import view.PCManagementPage.PCManagementVar;


public class PcController {
	PcModel pcModel = new PcModel();
	
	public void handling_showPctoTable(PCManagementVar pcManagementVar) {
		for (Pc pc : new PcModel().getPC()) {
			pcManagementVar.table.getItems().add(pc);
		}
		
		pcManagementVar.pc_idCol.setCellValueFactory(new PropertyValueFactory<Pc, String>("PC_ID"));
		pcManagementVar.pc_conditionCol.setCellValueFactory(new PropertyValueFactory<Pc, String>("PC_Condition"));
	}
	
	public void handling_addPc(PCManagementVar pcManagementVar) {
		pcManagementVar.button_addPC.setOnAction(e->{
			String pc_id = pcManagementVar.addPCID_tf.getText();
			
			if(pc_id.length() <= 0) {
				pcManagementVar.addAlert.showAndWait();
			} else {
				for(Pc pc : new PcModel().getPC()) {
					if(pc.getPC_ID().equals(pc_id)) {
						pcManagementVar.idExistAlert.showAndWait();
						return;
					}
				}
				pcModel.addPC(new Pc(pc_id, "Usable"));
				Main.changeScene(new PCManagementPage().initializePCManagementPage());
			}
		});
	}
	
	public void handling_showPc(PCManagementVar PCManagementVar) {
		for(Pc pc : new PcModel().getPC()) {
			PCManagementVar.updatePC_ID.getItems().add(pc.getPC_ID());
			PCManagementVar.deleteID.getItems().add(pc.getPC_ID());
		}
	}
	
	public void handling_showPc(JobManagementVar jobManagementVar) {
		for(Pc pc : new PcModel().getPC()) {
			if(pc.getPC_Condition().equals("Broken")) {
				jobManagementVar.addJobPCID.getItems().add(pc.getPC_ID());
			}
		}
	}
	
	public void handling_deletePc(PCManagementVar PCManagementVar) {
		PCManagementVar.button_deletePc.setOnAction(e->{
			String pc_id = PCManagementVar.deleteID.getValue();
			long time = System.currentTimeMillis();
			Date nowDate = new java.sql.Date(time);
			
			if(pc_id == null) {
				PCManagementVar.deleteIDAlert.showAndWait();
			} else {
				for(PcBook pcbook : new PcBookModel().getPcBook()) {
					if(pc_id.equals(pcbook.getPC_ID()) && pcbook.getBookedDate().after(nowDate)) {
						PCManagementVar.deleteDateAlert.showAndWait();
					}
				}
				pcModel.deletePC(pc_id);
				Main.changeScene(new PCManagementPage().initializePCManagementPage());
			}
		});
	}
	
	public void handling_updatePc(PCManagementVar pcManagementVar) {
		pcManagementVar.button_updatePc.setOnAction(e->{
			String pc_id = pcManagementVar.updatePC_ID.getValue();
			String pc_condition = pcManagementVar.updatepc_Condition.getValue();
			
			if(pc_id == null) {
				pcManagementVar.updateIDAlert.showAndWait();
			} else {
				pcModel.updatePC(new Pc(pc_id, pc_condition));
				Main.changeScene(new PCManagementPage().initializePCManagementPage());
			}
		});
	}
	
	
}
