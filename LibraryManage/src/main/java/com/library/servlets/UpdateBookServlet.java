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

@WebServlet("/updateBook")
	public class UpdateBookServlet extends HttpServlet {

	    protected void doPost(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        Book b = new Book();
	        b.setId(Integer.parseInt(request.getParameter("id")));
	        b.setBookName(request.getParameter("bookName"));
	        b.setAuthor(request.getParameter("author"));
	        b.setCategory(request.getParameter("category"));
	        b.setQuantity(Integer.parseInt(request.getParameter("quantity")));

	        BookDAO dao = new BookDAO(DBConnect.getConnection());
	        dao.updateBook(b);

	        response.sendRedirect("view-books.jsp");
	    }
	}

