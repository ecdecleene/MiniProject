<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create Events List</title>
</head>
<body>
<form action="createNewListServlet" method="post">
	List Name: <input type="text" name="listName"><br/>
	Organizer Name: <input type="text" name="organizerName"><br/>
	
	Available Events:<br/>
	<select name="allEventsToAdd" multiple size="6">
	<c:forEach items="${requestScope.allEvents}" var="currentevent">
	<option value="${currentevent.id}">${jcurrentevent.name} | ${currentevent.date}</option>
	</c:forEach>
	</select>
	<br/>
	<input type="submit" value="Create Event List">
</form>
<a href="index.html">Home</a>
</body>
</html>