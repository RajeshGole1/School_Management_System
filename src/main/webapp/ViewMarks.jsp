<%@page import="Com.dto.Assignmment"%>
<%@page import="java.util.List"%>
<%@page import="Com.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>View marks</title>
<style type="text/css">


</style>
</head>
<body>
<center>
	<%
	
	Student s=(Student) session.getAttribute("student");
    List<Assignmment> a=s.getAssignment();
    
	%>
	
	<table border="1px" bgcolor="pink">
		<th > Marks table</th>
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>MARKS</th>
		</tr>
		
		<% for(int i=0;i<a.size();i++) { %>
			<tr>
				<td><%= a.get(i).getId() %></td>
				<td><%= a.get(i).getName() %></td>
				<td><%= a.get(i).getMarks() %></td>
			</tr>
		<% } %>
			</table>
			</center>
</body>
</html>