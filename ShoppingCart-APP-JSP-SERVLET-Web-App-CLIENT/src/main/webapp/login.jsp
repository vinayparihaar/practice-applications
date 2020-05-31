<%@page import="javassist.bytecode.analysis.Util"%>
<%@page import="com.vinayparihar.shoppingcart.client.utils.Utils"%>
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
		String email = (String) request.getAttribute("email");
	String password = (String) request.getAttribute("password");

	if (!Utils.isEmpty(email)) {
	%>
	<div style="text-align: center; color: red"><%=email%></div>
	<%
		}
	if (!Utils.isEmpty(password)) {
	%>
	<div style="text-align: center; color: red"><%=password%></div>
	<%
		}
	%>

	<form action="./login" method="post">
		<h2>Login Page</h2>

		<table>

			<tr>
				<td><label for="email">Email : </label></td>
				<td><input type="text" id="email" name="email"></td>
			</tr>

			<tr>
				<td><label for="password">Password : </label></td>
				<td><input type="password" id="password" name="password"></td>
			</tr>

			<tr>
				<td></td>
				<td></td>
				<td></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Login"></td>
				<td></td>
			</tr>
			<tr>
				<td></td>
				<td><label for="">Not Registered ??</label><a
					href="register.jsp"> <b>Register Here</b></a></td>
				<td></td>
			</tr>

		</table>

	</form>

</body>
</html>