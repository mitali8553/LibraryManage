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

	@WebServlet("/returnBook")
	public class ReturnBookServlet extends HttpServlet {

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        int issueId = Integer.parseInt(request.getParameter("issueId"));
	        String returnDate = request.getParameter("returnDate");

	        IssueDAO issueDao = new IssueDAO(DBConnect.getConnection());
	        BookDAO bookDao = new BookDAO(DBConnect.getConnection());

	        int bookId = issueDao.getBookIdByIssueId(issueId);

	        boolean returned = issueDao.returnBook(issueId, returnDate);

	        if (returned) {
	            bookDao.bookQuantity(bookId);
	            response.sendRedirect("index.jsp");
	        } else {
	            response.getWriter().print("Error while returning book");
	        }
	    }
	}
