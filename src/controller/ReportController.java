package controller;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.Vector;

import database.PcModel;
import database.ReportModel;
import database.UserModel;
import model.Pc;
import model.Report;
import model.User;
import view.LoginPage.LoginVar;
import view.ReportFormPage.ReportForm;

public class ReportController {
	
	UserModel um = new UserModel();
	ReportModel rm = new ReportModel();
	
	public void handling_addReport(ReportForm rf, LoginVar lv) {
		rf.submit_btn.setOnAction(e->{
			
			int id = 0;
			
			String username = lv.username_tf.getText();
			
			ResultSet rs = um.getUserByUsername(username);
			User u = null;
			try {
				rs.next();
				u = new User(rs.getInt("UserID"), rs.getString("UserName"), rs.getString("UserPassword"),
						rs.getInt("UserAge"), rs.getString("UserRole"));
			} catch (Exception e2) {
				
			}
			String userRole = u.getUserRole();
			String pc_id = rf.pcid_tf.getText();
			String reportNote = rf.note_tf.getText();		
			long now = System.currentTimeMillis();
			Date reportDate = new Date(now);
			
			if(pc_id.length() <= 0 || reportNote.length() <= 0) {
				rf.alertEmpty.showAndWait();
			} else {
				for(Pc pc : new PcModel().getPC()) {
					if(!pc.getPC_ID().equals(pc_id)) {
						rf.alertSameID.showAndWait();
					}
				}
			}
			rm.makeReport(new Report(id, userRole, pc_id, reportNote, reportDate));
		});
	}
	
	
	
	
}
