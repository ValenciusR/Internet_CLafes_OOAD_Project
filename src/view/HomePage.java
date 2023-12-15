package view;

import controller.AdminPageController;
import controller.HomePageController;
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
import view.HomePage.HomeVar;

public class HomePage {
	
	public class HomeVar{
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
		Menu pc_menu;
		public MenuItem menuItem1, menuItem2, menuItem3;
	}
	
	private void initialize(HomeVar homeVar) {
		homeVar.bp = new BorderPane();
		homeVar.gp = new GridPane();
		homeVar.vb1 = new VBox();
		homeVar.vb2 = new VBox();
		
		homeVar.pc_menu = new Menu("PC Management");
		
		homeVar.menuItem1 = new MenuItem("Add PC"); 
		homeVar.menuItem2 = new MenuItem("Delete PC"); 
		homeVar.menuItem3 = new MenuItem("Update PC"); 
		
		homeVar.pc_menu.getItems().addAll(homeVar.menuItem1, homeVar.menuItem2, homeVar.menuItem3);
		
		homeVar.menuBar = new MenuBar();
		homeVar.menuBar.getMenus().add(homeVar.pc_menu);

		homeVar.title = new Label("Welcome to Admin Home Page");

		homeVar.vb1.getChildren().add(homeVar.menuBar);
		homeVar.vb2.getChildren().addAll(homeVar.title);
		

		homeVar.gp.add(homeVar.vb1, 0, 0);
		homeVar.gp.add(homeVar.vb2, 0, 1);

		homeVar.bp.setCenter(homeVar.gp);


		homeVar.scene = new Scene(homeVar.bp, 600, 600);
	}
	
	private void handle(HomeVar homeVar) {
		HomePageController hpController = new HomePageController();
		hpController.changeHomeMenuPage(homeVar);
	}
	
	public Scene initializeAdminPage(){
		// TODO Auto-generated method stub
		HomeVar homeVar = new HomeVar();
		initialize(homeVar);
		handle(homeVar);
		
		return homeVar.scene;
	}
}
