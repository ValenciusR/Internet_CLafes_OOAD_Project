package controller;

import database.UserModel;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Main;
import model.User;
import view.JobManagemenPage.JobManagementVar;
import view.RegisterPage.RegisterVar;
import view.StaffManagementPage;
import view.StaffManagementPage.StaffManagementVar;

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
	
	public void handling_showUser(JobManagementVar jobManagementVar) {
		for(User user : new UserModel().getUser()) {
			if(user.getUserRole().equals("Computer Technician")) {
				jobManagementVar.addJobUserID.getItems().add(Integer.toString(user.getUserID()));
			}
		}
	}
	
	public void handling_showStaff(StaffManagementVar staffManagementVar) {
		for(User user : new UserModel().getUser()) {
			if(!user.getUserRole().equals("Customer")) {
				staffManagementVar.table.getItems().add(user);
			}
		}
		staffManagementVar.user_idCol.setCellValueFactory(new PropertyValueFactory<User, Integer>("UserID"));
		staffManagementVar.user_nameCol.setCellValueFactory(new PropertyValueFactory<User, String>("UserName"));
		staffManagementVar.user_ageCol.setCellValueFactory(new PropertyValueFactory<User, Integer>("UserAge"));
		staffManagementVar.user_roleCol.setCellValueFactory(new PropertyValueFactory<User, String>("UserRole"));
	}
	
	public void handling_updateUser(StaffManagementVar staffManagementVar) {
		staffManagementVar.button_updateRole.setOnAction(e->{
			Integer user_id;
			String userRole = staffManagementVar.updateUserRole.getValue();
			
			if(staffManagementVar.updateUserID_tf.getLength() <= 0) {
				user_id = -1;
			}else {
				user_id = Integer.parseInt(staffManagementVar.updateUserID_tf.getText());
			}
			if(user_id <= 0) {
				staffManagementVar.addAlert.showAndWait();
			} else {
				userModel.updateUserRole(user_id, userRole);
				Main.changeScene(new StaffManagementPage().initializeStaffManagementPage());
			}
		});
	}
	
}
