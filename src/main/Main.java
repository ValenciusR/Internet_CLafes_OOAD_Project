package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.AddPCPage;
import view.AdminHomePage;

public class Main extends Application{
	public static Stage stage;
	
	public static void changeScene(Scene s) {
		if (stage == null)
			return;
		stage.setScene(s);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		stage = primaryStage;
//		Main.changeScene(new AddPCPage().initializeAddPCPage());
		Main.changeScene(new AdminHomePage().initializeAdminPage());
		
		stage.setTitle("Application");
		stage.show();
	}
	

	

}
