<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/style.css" type="text/css" />
<title>expect_page</title>
</head>
<body style="background-image: url(images/expect.jpg)">
<br/>
<br/>

	<table bgcolor="#6699FF" align="left">

		<tr>
			<td><h3 align="center">
					<i> <a href="main_page">link to BACk</a></i>
				</h3></td>
		</tr>
		<tr>
			<td><h1 align="center" style="color: BLACK;">

					Dear <c:out value="${sessionScope.user.name }"></c:out>!!!<br/>
					Wait while administrator will check Your data.
				</h1>
			</td>
		</tr>

	</table>
	




</body>
</html>