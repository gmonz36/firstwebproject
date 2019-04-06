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
<script>

	function validate() {
		var room_no = document.getElementById("room_no");
		if(room_no.value == ""){
			alert("room_no can't be null");
			return false;
		}
		else
			return true;
	}

</script>
</head>
<body>
	<form method="post" action="roombook">
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
								String str = "-------- Room option "+i+"--------";
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
								i++;
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
				Enter the room option number to book:<input type="text" id="option_no" name="option_no"><br><br>
				<button type="submit" value="submit" onclick="return validate();">book</button>
	</form>
<button onclick="location.href='index.html'">quit</button>
</body>
</html>