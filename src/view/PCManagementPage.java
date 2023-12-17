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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Pc;


public class PCManagementPage {
	public class PCManagementVar{
		Scene scene;
		BorderPane bp;
		GridPane gp;
		VBox vb1, vb2;
		Label addPC_lbl, deletePC_lbl, addId_lbl, updatePC_lbl, updateID_lbl, deleteID_lbl, updatePC_condition_lbl;
		public TableView<Pc> table;
		public TableColumn<Pc, String> pc_idCol;
		public TableColumn<Pc, String> pc_conditionCol;
		public ComboBox<String> updatepc_Condition, deleteID, updatePC_ID;
		public TextField addPCID_tf;
		public Button button_addPC, button_deletePc, button_updatePc;
		MenuBar menuBar;
		Menu menu;
		public MenuItem pcItem, jobItem,staffItem,reportItem, historyItem;
		public Alert addAlert, idExistAlert, updateIDAlert, deleteIDAlert, deleteDateAlert;
	}
	
	private void initializeaddAlert(PCManagementVar pcManagementVar) {
		pcManagementVar.addAlert = new Alert(AlertType.ERROR);
		pcManagementVar.addAlert.setTitle("Add PC Error");
		pcManagementVar.addAlert.setContentText("ID field must be filled to add PC!");
	}
	
	private void initializeidExistAlert(PCManagementVar pcManagementVar) {
		pcManagementVar.idExistAlert = new Alert(AlertType.ERROR);
		pcManagementVar.idExistAlert.setTitle("Add PC Error");
		pcManagementVar.idExistAlert.setContentText("ID already Exist");
	}
	
	private void initializeupdateIDAlert(PCManagementVar pcManagementVar) {
		pcManagementVar.updateIDAlert = new Alert(AlertType.ERROR);
		pcManagementVar.updateIDAlert.setTitle("Update PC Error");
		pcManagementVar.updateIDAlert.setContentText("ID Must be Selected!");
	}
	
	private void initializedeleteIDAlert(PCManagementVar pcManagementVar) {
		pcManagementVar.deleteIDAlert = new Alert(AlertType.ERROR);
		pcManagementVar.deleteIDAlert.setTitle("Delete PC Error");
		pcManagementVar.deleteIDAlert.setContentText("ID Must be Selected!");
	}
	
	private void initializedeleteDateAlert(PCManagementVar pcManagementVar) {
		pcManagementVar.deleteDateAlert = new Alert(AlertType.ERROR);
		pcManagementVar.deleteDateAlert.setTitle("Delete PC Error");
		pcManagementVar.deleteDateAlert.setContentText("This PC have been Booked!");
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	private void initialize(PCManagementVar pcManagementVar) {
		pcManagementVar.bp = new BorderPane();
		pcManagementVar.gp = new GridPane();
		pcManagementVar.vb1 = new VBox();
		pcManagementVar.vb2 = new VBox();
		
		pcManagementVar.menu = new Menu("Menu");
		
		pcManagementVar.pcItem = new MenuItem("PC Management"); 
		pcManagementVar.jobItem = new MenuItem("Job Management"); 
		pcManagementVar.staffItem = new MenuItem("Staff Management"); 
		pcManagementVar.reportItem = new MenuItem("View All Report"); 
		pcManagementVar.historyItem = new MenuItem("View All Transaction History"); 
		
		pcManagementVar.menu.getItems().addAll(pcManagementVar.pcItem, pcManagementVar.jobItem,pcManagementVar.staffItem,pcManagementVar.reportItem, pcManagementVar.historyItem);
		
		pcManagementVar.menuBar = new MenuBar();
		
		pcManagementVar.menuBar.getMenus().addAll(pcManagementVar.menu);
		
		pcManagementVar.table = new TableView<Pc>();
		pcManagementVar.pc_idCol = new TableColumn<Pc, String>("ID");
		pcManagementVar.pc_conditionCol = new TableColumn<Pc, String>("Condition");
		pcManagementVar.table.getColumns().addAll(pcManagementVar.pc_idCol, pcManagementVar.pc_conditionCol);

		pcManagementVar.addPC_lbl = new Label("Add New PC");
		pcManagementVar.addId_lbl = new Label("ID : ");
		pcManagementVar.addPCID_tf = new TextField();
		pcManagementVar.button_addPC = new Button("Add PC");
		
		pcManagementVar.updatePC_lbl = new Label("Update PC");
		pcManagementVar.updateID_lbl = new Label("ID : ");
		pcManagementVar.updatePC_ID = new ComboBox<>();
		pcManagementVar.updatePC_condition_lbl = new Label("Condition : ");
		pcManagementVar.updatepc_Condition = new ComboBox<>();
		pcManagementVar.updatepc_Condition.getItems().addAll(
				"Usable",
				"Maintenance",
				"Broken");
		pcManagementVar.updatepc_Condition.setValue("Usable");
		pcManagementVar.button_updatePc = new Button("Update PC");
		
		pcManagementVar.deletePC_lbl = new Label("Delete PC");
		pcManagementVar.deleteID_lbl = new Label("ID : ");
		pcManagementVar.deleteID = new ComboBox<>();
		pcManagementVar.button_deletePc = new Button("Delete PC");
		
		pcManagementVar.vb1.getChildren().add(pcManagementVar.menuBar);
		pcManagementVar.vb2.getChildren().addAll(pcManagementVar.table, pcManagementVar.addPC_lbl, pcManagementVar.addId_lbl, pcManagementVar.addPCID_tf, pcManagementVar.button_addPC, pcManagementVar.updatePC_lbl, pcManagementVar.updateID_lbl,pcManagementVar.updatePC_ID, pcManagementVar.updatePC_condition_lbl,pcManagementVar.updatepc_Condition, pcManagementVar.button_updatePc, pcManagementVar.deletePC_lbl, pcManagementVar.deleteID_lbl, pcManagementVar.deleteID, pcManagementVar.button_deletePc);

		pcManagementVar.gp.add(pcManagementVar.vb1, 0, 0);
		pcManagementVar.gp.add(pcManagementVar.vb2, 0, 1);

		pcManagementVar.bp.setCenter(pcManagementVar.gp);

		pcManagementVar.scene = new Scene(pcManagementVar.bp, 600, 600);
	}
	
	private void handle(PCManagementVar pcManagementVar) {
		PcController pcController = new PcController();
		pcController.handling_showPctoTable(pcManagementVar);
		pcController.handling_addPc(pcManagementVar);
		pcController.handling_showPc(pcManagementVar);
		pcController.handling_updatePc(pcManagementVar);
		pcController.handling_deletePc(pcManagementVar);
		
		AdminPageController adminPageController = new AdminPageController();
		adminPageController.changePCManagementPage(pcManagementVar);
	}
	
	public Scene initializePCManagementPage(){
		// TODO Auto-generated method stub
		PCManagementVar pcManagementVar = new PCManagementVar();
		initialize(pcManagementVar);
		initializeaddAlert(pcManagementVar);
		initializeidExistAlert(pcManagementVar);
		initializeupdateIDAlert(pcManagementVar);
		initializedeleteIDAlert(pcManagementVar);
		initializedeleteDateAlert(pcManagementVar);
		handle(pcManagementVar);
		
		return pcManagementVar.scene;
	}
}
