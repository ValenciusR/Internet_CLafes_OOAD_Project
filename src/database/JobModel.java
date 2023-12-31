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
}
