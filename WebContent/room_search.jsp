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
<script>

	function validate() {
		var startDate = document.getElementById("startDate");
		var endDate = document.getElementById("endDate");
		var d1 = Date.parse(startDate.value);
		var d2 = Date.parse(endDate.value);
		if(startDate.value == ""){
			alert("start date can't be null");
			return false;
		}
		else if(endDate.value ==""){
			alert("end date can't be null");
			return false;
		}
		else if(d2 < d1) {
			alert ("End date must be after start date");
			return false
		}
		else
			return true;
	}

</script>
</head>
<body>
	<%
		String custSSN = (String) request.getAttribute("custSSN");
	%>
	<h4>Fill in the criteria for your room</h4>
	<form method = "post" action="roomSearch">
Start date(YYYY-MM-DD) *required:<input type="text" id="startDate" name="startDate"><br><br>
End date(YYYY-MM-DD) *required:<input type="text" id="endDate" name="endDate"><br><br>
Room capacity:<input type="text" id="roomCapacity" name="roomCapacity"><br><br>
State:<input type="text" id="state" name="state"><br><br>
City:<input type="text" id="city" name="city"><br><br>
Hotel chain:<input type="text" id="hotelChain" name="hotelChain"><br><br>
Hotel:<input type="text" id="hotelName" name="hotelName"><br><br>
category:<input type="text" id="category" name="category"><br><br>
hotel total number of room:<input type="text" id="hotelRoomNbr" name="hotelRoomNbr"><br><br>
maximum price:<input type="text" id="price" name="price"><br><br>
<input type="hidden" name="custSSN" value="<%=custSSN%>" />
<button type="submit" value="submit" onclick="return validate();">search</button>
</form>

</body>
</html>