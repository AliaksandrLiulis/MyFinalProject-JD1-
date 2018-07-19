<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>main_page</title>
</head>

<body style="background-image:url(images/page4.jpg)">
	<div>
		<center>
			<h3>
				<i><a href="register_page">link to REGISTER</a></i>
			</h3>
		</center>
	</div>

	<table bgcolor="#6699FF">
		<form action="controllerServlet" method="post">
			<input type="hidden" name="command" value="sign_in">
			<tr>
				<td><label for="nick"><b>Enter your nickName:</b></label></td>
				<td><input id=nick type="text" name="nickName" value=""
					placeholder="nickName" required class="my_field"></td>
			</tr>
			<tr>
				<td><label for="pass"><b>Enter your password:</b></label></td>
				<td><input id=pass type="password" name="password" value=""
					placeholder="password" required class="my_field"></td>
			</tr>
			<tr>
				<td colspan="2" align="center"><input type="submit" value="Ok"
					width="30" class="my_button"> <input type="reset"
					value="Clear" width="30" class="my_button"></td>
			</tr>
		</form>
	</table>


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