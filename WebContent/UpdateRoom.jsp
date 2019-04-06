<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form method="post" action=dbUpdate2>
		<TABLE style="background-color: #ECE5B6;" WIDTH="100%">
			<tr>				
				<td width="20%">Find Room to update:</td>
				
			</tr>
			<tr>
				<td width="20%">Hotel Chain Name:</td>
				<td width="20%"><input type="Text" id= "chainName" name="chainName"></td>
			</tr>
			<tr>
				<td width="20%">Hotel Name:</td>
				<td width="20%"><input type="Text" id= "hotelName" name="hotelName"></td>
			</tr>
			<tr>
				<td width="20%">Room Number:</td>
				<td width="20%"><input type="Text" id= "roomNumber" name="roomNumber"></td>
			</tr>
		</TABLE>
		<input type="hidden" name="Operation" value=<%=(String) request.getAttribute("Operation")%> />
		<input type="hidden" name="Table" value=<%=(String) request.getAttribute("Table")%> />
	</form>
</body>
</html>