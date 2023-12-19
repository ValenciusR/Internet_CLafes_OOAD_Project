package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import model.Job;

public class JobModel {
	public void addJob(Job job) {
		Connect con = Connect.getInstance();
		
		String query = "INSERT INTO job VALUES(?,?,?,?)";
		
		PreparedStatement ps = con.prepareStatment(query);
		
		
		try {
			ps.setInt(1, job.getJobID());
			ps.setInt(2, job.getUserID());
			ps.setString(3, job.getPC_ID());
			ps.setString(4, job.getJobStatus());
			
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateJob(String jobstatus, Integer jobId) {
		Connect con = Connect.getInstance();
		
		String query = "UPDATE job SET JobStatus=? WHERE Job_ID = ?";
		
		PreparedStatement ps = con.prepareStatment(query);
		
		
		try {
			ps.setString(1, jobstatus);
			ps.setInt(2, jobId);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void updateJobTech(String jobstatus, String pc_ID) {
		Connect con = Connect.getInstance();
		
		String query = "UPDATE job SET JobStatus=? WHERE PC_ID = ?";
		
		PreparedStatement ps = con.prepareStatment(query);
		
		
		try {
			ps.setString(1, jobstatus);
			ps.setString(2, pc_ID);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void deleteJob(String pc_ID) {
		Connect con = Connect.getInstance();
		String query = "DELETE FROM job WHERE PC_ID = ?";
		PreparedStatement ps = con.prepareStatment(query);
		
		try {
			ps.setString(1, pc_ID);
			ps.executeUpdate();
			
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public Vector<Job> getJob() {
		Connect con = Connect.getInstance();
		
		String query = "SELECT * FROM job";
		ResultSet rs = con.selectData(query);
		Vector<Job> vectJob = new Vector<>();
		
		try {
			while(rs.next()) {
				vectJob.add(new Job(rs.getInt("Job_ID"),
									rs.getInt("UserID"),
									rs.getString("PC_ID"),
									rs.getString("JobStatus") 
									));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return vectJob;
	}
	
//	public Vector<Job> getJobTech() {
//		Connect con = Connect.getInstance();
//		
//		String query = "SELECT * FROM job";
//		ResultSet rs = con.selectData(query);
//		Vector<Job> vectJob = new Vector<>();
//		
//		try {
//			while(rs.next()) {
//				vectJob.add(new Job(
//									rs.getString("PC_ID"),
//									rs.getString("JobStatus") 
//									));
//			}
//		}catch(SQLException e) {
//			e.printStackTrace();
//		}
//		
//		return vectJob;
//	}
}