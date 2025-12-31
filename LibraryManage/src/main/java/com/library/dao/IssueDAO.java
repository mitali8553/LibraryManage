package com.library.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class IssueDAO {

	private Connection conn;
	public IssueDAO(Connection conn) {
		this.conn = conn;
	}
	
	//Issue Book
	public boolean issueBook(int bookId, int memberId, String issueDate) {
		boolean f = false;
		try {
			String sql = "INSERT INTO issued_books(book_id,member_id,issue_date,status) VALUES(?,?,?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setInt(1, bookId);
			ps.setInt(2, memberId);
			ps.setString(3, issueDate);
			ps.setString(4, "Issued");
			
			int i = ps.executeUpdate();
			if(i == 1) {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	//Return Book
	public boolean returnBook(int issueId, String returnDate) {
		boolean f = false;
		try {
			String sql = "UPDATE issued_books SET return_date=?, status=? WHERE id=?";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, returnDate);
			ps.setString(2, "return");
			ps.setInt(3, issueId);
			
			int i = ps.executeUpdate();
			if(i == 1) {
				f = true;
			}
		}catch(Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	
	//issue book by id

    public int getBookIdByIssueId(int issueId) {
        int bookId = 0;
        try {
            String sql = "SELECT book_id FROM issued_books WHERE id=?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, issueId);
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                bookId = rs.getInt("book_id");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bookId;
    }
}

