package controller;

import database.UserModel;
import main.Main;
import model.User;
import view.RegisterPage;
import view.RegisterPage.RegisterVar;
import view.ReportFormPage;
import view.ReportFormPage.ReportForm;

public class PageController {
	
	public void changePageToReportForm(RegisterVar rv) {
		rv.btnTestRF.setOnAction(e->{
			Main.changeScene(new ReportFormPage().initializeReportFormPage());
		});
	}
	
	public void changePageToRegister(ReportForm rf) {
		rf.back_btn.setOnAction(e->{
			Main.changeScene(new RegisterPage().initializeRegisterPage());
		});
	}
}
