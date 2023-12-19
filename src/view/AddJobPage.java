package view;

import controller.AdminPageController;
import controller.JobController;
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
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class AddJobPage {
	public class AddJobVar {
		Scene scene;
		BorderPane bp;
		GridPane gp;
		VBox vb1, vb2;
		Label pcid_lbl, userid_lbl, jobstatus_lbl, userlist_lbl;
		public TableView<String> table;
		TableColumn userIdCol, userNameCol, userRoleCol;
		public ComboBox<String> pc_id, jobstatus;
		public ComboBox<Integer> user_id;
		public Button button_addJob;
		MenuBar menuBar;
		Menu pc_menu, staff_menu;
		public MenuItem menuItem1, menuItem2, menuItem3, staffItem1, staffItem2;
		public Alert alert,alertTech;
	}
	
	private void initializeAlert(AddJobVar addJobVar) {
		addJobVar.alert = new Alert(AlertType.ERROR);
		addJobVar.alert.setTitle("Add Job Error");
		addJobVar.alert.setContentText("All fields must be filled!");
	}
	
	private void initializeAlertTech(AddJobVar addJobVar) {
		addJobVar.alertTech = new Alert(AlertType.ERROR);
		addJobVar.alertTech.setTitle("Add Job Error");
		addJobVar.alertTech.setContentText("User Must Be Technician");
	}
	
	
	private void initialize(AddJobVar addJobVar) {
		addJobVar.bp = new BorderPane();
		addJobVar.gp = new GridPane();
		addJobVar.vb1 = new VBox();
		addJobVar.vb2 = new VBox();
		
		addJobVar.pc_menu = new Menu("PC Management");
		
		addJobVar.menuItem1 = new MenuItem("Add PC"); 
		addJobVar.menuItem2 = new MenuItem("Delete PC"); 
		addJobVar.menuItem3 = new MenuItem("Update PC"); 
		
		addJobVar.pc_menu.getItems().addAll(addJobVar.menuItem1, addJobVar.menuItem2, addJobVar.menuItem3);
		
		addJobVar.staff_menu = new Menu("Staff Management");
		
		addJobVar.staffItem1 = new MenuItem("Add Staff Job"); 
		addJobVar.staffItem2 = new MenuItem("Update Staff Job"); 
		
		addJobVar.staff_menu.getItems().addAll(addJobVar.staffItem1, addJobVar.staffItem2);
		
		addJobVar.menuBar = new MenuBar();
		addJobVar.menuBar.getMenus().addAll(addJobVar.pc_menu, addJobVar.staff_menu);

//		addJobVar.userlist_lbl = new Label("User List : ");
//		addJobVar.table = new TableView<>();
//		
//		addJobVar.userIdCol = new TableColumn<>("User ID");
//		addJobVar.userNameCol = new TableColumn<>("Username");
//		addJobVar.userRoleCol = new TableColumn<>("User Role");
//		
//		addJobVar.table.getColumns().addAll(addJobVar.userIdCol,addJobVar.userNameCol, addJobVar.userRoleCol);
//		
//		addJobVar.userIdCol.
		
		addJobVar.pcid_lbl = new Label("PC ID : ");
		addJobVar.pc_id = new ComboBox<String>();
		addJobVar.userid_lbl = new Label("User ID : ");
		addJobVar.user_id = new ComboBox<Integer>();
		addJobVar.jobstatus_lbl = new Label("Job Status : ");
		addJobVar.jobstatus = new ComboBox<String>();
		addJobVar.jobstatus.getItems().addAll(
				"Complete",
				"UnComplete"
				);
		addJobVar.jobstatus.setValue("Complete");
		addJobVar.button_addJob = new Button("Add Job");

		addJobVar.vb1.getChildren().add(addJobVar.menuBar);
		addJobVar.vb2.getChildren().addAll(addJobVar.userlist_lbl, addJobVar.table, addJobVar.pcid_lbl, addJobVar.pc_id, 
				addJobVar.userid_lbl,addJobVar.user_id ,addJobVar.jobstatus_lbl, addJobVar.jobstatus,
				addJobVar.button_addJob);

		addJobVar.gp.add(addJobVar.vb1, 0, 0);
		addJobVar.gp.add(addJobVar.vb2, 0, 1);

		addJobVar.bp.setCenter(addJobVar.gp);

		addJobVar.scene = new Scene(addJobVar.bp, 600, 600);
	}
	
	private void handle(AddJobVar addJobVar) {
		JobController jobController = new JobController();
		//jobController.handling_showPC(addJobVar);
		jobController.handling_addJob(addJobVar);
		jobController.handling_showUser(addJobVar);
		
		AdminPageController adminPageController = new AdminPageController();
		adminPageController.changeAddJobMenuPage(addJobVar);
	}
	
	public Scene initializeAddJobPage(){
		// TODO Auto-generated method stub
		AddJobVar addJobVar = new AddJobVar();
		initialize(addJobVar);
		initializeAlert(addJobVar);
		initializeAlertTech(addJobVar);
		handle(addJobVar);
		
		return addJobVar.scene;
	}
}
