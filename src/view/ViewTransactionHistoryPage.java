package view;

import java.sql.Date;

import controller.AdminPageController;
import controller.TransactionController;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
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
import model.TransactionDetail;
import model.TransactionHeader;

public class ViewTransactionHistoryPage {
	public class ViewTransactionHistoryVar{
		Scene scene;
		BorderPane bp;
		GridPane gp;
		VBox vb1, vb2;
		Label detail_lbl;
		public TableView<TransactionHeader> table;
		public TableView<TransactionDetail> table2;
		public TableColumn<TransactionHeader, Integer> transaction_idCol;
		public TableColumn<TransactionHeader, Integer> staff_idCol;
		public TableColumn<TransactionDetail, String> customer_nameCol;
		public TableColumn<TransactionHeader, String> staff_nameCol;
		public TableColumn<TransactionDetail, String> pc_idCol;
		public TableColumn<TransactionHeader, Date> transaction_dateCol;
		public TableColumn<TransactionDetail, Date> book_timeCol;
		public TextField transactionID_tf;
		public Button button_detail;
		MenuBar menuBar;
		Menu menu;
		public MenuItem pcItem, jobItem, staffItem, reportItem, historyItem;
		public Alert addAlert, idExistAlert;
	}
	
	@SuppressWarnings({ "unchecked", "unused" })
	private void initialize(ViewTransactionHistoryVar viewTransactionHistoryVar) {
		viewTransactionHistoryVar.bp = new BorderPane();
		viewTransactionHistoryVar.gp = new GridPane();
		viewTransactionHistoryVar.vb1 = new VBox();
		viewTransactionHistoryVar.vb2 = new VBox();
		
		viewTransactionHistoryVar.menu = new Menu("Menu");
		
		viewTransactionHistoryVar.pcItem = new MenuItem("PC Management"); 
		viewTransactionHistoryVar.jobItem = new MenuItem("Job Management"); 
		viewTransactionHistoryVar.staffItem = new MenuItem("Staff Management"); 
		viewTransactionHistoryVar.reportItem = new MenuItem("View All Report"); 
		viewTransactionHistoryVar.historyItem = new MenuItem("View All Transaction History"); 
		
		viewTransactionHistoryVar.menu.getItems().addAll(viewTransactionHistoryVar.pcItem, viewTransactionHistoryVar.jobItem,viewTransactionHistoryVar.staffItem, viewTransactionHistoryVar.reportItem, viewTransactionHistoryVar.historyItem);
		
		viewTransactionHistoryVar.menuBar = new MenuBar();
		
		viewTransactionHistoryVar.menuBar.getMenus().addAll(viewTransactionHistoryVar.menu);
		
		viewTransactionHistoryVar.table = new TableView<TransactionHeader>();
		viewTransactionHistoryVar.transaction_idCol = new TableColumn<TransactionHeader, Integer>("Transaction ID");
		viewTransactionHistoryVar.staff_idCol = new TableColumn<TransactionHeader, Integer>("Staff ID");
		viewTransactionHistoryVar.staff_nameCol = new TableColumn<TransactionHeader, String>("Staff Name");
		viewTransactionHistoryVar.transaction_dateCol = new TableColumn<TransactionHeader, Date>("Transaction Date");
		viewTransactionHistoryVar.table.getColumns().addAll(viewTransactionHistoryVar.transaction_idCol,viewTransactionHistoryVar.staff_idCol,viewTransactionHistoryVar.staff_nameCol,viewTransactionHistoryVar.transaction_dateCol);

		viewTransactionHistoryVar.detail_lbl = new Label("Transaction ID : ");
		viewTransactionHistoryVar.transactionID_tf = new TextField();
		viewTransactionHistoryVar.button_detail = new Button("Search Detail");
		
		viewTransactionHistoryVar.table2 = new TableView<TransactionDetail>();
		
		viewTransactionHistoryVar.pc_idCol = new TableColumn<TransactionDetail, String>("PC ID");
		viewTransactionHistoryVar.customer_nameCol = new TableColumn<TransactionDetail, String>("Customer Name");
		viewTransactionHistoryVar.book_timeCol = new TableColumn<TransactionDetail, Date>("Book Time");
		
		viewTransactionHistoryVar.table2.getColumns().addAll(viewTransactionHistoryVar.pc_idCol, viewTransactionHistoryVar.customer_nameCol, viewTransactionHistoryVar.book_timeCol);
		
		viewTransactionHistoryVar.vb1.getChildren().add(viewTransactionHistoryVar.menuBar);
		viewTransactionHistoryVar.vb2.getChildren().addAll(viewTransactionHistoryVar.table, viewTransactionHistoryVar.detail_lbl, viewTransactionHistoryVar.transactionID_tf, viewTransactionHistoryVar.button_detail, viewTransactionHistoryVar.table2);

		viewTransactionHistoryVar.gp.add(viewTransactionHistoryVar.vb1, 0, 0);
		viewTransactionHistoryVar.gp.add(viewTransactionHistoryVar.vb2, 0, 1);

		viewTransactionHistoryVar.bp.setCenter(viewTransactionHistoryVar.gp);

		viewTransactionHistoryVar.scene = new Scene(viewTransactionHistoryVar.bp, 600, 600);
	}
	
	private void handle(ViewTransactionHistoryVar viewTransactionHistoryVar) {
		TransactionController transactionController = new TransactionController();
		transactionController.handling_showTransactionHeader(viewTransactionHistoryVar);
		transactionController.handling_showTransactionDetail(viewTransactionHistoryVar);
		
		AdminPageController adminPageController = new AdminPageController();
		adminPageController.changeViewTransactionHistoryPage(viewTransactionHistoryVar);
	}
	
	
	public Scene initializeViewTransactionHistoryPage(){
		// TODO Auto-generated method stub
		ViewTransactionHistoryVar viewTransactionHistoryVar = new ViewTransactionHistoryVar();
		initialize(viewTransactionHistoryVar);
		handle(viewTransactionHistoryVar);
		
		return viewTransactionHistoryVar.scene;
	}
}
