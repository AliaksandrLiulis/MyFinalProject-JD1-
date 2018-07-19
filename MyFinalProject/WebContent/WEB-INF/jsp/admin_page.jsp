<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="by.myProject.been.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>usermain_page</title>
</head>
<body style="background-image: url(images/page.jpg)">
	<h3 align="center">
		Hello
		<c:out value="${sessionScope.user.name}"></c:out>
		<br /> <br /> What are you going to do?
	</h3>
	<c:if test="${sessionScope.user.role==\"Admin\"}">
		<table align="left">
			<tr>
				<td><form action="controllerServlet" method="get">
						<input type="hidden" name="command" value="show_all_users">
						<input type="hidden" name="role" value="admin"> <input
							type="submit" value="Show all users" class="my_field">
					</form></td>
			</tr>
			<tr>
				<td><form action="controllerServlet" method="get">
						<input type="hidden" name="command" value="show_all_base">
						<input type="hidden" name=nickName value="admin">
						<input type="submit" value="Show all workers" class="my_field" />
					</form></td>
			</tr>
			<tr>
				<td><form action="controllerServlet" method="get">
						<input type="hidden" name="command" value="add_user"> <input
							type="submit" value="Add user" class="my_field">
					</form></td>
			</tr>
			<tr>
				<td><form action="controllerServlet" method="get">
						<input type="hidden" name="role" value="admin"> <input
							type="hidden" name="command" value="remove_user"> <input
							type="submit" value="Remove user" class="my_field">
					</form></td>
			</tr>
			<tr>
				<td><form action="controllerServlet" method="get">
						<input type="hidden" name="role" value="admin"> <input
							type="hidden" name="command" value="authorize_user"> <input
							type="submit" value="Authorize user" class="my_field">
					</form></td>
			</tr>
			<tr>
				<td><form action="controllerServlet" method="get">
						<input type="hidden" name="role" value="admin"> <input
							type="hidden" name="command" value="exit"> <input
							type="submit" value="Exit" class="my_field">
					</form></td>
			</tr>
			<c:if test="${authoriseUser==\"true\"}">
				<tr>
					<td>
						<form action="controllerServlet" method="get">
							<input type="hidden" name="command" value="do_avaliable_user">
							<label for="choose"><b>Choose user nickName for
									authorization:</b></label> <br /> <select name="choose" class="my_field"
								required>
								<c:forEach items="${allUsers}" var="choosen">
									<option>${choosen.getNickName()}</option>
								</c:forEach>
							</select> <br /> <input type="submit" value="Authorize" class="my_button">
						</form>
					</td>
				</tr>
			</c:if>
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
			<c:if test="${removeUser==\"true\"}">

				<tr>
					<td>
						<form action="controllerServlet" method="get">
							<input type="hidden" name="command" value="do_remove_user">
							<label for="choose" style="color: red"><b>Choose user
									nickName for delete:</b></label> <br /> <select name="choose"
								class="my_field" required>
								<c:forEach items="${allUsers}" var="choosen">
									<option>${choosen.getNickName()}</option>
								</c:forEach>
							</select> <br /> <input type="submit" value="Remove" class="my_button">
						</form>
					</td>
				</tr>
			</c:if>
			<c:if test="${allUsers != null}">

				<table align="center" border="1"
					style="box-shadow: 0 0 25px 1px green">
					<tr>
						<td align="center">Name</td>
						<td align="center">SurName</td>
						<td align="center">NickName</td>
						<td align="center">E-mail</td>
						<td align="center">Speciality</td>
						<td align="center">Organize</td>
						<td align="center">Role</td>
						<td align="center">Avaliable</td>

					</tr>

					<c:forEach items="${allUsers}" var="cell">
						<tr>
							<td align="center">${cell.getName()}</td>
							<td align="center">${cell.getSurname()}</td>
							<td align="center">${cell.getNickName()}</td>
							<td align="center">${cell.getEmail()}</td>
							<td align="center">${cell.getSpeciality()}</td>
							<td align="center">${cell.getOrganize()}</td>
							<td align="center">${cell.getRole()}</td>
							<td align="center">${cell.getAvaliable()}</td>
						</tr>
					</c:forEach>
				</table>
			</c:if>
		</table>
	</c:if>

	<c:if test="${sessionScope.user.role==\"Worker\"}">
		<c:redirect url="/worker_page" />
	</c:if>
	<c:if test="${sessionScope.user.role==\"Boss\"}">
		<c:redirect url="/boss_page" />
	</c:if>

</body>
</html>