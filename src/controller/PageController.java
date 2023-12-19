package controller;

import database.UserModel;
import main.Main;
import model.User;
import view.LoginPage;
import view.LoginPage.LoginVar;
import view.RegisterPage;
import view.RegisterPage.RegisterVar;
import view.ReportFormPage;
import view.ReportFormPage.ReportForm;
import view.UserHomePage;

public class PageController {
	
	
	public void changePageToRegister(ReportForm rf) {
		rf.back_btn.setOnAction(e->{
			Main.changeScene(new RegisterPage().initializeRegisterPage());
		});
	}
	
//	public void changePageToRegister(LoginVar loginVar) {
//		loginVar.back_btn.setOnAction(e->{
//			Main.changeScene(new RegisterPage().initializeRegisterPage());
//		});
//	}
	
	public void changePageToLogin(RegisterVar regisVar) {
		regisVar.button_login.setOnAction(e->{
			//logic ganti scene
			Main.changeScene(new LoginPage().initializeLoginPage());
		});
	}
	
//	public void changePageToHome(LoginVar loginVar) {
//	loginVar.button_login.setOnAction(e->{
//		//logic ganti scene
//		Main.changeScene(new UserHomePage().initializeUserPage());
//		});
//	}
}


