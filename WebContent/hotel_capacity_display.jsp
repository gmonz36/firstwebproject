<%@page import="eHotel.entities.hotelRoomCapacity"%>
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
				<h4>Here are the hotel room(s) capacity</h4>
				<ul>
					<%
						Object obj1 = request.getAttribute("allHotels");
					ArrayList<hotelRoomCapacity> roomList = null;
						if (obj1 instanceof ArrayList) {
							roomList = (ArrayList<hotelRoomCapacity>) obj1;
						}
						if (roomList != null) {
							for (hotelRoomCapacity hotelRoomCapacity : roomList) {
								String str = "Hotel "+hotelRoomCapacity.getHotelName()+" from the chain "+hotelRoomCapacity.getChainName()+" has capacity for "+hotelRoomCapacity.getCapacity();
					%>
					<li><%=str%></li>
					<%
						}
						}
					%>
				</ul>
<button onclick="location.href='index.html'">exit</button>
</body>
</html>