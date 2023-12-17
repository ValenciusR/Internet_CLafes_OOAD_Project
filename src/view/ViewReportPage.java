package view;

import java.sql.Date;

import controller.AdminPageController;
import controller.ReportController;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Report;

public class ViewReportPage {
	public class ViewReportVar{
		Scene scene;
		BorderPane bp;
		GridPane gp;
		VBox vb1, vb2;
		public TableView<Report> table;
		public TableColumn<Report, Integer> report_idCol;
		public TableColumn<Report, String> user_roleCol;
		public TableColumn<Report, String> pc_idCol;
		public TableColumn<Report, String> report_noteCol;
		public TableColumn<Report, Date> report_dateCol;
		MenuBar menuBar;
		Menu menu;
		public MenuItem pcItem, jobItem, staffItem, reportItem, historyItem;
		public Alert addAlert, idExistAlert;
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	private void initialize(ViewReportVar viewReportVar) {
		viewReportVar.bp = new BorderPane();
		viewReportVar.gp = new GridPane();
		viewReportVar.vb1 = new VBox();
		viewReportVar.vb2 = new VBox();
		
		viewReportVar.menu = new Menu("Menu");
		
		viewReportVar.pcItem = new MenuItem("PC Management"); 
		viewReportVar.jobItem = new MenuItem("Job Management"); 
		viewReportVar.staffItem = new MenuItem("Staff Management"); 
		viewReportVar.reportItem = new MenuItem("View All Report"); 
		viewReportVar.historyItem = new MenuItem("View All Transaction History"); 
		
		viewReportVar.menu.getItems().addAll(viewReportVar.pcItem, viewReportVar.jobItem,viewReportVar.staffItem  , viewReportVar.reportItem, viewReportVar.historyItem);
		
		viewReportVar.menuBar = new MenuBar();
		
		viewReportVar.menuBar.getMenus().addAll(viewReportVar.menu);
		
		viewReportVar.table = new TableView<Report>();
		viewReportVar.report_idCol = new TableColumn<Report, Integer>("Report ID");
		viewReportVar.user_roleCol = new TableColumn<Report, String>("User Role");
		viewReportVar.pc_idCol = new TableColumn<Report, String>("PC ID");
		viewReportVar.report_noteCol = new TableColumn<Report, String>("Report Note");
		viewReportVar.report_dateCol = new TableColumn<Report, Date>("Report Date");
		viewReportVar.table.getColumns().addAll(viewReportVar.report_idCol,viewReportVar.user_roleCol,viewReportVar.pc_idCol, viewReportVar.report_noteCol, viewReportVar.report_dateCol);

		viewReportVar.vb1.getChildren().add(viewReportVar.menuBar);
		viewReportVar.vb2.getChildren().addAll(viewReportVar.table);

		viewReportVar.gp.add(viewReportVar.vb1, 0, 0);
		viewReportVar.gp.add(viewReportVar.vb2, 0, 1);

		viewReportVar.bp.setCenter(viewReportVar.gp);

		viewReportVar.scene = new Scene(viewReportVar.bp, 600, 600);
	}
	
	private void handle(ViewReportVar viewReportVar) {
		ReportController reportController = new ReportController();
		reportController.handling_showReport(viewReportVar);

		AdminPageController adminPageController = new AdminPageController();
		adminPageController.changeViewReportPage(viewReportVar);
	}
	
	
	public Scene initializeViewReportPage(){
		// TODO Auto-generated method stub
		ViewReportVar viewReportVar = new ViewReportVar();
		initialize(viewReportVar);
		handle(viewReportVar);
		
		return viewReportVar.scene;
	}
}
