<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@page import="com.createiq.sms.model.Student"%>
<%@page import="java.util.List"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		List<Student> students = (List<Student>) request.getAttribute("students");
	%>
	<div align="center">
		<table border="1px">

			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Email</th>
				<th>Course</th>
				<th>Action</th>
			</tr>


			<tr>
				<td>
					<%
						out.print(students);
					%>
				</td>
			</tr>
		</table>
	</div>
</body>
</html>