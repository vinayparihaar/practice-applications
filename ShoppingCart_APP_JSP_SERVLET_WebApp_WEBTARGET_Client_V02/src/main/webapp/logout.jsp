<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
session.removeAttribute("email");
session.removeAttribute("password");
session.invalidate();
%>
<center>
     <h1>You have successfully logged out</h1>
     To login again <a href="login.jsp">click here</a>.
</center>
</body>
</html>