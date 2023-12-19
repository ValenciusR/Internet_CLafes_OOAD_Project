package controller;

import main.Main;
import model.User;
import view.CustomerReportFormPage;
import view.CustomerReportFormPage.ReportFormVar;
import view.PcBookPage;
import view.PcBookPage.PcBookVar;

import view.UserHomePage;
import view.UserHomePage.UserHomeVar;
import view.ViewAllPcPage.ViewAllPcVar;
import view.ViewAllPcPage;
import view.ViewTransactionHistoryPage;
import view.ViewTransactionHistoryPage.ViewTransactionHistoryVar;

public class UserPageController {
	public void changeHomeMenuPage(UserHomeVar userHomeVar, User cu) {
		userHomeVar.menuItem1.setOnAction(e->{
			Main.changeScene(new ViewAllPcPage().initializeVAPPage(cu));
		});
		userHomeVar.menuItem2.setOnAction(e->{
			Main.changeScene(new ViewTransactionHistoryPage().initializeTransactionHistoryPage(cu));
		});
		userHomeVar.menuItem3.setOnAction(e->{
			Main.changeScene(new PcBookPage().initializePcBookPage(cu));
		});
		
		userHomeVar.menuItem4.setOnAction(e->{
			Main.changeScene(new CustomerReportFormPage().initializeReportFormPage(cu));
		});
	}
	public void changeHomeMenuPage(ViewAllPcVar viewAllPcVar, User cu) {
		viewAllPcVar.menuItem1.setOnAction(e->{
			Main.changeScene(new ViewAllPcPage().initializeVAPPage(cu));
		});
		viewAllPcVar.menuItem2.setOnAction(e->{
			Main.changeScene(new ViewTransactionHistoryPage().initializeTransactionHistoryPage(cu));
		});
		viewAllPcVar.menuItem3.setOnAction(e->{
			Main.changeScene(new PcBookPage().initializePcBookPage(cu));
		});
		
		viewAllPcVar.menuItem4.setOnAction(e->{
			Main.changeScene(new CustomerReportFormPage().initializeReportFormPage(cu));
		});
	}
	public void changeHomeMenuPage(ViewTransactionHistoryVar viewTransactionHistoryVar, User cu) {
		viewTransactionHistoryVar.menuItem1.setOnAction(e->{
			Main.changeScene(new ViewAllPcPage().initializeVAPPage(cu));
		});
		viewTransactionHistoryVar.menuItem2.setOnAction(e->{
			Main.changeScene(new ViewTransactionHistoryPage().initializeTransactionHistoryPage(cu));
		});
		viewTransactionHistoryVar.menuItem3.setOnAction(e->{
			Main.changeScene(new PcBookPage().initializePcBookPage(cu));
		});
		
		viewTransactionHistoryVar.menuItem4.setOnAction(e->{
			Main.changeScene(new CustomerReportFormPage().initializeReportFormPage(cu));
		});
	}
	public void changeHomeMenuPage(PcBookVar pcBookVar, User cu) {
		pcBookVar.menuItem1.setOnAction(e->{
			Main.changeScene(new ViewAllPcPage().initializeVAPPage(cu));
		});
		pcBookVar.menuItem2.setOnAction(e->{
			Main.changeScene(new ViewTransactionHistoryPage().initializeTransactionHistoryPage(cu));
		});
		pcBookVar.menuItem3.setOnAction(e->{
			Main.changeScene(new PcBookPage().initializePcBookPage(cu));
		});
		
		pcBookVar.menuItem4.setOnAction(e->{
			Main.changeScene(new CustomerReportFormPage().initializeReportFormPage(cu));
		});
	}
	public void changeHomeMenuPage(ReportFormVar rm, User cu) {
		rm.menuItem1.setOnAction(e->{
			Main.changeScene(new ViewAllPcPage().initializeVAPPage(cu));
		});
		rm.menuItem2.setOnAction(e->{
			Main.changeScene(new ViewTransactionHistoryPage().initializeTransactionHistoryPage(cu));
		});
		rm.menuItem3.setOnAction(e->{
			Main.changeScene(new PcBookPage().initializePcBookPage(cu));
		});
		
		rm.menuItem4.setOnAction(e->{
			Main.changeScene(new CustomerReportFormPage().initializeReportFormPage(cu));
		});
	}
}
