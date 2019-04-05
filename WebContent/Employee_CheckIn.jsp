<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

		<form method="post" action="checkin">
<ul>

					<%
					if (request.getAttribute("chainname") != null){
					
					String message = "The following room has been booked for today:";
					String chainname= (String) request.getAttribute("chainname");
					String hotelname=(String)request.getAttribute("hotelname");
					String roomnumber=(String)request.getAttribute("roomnumber");
					String customerSSN=(String)request.getAttribute("customerSSN");
					String bookingID=(String)request.getAttribute("bookingid");
					String CheckInDate=(String)request.getAttribute("checkindate");
					String CheckOutDate =(String)request.getAttribute("checkoutdate");					
						%>
					<li><%=message%></li>
					<li><%=chainname%></li>
					<li><%=hotelname%></li>
					<li><%=roomnumber%></li>
					<li><%=customerSSN%></li>
					<li><%=bookingID%></li>
					<li><%=CheckInDate%></li>
					<li><%=CheckOutDate%></li>
					
		
					<% } 
					else{
						
					}
					%>
					
				</ul>
				
		Perform Check-in on Customer SSN:<input type="text" id="SSN" name="customerSSN"><br>
		<button type="submit" value="submit" onclick="return validate();">Submit</button>
		<br>
		<br>
		
	
	</form>
</body>
</html>