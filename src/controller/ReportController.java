package controller;

import java.sql.Date;
import java.util.Vector;

import database.PcModel;
import database.ReportModel;
import database.UserModel;
import model.Pc;
import model.Report;
import model.User;
import view.CustomerReportFormPage.ReportFormVar;
//import view.ReportFormPage.ReportForm;

public class ReportController {
	
	ReportModel rm = new ReportModel();
	
	public void handling_addReport(ReportFormVar rf) {
		rf.submit_btn.setOnAction(e->{
			
			int id = 0;
			String userRole = "Customer"; // benerin nih tar tolol lu masa userrole hardcoded gini
			String pc_id = rf.pcid_tf.getText();
			String reportNote = rf.note_tf.getText();		
			long now = System.currentTimeMillis();
			Date reportDate = new Date(now);
			
//			String str = "2021-03-20
//			Date reportDate = Date.valueOf(str);
			
			if(pc_id.length() <= 0 || reportNote.length() <= 0) {
				rf.alertEmpty.showAndWait();
			} else {
				for(Pc pc : new PcModel().getPc()) {
					if(pc.getPC_ID().equals(pc_id)) {
						rm.makeReport(new Report(id, userRole, pc_id, reportNote, reportDate));
						
						return;
					}
				}
				rf.alertSameID.showAndWait();
			}
			
		});
	}
	
	
	
	
}
