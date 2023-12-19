package view;

import controller.PcViewController;
import controller.UserPageController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Pc;
import model.User;



public class ViewAllPcPage {
	
	
	public class ViewAllPcVar{
		Scene scene;
		BorderPane bp;
		GridPane gp;
		VBox vb1, vb2;
		public TableView<Pc> tvPc;
		public TableColumn <Pc, String> pc_id_col;
		public TableColumn <Pc, String> pc_condition_col;
		Label title, username_lbl, password_lbl, age_lbl;
		public TextField username_tf;
		public PasswordField pass_pf;
		public Spinner<Integer> age_spin;
		public Button button_regis, button_login;
		MenuBar menuBar;
		Menu menu;
		public MenuItem menuItem1, menuItem2, menuItem3, menuItem4;
	}
	
	@SuppressWarnings("unchecked")
	private void initialize(ViewAllPcVar viewAllPcVar) {
		viewAllPcVar.bp = new BorderPane();
		viewAllPcVar.gp = new GridPane();
		viewAllPcVar.vb1 = new VBox();
		viewAllPcVar.vb2 = new VBox();
		

		
		viewAllPcVar.menu = new Menu("Menu");
		
		viewAllPcVar.menuItem1 = new MenuItem("View All PC"); 
		viewAllPcVar.menuItem2 = new MenuItem("View Transaction History"); 
		viewAllPcVar.menuItem3 = new MenuItem("Book PC"); 
		viewAllPcVar.menuItem4 = new MenuItem("Make Report"); 
		
		viewAllPcVar.menu.getItems().addAll(viewAllPcVar.menuItem1, viewAllPcVar.menuItem2, 
				viewAllPcVar.menuItem3, viewAllPcVar.menuItem4);
		
		viewAllPcVar.menuBar = new MenuBar();
		viewAllPcVar.menuBar.getMenus().add(viewAllPcVar.menu);

		viewAllPcVar.title = new Label("Welcome to View All PC Page");

		
		viewAllPcVar.tvPc = new TableView<Pc>();
		viewAllPcVar.pc_id_col = new TableColumn<>("PC ID");
		viewAllPcVar.pc_condition_col = new TableColumn<>("PC CONDITION");
		viewAllPcVar.tvPc.getColumns().addAll(viewAllPcVar.pc_id_col, viewAllPcVar.pc_condition_col);

		viewAllPcVar.vb1.getChildren().add(viewAllPcVar.menuBar);
		viewAllPcVar.vb2.getChildren().addAll(viewAllPcVar.title, viewAllPcVar.tvPc);
		

		viewAllPcVar.gp.add(viewAllPcVar.vb1, 0, 0);
		viewAllPcVar.gp.add(viewAllPcVar.vb2, 0, 1);

		viewAllPcVar.bp.setCenter(viewAllPcVar.gp);

		viewAllPcVar.scene = new Scene(viewAllPcVar.bp, 600, 600);
	}
	
	public void handle(ViewAllPcVar viewAllPcVar, User cu) {
		UserPageController userPageController = new UserPageController();
		userPageController.changeHomeMenuPage(viewAllPcVar, cu);
		
		PcViewController pcViewController = new PcViewController();
		pcViewController.handling_showPctoTable(viewAllPcVar);
	}
	public Scene initializeVAPPage(User cu){
		ViewAllPcVar viewAllPcVar = new ViewAllPcVar();
		initialize(viewAllPcVar);
		handle(viewAllPcVar, cu);
		return viewAllPcVar.scene;
		
	}
}
