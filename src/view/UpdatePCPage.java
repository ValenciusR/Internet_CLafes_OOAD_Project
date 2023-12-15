package view;

import controller.AdminPageController;
import controller.PcController;
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

public class UpdatePCPage {
	public class UpdatePCVar {
		Scene scene;
		BorderPane bp;
		GridPane gp;
		VBox vb1, vb2;
		Label title, id_lbl, condition_lbl,oldid_lbl;
		public TextField pc_id;
		public ComboBox<String> pc_Condition, old_pc_id;
		public Button button_updatePc;
		MenuBar menuBar;
		Menu pc_menu;
		public MenuItem menuItem1, menuItem2, menuItem3;
		Menu staff_menu;
		public MenuItem staffItem1, staffItem2;
		public Alert alert;
	}
	
	private void initializeAlert(UpdatePCVar updatePCVar) {
		updatePCVar.alert = new Alert(AlertType.ERROR);
		updatePCVar.alert.setTitle("Add PC Error");
		updatePCVar.alert.setContentText("All fields must be filled!");
	}
	
	
	private void initialize(UpdatePCVar updatePCVar) {
		updatePCVar.bp = new BorderPane();
		updatePCVar.gp = new GridPane();
		updatePCVar.vb1 = new VBox();
		updatePCVar.vb2 = new VBox();
		
		updatePCVar.pc_menu = new Menu("PC Management");
		
		updatePCVar.menuItem1 = new MenuItem("Add PC"); 
		updatePCVar.menuItem2 = new MenuItem("Delete PC"); 
		updatePCVar.menuItem3 = new MenuItem("Update PC"); 
		
		updatePCVar.pc_menu.getItems().addAll(updatePCVar.menuItem1, updatePCVar.menuItem2, updatePCVar.menuItem3);
		
		updatePCVar.staff_menu = new Menu("Staff Management");
		
		updatePCVar.staffItem1 = new MenuItem("Add Staff Job"); 
		updatePCVar.staffItem2 = new MenuItem("Update Staff Job"); 
		
		updatePCVar.staff_menu.getItems().addAll(updatePCVar.staffItem1, updatePCVar.staffItem2);
		
		updatePCVar.menuBar = new MenuBar();
		updatePCVar.menuBar.getMenus().addAll(updatePCVar.pc_menu, updatePCVar.staff_menu);

		updatePCVar.title = new Label("Update PC");
		updatePCVar.oldid_lbl = new Label("Old ID : ");
		updatePCVar.old_pc_id = new ComboBox<String>();
		updatePCVar.id_lbl = new Label("ID : ");
		updatePCVar.pc_id = new TextField();
		updatePCVar.condition_lbl = new Label("Condition : ");
		updatePCVar.pc_Condition = new ComboBox<String>();
		updatePCVar.pc_Condition.getItems().addAll(
				"Usable",
				"Maintenance",
				"Broken");
		updatePCVar.pc_Condition.setValue("Usable");
		updatePCVar.button_updatePc = new Button("Update PC");

		updatePCVar.vb1.getChildren().add(updatePCVar.menuBar);
		updatePCVar.vb2.getChildren().addAll(updatePCVar.oldid_lbl,updatePCVar.old_pc_id, updatePCVar.id_lbl, updatePCVar.pc_id,
				updatePCVar.condition_lbl, updatePCVar.pc_Condition, updatePCVar.button_updatePc);

		updatePCVar.gp.add(updatePCVar.vb1, 0, 0);
		updatePCVar.gp.add(updatePCVar.vb2, 0, 1);

		updatePCVar.bp.setCenter(updatePCVar.gp);

		updatePCVar.scene = new Scene(updatePCVar.bp, 600, 600);
	}
	
	private void handle(UpdatePCVar updatePCVar) {
		PcController pcController = new PcController();
		pcController.handling_showPc(updatePCVar);
		pcController.handling_updatePc(updatePCVar);
		
		AdminPageController adminPageController = new AdminPageController();
		adminPageController.changeUpdatePCMenuPage(updatePCVar);
	}
	
	public Scene initializeUpdatePCPage(){
		// TODO Auto-generated method stub
		UpdatePCVar updatePCVar = new UpdatePCVar();
		initialize(updatePCVar);
		initializeAlert(updatePCVar);
		handle(updatePCVar);
		
		return updatePCVar.scene;
	}
}
