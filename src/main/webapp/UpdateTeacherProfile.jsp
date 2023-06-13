<%@page import="Com.dto.Teacher"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Update teacher profile</title>
</head>
<body>
	<%
	 Teacher t=(Teacher) session.getAttribute("teacher");
	
	%>
	<center>
	<form action="upteacher" method="post">
		<label >ID </label>
	    <input type="number" name="id" value="<%= t.getId()%>"><br><br>
	    
	    <label>Name </label>
	    <input type="text" name="name" value="<%= t.getName()%>"><br><br>
	    
	    <label>Subject</label>
	    <input type="text" name="subject" value="<%= t.getSubject()%>"><br><br>
	    
	    <label>Age</label>
	    <input type="text" name="age" value=<%= t.getAge() %>><br><br>
	    
	    <label>Email</label>
	    <input type="text" name="email" value="<%= t.getEmail() %>"><br><br>
	    
	    <label>Password</label>
	    <input type="text" name="password" value="<%= t.getPassword() %>"><br><br>
	    
	    <input type="submit">
	    
	    
	</form>
	</center>
	
</body>
</html>