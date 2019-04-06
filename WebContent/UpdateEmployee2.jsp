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
				
				<td width="20%">SSN:</td>
				<td width="20%"><input type="Text" id= "SSN" name="SSN" readonly="readonly" value=<%=(String) request.getAttribute("ssn")%>></td>
			</tr>
			<tr>
				
				<td width="20%">First Name:</td>
				<td width="20%"><input type="Text" id= "FirstName" name="FirstName" value=<%=(String) request.getAttribute("firstname")%>></td>
			</tr>
			<tr>
				
				<td width="20%">Last Name:</td>
				<td width="20%"><input type="Text" id= "LastName" name="LastName" value=<%=(String) request.getAttribute("lastname")%>></td>
			</tr>
			
			<tr>
				<td width="20%">Street Number:</td>
				<td width="20%"><input type="Text" id= "streetNo" name="streetNo" value=<%=(String) request.getAttribute("streetnumber")%>></td>
			</tr>
			<tr>
				<td width="20%">Street Name:</td>
				<td width="20%"><input type="Text" id= "streetName" name="streetName" value=<%=(String) request.getAttribute("streetname")%>></td>
			</tr>
			<tr>
				<td width="20%">Apartment Number:</td>
				<td width="20%"><input type="Text" id= "aptNo" name="aptNo" value=<%=(String) request.getAttribute("aptnumber")%>></td>
			</tr>
			<tr>
				<td width="20%">City:</td>
				<td width="20%"><input type="Text" id= "city" name="city" value=<%=(String) request.getAttribute("city")%>></td>
			</tr>
			<tr>
				<td width="20%">State:</td>
				<td width="20%"><input type="Text" id= "state" name="state" value=<%=(String) request.getAttribute("state")%>></td>
			</tr>
			<tr>
				<td width="20%">Postal Code:</td>
				<td width="20%"><input type="Text" id= "pCode" name="pCode" value=<%=(String) request.getAttribute("postalcode")%>></td>
			</tr>
			<tr>
				<td width="20%">Hotel Chain Name:</td>
				<td width="20%"><input type="Text" id= "chainName" name="chainName" value=<%=(String) request.getAttribute("chainname")%>></td>
			</tr>
			<tr>
				<td width="20%">Hotel Name:</td>
				<td width="20%"><input type="Text" id= "hotelName" name="hotelName" value=<%=(String) request.getAttribute("hotelname")%>></td>
			</tr>
			<tr>
				<td width="20%">Position:</td>
				<td width="20%"><input type="Text" id= "position" name="position" value=<%=(String) request.getAttribute("position")%>></td>
			</tr>
			<tr>
				<td width="20%">Username:</td>
				<td width="20%"><input type="Text" id= "username" name="username" value=<%=(String) request.getAttribute("username")%>></td>
			</tr>
			<tr>
				<td width="20%">Password:</td>
				<td width="20%"><input type="Password" id= "password" name="password" value=<%=(String) request.getAttribute("password")%>></td>
			</tr>
				<tr><td></td><td></td>
				<td><input type="submit" value="UPDATE" name="Operation" onclick="return validate();"></td>
				<td><input type="submit" value="DELETE" name="Operation" onclick="return true;"></td></tr>
		</TABLE>
		<input type="hidden" name="Table" value=<%=(String) request.getAttribute("Table")%> />
	</form>

</body>
</html>