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
	<form method="post" action="roombook">
				<h4>Here are the room(s) you can book</h4>
				<ul>
					<%
						Object obj1 = request.getAttribute("allRooms");
						ArrayList<Room> broomList = null;
						if (obj1 instanceof ArrayList) {
							broomList = (ArrayList<Room>) obj1;
						}
						if (broomList != null) {
							int i = 1;
							for (Room room : broomList) {
								String str = "-------- Room "+i+"--------";
								String chain = "Chain name: "+room.getchainName();
								String hotel = "Hotel name: "+room.gethotelName();
								String number = "Room number: "+room.getRoomNumber();
								String price = "Price: "+room.getPrice()+"$";
								String capacity = "Capacity: "+room.getCapacity();
								String view = "View: "+room.getView();
								String extendable = "Extendable: ";
								if(room.isExtendable()){
									extendable+="Yes";
								} else { extendable+="No"; }
								String problems = "Problems description: "+room.getProblems();
								//TODO also add amenities
					%>
					<li><%=str%></li>
					<li><%=chain%></li>
					<li><%=hotel%></li>
					<li><%=number%></li>
					<li><%=price%></li>
					<li><%=capacity%></li>
					<li><%=view%></li>
					<li><%=extendable%></li>
					<li><%=problems%></li>
					<%
						}
						}
					%>
				</ul>
	</form>
<button onclick="location.href='index.html'">quit</button>
</body>
</html>