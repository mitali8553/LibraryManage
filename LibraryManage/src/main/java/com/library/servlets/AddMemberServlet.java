package com.library.servlets;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/add-member")
public class AddMemberServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String firstName = request.getParameter("first_name");
        String lastName = request.getParameter("last_name");
        String phone = request.getParameter("phone_no");
        String email = request.getParameter("email");
        String address = request.getParameter("address");

        System.out.println(firstName);
        System.out.println(lastName);
        System.out.println(phone);
        System.out.println(email);
        System.out.println(address);

        response.sendRedirect("success.jsp");
    }
}
