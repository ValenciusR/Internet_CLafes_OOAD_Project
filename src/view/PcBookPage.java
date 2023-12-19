package view;

import java.sql.Date;
import java.time.LocalDate;

import controller.PageController;
import controller.PcBookPageController;
import controller.UserController;
import controller.UserPageController;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import model.User;
import view.LoginPage.LoginVar;

public class PcBookPage {
	public class PcBookVar {

		Scene scene;
		BorderPane bp;
		GridPane gp;
		VBox vb1, vb2;
		Label title, pc_id_lbl, date_lbl;
		public TextField pc_id_tf;
		public PasswordField pass_pf;
		public Button button_book;
		
		
		public MenuItem menuItem1, menuItem2, menuItem3, menuItem4;
		MenuBar menuBar;
		Menu menu;
		public MenuItem menuItem;
		public Alert alert, emptyAlert;
		public DatePicker date;
//		LocalDate date1;
	}

	private void initializeAlert(PcBookVar pcBookVar) {
		pcBookVar.alert = new Alert(AlertType.ERROR);
		pcBookVar.alert.setTitle("Book PC");
		pcBookVar.alert.setContentText("PC is Unavailable");

		pcBookVar.emptyAlert = new Alert(AlertType.ERROR);
		pcBookVar.emptyAlert.setTitle("Book PC");
		pcBookVar.emptyAlert.setContentText("All fields must be filled!");
	}

	private void initialize(PcBookVar pcBookVar) {
		pcBookVar.bp = new BorderPane();
		pcBookVar.gp = new GridPane();
		pcBookVar.vb1 = new VBox();
		pcBookVar.vb2 = new VBox();
		
		pcBookVar.menu = new Menu("Menu");
		pcBookVar.menuItem1 = new MenuItem("View All PC"); 
		pcBookVar.menuItem2 = new MenuItem("View Transaction History"); 
		pcBookVar.menuItem3 = new MenuItem("Book PC"); 
		pcBookVar.menuItem4 = new MenuItem("Make Report"); 
		pcBookVar.menu.getItems().addAll(pcBookVar.menuItem1, pcBookVar.menuItem2, 
				pcBookVar.menuItem3, pcBookVar.menuItem4);
		
		pcBookVar.menuBar = new MenuBar();
		pcBookVar.menuBar.getMenus().add(pcBookVar.menu);

		pcBookVar.title = new Label("Book PC");
		pcBookVar.date_lbl = new Label("Date");
		pcBookVar.date = new DatePicker();
		pcBookVar.pc_id_lbl = new Label("PC ID");
		pcBookVar.pc_id_tf = new TextField();
//		pcBookVar.password_lbl = new Label("Password");
//		pcBookVar.pass_pf = new PasswordField();

//		pcBookVar.button_regis = new Button("Register Page");
		pcBookVar.button_book = new Button("Book PC");

		pcBookVar.vb1.getChildren().add(pcBookVar.menuBar);
		pcBookVar.vb2.getChildren().addAll( pcBookVar.title, pcBookVar.date_lbl,pcBookVar.date, pcBookVar.pc_id_lbl, 
				pcBookVar.pc_id_tf, pcBookVar.button_book);

		pcBookVar.gp.add(pcBookVar.vb1, 0, 0);
		pcBookVar.gp.add(pcBookVar.vb2, 0, 1);

		pcBookVar.bp.setCenter(pcBookVar.gp);

		pcBookVar.scene = new Scene(pcBookVar.bp, 600, 600);
	}

	private void handle(PcBookVar pcBookVar, User cu) {
		PcBookPageController  pcBookPageController= new PcBookPageController();
		pcBookPageController.handling_book(pcBookVar, cu);
//		
//		PageController pageController = new PageController();
//		pageController.changePageToRegister(loginVar);

		UserPageController userPageController = new UserPageController();
		userPageController.changeHomeMenuPage(pcBookVar, cu);
	}

	public Scene initializePcBookPage(User cu) {
		// TODO Auto-generated method stub
		PcBookVar pcBookVar = new PcBookVar();
		initialize(pcBookVar);
		initializeAlert(pcBookVar);
		handle(pcBookVar, cu);
		return pcBookVar.scene;
	}

}
