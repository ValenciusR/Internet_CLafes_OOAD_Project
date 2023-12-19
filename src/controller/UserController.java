package controller;

import java.sql.ResultSet;

import database.UserModel;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Main;

import model.Pc;
import model.User;
import view.PCManagementPage;
import view.JobManagementPage;
import view.JobManagementPage.JobManagementVar;
import view.LoginPage.LoginVar;
import view.OperatorPage;
import view.PCManagementPage.PCManagementVar;
import view.RegisterPage.RegisterVar;
import view.StaffManagementPage;
import view.StaffManagementPage.StaffManagementVar;
import view.TechnicianPage;
import view.UserHomePage;

public class UserController {
	UserModel userModel = new UserModel();

	public void handling_regis(RegisterVar registerVar) {
		registerVar.button_regis.setOnAction(e -> {
			int id = 0;
			String username = registerVar.username_tf.getText();
			String password = registerVar.pass_pf.getText();
			int age = registerVar.age_spin.getValue();
			String role = "admin";

			if (username.length() <= 0 || password.length() <= 0 || age <= 0) {
				registerVar.alert.showAndWait();
			} else {
				userModel.regis(new User(id, username, password, age, role));

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
					if (user.getUserName().equals(username) && user.getUserPassword().equals(password)
							&& user.getUserRole().equals("Customer")) {
						ResultSet rs = userModel.getUserByUsername(username);
						User cu = null;
						try {
							rs.next();
							cu = new User(rs.getInt("UserID"), rs.getString("UserName"), rs.getString("UserPassword"),
									rs.getInt("UserAge"), rs.getString("UserRole"));
						} catch (Exception e2) {
							// TODO: handle exception
						}
//						Main.changeScene(new UserHomePage(cu).initializeUserPage(cu));
						return;
					} else if (user.getUserName().equals(username) && user.getUserPassword().equals(password)
							&& user.getUserRole().equals("Admin")) {
						Main.changeScene(new JobManagementPage().initializeJobManagementPage(loginVar));
						return;
					} else if (user.getUserName().equals(username) && user.getUserPassword().equals(password)
							&& user.getUserRole().equals("Technician")) {
						Main.changeScene(new TechnicianPage().initializeTechnicianPage());
						return;
					} else if (user.getUserName().equals(username) && user.getUserPassword().equals(password)
							&& user.getUserRole().equals("Operator")) {
						Main.changeScene(new OperatorPage().initializeOperatorPage(loginVar));
						return;
					}
				}
				loginVar.alert.showAndWait();
			}
		});
	}

	public void handling_showUser(JobManagementVar jobManagementVar) {
		for (User user : new UserModel().getUser()) {
			if (user.getUserRole().equals("Technician")) {
				jobManagementVar.addJobUserID.getItems().add(Integer.toString(user.getUserID()));
			}
		}
	}

	public void handling_showStaff(StaffManagementVar staffManagementVar) {
		for (User user : new UserModel().getUser()) {
			if (!user.getUserRole().equals("Customer")) {
				staffManagementVar.table.getItems().add(user);
			}
		}
		staffManagementVar.user_idCol.setCellValueFactory(new PropertyValueFactory<User, Integer>("UserID"));
		staffManagementVar.user_nameCol.setCellValueFactory(new PropertyValueFactory<User, String>("UserName"));
		staffManagementVar.user_ageCol.setCellValueFactory(new PropertyValueFactory<User, Integer>("UserAge"));
		staffManagementVar.user_roleCol.setCellValueFactory(new PropertyValueFactory<User, String>("UserRole"));
	}

	public void handling_updateUser(StaffManagementVar staffManagementVar, LoginVar lv) {
		staffManagementVar.button_updateRole.setOnAction(e -> {

			Integer user_id = Integer.parseInt(staffManagementVar.updateUserID_tf.getText());
			String userRole = staffManagementVar.updateUserRole.getValue();

			if (user_id <= 0) {
//				pcManagementVar.addAlert.showAndWait();
				if (staffManagementVar.updateUserID_tf.getLength() <= 0) {
					user_id = -1;
				} else {
					user_id = Integer.parseInt(staffManagementVar.updateUserID_tf.getText());
				}
				if (user_id <= 0) {
					staffManagementVar.addAlert.showAndWait();
				} else {
					userModel.updateUserRole(user_id, userRole);
					Main.changeScene(new StaffManagementPage().initializeStaffManagementPage(lv));
				}
			}

		});
	}
}
