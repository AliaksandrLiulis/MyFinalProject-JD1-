<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>add worker</title>
</head>
<body>

	<div>
		<h3 align="center">
			<i> <a href="worker_page">link to BACK</a>
			</i>
		</h3>
	</div>

	<h1 align="center" style="color: blue">Add Worker</h1>

	<form action="controllerServlet" method="get">

		<input type="hidden" name="command" value="add_new_worker"> <input
			type="hidden" name="nickName" value="${sessionScope.user.nickName}">

		<table border="1" style="box-shadow: 0 0 25px 1px green">
			<tr>
				<td align="center">Name</td>
				<td align="center">SurName</td>
				<td align="center">Profession</td>
				<td align="center">Age</td>
				<td align="center">Experience</td>
				<td align="center">Salary</td>
				<td align="center">Year Of Admission</td>
			</tr>
			<tr>
				<td><input type="text" name="name" value="" placeholder="Name"
					required class="my_field"></td>
				<td><input type="text" name="surname" value=""
					placeholder="surName" required class="my_field"></td>
				<td><select name="profession" class="my_field">
						<option>Motor mechanic</option>
						<option>Agronomist</option>
						<option>Concrete worker</option>
						<option>Biologist</option>
						<option>Foreman</option>
						<option>Veterinarian</option>
						<option>Doctor</option>
						<option>Engineer</option>
				</select></td>
				<td><input type="text" name="age" value="" placeholder="age"
					required class="my_field"></td>
				<td><input type="text" name="experience" value=""
					placeholder="experience" required class="my_field"></td>
				<td><input type="text" name="salary" value=""
					placeholder="salary" required class="my_field"></td>
				<td><input type="text" name="admission" value=""
					placeholder="year Of admission" required class="my_field"></td>
			</tr>
			<tr>
				<td colspan="7" align="center"><input type="submit"
					value="Enter" class="my_button"> <input type="reset"
					value="Clear" class="my_button"></td>
		</table>
		<div>
			<h1 align="center" style="color: red">
				<i> <c:if test="${not empty requestScope.message}">
						<c:out value="${requestScope.message}"></c:out>

					</c:if>
				</i>
			</h1>
		</div>
	</form>
</body>
</html>