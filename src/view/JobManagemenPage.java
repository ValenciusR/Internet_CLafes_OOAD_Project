package view;

import controller.AdminPageController;
import controller.JobController;
import controller.PcController;
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
import model.Job;


public class JobManagemenPage {
	public class JobManagementVar{
		Scene scene;
		BorderPane bp;
		GridPane gp;
		VBox vb1, vb2;
		Label addJob_lbl, addUserId_lbl,addJob_pcid_lbl, updateJob_lbl, updateJob_id_lbl, updateJob_status_lbl;
		public TableView<Job> table;
		public TableColumn<Job, Integer> job_idCol;
		public TableColumn<Job, Integer> user_idCol;
		public TableColumn<Job, String> pc_idCol;
		public TableColumn<Job, String> job_statusCol;
		public ComboBox<String> addJobPCID, addJobUserID, updateJob_ID,updateJob_Status;
		public TextField addPCID_tf;
		public Button button_addJob, button_deletePc, button_updateJob;
		MenuBar menuBar;
		Menu menu;
		public MenuItem pcItem, jobItem, staffItem;
		public Alert addAlert, idExistAlert;
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	private void initialize(JobManagementVar jobManagementVar) {
		jobManagementVar.bp = new BorderPane();
		jobManagementVar.gp = new GridPane();
		jobManagementVar.vb1 = new VBox();
		jobManagementVar.vb2 = new VBox();
		
		jobManagementVar.menu = new Menu("Menu");
		
		jobManagementVar.pcItem = new MenuItem("PC Management"); 
		jobManagementVar.jobItem = new MenuItem("Job Management"); 
		jobManagementVar.staffItem = new MenuItem("Staff Management"); 
		
		jobManagementVar.menu.getItems().addAll(jobManagementVar.pcItem, jobManagementVar.jobItem,jobManagementVar.staffItem  );
		
		jobManagementVar.menuBar = new MenuBar();
		
		jobManagementVar.menuBar.getMenus().addAll(jobManagementVar.menu);
		
		jobManagementVar.table = new TableView<Job>();
		jobManagementVar.job_idCol = new TableColumn<Job, Integer>("Job ID");
		jobManagementVar.user_idCol = new TableColumn<Job, Integer>("User ID");
		jobManagementVar.pc_idCol = new TableColumn<Job, String>("PC ID");
		jobManagementVar.job_statusCol = new TableColumn<Job, String>("Job Status");
		jobManagementVar.table.getColumns().addAll(jobManagementVar.job_idCol, jobManagementVar.user_idCol, jobManagementVar.pc_idCol,jobManagementVar.job_statusCol);

		jobManagementVar.addJob_lbl = new Label("Add New Job");
		jobManagementVar.addUserId_lbl = new Label("User ID : ");
		jobManagementVar.addJobUserID = new ComboBox<>();
		jobManagementVar.addJob_pcid_lbl = new Label("PC ID : ");
		jobManagementVar.addJobPCID = new ComboBox<>();
		jobManagementVar.button_addJob = new Button("Add Job");
		
		jobManagementVar.updateJob_lbl = new Label("Update Job");
		jobManagementVar.updateJob_id_lbl = new Label("Job ID : ");
		jobManagementVar.updateJob_ID = new ComboBox<>();
		jobManagementVar.updateJob_status_lbl = new Label("Job Status : ");
		jobManagementVar.updateJob_Status = new ComboBox<>();
		jobManagementVar.updateJob_Status.getItems().addAll(
				"Complete",
				"UnComplete");
		jobManagementVar.updateJob_Status.setValue("Complete");
		jobManagementVar.button_updateJob = new Button("Update Job");
		
		jobManagementVar.vb1.getChildren().add(jobManagementVar.menuBar);
		jobManagementVar.vb2.getChildren().addAll(jobManagementVar.table, jobManagementVar.addJob_lbl,jobManagementVar.addUserId_lbl, jobManagementVar.addJobUserID, jobManagementVar.addJob_pcid_lbl,jobManagementVar.addJobPCID , jobManagementVar.button_addJob , jobManagementVar.updateJob_lbl, jobManagementVar.updateJob_id_lbl ,jobManagementVar.updateJob_ID, jobManagementVar.updateJob_status_lbl,jobManagementVar.updateJob_Status, jobManagementVar.button_updateJob  );

		jobManagementVar.gp.add(jobManagementVar.vb1, 0, 0);
		jobManagementVar.gp.add(jobManagementVar.vb2, 0, 1);

		jobManagementVar.bp.setCenter(jobManagementVar.gp);

		jobManagementVar.scene = new Scene(jobManagementVar.bp, 600, 600);
	}
	
	private void handle(JobManagementVar jobManagementVar) {
		JobController jobController = new JobController();
		jobController.handling_addJob(jobManagementVar);
		jobController.handling_showJob(jobManagementVar);
		jobController.handling_UpdateJob(jobManagementVar);
		
		UserController userController = new UserController();
		userController.handling_showUser(jobManagementVar);
		
		PcController pcController = new PcController();
		pcController.handling_showPc(jobManagementVar);

		
		AdminPageController adminPageController = new AdminPageController();
		adminPageController.changeJobManagementPage(jobManagementVar);
	}
	
	public Scene initializeJobManagementPage(){
		// TODO Auto-generated method stub
		JobManagementVar jobManagementVar = new JobManagementVar();
		initialize(jobManagementVar);

		handle(jobManagementVar);
		
		return jobManagementVar.scene;
	}
}
