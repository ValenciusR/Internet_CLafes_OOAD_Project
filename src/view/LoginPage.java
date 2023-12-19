package view;

import controller.PageController;
import controller.UserController;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class LoginPage {

	public class LoginVar {

		Scene scene;
		BorderPane bp;
		GridPane gp;
		VBox vb1, vb2;
		Label title, username_lbl, password_lbl;
		public TextField username_tf;
		public PasswordField pass_pf;
		public Button button_regis, button_login;
		MenuBar menuBar;
		Menu menu;
		public MenuItem menuItem;
		public Alert alert, emptyAlert;
	}

	private void initializeAlert(LoginVar loginVar) {
		loginVar.alert = new Alert(AlertType.ERROR);
		loginVar.alert.setTitle("Login");
		loginVar.alert.setContentText("Wrong username or password");
		
		loginVar.emptyAlert = new Alert(AlertType.ERROR);
		loginVar.emptyAlert.setTitle("Login");
		loginVar.emptyAlert.setContentText("All fields must be filled!");
	}

	private void initialize(LoginVar loginVar) {
		loginVar.bp = new BorderPane();
		loginVar.gp = new GridPane();
		loginVar.vb1 = new VBox();
		loginVar.vb2 = new VBox();

		loginVar.title = new Label("Login");
		loginVar.username_lbl = new Label("Username");
		loginVar.username_tf = new TextField();
		loginVar.password_lbl = new Label("Password");
		loginVar.pass_pf = new PasswordField();
	
	
		loginVar.button_regis = new Button("Register Page");
		loginVar.button_login = new Button("Login");

		loginVar.vb1.getChildren().add(loginVar.title);
		loginVar.vb2.getChildren().addAll(loginVar.username_lbl, loginVar.username_tf,
				loginVar.password_lbl, loginVar.pass_pf,
				loginVar.button_login, loginVar.button_regis);

		loginVar.gp.add(loginVar.vb1, 0, 0);
		loginVar.gp.add(loginVar.vb2, 0, 1);

		loginVar.bp.setCenter(loginVar.gp);

		loginVar.scene = new Scene(loginVar.bp, 600, 600);
	}

	private void handle(LoginVar loginVar) {
		UserController userController = new UserController();
		userController.handling_login(loginVar);
		
		PageController pageController = new PageController();
		pageController.changePageToRegister(loginVar);
		
//		UserController pageController1 = new UserController();
//		pageController1.userLoginPage(loginVar);
	}

	public Scene initializeLoginPage() {
		// TODO Auto-generated method stub
		LoginVar loginVar = new LoginVar();
		initialize(loginVar);
		initializeAlert(loginVar);
		handle(loginVar);
		return loginVar.scene;
	}
}
