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
		String CustName = (String) request.getAttribute("CustName");
	%>
	<form method="post" action="roombook">
		<h4>
			Welcome,
			<%=CustName%><h4>
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
								//TODO display more information on booked rooms. HOTEL, CITY, STATE, ROOM NUMBER
								String roominfo = room.getRoom_no();
					%>
					<li><%=roominfo%></li>
					<%
						}
						}
					%>
				</ul>
				<input type="hidden" name="custName" value="<%=CustName%>" />
				<button onclick="location.href='index.html'">quit</button>
				<button onclick="location.href='booking.jsp'">book a new room</button>
	</form>


</body>
</html>