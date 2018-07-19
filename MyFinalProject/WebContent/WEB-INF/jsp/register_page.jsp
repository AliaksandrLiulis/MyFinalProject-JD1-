<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>register_page</title>
</head>
<body style="background-image: url(images/page4.jpg)">
	<div>
		<h3 align="center">
			<i> <a href="main_page">link to MAIN</a>
			</i>
		</h3>
	</div>
	<form action="controllerServlet" method="post">
		<table bgcolor="#6699FF">

			<input type="hidden" name="command" value="registr">
			<tr>
				<td><label for="nick"><b>Enter your nickName:</b></label></td>
				<td><input id=nick type="text" name="nickName" value=""
					placeholder="nickName" required class="my_field"></td>
			</tr>
			<tr>
				<td><label for="firstname"><b>Enter your Name:</b></label></td>
				<td><input id=firstname type="text" name="name" value=""
					placeholder="name" required class="my_field"></td>
			</tr>
			<tr>
				<td><label for="lastname"><b>Enter your surName:</b></label></td>
				<td><input id=lastname type="text" name="surName" value=""
					placeholder="surName" required class="my_field"></td>
			</tr>
			<tr>
				<td><label for="sex"><b>Sex:</b></label></td>
				<td><input type="radio" name="gender" value="mr" required>M
					<input type="radio" name="gender" value="mrs" required>W</td>
			</tr>
			<tr>
				<td><label for="ages"><b>I'm 18 years old:</b></label></td>
				<td><input id=ages type="checkbox" name="age" required></td>
			</tr>
			<tr>
				<td><label for="email"><b>Enter your e-mail:</b></label></td>
				<td><input id=email type="email" name="email" value=""
					placeholder="e-mail" required class="my_field"></td>
			</tr>
			<tr>
				<td><label for="special"><b>Choose your specialty:</b></label></td>
				<td><select name="special" class="my_field" required>
						<option>Boss</option>
						<option>Worker</option>
				</select></td>
			</tr>
			<tr>
				<td><label for="organize"><b>Name of organization:</b></label></td>
				<td><select name="organize" class="my_field" required>
						<option>My organization</option>
				</select></td>
			</tr>
			<tr>
				<td><label for="pass"><b>Enter your password:</b></label></td>
				<td><input id=pass type="text" name="password" value=""
					placeholder="password" required class="my_field"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="checkbox"
					name="terms" required> I agree to <a href="/terms">the
						terms of use</a></td>

			</tr>
			<tr>
				<td colspan="2" align="center">
					<p>
						<button class="my_button">Register</button>
					</p>
				</td>

			</tr>

		</table>
	</form>

	<div>
		<h1 align="center" style="color: red">
			<i> <c:if test="${not empty requestScope.errorMessage}">
					<c:out value="${requestScope.errorMessage}"></c:out>

				</c:if>
			</i>
		</h1>
	</div>
</body>
</html>