<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>

	function validate() {
		var SSN = document.getElementById("SSN");
		var password = document.getElementById("password");
		var username = document.getElementById("username");
		var position = document.getElementById("position");
		var registrationdate = document.getElementById("registrationdate");
		var chainName = document.getElementById("chainName");
		var hotelName = document.getElementById("hotelName");
		var streetNo = document.getElementById("streetNo");
		var streetName = document.getElementById("streetName");
		var aptNo = document.getElementById("aptNo");
		var city = document.getElementById("city");
		var state = document.getElementById("state");
		var pCode = document.getElementById("pCode");
		var registrationdate = document.getElementById("registrationdate");
		
		if(SSN.value == "" || password.value == "" || chainname.value == "" || hotelname.value == "" || username.value == "" || position.value == "" || FirstName.value == "" || LastName.value == "" || streetNo.value == "" || streetName.value == "" || aptNo.value == "" || city.value == "" || state.value == "" || pCode.value == ""){
			alert("All fields must be filled");
			return false;
		}		
		else
			return true;
	}

</script>
</head>
<body>

	<form method="post" action=dbUpdate3>
		<TABLE style="background-color: #ECE5B6;" WIDTH="100%">
			<tr>
				<td width="20%">Hotel Chain Name:</td>
				<td width="20%"><input type="Text" id= "chainName" name="chainName" readonly="readonly" value=<%=(String) request.getAttribute("chainName")%>></td>
			</tr>
			<tr>
				<td width="20%">Hotel Name:</td>
				<td width="20%"><input type="Text" id= "hotelName" name="hotelName" readonly="readonly" value=<%=(String) request.getAttribute("hotelName")%>></td>
			</tr>
			<tr>
				<td width="20%">Room Number:</td>
				<td width="20%"><input type="Text" id= "roomNumber" name="roomNumber" readonly="readonly" value=<%=(String) request.getAttribute("roomNumber")%>></td>
			</tr>
			<tr>
				<td width="20%">Price:</td>
				<td width="20%"><input type="Text" id= "price" name="price" value=<%=(String) request.getAttribute("price")%>></td>
			</tr>
			<tr>
				<td width="20%">Capacity:</td>
				<td width="20%"><input type="Text" id= "capacity" name="capacity" value=<%=(String) request.getAttribute("capacity")%>></td>
			</tr>
			<tr>
				<td width="20%">View:</td>
				<td width="20%"><input type="Text" id= "view" name="view" value=<%=(String) request.getAttribute("view")%>></td>
			</tr>
			<tr>
				<td width="20%">Extendable:</td>
				<td width="20%"><input type="Radio" id= "extendable" name="extendable" value="True" <%= ("t".equals(request.getAttribute("extendable")) ? "checked" : "") %>> Yes </td>
				<td width="20%"><input type="Radio" id= "extendable" name="extendable" value="False" <%= ("f".equals(request.getAttribute("extendable")) ? "checked" : "") %>> No </td>
			</tr>
			<tr>
				<td width="20%">Amenities:</td>
				<td width="20%"><input type="Checkbox" id= "tv" name="tv"  value="Television" <%= ("Television".equals(request.getAttribute("Television")) ? "checked" : "") %>>Television</td>
				<td width="20%"><input type="Checkbox" id= "airCond" name="airCond" value="Air Conditioning" <%= ("airCon".equals(request.getAttribute("airCon")) ? "checked" : "") %>>Air Conditioning</td>
				<td width="20%"><input type="Checkbox" id= "fridge" name="fridge" value="Fridge" <%= ("Fridge".equals(request.getAttribute("Fridge")) ? "checked" : "") %>>Fridge</td>
			</tr>
		</TABLE>
		
		<TABLE style="background-color: #ECE5B6;" WIDTH="100%">		
			<tr>
				<td width="20%">Problems:</td>
				<td width=80%><textarea rows="4" cols="50" id= "problems" name="problems"></textarea></td>
			</tr>
			
			<tr>
				<td><input type="submit" value="UPDATE" name="Operation" onclick="return validate();"></td>
				<td><input type="submit" value="DELETE" name="Operation" onclick="return true;"></td></tr>
				
		</TABLE>
		<input type="hidden" name="Operation" value=<%=(String) request.getAttribute("Operation")%> />
		<input type="hidden" name="Table" value=<%=(String) request.getAttribute("Table")%> />
	</form>

</body>
</html>