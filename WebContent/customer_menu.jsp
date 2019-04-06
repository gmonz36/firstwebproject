<%@page import="java.util.ArrayList"%>
<%@page import="eHotel.entities.Room"%>
<%@page import="eHotel.entities.HotelChain"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome Page</title>
</head>
<body>
	<%
		String custSSN = (String) request.getAttribute("custSSN");
	%>
				<h4>Here are the room(s) you booked</h4>
				<ul>
					<%
						Object obj1 = request.getAttribute("bookedRooms");
						ArrayList<Room> broomList = null;
						if (obj1 instanceof ArrayList) {
							broomList = (ArrayList<Room>) obj1;
						}
						if (broomList != null) {
							for (Room room : broomList) {
								String roominfo = "Room number "+Integer.toString(room.getRoomNumber())+" in "+room.gethotelName();
					%>
					<li><%=roominfo%></li>
					<%
						}
						}
					%>
				</ul>
	<form method="post" action="initiateBooking">
				<input type="hidden" name="custSSN" value="<%=custSSN%>" />
				<button type="submit" value="submit">book a new room</button>
	</form>
	<form method="post" action="hotelCapacity">
				<button type="submit" value="submit">view rooms capacity for an hotel</button>
	</form>
<button onclick="location.href='area_search.jsp'">view available rooms per area</button>
<button onclick="location.href='index.html'">quit</button>
</body>
</html>