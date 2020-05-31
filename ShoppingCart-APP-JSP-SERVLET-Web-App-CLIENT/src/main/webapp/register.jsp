<%@page import="com.vinayparihar.shoppingcart.client.utils.Utils"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>RegistrationPage</title>
</head>
<body>
	<%
	String firstName = (String) request.getAttribute("firstname");
	String lastName = (String) request.getAttribute("lastname");
	String email = (String) request.getAttribute("email");
	String phone = (String) request.getAttribute("phone");
	String password = (String) request.getAttribute("password");
	String addlineone = (String) request.getAttribute("addlineone");
	String addlinetwo = (String) request.getAttribute("addlinetwo");
	String city = (String) request.getAttribute("city");
	String state = (String) request.getAttribute("state");
	String zipcode = (String) request.getAttribute("zipcode");
	String country = (String) request.getAttribute("country");

	if (!Utils.isEmpty(firstName)) {
	%>
	<div style="text-align: center; color: red"><%=firstName%></div>
	<%
		}
	if (!Utils.isEmpty(lastName)) {
	%>
	<div style="text-align: center; color: red"><%=lastName%></div>
	<%
		}
	if (!Utils.isEmpty(email)) {
	%>
	<div style="text-align: center; color: red"><%=email%></div>
	<%
		}
	if (!Utils.isEmpty(phone)) {
	%>
	<div style="text-align: center; color: red"><%=phone%></div>
	<%
		}
	if (!Utils.isEmpty(password)) {
	%>
	<div style="text-align: center; color: red"><%=password%></div>
	<%
		}
	if (!Utils.isEmpty(addlineone)) {
	%>
	<div style="text-align: center; color: red"><%=addlineone%></div>
	<%
		}
	if (!Utils.isEmpty(addlinetwo)) {
	%>
	<div style="text-align: center; color: red"><%=addlinetwo%></div>
	<%
		}
	if (!Utils.isEmpty(city)) {
	%>
	<div style="text-align: center; color: red"><%=city%></div>
	<%
		}
	if (!Utils.isEmpty(state)) {
	%>
	<div style="text-align: center; color: red"><%=state%></div>
	<%
		}
	if (!Utils.isEmpty(zipcode)) {
	%>
	<div style="text-align: center; color: red"><%=zipcode%></div>
	<%
		}
	if (!Utils.isEmpty(country)) {
	%>
	<div style="text-align: center; color: red"><%=country%></div>
	<%
		}
	%>
	<form action="./register" method="post">
		<h2>Registration Page</h2>

		<table>
			<tr>
				<td><label for="firstname">First Name : </label></td>
				<td><input type="text" id="firstname" name="firstname"
					value="<%=request.getAttribute("ufirstname") != null ? request.getAttribute("ufirstname") : ""%>"
					<%-- value="<%=session.getAttribute("firstname") != null ? session.getAttribute("firstname") : ""%>" --%>></td>
			</tr>

			<tr>
				<td><label for="lastname">Last Name : </label></td>
				<td><input type="text" id="lastname" name="lastname"
					value="<%=request.getAttribute("ulastname") != null ? request.getAttribute("ulastname") : ""%>"
					<%-- value="<%=session.getAttribute("lastname") != null ? session.getAttribute("lastname") : ""%>" --%>></td>
			</tr>


			<tr>
				<td><label for="email">Email : </label></td>
				<td><input type="text" id="email" name="email"
					value="<%=request.getAttribute("uemail") != null ? request.getAttribute("uemail") : ""%>"
					<%-- value="<%=session.getAttribute("email") != null ? session.getAttribute("email") : ""%>" --%>></td>
			</tr>


			<tr>
				<td><label for="phone">Phone : </label></td>
				<td><input type="text" id="phone" name="phone"
					value="<%=request.getAttribute("uphone") != null ? request.getAttribute("uphone") : ""%>"
					<%-- value="<%=session.getAttribute("phone") != null ? session.getAttribute("phone") : ""%>" --%>></td>
			</tr>


			<tr>
				<td><label for="password">Password : </label></td>
				<td><input type="password" id="password" name="password"></td>
			</tr>

			<tr>
				<td><label for="addlineone">Address Line 1 : </label></td>
				<td><input type="text" id="addlineone" name="addlineone"
					value="<%=request.getAttribute("uaddlineone") != null ? request.getAttribute("uaddlineone") : ""%>"
					<%-- value="<%=session.getAttribute("addlineone") != null ? session.getAttribute("addlineone") : ""%>" --%>></td>
			</tr>

			<tr>
				<td><label for="addlinetwo">Address Line 2 : </label></td>
				<td><input type="text" id="addlinetwo" name="addlinetwo"
					value="<%=request.getAttribute("uaddlinetwo") != null ? request.getAttribute("uaddlinetwo") : ""%>"
					<%-- value="<%=session.getAttribute("addlinetwo") != null ? session.getAttribute("addlinetwo") : ""%>" --%>></td>
			</tr>

			<tr>
				<td><label for="city">City : </label></td>
				<td><input type="text" id="city" name="city"
					value="<%=request.getAttribute("ucity") != null ? request.getAttribute("ucity") : ""%>"
					<%-- value="<%=session.getAttribute("city") != null ? session.getAttribute("city") : ""%>" --%>></td>
			</tr>

			<tr>
				<td><label for="state">State : </label></td>
				<td><input type="text" id="state" name="state"
					value="<%=request.getAttribute("ustate") != null ? request.getAttribute("ustate") : ""%>"
					<%-- value="<%=session.getAttribute("state") != null ? session.getAttribute("state") : ""%>" --%>></td>
			</tr>

			<tr>
				<td><label for="zipcode">ZipCode : </label></td>
				<td><input type="text" id="zipcode" name="zipcode"
					value="<%=request.getAttribute("uzipcode") != null ? request.getAttribute("uzipcode") : ""%>"
					<%-- value="<%=session.getAttribute("zipcode") != null ? session.getAttribute("zipcode") : ""%>" --%>></td>
			</tr>

			<tr>
				<td><label for="country">Country : </label></td>
				<td><input type="text" id="country" name="country"
					value="<%=request.getAttribute("ucountry") != null ? request.getAttribute("ucountry") : ""%>"
					<%-- value="<%=session.getAttribute("country") != null ? session.getAttribute("country") : ""%>" --%>></td>
			</tr>

			<tr>
				<td></td>
				<td></td>
				<td></td>
			</tr>

			<tr>
				<td></td>
				<td><input type="submit" value="Submit"></td>
				<td></td>
			</tr>

			<tr>
				<td></td>
				<td><label for="">Already Registered ??</label><a
					href="login.jsp"> <b>Login Here</b></a></td>
				<td></td>
			</tr>



		</table>

	</form>
</body>
</html>