<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
<%@page import="java.util.ArrayList"%>
<%@page import="eHotel.entities.Room"%>
<%@page import="eHotel.entities.HotelChain"%>
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
				<h4>Here are the room(s) you booked</h4>
				<ul>
					<%
						Object obj1 = request.getAttribute("bookedRooms");
						ArrayList<Room> broomList = null;
						if (obj1 instanceof ArrayList) {
							broomList = (ArrayList<Room>) obj1;
						}
						if (broomList != null) {
							int i=1;
							for (Room room : broomList) {
								String roominfo = "Room number "+Integer.toString(room.getRoomNumber())+" in "+room.gethotelName();
								i++;
					%>
					<li><%=roominfo%></li>
					<li class="no-bullet">
					<button id='submit-<%=i%>' type="submit" name='submit' value="<%=room.getchainName()%>--<%=room.gethotelName()%>--<%=room.getRoomNumber()%>" onclick="return confirm('Check-in?');">Check-in</button>
					</li>
					<%
						}
						}
					%>
				</ul>				
	</form>
</body>
</html>