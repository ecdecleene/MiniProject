<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events List</title>
</head>
<body>
<form method="post" action="navigationServlet">
<table>
<c:forEach items="${requestScope.allEvents}" var="currentevent">
<tr>
	<td><input type="radio" name="id" value="${currentevent.id}"></td>
	<td>${currentevent.name}</td>
	<td>${currentevent.date}</td>
</tr>
</c:forEach>
</table>
<input type="submit" value="edit" name="doThisToEvent">
<input type="submit" value="delete" name="doThisToEvent">
<input type="submit" value="add" name="doThisToEvent">
</form>
</body>
</html>