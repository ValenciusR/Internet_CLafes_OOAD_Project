package view;

import controller.AdminPageController;
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

public class AdminHomePage {
	
	public class AdminHomeVar{
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
	
	private void initialize(AdminHomeVar adminHomeVar) {
		adminHomeVar.bp = new BorderPane();
		adminHomeVar.gp = new GridPane();
		adminHomeVar.vb1 = new VBox();
		adminHomeVar.vb2 = new VBox();
		
		adminHomeVar.pc_menu = new Menu("PC Management");
		
		adminHomeVar.menuItem1 = new MenuItem("Add PC"); 
		adminHomeVar.menuItem2 = new MenuItem("Delete PC"); 
		adminHomeVar.menuItem3 = new MenuItem("Update PC"); 
		
		adminHomeVar.pc_menu.getItems().addAll(adminHomeVar.menuItem1, adminHomeVar.menuItem2, adminHomeVar.menuItem3);
		
		adminHomeVar.menuBar = new MenuBar();
		adminHomeVar.menuBar.getMenus().add(adminHomeVar.pc_menu);

		adminHomeVar.title = new Label("Welcome to Admin Home Page");

		adminHomeVar.vb1.getChildren().add(adminHomeVar.menuBar);
		adminHomeVar.vb2.getChildren().addAll(adminHomeVar.title);
		

		adminHomeVar.gp.add(adminHomeVar.vb1, 0, 0);
		adminHomeVar.gp.add(adminHomeVar.vb2, 0, 1);

		adminHomeVar.bp.setCenter(adminHomeVar.gp);


		adminHomeVar.scene = new Scene(adminHomeVar.bp, 600, 600);
	}
	
	private void handle(AdminHomeVar adminHomeVar) {
		AdminPageController adminPageController = new AdminPageController();
		adminPageController.changeHomeMenuPage(adminHomeVar);
	}
	
	public Scene initializeAdminPage(){
		// TODO Auto-generated method stub
		AdminHomeVar adminHomeVar = new AdminHomeVar();
		initialize(adminHomeVar);
		handle(adminHomeVar);
		
		return adminHomeVar.scene;
	}
	

}
