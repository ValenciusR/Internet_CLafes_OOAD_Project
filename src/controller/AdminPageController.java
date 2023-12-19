package controller;

import main.Main;
import view.JobManagementPage;
import view.JobManagementPage.JobManagementVar;
import view.LoginPage.LoginVar;
import view.PCManagementPage;
import view.PCManagementPage.PCManagementVar;
import view.ReportFormPage;
import view.StaffManagementPage;
import view.StaffManagementPage.StaffManagementVar;
import view.ViewReportPage;
import view.ViewReportPage.ViewReportVar;
import view.ViewTransactionHistoryPage;
import view.ViewTransactionHistoryPage.ViewTransactionHistoryVar;


public class AdminPageController {

	public void changePCManagementPage(PCManagementVar pcManagementVar, LoginVar lv) {
		pcManagementVar.pcItem.setOnAction(e->{
			Main.changeScene(new PCManagementPage().initializePCManagementPage(lv));
		});
		pcManagementVar.jobItem.setOnAction(e->{

			Main.changeScene(new JobManagementPage().initializeJobManagementPage(lv));
		});
		pcManagementVar.staffItem.setOnAction(e->{
			Main.changeScene(new StaffManagementPage().initializeStaffManagementPage(lv));

			Main.changeScene(new JobManagementPage().initializeJobManagementPage(lv));
		});
		pcManagementVar.staffItem.setOnAction(e->{
			Main.changeScene(new StaffManagementPage().initializeStaffManagementPage(lv));
		});
		pcManagementVar.reportItem.setOnAction(e->{
			Main.changeScene(new ReportFormPage().initializeReportFormPage(lv));
		});
		pcManagementVar.historyItem.setOnAction(e->{
			Main.changeScene(new ViewTransactionHistoryPage().initializeViewTransactionHistoryPage(lv));

		});
	}
	
	
	public void changeJobManagementPage(JobManagementVar jobManagemenVar, LoginVar lv) {
		jobManagemenVar.pcItem.setOnAction(e->{
			Main.changeScene(new PCManagementPage().initializePCManagementPage(lv));
		});
		jobManagemenVar.jobItem.setOnAction(e->{

			Main.changeScene(new JobManagementPage().initializeJobManagementPage(lv));
		});
		
		jobManagemenVar.staffItem.setOnAction(e->{
			Main.changeScene(new StaffManagementPage().initializeStaffManagementPage(lv));
		});

		jobManagemenVar.reportItem.setOnAction(e->{
			Main.changeScene(new ViewReportPage().initializeViewReportPage(lv));
		});
		jobManagemenVar.historyItem.setOnAction(e->{
			Main.changeScene(new ViewTransactionHistoryPage().initializeViewTransactionHistoryPage(lv));
		});
	}
	
	public void changeStaffManagementPage(StaffManagementVar staffManagementVar, LoginVar lv) {
		staffManagementVar.pcItem.setOnAction(e->{
			Main.changeScene(new PCManagementPage().initializePCManagementPage(lv));
		});
		staffManagementVar.jobItem.setOnAction(e->{
			Main.changeScene(new JobManagementPage().initializeJobManagementPage(lv));
		});
		staffManagementVar.staffItem.setOnAction(e->{
			Main.changeScene(new StaffManagementPage().initializeStaffManagementPage(lv));
		});
		staffManagementVar.reportItem.setOnAction(e->{
			Main.changeScene(new ViewReportPage().initializeViewReportPage(lv));
		});
		staffManagementVar.historyItem.setOnAction(e->{
			Main.changeScene(new ViewTransactionHistoryPage().initializeViewTransactionHistoryPage(lv));
		});
	}
	
	public void changeViewReportPage(ViewReportVar viewReportVar, LoginVar lv) {
		viewReportVar.pcItem.setOnAction(e->{
			Main.changeScene(new PCManagementPage().initializePCManagementPage(lv));
		});
		viewReportVar.jobItem.setOnAction(e->{
			Main.changeScene(new JobManagementPage().initializeJobManagementPage(lv));
		});
		viewReportVar.staffItem.setOnAction(e->{
			Main.changeScene(new StaffManagementPage().initializeStaffManagementPage(lv));
		});
		viewReportVar.reportItem.setOnAction(e->{
			Main.changeScene(new ViewReportPage().initializeViewReportPage(lv));
		});
		viewReportVar.historyItem.setOnAction(e->{
			Main.changeScene(new ViewTransactionHistoryPage().initializeViewTransactionHistoryPage(lv));
		});
	}
	
	public void changeViewTransactionHistoryPage(ViewTransactionHistoryVar viewTransactionHistoryVar, LoginVar lv) {
		viewTransactionHistoryVar.pcItem.setOnAction(e->{
			Main.changeScene(new PCManagementPage().initializePCManagementPage(lv));
		});
		viewTransactionHistoryVar.jobItem.setOnAction(e->{
			Main.changeScene(new JobManagementPage().initializeJobManagementPage(lv));
		});
		viewTransactionHistoryVar.staffItem.setOnAction(e->{
			Main.changeScene(new StaffManagementPage().initializeStaffManagementPage(lv));
		});
		viewTransactionHistoryVar.reportItem.setOnAction(e->{
			Main.changeScene(new ViewReportPage().initializeViewReportPage(lv));
		});
		viewTransactionHistoryVar.historyItem.setOnAction(e->{
			Main.changeScene(new ViewTransactionHistoryPage().initializeViewTransactionHistoryPage(lv));
		});
	}
	
	
}