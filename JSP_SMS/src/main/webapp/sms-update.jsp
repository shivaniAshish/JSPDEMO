<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ page import="com.createiq.sms.model.Student" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Student Update Form</h1>
<%
		Student student = (Student) request.getAttribute("student");
	%>
	<div align="center">
		<form action="Update" method="post">
			<table>
				<tr>
					<td>ID:</td>
					<td><input type="text" name="id" 
					value="<%=student.getId()%>"></td>
				</tr>
				<tr>
					<td>Name:</td>
					<td><input type="text" name="name"
						value="<%=student.getName()%>"></td>
				</tr>
				<tr>
					<td>Email:</td>
					<td><input type="text" name="email"
						value="<%=student.getEmail()%>"></td>
				</tr>
				<tr>
					<td>CourseName:</td>
					<td><input type="text" name="course"
						value="<%=student.getCourseName()%>"></td>
				</tr>
				<tr>
					<td><input type="submit" value="save"></td>
				</tr>


			</table>
		</form>
	</div>
</body>
</html>