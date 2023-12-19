package view;

import java.sql.Date;

import controller.TransactionController;
import controller.UserPageController;
//import controller.TransactionHistoryController;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.Pc;
import model.TransactionHistory;
import model.User;
import view.ViewAllPcPage.ViewAllPcVar;

public class ViewTransactionHistoryPage {

	public class ViewTransactionHistoryVar {
		Scene scene;
		BorderPane bp;
		GridPane gp;
		VBox vb1, vb2;
		public TableView<TransactionHistory> tvTH;
		public TableColumn<TransactionHistory, Integer> TiD_col;
		public TableColumn<TransactionHistory, String> pc_id_col;
		public TableColumn<TransactionHistory, String> customer_name_col;
		public TableColumn<TransactionHistory, Date> book_time_col;
		Label title, username_lbl, password_lbl, age_lbl;
		public TextField username_tf;
		public PasswordField pass_pf;
		public Spinner<Integer> age_spin;
		public Button button_regis, button_login;
		MenuBar menuBar;
		Menu menu;
		public MenuItem menuItem1, menuItem2, menuItem3, menuItem4;
	}

	@SuppressWarnings("unchecked")
	private void initialize(ViewTransactionHistoryVar viewTransactionHistoryVar) {
		viewTransactionHistoryVar.bp = new BorderPane();
		viewTransactionHistoryVar.gp = new GridPane();
		viewTransactionHistoryVar.vb1 = new VBox();
		viewTransactionHistoryVar.vb2 = new VBox();

		viewTransactionHistoryVar.menu = new Menu("Menu");

		viewTransactionHistoryVar.menuItem1 = new MenuItem("View All PC");
		viewTransactionHistoryVar.menuItem2 = new MenuItem("View Transaction History");
		viewTransactionHistoryVar.menuItem3 = new MenuItem("Book PC");
		viewTransactionHistoryVar.menuItem4 = new MenuItem("Make Report");

		viewTransactionHistoryVar.menu.getItems().addAll(viewTransactionHistoryVar.menuItem1,
				viewTransactionHistoryVar.menuItem2, viewTransactionHistoryVar.menuItem3,
				viewTransactionHistoryVar.menuItem4);

		viewTransactionHistoryVar.menuBar = new MenuBar();
		viewTransactionHistoryVar.menuBar.getMenus().add(viewTransactionHistoryVar.menu);

		viewTransactionHistoryVar.title = new Label("Welcome to View Transaction History Page");

		viewTransactionHistoryVar.tvTH = new TableView<TransactionHistory>();
		viewTransactionHistoryVar.TiD_col = new TableColumn<>("Transaction ID");
		viewTransactionHistoryVar.pc_id_col = new TableColumn<>("PC ID");
		viewTransactionHistoryVar.customer_name_col = new TableColumn<>("Customer Name");
		viewTransactionHistoryVar.book_time_col = new TableColumn<>("Book Time");
		viewTransactionHistoryVar.tvTH.getColumns().addAll(viewTransactionHistoryVar.TiD_col,
				viewTransactionHistoryVar.pc_id_col, viewTransactionHistoryVar.customer_name_col,
				viewTransactionHistoryVar.book_time_col);

		viewTransactionHistoryVar.vb1.getChildren().add(viewTransactionHistoryVar.menuBar);
		viewTransactionHistoryVar.vb2.getChildren().addAll(viewTransactionHistoryVar.title,
				viewTransactionHistoryVar.tvTH);

		viewTransactionHistoryVar.gp.add(viewTransactionHistoryVar.vb1, 0, 0);
		viewTransactionHistoryVar.gp.add(viewTransactionHistoryVar.vb2, 0, 1);

		viewTransactionHistoryVar.bp.setCenter(viewTransactionHistoryVar.gp);

		viewTransactionHistoryVar.scene = new Scene(viewTransactionHistoryVar.bp, 600, 600);
	}

	public void handle(ViewTransactionHistoryVar viewTransactionHistoryVar, User cu) {
		TransactionController transactionController = new TransactionController();
		transactionController.handling_showTransactiontoTable(viewTransactionHistoryVar, cu);
		
		UserPageController userPageController = new UserPageController();
		userPageController.changeHomeMenuPage(viewTransactionHistoryVar, cu);
		
	}
	public Scene initializeTransactionHistoryPage(User cu) {
		ViewTransactionHistoryVar viewTransactionHistoryVar = new ViewTransactionHistoryVar();
		initialize(viewTransactionHistoryVar);
		handle(viewTransactionHistoryVar, cu);
		return viewTransactionHistoryVar.scene;

	}
}
