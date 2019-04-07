<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eHotel.entities.Room"%>
<%@page import="eHotel.entities.HotelChain"%>
<%@page import="eHotel.entities.booking"%>
<%@page import="eHotel.entities.Renting"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="empcheckin">
	<%
		String custSSN = (String) request.getAttribute("SSN");
	%>
				<h4>Here are the customer's booked room(s)</h4>
				<ul>
					<%
						Object obj1 = request.getAttribute("bookings");
						ArrayList<booking> broomList = null;
						if (obj1 instanceof ArrayList) {
							broomList = (ArrayList<booking>) obj1;
						}
						if (broomList != null) {
							int i=1;
							for (booking bookings : broomList) {
								String roominfo = "Room number "+Integer.toString(bookings.getRoomNumber())+" in "+bookings.gethotelName();
								i++;
					%>
					<li><%=roominfo%></li>
					<li class="no-bullet">
					<button id='submit-<%=i%>' type="submit" name='bookingID' value="<%=bookings.getBookingID()%>" onclick="return confirm('Check-in?');">Check-in</button>
					</li>
					<%
						}
						}
					%>
				</ul>		
				
		<input type="hidden" name="SSN" value=<%=request.getAttribute("SSN")%> />		
	</form>
	
	<form method="post" action="payRent">
	
				<h4>Here are the customer's unpaid rented room(s)</h4>
				<ul>
					<%
						Object obj2 = request.getAttribute("rentings");
						ArrayList<Renting> broomList2 = null;
						if (obj2 instanceof ArrayList) {
							broomList2 = (ArrayList<Renting>) obj2;
						}
						if (broomList2 != null) {
							int i=1;
							for (Renting rentings : broomList2) {
								String roominfo = "Room number "+Integer.toString(rentings.getRoomNumber())+" in "+rentings.gethotelName();
								i++;
					%>
					<li><%=roominfo%></li>
					<li class="no-bullet">
					<button id='submit-<%=i%>' type="submit" name='rentingID' value="<%=rentings.getRentingID()%>" onclick="return confirm('Confirm Payment?');">Pay</button>
					</li>
					<%
						}
						}
					%>
				</ul>		
				
		<input type="hidden" name="SSN" value=<%=request.getAttribute("SSN")%> />		
	</form>
</body>
</html>