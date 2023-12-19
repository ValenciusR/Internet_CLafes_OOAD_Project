package database;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import model.PcBook;

public class PcBookModel {
	public Vector<PcBook> getPcBook() {
		Connect con = Connect.getInstance();
		
		String query = "SELECT * FROM pcbook";
		ResultSet rs = con.selectData(query);
		Vector<PcBook> vectPcBook = new Vector<>();
		
		try {
			while(rs.next()) {
				vectPcBook.add(new PcBook(rs.getInt("BookID"),
									  rs.getString("PC_ID"),
									  rs.getInt("UserID"),
									  rs.getDate("BookedDate")));
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return vectPcBook;
	}
	
	public Vector<PcBook> getBookedPC() {
		Connect con = Connect.getInstance();

		String query = "SELECT * FROM pcbook";
		ResultSet rs = con.selectData(query);
		Vector<PcBook> pb = new Vector<>();

		try {
			while (rs.next()) {
				pb.add(new PcBook(rs.getInt("BookID"), 
						rs.getString("PC_ID"),
						rs.getInt("UserID"), 
						rs.getDate("BookedDate")));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return pb;
	}
	
	public void book(PcBook book) {
        Connect con = Connect.getInstance();

        String query = "INSERT INTO pcbook VALUES(?,?,?,?)";

        PreparedStatement ps = con.prepareStatment(query);

        try {
            ps.setInt(1, book.getBookID());
            ps.setString(2, book.getPC_ID());
            ps.setInt(3, book.getUserID());
            ps.setDate(4, book.getBookedDate());

            ps.executeUpdate();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
	
	public void cancelBook(Date date) {
		Connect con = Connect.getInstance();
		String query = "DELETE FROM pcbook WHERE BookedDate < ?";
		PreparedStatement ps = con.prepareStatment(query);
		
		try {
			ps.setDate(1, date);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}

	public void finishBook(Date date) {
		// TODO Auto-generated method stub
		Connect con = Connect.getInstance();
		String query = "DELETE FROM pcbook WHERE BookedDate = ?";
		PreparedStatement ps = con.prepareStatment(query);
		
		try {
			ps.setDate(1, date);
			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}
	
	public ResultSet getBookedPCbyPCID(String pc_id) {
		Connect con = Connect.getInstance();
		
		String query = "SELECT * FROM pcbook where PC_ID = ?";
		PreparedStatement ps = con.prepareStatment(query);
		ResultSet rs = null;
		
		try {
			ps.setString(1, pc_id);
			rs = ps.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	public ResultSet getBookedPCbyBookedDate(Date bookedDate) {
		Connect con = Connect.getInstance();
		
		String query = "SELECT * FROM pcbook where BookedDate = ?";
		PreparedStatement ps = con.prepareStatment(query);
		ResultSet rs = null;
		
		try {
			ps.setDate(1, bookedDate);
			rs = ps.executeQuery();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
		return rs;
	}
	
	
}
