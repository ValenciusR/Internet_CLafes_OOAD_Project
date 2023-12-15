package controller;


import database.PcModel;
import model.Pc;
import view.AddPCPage.AddPCVar;
import view.DeletePCPage.DeletePCVar;
import view.UpdatePCPage.UpdatePCVar;


public class PcController {
	PcModel pcModel = new PcModel();
	
	public void handling_addPc(AddPCVar addPCVar) {
		addPCVar.button_addPc.setOnAction(e->{
			String pc_id = addPCVar.pc_id.getText();
			String pc_condition = addPCVar.pc_Condition.getValue();
			
			if(pc_id.length() <= 0) {
				addPCVar.fillalert.showAndWait();
			} else {
				for(Pc pc : new PcModel().getPC()) {
					if(pc.getPC_ID().equals(pc_id)) {
						addPCVar.idalert.showAndWait();
						return;
					}
				}
				
				pcModel.addPC(new Pc(pc_id, pc_condition));
				
			}
		});
	}
	
	public void handling_showPc(DeletePCVar deletePCVar) {
		for(Pc pc : new PcModel().getPC()) {
			deletePCVar.pc_id.getItems().add(pc.getPC_ID());
		}
	}
	
	public void handling_showPc(UpdatePCVar updatePCVar) {
		for(Pc pc : new PcModel().getPC()) {
			updatePCVar.old_pc_id.getItems().add(pc.getPC_ID());
		}
	}
	
	public void handling_deletePc(DeletePCVar deletePCVar) {
		deletePCVar.button_deletePc.setOnAction(e->{
			String pc_id = deletePCVar.pc_id.getValue();
			
			if(pc_id.length() <= 0) {
				deletePCVar.alert.showAndWait();
			} else {
				pcModel.deletePC(pc_id);
				
			}
		});
	}
	
	public void handling_updatePc(UpdatePCVar updatePCVar) {
		updatePCVar.button_updatePc.setOnAction(e->{
			String oldpc_id = updatePCVar.old_pc_id.getValue();
			String pc_id = updatePCVar.pc_id.getText();
			String pc_condition = updatePCVar.pc_Condition.getValue();
			
			if(pc_id.length() <= 0) {
				updatePCVar.alert.showAndWait();
			} else {
				pcModel.updatePC(new Pc(pc_id, pc_condition), oldpc_id);
				
			}
		});
	}
	
	
}
