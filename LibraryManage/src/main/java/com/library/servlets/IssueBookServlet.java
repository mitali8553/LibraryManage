package com.library.servlets;
	import java.io.IOException;

	import com.library.dao.BookDAO;
	import com.library.dao.IssueDAO;
	import com.library.db.DBConnect;

	import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;

	@WebServlet("/issueBook")
	public class IssueBookServlet extends HttpServlet {

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        int bookId = Integer.parseInt(request.getParameter("bookId"));
	        int memberId = Integer.parseInt(request.getParameter("memberId"));
	        String issueDate = request.getParameter("issueDate");

	        BookDAO bookDao = new BookDAO(DBConnect.getConnection());
	        IssueDAO issueDao = new IssueDAO(DBConnect.getConnection());

	        boolean reduced = bookDao.bookQuantity(bookId);

	        if (reduced) {
	            issueDao.issueBook(bookId, memberId, issueDate);
	            response.sendRedirect("index.jsp");
	        } else {
	            response.getWriter().print("Book not available");
	        }
	    }
	}

