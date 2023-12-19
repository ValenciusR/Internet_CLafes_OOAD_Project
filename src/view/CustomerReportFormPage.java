package view;

import controller.PageController;
import controller.ReportController;
import controller.UserPageController;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.User;
import view.RegisterPage.RegisterVar;

public class CustomerReportFormPage {
	
	public class ReportFormVar {
		Scene scene;
		BorderPane bp;
		GridPane gp;
		VBox vb1, vb2;
		Label title, role_lbl, pcid_lbl, note_lbl;
		
		
		public TextField note_tf, pcid_tf;
		public Alert alertEmpty, alertSameID;
		public Button back_btn, submit_btn;
	
		public MenuItem menuItem1, menuItem2, menuItem3, menuItem4;
		MenuBar menuBar;
		Menu menu;
		
	}
	
	private void initializeAlertEmpty(ReportFormVar rf) {
		rf.alertEmpty = new Alert(AlertType.ERROR);
		rf.alertEmpty.setTitle("Empty Fields");
		rf.alertEmpty.setContentText("All fields must be filled.");
	}
	
	private void initializeAlertSameID(ReportFormVar rf) {
		rf.alertSameID = new Alert(AlertType.ERROR);
		rf.alertSameID.setTitle("Invalid PC ID");
		rf.alertSameID.setContentText("This PC doesn't exist.");
	}
	
	private void initialize(ReportFormVar rf) {
		rf.bp = new BorderPane();
		rf.gp = new GridPane();
		rf.vb1 = new VBox();
		rf.vb2 = new VBox();
		
		
		rf.menu = new Menu("Menu");
		rf.menuItem1 = new MenuItem("View All PC"); 
		rf.menuItem2 = new MenuItem("View Transaction History"); 
		rf.menuItem3 = new MenuItem("Book PC"); 
		rf.menuItem4 = new MenuItem("Make Report"); 
		rf.menu.getItems().addAll(rf.menuItem1, rf.menuItem2, 
				rf.menuItem3, rf.menuItem4);
		
		rf.menuBar = new MenuBar();
		rf.menuBar.getMenus().add(rf.menu);

		rf.title = new Label("Make Report");
		rf.pcid_lbl = new Label("PC ID");
		rf.note_lbl = new Label("Note");
		
		rf.pcid_tf = new TextField();
		rf.note_tf = new TextField();
		
		//rf.back_btn = new Button("Return to Register Page");
		rf.submit_btn = new Button("Submit");
		
//		rf.datePicker = new DatePicker();

		rf.vb1.getChildren().add(rf.menuBar);
		rf.vb2.getChildren().addAll(rf.title, rf.pcid_lbl, rf.pcid_tf, rf.note_lbl, rf.note_tf,
				rf.submit_btn);

		rf.gp.add(rf.vb1, 0, 0);
		rf.gp.add(rf.vb2, 0, 1);

		rf.bp.setCenter(rf.gp);

		rf.scene = new Scene(rf.bp, 600, 600);
	}
	
	private void handle(ReportFormVar rf, User cu) {
		// TODO Auto-generated method stub
		ReportController rc = new ReportController();
		rc.handling_addReport(rf);

		UserPageController userPageController = new UserPageController();
		userPageController.changeHomeMenuPage(rf, cu);
		
	}
	
	public Scene initializeReportFormPage(User cu) {
		ReportFormVar rf = new ReportFormVar();
		initialize(rf);
		initializeAlertEmpty(rf);
		initializeAlertSameID(rf);
		handle(rf, cu);
		
		return rf.scene;
	}

	

}
