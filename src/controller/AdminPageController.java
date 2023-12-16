package controller;

import main.Main;
import view.JobManagemenPage;
import view.JobManagemenPage.JobManagementVar;
import view.PCManagementPage;
import view.PCManagementPage.PCManagementVar;
import view.StaffManagementPage;
import view.StaffManagementPage.StaffManagementVar;
import view.ViewReportPage;
import view.ViewReportPage.ViewReportVar;
import view.ViewTransactionHistoryPage;
import view.ViewTransactionHistoryPage.ViewTransactionHistoryVar;

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
		pcManagementVar.reportItem.setOnAction(e->{
			Main.changeScene(new ViewReportPage().initializeViewReportPage());
		});
		pcManagementVar.historyItem.setOnAction(e->{
			Main.changeScene(new ViewTransactionHistoryPage().initializeViewTransactionHistoryPage());
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
		jobManagemenVar.reportItem.setOnAction(e->{
			Main.changeScene(new ViewReportPage().initializeViewReportPage());
		});
		jobManagemenVar.historyItem.setOnAction(e->{
			Main.changeScene(new ViewTransactionHistoryPage().initializeViewTransactionHistoryPage());
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
		staffManagementVar.reportItem.setOnAction(e->{
			Main.changeScene(new ViewReportPage().initializeViewReportPage());
		});
		staffManagementVar.historyItem.setOnAction(e->{
			Main.changeScene(new ViewTransactionHistoryPage().initializeViewTransactionHistoryPage());
		});
	}
	
	public void changeViewReportPage(ViewReportVar viewReportVar) {
		viewReportVar.pcItem.setOnAction(e->{
			Main.changeScene(new PCManagementPage().initializePCManagementPage());
		});
		viewReportVar.jobItem.setOnAction(e->{
			Main.changeScene(new JobManagemenPage().initializeJobManagementPage());
		});
		viewReportVar.staffItem.setOnAction(e->{
			Main.changeScene(new StaffManagementPage().initializeStaffManagementPage());
		});
		viewReportVar.reportItem.setOnAction(e->{
			Main.changeScene(new ViewReportPage().initializeViewReportPage());
		});
		viewReportVar.historyItem.setOnAction(e->{
			Main.changeScene(new ViewTransactionHistoryPage().initializeViewTransactionHistoryPage());
		});
	}
	
	public void changeViewTransactionHistoryPage(ViewTransactionHistoryVar viewTransactionHistoryVar) {
		viewTransactionHistoryVar.pcItem.setOnAction(e->{
			Main.changeScene(new PCManagementPage().initializePCManagementPage());
		});
		viewTransactionHistoryVar.jobItem.setOnAction(e->{
			Main.changeScene(new JobManagemenPage().initializeJobManagementPage());
		});
		viewTransactionHistoryVar.staffItem.setOnAction(e->{
			Main.changeScene(new StaffManagementPage().initializeStaffManagementPage());
		});
		viewTransactionHistoryVar.reportItem.setOnAction(e->{
			Main.changeScene(new ViewReportPage().initializeViewReportPage());
		});
		viewTransactionHistoryVar.historyItem.setOnAction(e->{
			Main.changeScene(new ViewTransactionHistoryPage().initializeViewTransactionHistoryPage());
		});
	}
}
