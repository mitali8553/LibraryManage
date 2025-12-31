<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.library.dao.BookDAO" %>
<%@ page import="com.library.db.DBConnect" %>
<%@ page import="com.library.model.Book" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Books</title>

<style>
    body {
        font-family: 'Segoe UI', Arial, sans-serif;
        background: #f4f6f9;
        padding: 30px;
    }

    h2 {
        text-align: center;
        color: #2a5298;
    }

    table {
        width: 100%;
        border-collapse: collapse;
        margin-top: 20px;
        background: #fff;
        box-shadow: 0 8px 20px rgba(0,0,0,0.1);
    }

    th, td {
        padding: 12px;
        text-align: center;
        border-bottom: 1px solid #ddd;
    }

    th {
        background: #2a5298;
        color: white;
    }

    tr:hover {
        background-color: #f1f1f1;
    }

    a.action {
        margin: 0 6px;
        text-decoration: none;
        font-weight: 600;
        color: #2a5298;
    }

    a.delete {
        color: red;
    }

    .back {
        margin-top: 20px;
        text-align: center;
    }

    .back a {
        text-decoration: none;
        color: #2a5298;
        font-weight: 600;
    }
</style>
</head>

<body>

<h2>Library Books</h2>

<%
    BookDAO dao = new BookDAO(DBConnect.getConnection());
    List<Book> list = dao.getAllBooks();
%>

<table>
    <tr>
        <th>ID</th>
        <th>Book Name</th>
        <th>Author</th>
        <th>Category</th>
        <th>Quantity</th>
        <th>Actions</th>
    </tr>

<%
    if (list != null && !list.isEmpty()) {
        for (Book b : list) {
%>
    <tr>
        <td><%= b.getId() %></td>
        <td><%= b.getBookName() %></td>
        <td><%= b.getAuthor() %></td>
        <td><%= b.getCategory() %></td>
        <td><%= b.getQuantity() %></td>

        <td>
            <a class="action delete"
               href="<%= request.getContextPath() %>/deleteBook?id=<%= b.getId() %>"
               onclick="return confirm('Are you sure you want to delete this book?');">
               Delete
            </a>

            <a class="action"
               href="edit-book.jsp?id=<%= b.getId() %>">
               Edit
            </a>
        </td>
    </tr>
<%
        }
    } else {
%>
    <tr>
        <td colspan="6">No Books Available</td>
    </tr>
<%
    }
%>

</table>

<div class="back">
    <a href="index.jsp">← Back to Home</a>
</div>

</body>
</html>
