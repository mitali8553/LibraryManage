<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> Adding Members </title>
</head>
<body>
<form action="add-member" method="post">
    <input type="text" name="first_name" placeholder="First Name"><br>
    <input type="text" name="last_name" placeholder="Last Name"><br>
    <input type="text" name="phone_no" placeholder="Phone"><br>
    <input type="text" name="email" placeholder="Email"><br>
    <textarea name="address" placeholder="Address"></textarea><br>
    <button type="submit">Add Member</button>
</form>
</body>
</html>