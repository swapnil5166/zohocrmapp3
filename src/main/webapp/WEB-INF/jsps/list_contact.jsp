<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ include file="menu.jsp" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>list AllContact</title>
</head>
	<body>
	<h2>list Contact</h2>
		<table border="1">
		<tr>
			<th>Id</th>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Email</th>
			<th>Mobile</th>
			<th>Source</th>
			<th>Billing</th>
		</tr>
		
		<c:forEach var="contact" items="${contacts}">
		
		<tr>
			<td>${contact.id}</td>
			<td>${contact.firstName}</td>
			<td>${contact.lastName}</td>
			<td>${contact.email}</td>
			<td>${contact.mobile}</td>
			<td>${contact.source}</td>
			<td><a href="generateBilll?id=${contact.id}">billing</a></td>
		</tr>
		</c:forEach>
		</table>
	
	</body>
</html>