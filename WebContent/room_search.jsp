<%@page import="java.util.ArrayList"%>
<%@page import="eHotel.entities.Room"%>
<%@page import="eHotel.entities.HotelChain"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Search room Page</title>
</head>
<body>
	<h4>Fill in the criteria for your room</h4>
	<form method = "post" action="roomSearch">
Start date(YYYY-MM-DD) *required:<input type="text" id="custSSN" name="custSSN"><br><br>
End date(YYYY-MM-DD) *required:<input type="text" id="custfirstName" name="custfirstName"><br><br>
Room capacity:<input type="text" id="custlastName" name="custlastName"><br><br>
Country:<input type="text" id="custStreetNumber" name="custStreetNumber"><br><br>
State:<input type="text" id="custStreetNumber" name="custStreetNumber"><br><br>
City:<input type="text" id="custStreetNumber" name="custStreetNumber"><br><br>
Hotel chain:<input type="text" id="custStreetName" name="custStreetName"><br><br>
category:<input type="text" id="custAptNumber" name="custAptNumber"><br><br>
hotel total number of room:<input type="text" id="custCity" name="custCity"><br><br>
maximum price:<input type="text" id="custState" name="custState"><br><br>
<button type="submit" onclick="return confirm('book?');">search</button>
</form>


</body>
</html>