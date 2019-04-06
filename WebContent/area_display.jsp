<%@page import="eHotel.entities.Room"%>
<%@page import="eHotel.entities.Hotel"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<%
		Integer numberOfRooms = (Integer) request.getAttribute("numberOfRooms");
	%>
				<h4>There are <%=numberOfRooms%> rooms available in this area</h4>
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
<button onclick="location.href='customer_menu.jsp'">quit</button>
</body>
</html>