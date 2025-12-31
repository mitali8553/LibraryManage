<%@ page import="com.library.dao.BookDAO,com.library.db.DBConnect,com.library.model.Book" %>

<%
    int id = Integer.parseInt(request.getParameter("id"));
    BookDAO dao = new BookDAO(DBConnect.getConnection());
    Book b = dao.getBookById(id);
%>

<form action="<%= request.getContextPath() %>/updateBook" method="post">
    <input type="hidden" name="id" value="<%= b.getId() %>">

    Book Name: <input type="text" name="bookName" value="<%= b.getBookName() %>"><br><br>
    Author: <input type="text" name="author" value="<%= b.getAuthor() %>"><br><br>
    Category: <input type="text" name="category" value="<%= b.getCategory() %>"><br><br>
    Quantity: <input type="number" name="quantity" value="<%= b.getQuantity() %>"><br><br>

    <input type="submit" value="Update Book">
</form>
