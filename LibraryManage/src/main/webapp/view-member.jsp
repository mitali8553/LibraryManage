<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="java.util.List" %>
<%@ page import="com.library.dao.MemberDAO" %>
<%@ page import="com.library.db.DBConnect" %>
<%@ page import="com.library.model.Member" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View Members</title>

<style>
    body {
        font-family: Arial;
        padding: 20px;
    }
    table {
        width: 100%;
        border-collapse: collapse;
    }
    th, td {
        padding: 10px;
        text-align: center;
        border: 1px solid #000;
    }
    th {
        background-color: #f2f2f2;
    }
    a {
        color: red;
        text-decoration: none;
        font-weight: bold;
    }
</style>
</head>

<body>

<h2>Library Members</h2>
<hr>

<%
    MemberDAO dao = new MemberDAO(DBConnect.getConnection());
    List<Member> list = dao.getAllMembers();
%>

<table>
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Phone</th>
        <th>Email</th>
        <th>Address</th>
        <th>Action</th>
    </tr>

<% 
    if(list != null && !list.isEmpty()) {
        for(Member m : list) {
%>
    <tr>
        <td><%= m.getId() %></td>
        <td><%= m.getFirstName() %> <%= m.getLastName() %></td>
        <td><%= m.getPhoneNo() %></td>
        <td><%= m.getEmail() %></td>
        <td><%= m.getAddress() %></td>
        <td>
<a href="<%= request.getContextPath() %>/deleteMember?id=<%= m.getId() %>"
   onclick="return confirm('Are you sure you want to delete this member?');">
   Delete
</a>
        </td>
    </tr>
<%
        }
    } else {
%>
    <tr>
        <td colspan="6">No Members Found</td>
    </tr>
<%
    }
%>
</table>

<br>
<a href="index.jsp">← Back to Home</a>

</body>
</html>
