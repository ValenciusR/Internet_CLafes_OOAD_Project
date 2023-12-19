package controller;

import main.Main;
import view.ViewAllPcPage;
import view.LoginPage;
import view.LoginPage.LoginVar;
import view.OperatorPage;
import view.OperatorPage.OperatorVar;
import view.RegisterPage;
import view.UserHomePage.UserHomeVar;

public class OperatorPageController {
	public void changeHomeMenuPage(UserHomeVar userHomeVar) {
		userHomeVar.menuItem1.setOnAction(e->{
			Main.changeScene(new ViewAllPcPage().initializeVAPPage());
		});
	}
	
	public void backtoRegister(OperatorVar ov) {
		ov.registerItem.setOnAction(e->{
			Main.changeScene(new RegisterPage().initializeRegisterPage());
		});
	}
	
	public void backtoLogin(OperatorVar ov) {
		ov.loginItem.setOnAction(e->{
			Main.changeScene(new LoginPage().initializeLoginPage());
		});
	}
	
	public void refresh(OperatorVar ov, LoginVar lv) {
		ov.refreshItem.setOnAction(e->{
			Main.changeScene(new OperatorPage().initializeOperatorPage(lv));
		});
	}
}
