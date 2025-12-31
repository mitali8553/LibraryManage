package com.library.servlets;

	import java.io.IOException;
	import com.library.dao.BookDAO;
	import com.library.db.DBConnect;

	import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.*;

	@WebServlet("/deleteBook")
	public class DeleteBookServlet extends HttpServlet {

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        int id = Integer.parseInt(request.getParameter("id"));

	        BookDAO dao = new BookDAO(DBConnect.getConnection());
	        dao.deleteBook(id);

	        response.sendRedirect("view-books.jsp");
	    }
	}

