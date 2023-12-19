package view;

import controller.AdminPageController;
//import controller.PcController;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class AddPCPage {
	public class AddPCVar {
		Scene scene;
		BorderPane bp;
		GridPane gp;
		VBox vb1, vb2;
		Label title, id_lbl, condition_lbl;
		public TextField pc_id;
		public ComboBox<String> pc_Condition;
		public Button button_addPc;
		MenuBar menuBar;
		Menu pc_menu, staff_menu;
		public MenuItem menuItem1, menuItem2, menuItem3, staffItem1, staffItem2;
		public Alert fillalert, idalert;
	}
	
	private void initializefillAlert(AddPCVar addPCVar) {
		addPCVar.fillalert = new Alert(AlertType.ERROR);
		addPCVar.fillalert.setTitle("Add PC Error");
		addPCVar.fillalert.setContentText("All fields must be filled!");
	}
	
	private void initializeIDAlert(AddPCVar addPCVar) {
		addPCVar.idalert = new Alert(AlertType.ERROR);
		addPCVar.idalert.setTitle("Add PC Error");
		addPCVar.idalert.setContentText("PC with the same ID Exists!");
	}
	
	private void initialize(AddPCVar addPCVar) {
		addPCVar.bp = new BorderPane();
		addPCVar.gp = new GridPane();
		addPCVar.vb1 = new VBox();
		addPCVar.vb2 = new VBox();
		
		addPCVar.pc_menu = new Menu("PC Management");
		
		addPCVar.menuItem1 = new MenuItem("Add PC"); 
		addPCVar.menuItem2 = new MenuItem("Delete PC"); 
		addPCVar.menuItem3 = new MenuItem("Update PC"); 
		
		addPCVar.pc_menu.getItems().addAll(addPCVar.menuItem1, addPCVar.menuItem2, addPCVar.menuItem3);
		
		addPCVar.staff_menu = new Menu("Staff Management");
		
		addPCVar.staffItem1 = new MenuItem("Add Staff Job"); 
		addPCVar.staffItem2 = new MenuItem("Update Staff Job"); 
		
		addPCVar.staff_menu.getItems().addAll(addPCVar.staffItem1, addPCVar.staffItem2);
		
		addPCVar.menuBar = new MenuBar();
		addPCVar.menuBar.getMenus().addAll(addPCVar.pc_menu, addPCVar.staff_menu);

		addPCVar.title = new Label("Add New PC");
		addPCVar.id_lbl = new Label("ID : ");
		addPCVar.pc_id = new TextField();
		addPCVar.condition_lbl = new Label("Condition : ");
		addPCVar.pc_Condition = new ComboBox<String>();
		addPCVar.pc_Condition.getItems().addAll(
				"Usable",
				"Maintenance",
				"Broken");
		addPCVar.pc_Condition.setValue("Usable");
		addPCVar.button_addPc = new Button("Add PC");

		addPCVar.vb1.getChildren().add(addPCVar.menuBar);
		addPCVar.vb2.getChildren().addAll(addPCVar.id_lbl, addPCVar.pc_id,
				addPCVar.condition_lbl, addPCVar.pc_Condition, addPCVar.button_addPc);

		addPCVar.gp.add(addPCVar.vb1, 0, 0);
		addPCVar.gp.add(addPCVar.vb2, 0, 1);

		addPCVar.bp.setCenter(addPCVar.gp);

		addPCVar.scene = new Scene(addPCVar.bp, 600, 600);
	}
	
	private void handle(AddPCVar addPCVar) {
		//PcController pcController = new PcController();
		//pcController.handling_addPc(addPCVar);
		
		AdminPageController adminPageController = new AdminPageController();
		adminPageController.changeAddPCMenuPage(addPCVar);
	}
	
	public Scene initializeAddPCPage(){
		// TODO Auto-generated method stub
		AddPCVar addPCVar = new AddPCVar();
		initialize(addPCVar);
		initializefillAlert(addPCVar);
		initializeIDAlert(addPCVar);
		handle(addPCVar);
		
		return addPCVar.scene;
	}
}
