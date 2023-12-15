package controller;

import database.UserModel;
import model.User;
import view.RegisterPage.RegisterVar;

public class UserController {
	UserModel userModel = new UserModel();
	
	public void handling_regis(RegisterVar registerVar) {
		registerVar.button_regis.setOnAction(e->{
			int id = 0;
			String username = registerVar.username_tf.getText();
			String password = registerVar.pass_pf.getText();
			int age = registerVar.age_spin.getValue();
			String role = "admin";
			
			if(username.length() <= 0 || password.length() <= 0 || age <= 0) {
				registerVar.alert.showAndWait();
			} else {
				userModel.regis(new User(id,username, password, age,role));
			}
		});
	}
}
