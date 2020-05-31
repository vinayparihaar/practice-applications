<%@page import="com.vinayparihar.shoppingcart.client.bean.User"%>
<%@page import="java.util.Date"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>HomePage</title>
</head>
<body>
	<h1>Welcome you have Sucessfully Loggedin!!!</h1>


	<%
		User user = (User) session.getAttribute("user");
	%>

	<br>

	<table>
		<%=new Date()%>
		<br>
		<b>Welcome <%=user.getFirstName() + " " + user.getLastName()%>!!
		</b>
		<br>
		<a href="logout.jsp"><b>Logout</b></a>

		<tr>
			<td>First Name :</td>
			<td><%=user.getFirstName()%></td>
		</tr>
		<tr>
			<td>Last Name :</td>
			<td><%=user.getLastName()%></td>
		</tr>
		<tr>
			<td>Email :</td>
			<td><%=user.getEmail()%></td>
		</tr>
		<tr>
			<td>Phone :</td>
			<td><%=user.getPhone()%></td>
		</tr>
		<tr>
			<td>Password :</td>
			<td><%=user.getPassword()%></td>
		</tr>
		<tr>
			<td>Address Line 1 :</td>
			<td><%=user.getAddress().getLineOne()%></td>
		</tr>
		<tr>
			<td>Address Line 2 :</td>
			<td><%=user.getAddress().getLineTwo()%></td>
		</tr>
		<tr>
			<td>City :</td>
			<td><%=user.getAddress().getCity()%></td>
		</tr>
		<tr>
			<td>State :</td>
			<td><%=user.getAddress().getState()%></td>
		</tr>
		<tr>
			<td>ZipCode :</td>
			<td><%=user.getAddress().getZipcode()%></td>
		</tr>
		<tr>
			<td>Country :</td>
			<td><%=user.getAddress().getCountry()%></td>
		</tr>

	</table>
</body>
</html>