<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Query results</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body bgcolor="#57B7DF">
    <p>
    <h1>Results:</h1>
	<p>
	<table>
		<tr>
			<td>Drillhole ID</td>
			<td>Length</td>
			<td>Easting</td>
			<td>Northing</td>
			<td>Elevation</td>
			<td>Area</td>
			<td>Driller</td>
			<td>Casing</td>
			<td>Drill Date</td>
		</tr>
		
		<c:forEach items="${results}" var="row">
			<tr>
				<td>${row.id}</td>
				<td>${row.length}</td>
				<td>${row.easting}</td>
				<td>${row.northing}</td>
				<td>${row.elevation}</td>
				<td>${row.area}</td>
				<td>${row.driller}</td>
				<td>${row.casing}</td>
				<td>${row.date}</td>
			</tr>
		</c:forEach>
	</table>
	
</body>
</html>