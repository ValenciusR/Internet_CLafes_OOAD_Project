package view;

import java.sql.Date;

import controller.OperatorPageController;
import controller.PcBookController;
import controller.PcController;
import controller.TransactionController;
import controller.UserController;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
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
import model.PcBook;
import view.LoginPage.LoginVar;

public class OperatorPage {
	
	public class OperatorVar {
		Scene scene;
		BorderPane bp;
		GridPane gp;
		VBox vb1, vb2;

		public TableView<PcBook> table;
		public TableColumn<PcBook, Integer> book_idCol;
		public TableColumn<PcBook, String> pc_idCol;
		public TableColumn<PcBook, Integer> user_idCol;
		public TableColumn<PcBook, Date> date_Col;
		public DatePicker dp, dp2;
		public Label cancel_lbl, finish_lbl, assign_lbl, userIdtobeAssigned_lbl;
		
		public ComboBox<String> pcBook_cb;
		public ComboBox<Integer> userID_cb;
		
		public Button cancelBook, finishBook, assignUser;

		Menu menu, refresh;
		MenuBar menuBar;
		public MenuItem loginItem, registerItem, refreshItem;
		public Alert alertPickedDate, alertBookedPC, alertSuccess;
	}

	@SuppressWarnings("unchecked")
	private void initialize(OperatorVar ov) {
		ov.bp = new BorderPane();
		ov.gp = new GridPane();
		ov.vb1 = new VBox();
		ov.vb2 = new VBox(); 
		ov.cancelBook = new Button("Cancel Book");
		ov.finishBook = new Button("Finish Book");
		ov.assignUser = new Button("Assign User");
		
		ov.dp = new DatePicker();
		ov.dp2 = new DatePicker();
		
		ov.cancel_lbl = new Label("Cancel Book");
		ov.finish_lbl = new Label("Finish Book");
		ov.assign_lbl = new Label("Assign User to Other PC");
		ov.userIdtobeAssigned_lbl = new Label("Input User ID to be Assigned");
		
		ov.loginItem = new MenuItem("Return to Login");
		ov.registerItem = new MenuItem("Return to Register");
		ov.refreshItem = new MenuItem("Refresh");
		
		
		ov.pcBook_cb = new ComboBox<>();
		ov.userID_cb = new ComboBox<>();
		
		ov.menu = new Menu("Menu");
		ov.refresh = new Menu("Refresh");
		
		ov.menu.getItems().addAll(ov.loginItem, ov.registerItem);
		ov.refresh.getItems().addAll(ov.refreshItem);
		
		ov.menuBar = new MenuBar();
		
		ov.menuBar.getMenus().addAll(ov.menu, ov.refresh);
		
		
		ov.table = new TableView<PcBook>();
		ov.book_idCol = new TableColumn<PcBook, Integer>("Book ID");
		ov.pc_idCol = new TableColumn<PcBook, String>("PC ID");
		ov.user_idCol = new TableColumn<PcBook, Integer>("User ID");
		ov.date_Col = new TableColumn<PcBook, Date>("Booked Date");
		
		ov.table.getColumns().addAll(ov.book_idCol, ov.pc_idCol, 
				ov.user_idCol, ov.date_Col);
		
		ov.vb1.getChildren().add(ov.menuBar);
		ov.vb2.getChildren().addAll(ov.table, ov.cancel_lbl, ov.dp, ov.cancelBook, ov.finish_lbl,
				ov.dp2, ov.finishBook, ov.assign_lbl, ov.pcBook_cb, ov.userIdtobeAssigned_lbl, 
				ov.userID_cb ,ov.assignUser);
		
		ov.gp.add(ov.vb1, 0, 0);
		ov.gp.add(ov.vb2, 0, 1);
		
		ov.bp.setCenter(ov.gp);
		
		ov.scene = new Scene(ov.bp, 600, 600);
	}
	
	private void initializeAlert(OperatorVar ov) {
		ov.alertPickedDate = new Alert(AlertType.ERROR);
		ov.alertPickedDate.setTitle("Date can't be picked!");
		ov.alertPickedDate.setContentText("Booking date hasn't passed today's date, please pick other bookings that has been passed.");
	
		ov.alertBookedPC = new Alert(AlertType.ERROR);
		ov.alertBookedPC.setTitle("PC has already been booked!");
		ov.alertBookedPC.setContentText("PC has been booked by other user, please pick other PC");
	
		ov.alertSuccess = new Alert(AlertType.NONE);
		ov.alertSuccess.setTitle("Successfully assigned user.");
		ov.alertSuccess.setContentText("User has been successfully assigned to an available PC");
	}
	
	private void handle(OperatorVar ov, LoginVar lv) {
		PcBookController pbc = new PcBookController();
		TransactionController tc = new TransactionController();
		OperatorPageController opc = new OperatorPageController();
		
		pbc.handling_showBookedPC(ov);
		tc.handling_addTransaction(ov,lv);
		pbc.handling_cancelBook(ov);
		
		pbc.handling_showassignUser(ov);
		pbc.handling_assignUser(ov);
		
		opc.backtoLogin(ov);
		opc.backtoRegister(ov);
		opc.refresh(ov,lv);
		
	}
	
	public Scene initializeOperatorPage(LoginVar lv) {
		OperatorVar ov = new OperatorVar();
		
		initialize(ov);
		initializeAlert(ov);
		handle(ov, lv);
		
		return ov.scene;
	}
}
