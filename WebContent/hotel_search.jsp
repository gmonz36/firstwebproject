<%@page import="eHotel.entities.Hotel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Hotel Selection</title>
</head>
<body>
<h4>Here are available hotels</h4>
	<form method="post" action="displayHotel">

				<select name = "hotel">
					<%
						Object obj = request.getAttribute("allHotels");
						ArrayList<Hotel> hotelList = null;
						if (obj instanceof ArrayList) {
							hotelList = (ArrayList<Hotel>) obj;
						}
						if (hotelList != null) {
							for (Hotel hotel : hotelList) {
								/* String roominfo = room.getRoom_no() + "---" + room.getRoom_status(); */
					%>					
						<option><%=hotel.getHotelName()%> from chain <%=hotel.getChainName()%></option>

					<%
						}
						}
					%>
				</select>
				<button type="submit" onclick="return;">next</button>
	</form>

</body>
</html>