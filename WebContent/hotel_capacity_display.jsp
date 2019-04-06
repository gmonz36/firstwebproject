<%@page import="eHotel.entities.Room"%>
<%@page import="eHotel.entities.Hotel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel rooms capacity</title>
</head>
<body>
				<h4>Here are the room(s) you can book</h4>
				<ul>
					<%
						Object obj1 = request.getAttribute("allRooms");
						ArrayList<Room> roomList = null;
						if (obj1 instanceof ArrayList) {
							roomList = (ArrayList<Room>) obj1;
						}
						if (roomList != null) {
							int i = 1;
							for (Room room : roomList) {
								System.out.println(i);
								String str = "Room number "+room.getRoomNumber()+" has capacity for "+room.getCapacity();
					%>
					<li><%=str%></li>
					<%
						}
						}
					%>
				</ul>
<button onclick="location.href='customer_menu.jsp'">quit</button>
</body>
</html>