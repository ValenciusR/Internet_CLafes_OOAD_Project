package controller;

import database.UserModel;
import javafx.scene.control.DatePicker;
import main.Main;
import model.User;
import view.AdminHomePage;
import view.LoginPage.LoginVar;
import view.OperatorHomePage;
import view.PcBookPage.PcBookVar;
import view.RegisterPage.RegisterVar;
import view.TechnicianHomePage;
import view.UserHomePage;

import java.sql.Date;
import java.sql.ResultSet;
import java.util.ArrayList;

import database.Connect;

public class UserController {
	UserModel userModel = new UserModel();
	

	public void handling_regis(RegisterVar registerVar) {
		registerVar.button_regis.setOnAction(e -> {
			int id = 0;
			String username = registerVar.username_tf.getText();
			String password = registerVar.pass_pf.getText();
			String confirmPass = registerVar.confirmPass_pf.getText();
			int age = registerVar.age_spin.getValue();
			String role = "Customer";

			if (username.length() <= 0 || password.length() <= 0 || age <= 0) {
				registerVar.alert.showAndWait();
			} else if (!confirmPass.equals(password)) {
				registerVar.passwordAlert.showAndWait();
			} else if (username.length() < 7 && username.length() > 1) {
				registerVar.usernameMinAlert.showAndWait();
			} else if (password.length() < 6 && password.length() > 1) {
				registerVar.passwordMinAlert.showAndWait();
			} else {
				for (User user : new UserModel().getUser()) {
					if (user.getUserName().equals(username)) {
						registerVar.usernameAlert.showAndWait();
						return;
					}
				}
				userModel.regis(new User(id, username, password, age, role));
				registerVar.completeAlert.show();

			}
		});
	}

	public void handling_login(LoginVar loginVar) {
		loginVar.button_login.setOnAction(e -> {
			String username = loginVar.username_tf.getText();
			String password = loginVar.pass_pf.getText();
			
			if (username.length() <= 0 || password.length() <= 0) {
				loginVar.emptyAlert.showAndWait();
			} else {
				for (User user : new UserModel().getUser()) {
					if (user.getUserName().equals(username) && user.getUserPassword().equals(password) && 
							user.getUserRole().equals("Customer")) {
						ResultSet rs = userModel.getUserByUsername(username);
//						ResultSet rs1 = userModel.getUserById(id);
						User cu = null;
						try {
							rs.next();
							cu = new User(rs.getInt("UserID"),
									  rs.getString("UserName"),
									  rs.getString("UserPassword"),
									  rs.getInt("UserAge"),	  
									  rs.getString("UserRole"));
						} catch (Exception e2) {
							// TODO: handle exception
						}
						
						Main.changeScene(new UserHomePage(cu).initializeUserPage(cu));
						return;
					}else if (user.getUserName().equals(username) && user.getUserPassword().equals(password) && 
							user.getUserRole().equals("Admin")){
						Main.changeScene(new AdminHomePage().initializeAdminPage());
						return;
					}else if (user.getUserName().equals(username) && user.getUserPassword().equals(password) && 
							user.getUserRole().equals("Technician")){
						Main.changeScene(new TechnicianHomePage().intializeTechnicianPage());
						return;
					}else if (user.getUserName().equals(username) && user.getUserPassword().equals(password) && 
							user.getUserRole().equals("Operator")){
						Main.changeScene(new OperatorHomePage().initializeOperatorPage());
						return;
					}
				}
				loginVar.alert.showAndWait();
			}
		});
	}
//	public void handling_book(PcBookVar pcBookVar) {
//		pcBookVar.button_book.setOnAction(e -> {
//			int id = 0;
//			DatePicker date;
//			String pc_id = pcBookVar.pc_id_tf.getText();
//			String password = registerVar.pass_pf.getText();
//			String confirmPass = registerVar.confirmPass_pf.getText();
//			int age = registerVar.age_spin.getValue();
//			String role = "Customer";
//
//			if (username.length() <= 0 || password.length() <= 0 || age <= 0) {
//				registerVar.alert.showAndWait();
//			} else if (!confirmPass.equals(password)) {
//				registerVar.passwordAlert.showAndWait();
//			} else if (username.length() < 7 && username.length() > 1) {
//				registerVar.usernameMinAlert.showAndWait();
//			} else if (password.length() < 6 && password.length() > 1) {
//				registerVar.passwordMinAlert.showAndWait();
//			} else {
//				for (User user : new UserModel().getUser()) {
//					if (user.getUserName().equals(username)) {
//						registerVar.usernameAlert.showAndWait();
//						return;
//					}
//				}
//				userModel.regis(new User(id, username, password, age, role));
//				registerVar.completeAlert.show();
//
//			}
//		});
	
//		});
	}
	

