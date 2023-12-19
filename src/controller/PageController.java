package controller;

import main.Main;
import view.LoginPage;
import view.LoginPage.LoginVar;
import view.RegisterPage;
import view.RegisterPage.RegisterVar;
import view.UserHomePage;

public class PageController {
	public void changePageToLogin(RegisterVar regisVar) {
		regisVar.button_login.setOnAction(e->{
			//logic ganti scene
			Main.changeScene(new LoginPage().initializeLoginPage());
		});
	}

	public void changePageToRegister(LoginVar loginVar) {
		// TODO Auto-generated method stub
		loginVar.button_regis.setOnAction(e->{
			//logic ganti scene
			Main.changeScene(new RegisterPage().initializeRegisterPage());
		});
	}
	
//	public void userLoginPage(LoginVar loginVar) {
//		loginVar.button_login.setOnAction(e->{
//			//logic ganti scene
//			Main.changeScene(new UserHomePage().initializeUserPage());
//		});
	//}
}
