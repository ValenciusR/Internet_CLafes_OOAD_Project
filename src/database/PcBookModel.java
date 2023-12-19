package database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Vector;

import model.Book;
import model.Pc;
import model.User;
import view.PcBookPage.PcBookVar;

public class PcBookModel {
	public void book(Book book) {
		Connect con = Connect.getInstance();

		String query = "INSERT INTO pcbook VALUES(?,?,?,?)";

		PreparedStatement ps = con.prepareStatment(query);
//		LocalDate date = pcBookVar.date.getValue();
//		java.sql.Date sqlDate = java.sql.Date.valueOf(date);
		try {
			
			ps.setInt(1, book.getBookID());
			ps.setString(2, book.getPC_ID());
			ps.setInt(3, book.getUserID());
			ps.setDate(4, book.getDate());

			ps.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Vector<Book> getBook() {
		Connect con = Connect.getInstance();

		String query = "SELECT * FROM pcbook";
		ResultSet rs = con.selectData(query);
		Vector<Book> vectBook = new Vector<>();

		try {
			while (rs.next()) {
				vectBook.add(new Book(rs.getInt("BookID"), rs.getString("PC_ID"), 
						rs.getInt("UserID"), rs.getDate("BookedDate")));

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return vectBook;
	}
}

