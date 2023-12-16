package controller;

import database.JobModel;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Main;
import model.Job;
import view.JobManagemenPage;
import view.JobManagemenPage.JobManagementVar;

public class JobController {
	JobModel jobModel = new JobModel();
	
	public void handling_addJob(JobManagementVar jobManagementVar) {
		jobManagementVar.button_addJob.setOnAction(e->{
			int id = 0;
			String pc_id = jobManagementVar.addJobPCID.getValue();
			int userId = Integer.parseInt(jobManagementVar.addJobUserID.getValue());
			
			if(pc_id.length() <= 0 || userId <= 0 ) {
			} else {
				jobModel.addJob(new Job(id,userId, pc_id, "Uncomplete"));
				Main.changeScene(new JobManagemenPage().initializeJobManagementPage());
			}
		});
	}
	
	public void handling_UpdateJob(JobManagementVar jobManagementVar) {
		jobManagementVar.button_updateJob.setOnAction(e->{
			int jobId = Integer.parseInt(jobManagementVar.updateJob_ID.getValue());
			String jobstatus = jobManagementVar.updateJob_Status.getValue();
			
			if(jobstatus.length() <= 0 || jobId <= 0 ) {
			} else {
				jobModel.updateJob(jobstatus, jobId);
				Main.changeScene(new JobManagemenPage().initializeJobManagementPage());
			}
		});
	}
	
	public void handling_showJob(JobManagementVar jobManagementVar) {
		for (Job job : new JobModel().getJob()) {
			jobManagementVar.table.getItems().add(job);
			jobManagementVar.updateJob_ID.getItems().add(Integer.toString(job.getJobID()));
		}
		
		jobManagementVar.job_idCol.setCellValueFactory(new PropertyValueFactory<Job, Integer>("JobID"));
		jobManagementVar.user_idCol.setCellValueFactory(new PropertyValueFactory<Job, Integer>("UserID"));
		jobManagementVar.pc_idCol.setCellValueFactory(new PropertyValueFactory<Job, String>("PC_ID"));
		jobManagementVar.job_statusCol.setCellValueFactory(new PropertyValueFactory<Job, String>("JobStatus"));
	}
	
	
}
