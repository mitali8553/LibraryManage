<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Return Book</title>
</head>
<body>

<h2>Return Book</h2>
<hr>

<form action="returnBook" method="post">
    Issue ID : <input type="number" name="issueId" required><br><br>
    Return Date : <input type="date" name="returnDate" required><br><br>

    <input type="submit" value="Return Book">
</form>

<br>
<a href="index.jsp">Back to Home</a>

</body>
</html>
