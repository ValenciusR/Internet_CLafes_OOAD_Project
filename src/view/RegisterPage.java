package view;

import controller.PageController;
import controller.UserController;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class RegisterPage{

	public class RegisterVar {
		Scene scene;
		BorderPane bp;
		GridPane gp;
		VBox vb1, vb2;
		Label title, username_lbl, password_lbl, confirmPass_lbl, age_lbl;
		public TextField username_tf;
		public PasswordField pass_pf, confirmPass_pf;
		public Spinner<Integer> age_spin;
		public Button button_regis, button_login;
		MenuBar menuBar;
		Menu menu;
		public MenuItem menuItem;
		public Alert alert, usernameAlert,usernameMinAlert, passwordAlert, passwordMinAlert, passwordAnAlert, completeAlert;
	}

	private void initializeAlert(RegisterVar registerVar) {
		registerVar.alert = new Alert(AlertType.ERROR);
		registerVar.alert.setTitle("Register");
		registerVar.alert.setContentText("All fields must be fill!");
		
		// Username unique alert
		registerVar.usernameAlert = new Alert(AlertType.ERROR);
		registerVar.usernameAlert.setTitle("Register");
		registerVar.usernameAlert.setContentText("Username has been used!");
		
		// username minimum alert
		registerVar.usernameMinAlert = new Alert(AlertType.ERROR);
		registerVar.usernameMinAlert.setTitle("Register");
		registerVar.usernameMinAlert.setContentText("Username must have atleast 7 characters");
		
		// password minimum alert
		registerVar.passwordMinAlert = new Alert(AlertType.ERROR);
		registerVar.passwordMinAlert.setTitle("Register");
		registerVar.passwordMinAlert.setContentText("Password must have atleast 6 characters");
		
		//password contain alphanumeric alert
		registerVar.passwordAnAlert = new Alert(AlertType.ERROR);
		registerVar.passwordAnAlert.setTitle("Register");
		registerVar.passwordAnAlert.setContentText("Password must contains alpha numeric character");
		
		// confirmPass = password alert
		registerVar.passwordAlert = new Alert(AlertType.ERROR);
		registerVar.passwordAlert.setTitle("Register");
		registerVar.passwordAlert.setContentText("Confirm password does not match password.");
		
		// Regis complete
		registerVar.completeAlert = new Alert(AlertType.INFORMATION);
		registerVar.completeAlert.setTitle("Register");
		registerVar.completeAlert.setContentText("Registration Complete");
	}
	
	

	private void initialize(RegisterVar registerVar) {
		registerVar.bp = new BorderPane();
		registerVar.gp = new GridPane();
		registerVar.vb1 = new VBox();
		registerVar.vb2 = new VBox();

		registerVar.title = new Label("Registration");
		registerVar.username_lbl = new Label("Username");
		registerVar.username_tf = new TextField();
		registerVar.password_lbl = new Label("Password");
		registerVar.pass_pf = new PasswordField();
		registerVar.confirmPass_lbl = new Label("Confirm Password");
		registerVar.confirmPass_pf = new PasswordField();
		registerVar.age_lbl = new Label("Age");
		registerVar.age_spin = new Spinner<>(13, 65, 17); // min, max, initial
		registerVar.button_regis = new Button("REGISTER");
		registerVar.button_login = new Button("Redirect to Login");

		registerVar.vb1.getChildren().add(registerVar.title);
		registerVar.vb2.getChildren().addAll(registerVar.username_lbl, registerVar.username_tf,
				registerVar.password_lbl, registerVar.pass_pf, registerVar.confirmPass_lbl, 
				registerVar.confirmPass_pf, registerVar.age_lbl, registerVar.age_spin,
				registerVar.button_regis, registerVar.button_login);

		registerVar.gp.add(registerVar.vb1, 0, 0);
		registerVar.gp.add(registerVar.vb2, 0, 1);

		registerVar.bp.setCenter(registerVar.gp);

		registerVar.scene = new Scene(registerVar.bp, 600, 600);
	}

	private void handle(RegisterVar registerVar) {
		UserController userController = new UserController();
		userController.handling_regis(registerVar);
		
		PageController pageController = new PageController();
		pageController.changePageToLogin(registerVar);
	}


	public Scene initializeRegisterPage(){
		// TODO Auto-generated method stub
		RegisterVar registerVar = new RegisterVar();
		initialize(registerVar);
		initializeAlert(registerVar);
		handle(registerVar);
		
		return registerVar.scene;
	}

}
