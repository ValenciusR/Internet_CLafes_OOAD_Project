package controller;

import java.sql.Date;

import database.PcModel;
import database.ReportModel;
import database.UserModel;
import model.Pc;
import model.Report;
import model.User;
import view.ReportFormPage.ReportForm;

public class ReportController {
	
	ReportModel rm = new ReportModel();
	PcModel pm = new PcModel();
	UserModel um = new UserModel();
	User user;
	
	public void handling_addReport(ReportForm rf) {
		rf.submit_btn.setOnAction(e->{
			
			int id = 0;
			String userRole = user.getUserRole();
			String pc_id = rf.pcid_tf.getText();
			String reportNote = rf.note_tf.getText();
			
			long now = System.currentTimeMillis();
			Date reportDate = new Date(now);
			
			if(pc_id.length() <= 0 || reportNote.length() <= 0) {
				rf.alertEmpty.showAndWait();
			}else{
				for(Pc pc : new PcModel().getPC()) {
					if(pc.getPC_ID().equals(pc_id)) {
						rf.alertSameID.showAndWait();
						return;
					}
				}
				rm.makeReport(new Report(id, userRole, pc_id, reportNote, reportDate));
			}
		});
		
	}
	
	
	
	
}
