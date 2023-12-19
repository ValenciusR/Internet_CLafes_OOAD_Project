package controller;

import main.Main;
import view.UserHomePage.UserHomeVar;
import view.ViewAllPcPage;

public class UserPageController {
	public void changeHomeMenuPage(UserHomeVar userHomeVar) {
		userHomeVar.menuItem1.setOnAction(e->{
			Main.changeScene(new ViewAllPcPage().initializeVAPPage());
		});
	}
}