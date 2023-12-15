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
		Label title, username_lbl, password_lbl, age_lbl;
		public TextField username_tf;
		public PasswordField pass_pf;
		public Spinner<Integer> age_spin;
		public Button button_regis, button_login;
		MenuBar menuBar;
		Menu menu;
		public MenuItem menuItem;
		public Alert alert;
		
		public Button btnTestRF;
	}

	private void initializeAlert(RegisterVar registerVar) {
		registerVar.alert = new Alert(AlertType.ERROR);
		registerVar.alert.setTitle("Register");
		registerVar.alert.setContentText("All fields must be fill!");
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
		registerVar.age_lbl = new Label("Age");
		registerVar.age_spin = new Spinner<>(1, 100, 17); // min, max, initial
		registerVar.button_regis = new Button("Register");
		registerVar.button_login = new Button("Redirect to Login");
		
		registerVar.btnTestRF = new Button("Make Report");

		registerVar.vb1.getChildren().add(registerVar.title);
		registerVar.vb2.getChildren().addAll(registerVar.username_lbl, registerVar.username_tf,
				registerVar.password_lbl, registerVar.pass_pf, registerVar.age_lbl, registerVar.age_spin,
				registerVar.button_regis, registerVar.button_login, registerVar.btnTestRF);

		registerVar.gp.add(registerVar.vb1, 0, 0);
		registerVar.gp.add(registerVar.vb2, 0, 1);

		registerVar.bp.setCenter(registerVar.gp);

		registerVar.scene = new Scene(registerVar.bp, 600, 600);
	}

	private void handle(RegisterVar registerVar) {
		UserController userController = new UserController();
		userController.handling_regis(registerVar);
		
		PageController pageController = new PageController();
		pageController.changePageToReportForm(registerVar);
	}


	public Scene initializeRegisterPage(){
		
		RegisterVar registerVar = new RegisterVar();
		initialize(registerVar);
		initializeAlert(registerVar);
		handle(registerVar);
		
		return registerVar.scene;
	}

}
