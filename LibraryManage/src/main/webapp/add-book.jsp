<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Book</title>
</head>
<body>

<h2>Add New Book</h2>
<hr>

<form action="<%= request.getContextPath() %>/add-book" method="post">
    Book Name : <input type="text" name="bookName" required><br><br>
    Author : <input type="text" name="author" required><br><br>
    Category : <input type="text" name="category" required><br><br>
    Quantity : <input type="number" name="quantity" required><br><br>

    <input type="submit" value="Add Book">
</form>

<br>
<a href="index.jsp">Back to Home</a>

</body>
</html>
