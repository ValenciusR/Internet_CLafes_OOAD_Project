package controller;

import java.sql.Date;

import database.ReportModel;
import javafx.scene.control.cell.PropertyValueFactory;
import model.Report;
import view.ViewReportPage.ViewReportVar;

public class ReportController {
	ReportModel reportModel = new ReportModel();
	
	public void handling_showReport(ViewReportVar viweReportVar) {
		for (Report report : new ReportModel().getReport()) {
			viweReportVar.table.getItems().add(report);
		}
		
		viweReportVar.report_idCol.setCellValueFactory(new PropertyValueFactory<Report, Integer>("Report_ID"));
		viweReportVar.user_roleCol.setCellValueFactory(new PropertyValueFactory<Report, String>("UserRole"));
		viweReportVar.pc_idCol.setCellValueFactory(new PropertyValueFactory<Report, String>("PC_ID"));
		viweReportVar.report_noteCol.setCellValueFactory(new PropertyValueFactory<Report, String>("ReportNote"));
		viweReportVar.report_dateCol.setCellValueFactory(new PropertyValueFactory<Report, Date>("ReportDate"));
	}
}
