<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="by.myProject.been.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css" />

<title>worker_page</title>
</head>
<body>

	<h3 align="center">
		Hello
		<c:out value="${sessionScope.user.name}"></c:out>
		<br /> <br /> What are you going to do?
	</h3>

	<div>
		<h1 align="center" style="color: red">
			<i> <c:if test="${not empty requestScope.message}">
					<c:out value="${requestScope.message}"></c:out>

				</c:if>
			</i>
		</h1>
	</div>


	<table align="left">
		<tr>
			<td><form action="controllerServlet" method="get">
					<input type="hidden" name="command" value="show_all_base">
					<input type="hidden" name=nickName
						value=${sessionScope.user.nickName}> <input type="submit"
						value="Show all workers" class="my_field" />
				</form></td>
		</tr>
		<tr>
			<td><form action="controllerServlet" method="get">
					<input type="hidden" name=nickName
						value=${sessionScope.user.nickName}> <input type="hidden"
						name="command" value="add_new_worker" /> <input type="submit"
						value="Add new worker" class="my_field" />
				</form></td>
		</tr>
		<tr>
			<td><form action="controllerServlet" method="get">
					<input type="hidden" name=nickName
						value=${sessionScope.user.nickName}> <input type="hidden"
						name="command" value="remove_worker"> <input type="submit"
						value="Remove worker" class="my_field">
				</form></td>
		</tr>
		<tr>
			<td><form action="controllerServlet" method="get">
					<input type="hidden" name="command" value="change_data"> <input
						type="submit" value="Change data" class="my_field">
				</form></td>
		</tr>
		<tr>
			<td><form action="controllerServlet" method="get">
					<input type="hidden" name="command" value="exit"> <input
						type="submit" value="Exit" class="my_field">
				</form></td>
		</tr>
		<c:if test="${removeWorker==\"true\"}">
			<tr>
				<td>
					<form action="controllerServlet" method="get">
						<input type="hidden" name="command" value="do_remove_worker">
						<label for="choose" style="color: red"><b>Choose
								worker surName for delete:</b></label> <br /> <select name="choose"
							class="my_field" required>
							<c:forEach items="${allWorkers}" var="choosen">
								<option>${choosen.getSurname()}</option>
							</c:forEach>
						</select> <br /> <input type="submit" value="Remove" class="my_button">
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
	</table>



</body>
</html>