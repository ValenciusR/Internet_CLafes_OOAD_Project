package controller;

import main.Main;
import view.AddPCPage;
import view.AddPCPage.AddPCVar;
import view.AdminHomePage.AdminHomeVar;
import view.DeletePCPage;
import view.DeletePCPage.DeletePCVar;
import view.UpdatePCPage;
import view.UpdatePCPage.UpdatePCVar;

public class AdminPageController {

	public void changeHomeMenuPage(AdminHomeVar adminHomeVar) {
		adminHomeVar.menuItem1.setOnAction(e->{
			Main.changeScene(new AddPCPage().initializeAddPCPage());
		});
		adminHomeVar.menuItem2.setOnAction(e->{
			Main.changeScene(new DeletePCPage().initializeDeletePCPage());
		});
		adminHomeVar.menuItem3.setOnAction(e->{
			Main.changeScene(new UpdatePCPage().initializeUpdatePCPage());
		});
	}
	
	public void changeAddPCMenuPage(AddPCVar addPCVar) {
		addPCVar.menuItem1.setOnAction(e->{
			Main.changeScene(new AddPCPage().initializeAddPCPage());
		});
		addPCVar.menuItem2.setOnAction(e->{
			Main.changeScene(new DeletePCPage().initializeDeletePCPage());
		});
		addPCVar.menuItem3.setOnAction(e->{
			Main.changeScene(new UpdatePCPage().initializeUpdatePCPage());
		});
	}
	
	public void changeDeletePCMenuPage(DeletePCVar deletePCVar) {
		deletePCVar.menuItem1.setOnAction(e->{
			Main.changeScene(new AddPCPage().initializeAddPCPage());
		});
		deletePCVar.menuItem2.setOnAction(e->{
			Main.changeScene(new DeletePCPage().initializeDeletePCPage());
		});
		deletePCVar.menuItem3.setOnAction(e->{
			Main.changeScene(new UpdatePCPage().initializeUpdatePCPage());
		});
	}
	
	public void changeUpdatePCMenuPage(UpdatePCVar updatePCVar) {
		updatePCVar.menuItem1.setOnAction(e->{
			Main.changeScene(new AddPCPage().initializeAddPCPage());
		});
		updatePCVar.menuItem2.setOnAction(e->{
			Main.changeScene(new DeletePCPage().initializeDeletePCPage());
		});
		updatePCVar.menuItem3.setOnAction(e->{
			Main.changeScene(new UpdatePCPage().initializeUpdatePCPage());
		});
		
	}
}
