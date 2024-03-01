<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Events Lists</title>
</head>
<body>
	<form method="post" action="listNavigationServlet">
	<table>
	<c:forEach items="${requestScope.allLists}" var="currentlist">
	<tr>
		<td><input type="radio" name="id" value="${currentlist.id}"></td>
		<td><h2>${currentlist.listName}</h2></td>
	</tr>
	<tr>
		<td>Organizer: ${currentlist.organizer.organizerName}</td>
	</tr>
	<c:forEach var="listVal" items="${currentlist.eventsList}">
	<tr>
		<td></td>
		<td>${listVal.name} | ${listVal.date}</td>
	</tr>
	</c:forEach>
	</c:forEach>
	</table>
	<input type="submit" value="edit" name="doThisToList">
	<input type="submit" value="delete" name="doThisToList">
	<input type="submit" value="add" name="doThisToList">
	</form>
	<a href="viewOrganizerEventsServlet">View Events Lists</a>
	<a href="addEventsForListServlet">Create List</a>
</body>
</html>