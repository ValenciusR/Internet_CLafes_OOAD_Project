package view;

import controller.UserPageController;
//import controller.AdminPageController;
import javafx.scene.Scene;
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

public class UserHomePage {
	
	public class UserHomeVar{
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
		public MenuItem menuItem1, menuItem2, menuItem3, menuItem4;
	}
	
	private void initialize(UserHomeVar userHomeVar) {
		userHomeVar.bp = new BorderPane();
		userHomeVar.gp = new GridPane();
		userHomeVar.vb1 = new VBox();
		userHomeVar.vb2 = new VBox();
		
		userHomeVar.menu = new Menu("Menu");
		
		userHomeVar.menuItem1 = new MenuItem("View All PC"); 
		userHomeVar.menuItem2 = new MenuItem("View Transaction History"); 
		userHomeVar.menuItem3 = new MenuItem("Book PC"); 
		userHomeVar.menuItem4 = new MenuItem("Make Report"); 
		
		userHomeVar.menu.getItems().addAll(userHomeVar.menuItem1, userHomeVar.menuItem2, 
				userHomeVar.menuItem3, userHomeVar.menuItem4);
		
		userHomeVar.menuBar = new MenuBar();
		userHomeVar.menuBar.getMenus().add(userHomeVar.menu);

		userHomeVar.title = new Label("Welcome to User Home Page");

		userHomeVar.vb1.getChildren().add(userHomeVar.menuBar);
		userHomeVar.vb2.getChildren().addAll(userHomeVar.title);
		

		userHomeVar.gp.add(userHomeVar.vb1, 0, 0);
		userHomeVar.gp.add(userHomeVar.vb2, 0, 1);

		userHomeVar.bp.setCenter(userHomeVar.gp);


		userHomeVar.scene = new Scene(userHomeVar.bp, 600, 600);
	}
	
	private void handle(UserHomeVar userHomeVar) {
		UserPageController userPageController = new UserPageController();
		userPageController.changeHomeMenuPage(userHomeVar);
	}
	
	public Scene initializeUserPage(){
		// TODO Auto-generated method stub
		UserHomeVar userHomeVar = new UserHomeVar();
		initialize(userHomeVar);
		handle(userHomeVar);
		
		return userHomeVar.scene;
	}
	

}
