<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>boss_page</title>
</head>
<body>
<body>
	<h3 align="center">
		Hello
		<c:out value="${sessionScope.user.name}"></c:out>
		<br /> <br /> What are you going to do?
	</h3>

	<table align="left">
		<tr>
			<td><form action="controllerServlet" method="get">
					<input type="hidden" name="command" value="show_all_base">
					<input type="hidden" name=nickName value=${sessionScope.user.role}>
					<input type="submit" value="Show all workers" class="my_field" />
				</form></td>
		</tr>
		<tr>
			<td><form action="controllerServlet" method="get">
					<input type="hidden" name="command" value="exit"> <input
						type="submit" value="Exit" class="my_field">
				</form></td>
		</tr>

		<c:if test="${allWorkers != null}">

			<table align="center" border="1"
				style="box-shadow: 0 0 25px 1px green">
				<tr>
					<td align="center">Name</td>
					<td align="center">SurName</td>
					<td align="center">Profession</td>
					<td align="center">Age</td>
					<td align="center">Experience</td>
					<td align="center">Salary</td>
					<td align="center">Years of admission</td>

				</tr>

				<c:forEach items="${allWorkers}" var="cell">
					<tr>
						<td align="center">${cell.getName()}</td>
						<td align="center">${cell.getSurname()}</td>
						<td align="center">${cell.getProfession()}</td>
						<td align="center">${cell.getAge()}</td>
						<td align="center">${cell.getExperience()}</td>
						<td align="center">${cell.getSalary()}</td>
						<td align="center">${cell.getYearOfAdmission()}</td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</table>

</body>
</body>
</html>