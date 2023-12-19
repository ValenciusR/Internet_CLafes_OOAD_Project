package view;

import controller.PageController;
import controller.ReportController;
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
import view.LoginPage.LoginVar;
import view.RegisterPage.RegisterVar;

public class ReportFormPage {
	
	public class ReportForm {
		Scene scene;
		BorderPane bp;
		GridPane gp;
		VBox vb1, vb2;
		Label title, role_lbl, pcid_lbl, note_lbl;
		
		
		public TextField note_tf, pcid_tf;
		public Alert alertEmpty, alertSameID;
		public Button back_btn, submit_btn;
		
		MenuBar menuBar;
		Menu menu;
		public MenuItem menuItem;
		
	}
	
	private void initializeAlertEmpty(ReportForm rf) {
		rf.alertEmpty = new Alert(AlertType.ERROR);
		rf.alertEmpty.setTitle("Empty Fields");
		rf.alertEmpty.setContentText("All fields must be filled.");
	}
	
	private void initializeAlertSameID(ReportForm rf) {
		rf.alertSameID = new Alert(AlertType.ERROR);
		rf.alertSameID.setTitle("Invalid PC ID");
		rf.alertSameID.setContentText("This PC doesn't exist.");
	}
	
	private void initialize(ReportForm rf) {
		rf.bp = new BorderPane();
		rf.gp = new GridPane();
		rf.vb1 = new VBox();
		rf.vb2 = new VBox();

		rf.title = new Label("Make Report");
		rf.pcid_lbl = new Label("PC ID");
		rf.note_lbl = new Label("Note");
		
		rf.pcid_tf = new TextField();
		rf.note_tf = new TextField();
		
		rf.back_btn = new Button("Return to Register Page");
		rf.submit_btn = new Button("Submit");
		
//		rf.datePicker = new DatePicker();

		rf.vb1.getChildren().add(rf.title);
		rf.vb2.getChildren().addAll(rf.pcid_lbl, rf.pcid_tf, rf.note_lbl, rf.note_tf,
				rf.submit_btn, rf.back_btn);

		rf.gp.add(rf.vb1, 0, 0);
		rf.gp.add(rf.vb2, 0, 1);

		rf.bp.setCenter(rf.gp);

		rf.scene = new Scene(rf.bp, 600, 600);
	}
	
	private void handle(ReportForm rf, LoginVar lv) {
		// TODO Auto-generated method stub
		ReportController rc = new ReportController();
		rc.handling_addReport(rf, lv);
		
		PageController pc = new PageController();
		pc.changePageToRegister(rf);
		
	}
	
	public Scene initializeReportFormPage(LoginVar lv) {
		ReportForm rf = new ReportForm();
		
		initialize(rf);
		initializeAlertEmpty(rf);
		initializeAlertSameID(rf);
		handle(rf, lv);
		
		return rf.scene;
	}

	

}
