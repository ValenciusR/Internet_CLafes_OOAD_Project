package database;

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
}
