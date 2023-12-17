package controller;

import database.JobModel;
import database.PcModel;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Main;
import model.Job;
import model.Pc;
import view.JobManagemenPage;
import view.JobManagemenPage.JobManagementVar;

public class JobController {
	JobModel jobModel = new JobModel();
	PcModel pcModel = new PcModel();
	
	public void handling_addJob(JobManagementVar jobManagementVar) {
		jobManagementVar.button_addJob.setOnAction(e->{
			int id = 0;
			int userId;
			String pc_id = jobManagementVar.addJobPCID.getValue();
			if(jobManagementVar.addJobUserID.getValue() == null) {
				userId = -1;
			}else {
				userId = Integer.parseInt(jobManagementVar.addJobUserID.getValue());
			}
			
			if(pc_id == null || userId <= 0 ) {
				jobManagementVar.addAlert.showAndWait();
			} else {
				if(jobModel.getJob().size() == 0) {
					jobModel.addJob(new Job(id,userId, pc_id, "Uncomplete"));
					Main.changeScene(new JobManagemenPage().initializeJobManagementPage());
					
				}else {
					for (Job job : new JobModel().getJob()) {
						if(job.getPC_ID().equals(pc_id) && job.getJobStatus().equals("UnComplete")) {
							jobManagementVar.doingJobAlert.showAndWait();
						}else {
							jobModel.addJob(new Job(id,userId, pc_id, "Uncomplete"));
							Main.changeScene(new JobManagemenPage().initializeJobManagementPage());
							System.out.println("yy");
						}
					}	
				}

			}
		});
	}
	
	public void handling_UpdateJob(JobManagementVar jobManagementVar) {
		jobManagementVar.button_updateJob.setOnAction(e->{
			int jobId ;
			String jobstatus = jobManagementVar.updateJob_Status.getValue();
			
			if(jobManagementVar.updateJob_ID.getValue() == null) {
				jobId = -1;
			}else {
				jobId = Integer.parseInt(jobManagementVar.updateJob_ID.getValue());
			}
			
			if(jobstatus == null || jobId <= 0 ) {
				jobManagementVar.updateAlert.showAndWait();
				
			} else {
				if(jobstatus.equals("Complete")) {
					for (Job job : new JobModel().getJob()) {
						if(job.getJobID() == jobId) {
							jobModel.updateJob(jobstatus, jobId);
							pcModel.updatePC(new Pc(job.getPC_ID(), "Usable"));
						}
					}
				}else {
					for (Job job : new JobModel().getJob()) {
						if(job.getJobID() == jobId) {
							jobModel.updateJob(jobstatus, jobId);
							pcModel.updatePC(new Pc(job.getPC_ID(), "Maintenance"));
						}
					}
				}
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
