<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area selection</title>
</head>
<body>
	Select an area.
	<br>
	<form method="post" action="areaSearch">
		state:<input type="text" id="state" name="state"><br>
		<br> city:<input type="text" id="city" name="city"><br>
		<br>
		<button type="submit" value="submit">submit</button>
		<button type="reset" value="reset">reset</button>
	</form>
</body>
</html>