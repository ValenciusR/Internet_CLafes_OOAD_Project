package controller;

import database.JobModel;
//import database.PcModel;
import database.UserModel;
import model.Job;
//import model.Pc;
import model.User;
import view.AddJobPage.AddJobVar;

public class JobController {
	JobModel jobModel = new JobModel();
	
	public void handling_addJob(AddJobVar addJobVar) {
		addJobVar.button_addJob.setOnAction(e->{
			int id = 0;
			String pc_id = addJobVar.pc_id.getValue();
			int userId = addJobVar.user_id.getValue();
			System.out.println(userId);
			String jobstatus = addJobVar.jobstatus.getValue();
			
			if(pc_id.length() <= 0 || userId <= 0 ) {
				addJobVar.alert.showAndWait();
			} else {
				for(User user : new UserModel().getUser()) {
					if(user.getUserID() == userId) {
						if(user.getUserRole().equals("Technician")) {
							jobModel.addJob(new Job(id,userId, pc_id, jobstatus));
							return;
						}
						addJobVar.alertTech.showAndWait();
						return;
					}
				}
				addJobVar.alertTech.showAndWait();
			}
		});
	}
	
//	public void handling_showPC(AddJobVar addJobVar) {
//		for(Pc pc : new PcModel().getPC()) {
//			addJobVar.pc_id.getItems().add(pc.getPC_ID());
//		}
//	}
	
	public void handling_showUser(AddJobVar addJobVar) {
		for(User user : new UserModel().getUser()) {
			if(user.getUserRole().equals("Technician")) {
				addJobVar.user_id.getItems().add(user.getUserID());
			}
		}
	}
	
}
