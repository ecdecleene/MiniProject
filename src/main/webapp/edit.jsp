<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Edit Event</title>
</head>
<body>
<form method="post" action="editEventServlet">
<div class="form-group">
				<label for="name">Name:</label><input type="text" name="name"
					value="${eventToEdit.name}"><br />
			</div>
			<div class="form-group">
				<label for="date">Date:</label> <input type="text" name="month" placeholder="mm"
					value="${month}"><input type="text" name="day" placeholder="dd" value="${day}">
					<input type="text" name="year" placeholder="yyyy" value="${year}"><br />
			</div>
			<input type="hidden" name="id" value="${eventToEdit.id}"> <input
				type="submit" value="Save Edited Event" class="btn btn-primary">
</form>
</body>
</html>