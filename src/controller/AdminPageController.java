package controller;

import main.Main;
import view.JobManagemenPage;
import view.JobManagemenPage.JobManagementVar;
import view.PCManagementPage;
import view.PCManagementPage.PCManagementVar;
import view.StaffManagementPage;
import view.StaffManagementPage.StaffManagementVar;

public class AdminPageController {

	public void changePCManagementPage(PCManagementVar pcManagementVar) {
		pcManagementVar.pcItem.setOnAction(e->{
			Main.changeScene(new PCManagementPage().initializePCManagementPage());
		});
		pcManagementVar.jobItem.setOnAction(e->{
			Main.changeScene(new JobManagemenPage().initializeJobManagementPage());
		});
		pcManagementVar.staffItem.setOnAction(e->{
			Main.changeScene(new StaffManagementPage().initializeStaffManagementPage());
		});
	}
	
	
	public void changeJobManagementPage(JobManagementVar jobManagemenVar) {
		jobManagemenVar.pcItem.setOnAction(e->{
			Main.changeScene(new PCManagementPage().initializePCManagementPage());
		});
		jobManagemenVar.jobItem.setOnAction(e->{
			Main.changeScene(new JobManagemenPage().initializeJobManagementPage());
		});
		
		jobManagemenVar.staffItem.setOnAction(e->{
			Main.changeScene(new StaffManagementPage().initializeStaffManagementPage());
		});
	}
	
	public void changeStaffManagementPage(StaffManagementVar staffManagementVar) {
		staffManagementVar.pcItem.setOnAction(e->{
			Main.changeScene(new PCManagementPage().initializePCManagementPage());
		});
		staffManagementVar.jobItem.setOnAction(e->{
			Main.changeScene(new JobManagemenPage().initializeJobManagementPage());
		});
		staffManagementVar.staffItem.setOnAction(e->{
			Main.changeScene(new StaffManagementPage().initializeStaffManagementPage());
		});
	}
}
