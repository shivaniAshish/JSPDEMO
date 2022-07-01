<%@page import="com.createiq.sms.model.Student"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1 align="center">Student Management Servie</h1>

	<h2>
		<a href="sms-reg.jsp">addStudent</a>
	</h2>
	<%
		List<Student> students = (List<Student>) request.getAttribute("students");
		String message = (String) request.getAttribute("msg");
		message = message == null ? " " : message;
	%>
	<%
		out.println(message);
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
			<%
				for (Student student : students) {
			%>
			<tr>
				<td><%=student.getId()%></td>
				<td><%=student.getName()%></td>
				<td><%=student.getEmail()%></td>
				<td><%=student.getCourseName()%></td>
				<td><a href="Update?id=<%=student.getId()%>">Update</a>
				 <a href="#">delete</a></td>
			</tr>
			<%
				}
			%>


		</table>
	</div>
</body>
</html>