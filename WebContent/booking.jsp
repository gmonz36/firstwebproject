<%@page import="java.util.ArrayList"%>
<%@page import="eHotel.entities.Room"%>
<%@page import="eHotel.entities.HotelChain"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Booking Page</title>
</head>
<body>

	<%
		String CustName = (String) request.getAttribute("CustName");
	%>
	<form method="post" action="roombook">
		<h4>
			Welcome,
			<%=CustName%><h4>
				<input type="hidden" name="custName" value="<%=CustName%>" />
				<h4>Here are available hotel chains</h4>
				<select name = "hotelChains"> 
					<%
						Object objChain = request.getAttribute("allChains");
						ArrayList<HotelChain> chainList = null;
						if (objChain instanceof ArrayList) {
							chainList = (ArrayList<HotelChain>) objChain;
						}
						if (chainList != null) {
							for (HotelChain hotelChain : chainList) {
					%>					
						<option><%=hotelChain.getName()%></option>

					<%
						}
						}
					%> 
				</select> 
				<h4>Here are available hotels</h4>
				<h4>Here are available rooms</h4>

				<select name = "roomno">
					<%
						Object obj = request.getAttribute("allRooms");
						ArrayList<Room> roomList = null;
						if (obj instanceof ArrayList) {
							roomList = (ArrayList<Room>) obj;
						}
						if (roomList != null) {
							for (Room room : roomList) {
								/* String roominfo = room.getRoom_no() + "---" + room.getRoom_status(); */
					%>					
						<option><%=room.getRoom_no()%></option>

					<%
						}
						}
					%>
				</select>
				<button type="submit" onclick="return confirm('book?');">book</button>
	</form>


</body>
</html>