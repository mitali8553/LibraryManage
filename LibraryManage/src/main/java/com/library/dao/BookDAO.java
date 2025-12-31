package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.library.model.Book;

public class BookDAO {

	private Connection conn;
	public BookDAO(Connection conn) {
		this.conn = conn;
	}
	
	//Add Book
	public boolean addBook(Book b) {
		boolean f = false;
		try {
			String sql = "INSERT INTO books(book_name, author, category, quantity) VALUES (?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, b.getBookName());
			ps.setString(2, b.getAuthor());
			ps.setString(3, b.getCategory());
			ps.setLong(4, b.getQuantity());
			
			int i = ps.executeUpdate();
			if(i == 1) {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	//View All Books
	public List<Book> getAllBooks() {
		List<Book> list = new ArrayList<Book>();
		try {
			String sql = "SELECT * FROM Books";
			PreparedStatement ps = conn.prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt("id"));
				b.setBookName(rs.getString("book_name"));
				b.setAuthor(rs.getString("author"));
				b.setCategory(rs.getString("category"));
				b.setQuantity(rs.getInt("quantity"));
				list.add(b);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//Issue Book
	public boolean issueBook(int memberId, int bookId) {
	    boolean flag = false;
	    try {
	        String sql1 = "INSERT INTO issued_books(member_id, book_id, issue_date, due_date) VALUES (?,?,CURDATE(),DATE_ADD(CURDATE(),INTERVAL 7 DAY))";
	        String sql2 = "UPDATE books SET quantity = quantity - 1 WHERE id=?";

	        PreparedStatement ps1 = conn.prepareStatement(sql1);
	        ps1.setInt(1, memberId);
	        ps1.setInt(2, bookId);

	        PreparedStatement ps2 = conn.prepareStatement(sql2);
	        ps2.setInt(1, bookId);

	        ps1.executeUpdate();
	        ps2.executeUpdate();

	        flag = true;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return flag;
	}
	
	// quantity
	public boolean bookQuantity(int bookId) {
		boolean f = false;
		try {
			String sql = "UPDATE books SET quantity= quantity + 1 WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bookId);
			
			int i = ps.executeUpdate();
			if(i == 1) {
				f = true;
			}
			}catch(Exception e) {
				e.printStackTrace();
		}
		return f;
	}

	public boolean deleteBook(int id) {
	    boolean flag = false;
	    try {
	        String sql = "DELETE FROM books WHERE id=?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, id);

	        int i = ps.executeUpdate();
	        if (i == 1) flag = true;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return flag;
	}
	
	public Book getBookById(int id) {
	    Book b = null;
	    try {
	        String sql = "SELECT * FROM books WHERE id=?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setInt(1, id);
	        ResultSet rs = ps.executeQuery();

	        if (rs.next()) {
	            b = new Book();
	            b.setId(rs.getInt("id"));
	            b.setBookName(rs.getString("book_name"));
	            b.setAuthor(rs.getString("author"));
	            b.setCategory(rs.getString("category"));
	            b.setQuantity(rs.getInt("quantity"));
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return b;
	}

	public boolean updateBook(Book b) {
	    boolean flag = false;
	    try {
	        String sql = "UPDATE books SET book_name=?, author=?, category=?, quantity=? WHERE id=?";
	        PreparedStatement ps = conn.prepareStatement(sql);
	        ps.setString(1, b.getBookName());
	        ps.setString(2, b.getAuthor());
	        ps.setString(3, b.getCategory());
	        ps.setInt(4, b.getQuantity());
	        ps.setInt(5, b.getId());

	        if (ps.executeUpdate() == 1) flag = true;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return flag;
	}

           
	public boolean returnBook(int issueId, int bookId) {
	    boolean flag = false;
	    try {
	        String sql1 = "UPDATE issued_books SET return_date = CURDATE() WHERE issue_id=?";
	        String sql2 = "UPDATE books SET quantity = quantity + 1 WHERE id=?";

	        PreparedStatement ps1 = conn.prepareStatement(sql1);
	        ps1.setInt(1, issueId);

	        PreparedStatement ps2 = conn.prepareStatement(sql2);
	        ps2.setInt(1, bookId);

	        ps1.executeUpdate();
	        ps2.executeUpdate();

	        flag = true;
	    } catch (Exception e) {
	        e.printStackTrace();
	    }
	    return flag;
	}

	
}
