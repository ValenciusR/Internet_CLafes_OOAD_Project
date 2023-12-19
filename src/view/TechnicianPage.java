package view;

import controller.JobController;
import controller.PcController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Job;

public class TechnicianPage {
	public class TechnicianVar {
		Scene scene;
		BorderPane bp;
		GridPane gp;
		VBox vb1, vb2;
		Label completeJob_lbl, choosePC_lbl, jobStatus_lbl;
		public TableView<Job> table;
		
		public TableColumn<Job, Integer> job_idCol; //
		public TableColumn<Job, Integer> user_idCol; //
		
		public TableColumn<Job, String> pc_idCol;
		public TableColumn<Job, String> job_statusCol;
		
		public ComboBox<String> selectPCID_cb;
		
		public Button button_completeJob;
		
		MenuBar menuBar;
		Menu menu;
		public MenuItem loginItem, registerItem;
		
	}
	

	@SuppressWarnings("unchecked")
	private void initialize(TechnicianVar techVar) {
		techVar.bp = new BorderPane();
		techVar.gp = new GridPane();
		techVar.vb1 = new VBox();
		techVar.vb2 = new VBox();
		
		techVar.menu = new Menu("Menu");
		
		techVar.loginItem = new MenuItem("Return to Login");
		techVar.registerItem = new MenuItem("Return to Register");
		
		techVar.menu.getItems().addAll(techVar.loginItem, techVar.registerItem);
		
		techVar.menuBar = new MenuBar();
		
		techVar.menuBar.getMenus().addAll(techVar.menu);
		
		
		techVar.table = new TableView<Job>();
		
		techVar.pc_idCol = new TableColumn<Job, String>("PC ID");
		techVar.job_statusCol = new TableColumn<Job, String>("Job Status");
		techVar.table.getColumns().addAll(techVar.pc_idCol, techVar.job_statusCol);
		
		techVar.choosePC_lbl = new Label("Choose PC to Complete");
		
		techVar.selectPCID_cb = new ComboBox<>();
		techVar.button_completeJob = new Button("Complete Job");
		

		techVar.vb1.getChildren().add(techVar.menuBar);
		techVar.vb2.getChildren().addAll(techVar.table, 
				techVar.choosePC_lbl, techVar.selectPCID_cb, techVar.button_completeJob);
		
		techVar.gp.add(techVar.vb1, 0, 0);
		techVar.gp.add(techVar.vb2, 0, 1);
		
		techVar.bp.setCenter(techVar.gp);
		
		techVar.scene = new Scene(techVar.bp, 600, 600);
		
	}
	
	private void handle(TechnicianVar techVar) {
		JobController jobController = new JobController();
		jobController.handling_showPcJob(techVar); // ini buat combo box
		jobController.handling_showJob(techVar); // ini buat table
		
		jobController.handling_completeJob(techVar); // ini buat button complete
		
	}
	
	public Scene initializeTechnicianPage() {
		TechnicianVar techVar = new TechnicianVar();
		initialize(techVar);
		handle(techVar);
		
		return techVar.scene;
	}
}
