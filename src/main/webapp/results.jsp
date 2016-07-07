<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Drillhole Report</title>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	</head>
	<style>
		body {
		  font-family: "arial", sans-serif;
		}

		table, th, td {
			border: 1px solid black;
			border-collapse: collapse;
		}
		th, td {
			text-align: left;
			padding: 3px;
		}
	</style>
	<body bgcolor="#57B7DF">
		<p>
		<h1>Results: <c:out value="${numRecords}" /> records found</h1>
		<p>
		<table style="width:75%">
			<tr style="font-weight:bold">
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
					<td><fmt:formatNumber value="${row.length}" pattern="0.000" /></td>
					<td><fmt:formatNumber value="${row.easting}" pattern="0.000" /></td>
					<td><fmt:formatNumber value="${row.northing}" pattern="0.000" /></td>
					<td><fmt:formatNumber value="${row.elevation}" pattern="0.000" /></td>
					<td>${row.area}</td>
					<td>${row.driller}</td>
					<td><fmt:formatNumber value="${row.casing}" pattern="0.0" /></td>
					<td>${row.drilldate}</td>
				</tr>
			</c:forEach>
		</table>
	</body>
</html>