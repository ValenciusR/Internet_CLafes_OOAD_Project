package view;

import controller.AdminPageController;
import controller.UserController;
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
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.User;

public class StaffManagementPage {
	public class StaffManagementVar{
		Scene scene;
		BorderPane bp;
		GridPane gp;
		VBox vb1, vb2;
		Label updateUserRole_lbl, updateUserId_lbl,updateUser_lbl;
		public TableView<User> table;
		public TableColumn<User, Integer> user_ageCol;
		public TableColumn<User, Integer> user_idCol;
		public TableColumn<User, String> user_nameCol;
		public TableColumn<User, String> user_roleCol;
		public ComboBox<String> updateUserRole;
		public TextField updateUserID_tf;
		public Button button_updateRole;
		MenuBar menuBar;
		Menu menu;
		public MenuItem pcItem, jobItem, staffItem, reportItem, historyItem ;
		public Alert addAlert, idExistAlert;
	}
	
	@SuppressWarnings("unchecked")
	private void initialize(StaffManagementVar staffManagementVar) {
		staffManagementVar.bp = new BorderPane();
		staffManagementVar.gp = new GridPane();
		staffManagementVar.vb1 = new VBox();
		staffManagementVar.vb2 = new VBox();
		
		staffManagementVar.menu = new Menu("Menu");
		
		staffManagementVar.pcItem = new MenuItem("PC Management"); 
		staffManagementVar.jobItem = new MenuItem("Job Management"); 
		staffManagementVar.staffItem = new MenuItem("Staff Management");
		staffManagementVar.reportItem = new MenuItem("View All Report");
		staffManagementVar.historyItem = new MenuItem("View All Transaction History");
		
		staffManagementVar.menu.getItems().addAll(staffManagementVar.pcItem, staffManagementVar.jobItem,staffManagementVar.staffItem, staffManagementVar.reportItem,staffManagementVar.historyItem);
		
		staffManagementVar.menuBar = new MenuBar();
		
		staffManagementVar.menuBar.getMenus().addAll(staffManagementVar.menu);
		
		staffManagementVar.table = new TableView<User>();
		staffManagementVar.user_idCol = new TableColumn<User, Integer>("User ID");
		staffManagementVar.user_nameCol = new TableColumn<User, String>("UserName");
		staffManagementVar.user_ageCol = new TableColumn<User, Integer>("User Age");
		staffManagementVar.user_roleCol = new TableColumn<User, String>("User Role");
		staffManagementVar.table.getColumns().addAll(staffManagementVar.user_idCol,staffManagementVar.user_nameCol,staffManagementVar.user_ageCol, staffManagementVar.user_roleCol );

		staffManagementVar.updateUser_lbl = new Label("Change User Role");
		staffManagementVar.updateUserId_lbl = new Label("User ID : ");
		staffManagementVar.updateUserID_tf = new TextField();
		staffManagementVar.updateUserRole_lbl = new Label("Role : ");
		staffManagementVar.updateUserRole = new ComboBox<>();
		staffManagementVar.updateUserRole.getItems().addAll(
				"Admin",
				"Customer",
				"Operator",
				"Computer Technician"
				);
		staffManagementVar.updateUserRole.setValue("Customer");
		staffManagementVar.button_updateRole = new Button("Change Role");
		
		staffManagementVar.vb1.getChildren().add(staffManagementVar.menuBar);
		staffManagementVar.vb2.getChildren().addAll(staffManagementVar.table, staffManagementVar.updateUser_lbl, staffManagementVar.updateUserId_lbl, staffManagementVar.updateUserID_tf , staffManagementVar.updateUserRole_lbl, staffManagementVar.updateUserRole, staffManagementVar.button_updateRole);

		staffManagementVar.gp.add(staffManagementVar.vb1, 0, 0);
		staffManagementVar.gp.add(staffManagementVar.vb2, 0, 1);

		staffManagementVar.bp.setCenter(staffManagementVar.gp);

		staffManagementVar.scene = new Scene(staffManagementVar.bp, 600, 600);
	}
	
	private void handle(StaffManagementVar staffManagementVar) {
		UserController userController = new UserController();
		userController.handling_showStaff(staffManagementVar);
		userController.handling_updateUser(staffManagementVar);
		
		AdminPageController adminPageController = new AdminPageController();
		adminPageController.changeStaffManagementPage(staffManagementVar);
	}
	
	public Scene initializeStaffManagementPage(){
		// TODO Auto-generated method stub
		StaffManagementVar staffManagementVar = new StaffManagementVar();
		initialize(staffManagementVar);
		handle(staffManagementVar);
		
		return staffManagementVar.scene;
	}
}
