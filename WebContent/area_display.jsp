<%@page import="eHotel.entities.Area"%>
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
				<h4>Here are the number of room(s) available per area</h4>
				<ul>
					<%
						Object obj1 = request.getAttribute("allRooms");
					ArrayList<Area> areaList = null;
						if (obj1 instanceof ArrayList) {
							areaList = (ArrayList<Area>) obj1;
						}
						if (areaList != null) {
							for (Area area : areaList) {
								String str;
								if(area.getNumberOfRooms()==null){
									str = "The city "+area.getCity()+" from "+area.getState()+" has no room(s) available";
								} else {
									str = "The city "+area.getCity()+" from "+area.getState()+" has "+area.getNumberOfRooms()+" room(s) available";
								}
					%>           
					<li><%=str%></li>
					<%
						}
						}
					%>
				</ul>
<button onclick="location.href='index.html'">quit</button>
</body>
</html>