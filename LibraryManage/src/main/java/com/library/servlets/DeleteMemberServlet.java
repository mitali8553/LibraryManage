package com.library.servlets;

	import java.io.IOException;

	import com.library.dao.MemberDAO;
	import com.library.db.DBConnect;

	import jakarta.servlet.ServletException;
	import jakarta.servlet.annotation.WebServlet;
	import jakarta.servlet.http.HttpServlet;
	import jakarta.servlet.http.HttpServletRequest;
	import jakarta.servlet.http.HttpServletResponse;

	@WebServlet("/delete")
	public class DeleteMemberServlet extends HttpServlet {

	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {

	        int id = Integer.parseInt(request.getParameter("id"));

	        MemberDAO dao = new MemberDAO(DBConnect.getConnection());
	        boolean f = dao.deleteMember(id);

	        response.sendRedirect("view-member.jsp");
	    }
	}
