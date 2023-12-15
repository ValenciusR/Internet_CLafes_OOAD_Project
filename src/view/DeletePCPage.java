package view;

import controller.AdminPageController;
import controller.PcController;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;

public class DeletePCPage {
	public class DeletePCVar {
		Scene scene;
		BorderPane bp;
		GridPane gp;
		VBox vb1, vb2;
		Label title, id_lbl;
		public ComboBox<String> pc_id;
		public Button button_deletePc;
		MenuBar menuBar;
		Menu pc_menu;
		public MenuItem menuItem1, menuItem2, menuItem3;
		public Alert alert;
	}
	
	private void initializeAlert(DeletePCVar deletePCVar) {
		deletePCVar.alert = new Alert(AlertType.ERROR);
		deletePCVar.alert.setTitle("Delete PC Error");
		deletePCVar.alert.setContentText("Please choose PC ID!");
	}

	
	private void initialize(DeletePCVar deletePCVar) {
		deletePCVar.bp = new BorderPane();
		deletePCVar.gp = new GridPane();
		deletePCVar.vb1 = new VBox();
		deletePCVar.vb2 = new VBox();
		
		deletePCVar.pc_menu = new Menu("PC Management");
		
		deletePCVar.menuItem1 = new MenuItem("Add PC"); 
		deletePCVar.menuItem2 = new MenuItem("Delete PC"); 
		deletePCVar.menuItem3 = new MenuItem("Update PC"); 
		
		deletePCVar.pc_menu.getItems().addAll(deletePCVar.menuItem1, deletePCVar.menuItem2, deletePCVar.menuItem3);
		
		deletePCVar.menuBar = new MenuBar();
		deletePCVar.menuBar.getMenus().add(deletePCVar.pc_menu);

		deletePCVar.title = new Label("Delete PC");
		deletePCVar.id_lbl = new Label("ID : ");
		deletePCVar.pc_id = new ComboBox<String>();
		
		deletePCVar.button_deletePc = new Button("Delete PC");

		deletePCVar.vb1.getChildren().add(deletePCVar.menuBar);
		deletePCVar.vb2.getChildren().addAll(deletePCVar.id_lbl, deletePCVar.pc_id, deletePCVar.button_deletePc);

		deletePCVar.gp.add(deletePCVar.vb1, 0, 0);
		deletePCVar.gp.add(deletePCVar.vb2, 0, 1);

		deletePCVar.bp.setCenter(deletePCVar.gp);

		deletePCVar.scene = new Scene(deletePCVar.bp, 600, 600);
	}
	
	private void handle(DeletePCVar deletePCVar) {
		PcController pcController = new PcController();
		pcController.handling_showPc(deletePCVar);
		pcController.handling_deletePc(deletePCVar);
		
		
		AdminPageController adminPageController = new AdminPageController();
		adminPageController.changeDeletePCMenuPage(deletePCVar);
	}
	
	public Scene initializeDeletePCPage(){
		// TODO Auto-generated method stub
		DeletePCVar deletePCVar = new DeletePCVar();
		initialize(deletePCVar);
		initializeAlert(deletePCVar);
		handle(deletePCVar);
		
		return deletePCVar.scene;
	}
}
