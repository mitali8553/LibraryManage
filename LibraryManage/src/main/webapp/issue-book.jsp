<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Issue Book</title>
</head>
<body>

<h2>Issue Book</h2>
<hr>

<form action="issue-book" method="post">
    Book ID : <input type="number" name="bookId" required><br><br>
    Member ID : <input type="number" name="memberId" required><br><br>
    Issue Date : <input type="date" name="issueDate" required><br><br>

    <input type="submit" value="Issue Book">
</form>

<br>
<a href="index.jsp">Back to Home</a>

</body>
</html>
