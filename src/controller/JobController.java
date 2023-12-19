package controller;

import database.JobModel;
import database.PcModel;
import javafx.scene.control.cell.PropertyValueFactory;
import main.Main;
import model.Job;
import model.Pc;
import view.JobManagementPage;
import view.JobManagementPage.JobManagementVar;
import view.TechnicianPage;
import view.TechnicianPage.TechnicianVar;

public class JobController {
	JobModel jobModel = new JobModel();

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
		     jobModel.addJob(new Job(id,userId, pc_id, "UnComplete"));
		     Main.changeScene(new JobManagementPage().initializeJobManagementPage());
		     
		    }else {
		     for (Job job : new JobModel().getJob()) {
		      if(job.getPC_ID().equals(pc_id) && job.getJobStatus().equals("UnComplete")) {
		       jobManagementVar.doingJobAlert.showAndWait();
		       return;
		      }else {
		       jobModel.addJob(new Job(id,userId, pc_id, "UnComplete"));
		       Main.changeScene(new JobManagementPage().initializeJobManagementPage());
		       return;
		      }
		     } 
		    };};});}

		   

	public void handling_UpdateJob(JobManagementVar jobManagementVar) {
		jobManagementVar.button_updateJob.setOnAction(e -> {
			int jobId = Integer.parseInt(jobManagementVar.updateJob_ID.getValue());
			String jobstatus = jobManagementVar.updateJob_Status.getValue();

			if (jobstatus.length() <= 0 || jobId <= 0) {
			} else {
				jobModel.updateJob(jobstatus, jobId);
				Main.changeScene(new JobManagementPage().initializeJobManagementPage());
			}
		});
	}

	// complete button
	public void handling_completeJob(TechnicianVar techVar) {
		techVar.button_completeJob.setOnAction(e -> {
			String pc_ID = techVar.selectPCID_cb.getValue();
			String jobstatus = "Complete";
			jobModel.updateJobTech(jobstatus, pc_ID);

			Main.changeScene(new TechnicianPage().initializeTechnicianPage());
		});
	}

	// ini buat nampilin data di combobox
	public void handling_showPcJob(TechnicianVar techVar) {
		for (Job job : new JobModel().getJob()) {
			techVar.selectPCID_cb.getItems().add(job.getPC_ID());
		}
	}

	// perhatiin ini
	public void handling_showJob(TechnicianVar techVar) {
		for (Job job : new JobModel().getJob()) {
			techVar.table.getItems().add(job);
		}
		techVar.pc_idCol.setCellValueFactory(new PropertyValueFactory<Job, String>("PC_ID"));
		techVar.job_statusCol.setCellValueFactory(new PropertyValueFactory<Job, String>("JobStatus"));
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