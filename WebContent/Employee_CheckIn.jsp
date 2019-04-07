<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eHotel.entities.Room"%>
<%@page import="eHotel.entities.HotelChain"%>
<%@page import="eHotel.entities.booking"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

	<form method="post" action="checkin">
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
	</form>
</body>
</html>