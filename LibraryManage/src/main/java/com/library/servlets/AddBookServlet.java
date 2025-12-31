package com.library.servlets;

	import java.io.IOException;

import com.library.dao.BookDAO;
import com.library.db.DBConnect;
import com.library.model.Book;

import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;

	@WebServlet("/add-book")
	public class AddBookServlet extends HttpServlet {

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        String bookName = request.getParameter("bookName");
	        String author = request.getParameter("author");
	        String category = request.getParameter("category");
	        int quantity = Integer.parseInt(request.getParameter("quantity"));

	        Book b = new Book();
	        b.setBookName(bookName);
	        b.setAuthor(author);
	        b.setCategory(category);
	        b.setQuantity(category);
	        
	        BookDAO dao = new BookDAO(DBConnect.getConnection());

	        boolean f = dao.addBook(b);

	            response.sendRedirect("view-books.jsp");
	        }
	    }
