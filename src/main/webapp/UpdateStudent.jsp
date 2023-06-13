<%@page import="Com.dto.Student"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>


<body>
<%
           Student s=(Student) session.getAttribute("student");   //here "student " is key not class name

%>
<center>
<form action="StudentUp" method="post">
<label>ID</label>
<input type="text" name="id" value="<%=s.getId() %>"><br><br>

        <label>Name </label>
	    <input type="text" name="name" value="<%=s.getName() %>"><br><br>
	    
	    <label>Date Of Birth</label>
	    <input type="date" name="dob" value="<%=s.getDateOfBirth()%>"><br><br>

<label>Email</label>
<input type="email" name="email" value="<%=s.getEmail() %>"><br><br>

<label>Password</label>
<input type="password" name="password" value="<%=s.getPassword() %>"><br><br>

<input type="submit">



</form>
</center>
</body>
</html>