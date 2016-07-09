<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
		<script>
		function validateForm()
		{
			if (document.inputForm.start.value=="")
			{
				alert("Error: You must enter a value for Start date.");
				document.inputForm.start.focus();
				return false;
			}		
			if (document.inputForm.end.value=="")
			{
				alert("Error: You must enter a value for End date.");
				document.inputForm.end.focus();
				return false;
			}
			startDate = new Date(document.inputForm.start.value);
			endDate = new Date(document.inputForm.end.value);
			if (startDate > endDate)
			{
				alert("Error: Start date must come before End date.");
				document.inputForm.start.focus();
				return false;
			}
			return true;			
		}
		</script>
        <title>Drillhole Report</title>
    </head>
	 <style>
		body {
		  font-family: "arial", sans-serif;
		}
	</style>
    <body bgcolor="#57B7DF">
		<p>
		<h1>Enter a date range to query drillholes:</h1>
		<form name="inputForm" action="servlet" method="post" onSubmit="return validateForm()">
            <p>
			<p>
			Start Date: <input type="Date" name="start">
            <p>
			End Date:&nbsp; <input type="Date" name="end">
			<p>
			<input type="submit" value="Submit">
		</form>
    </body>
</html>