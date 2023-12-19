package main;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;
import view.PCManagementPage;
import view.JobManagementPage;
import view.LoginPage;
import view.OperatorPage;
import view.RegisterPage;
import view.ReportFormPage;
import view.TechnicianPage;


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

//		Main.changeScene(new JobManagementPage().initializeJobManagementPage());
//		Main.changeScene(new TechnicianPage().initializeTechnicianPage());
//		Main.changeScene(new OperatorPage().initializeOperatorPage());
//		Main.changeScene(new ReportFormPage().initializeReportFormPage());

//		Main.changeScene(new HomePage().initializeHomePage());
//		Main.changeScene(new RegisterPage().initializeRegisterPage());
		Main.changeScene(new LoginPage().initializeLoginPage());
//		Main.changeScene(new AddPCPage().initializeAddPCPage());
//		Main.changeScene(new PCManagementPage().initializePCManagementPage());

		stage.setTitle("Application");
		stage.show();
	}
	

	

}
