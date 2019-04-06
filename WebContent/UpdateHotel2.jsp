<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>

	function validate() {
		var mSSN = document.getElementById("mSSN");
		var chainName = document.getElementById("chainName");
		var hotelName = document.getElementById("hotelName");
		var starRating = document.getElementById("starRating");
		var streetNo = document.getElementById("streetNo");
		var streetName = document.getElementById("streetName");
		var city = document.getElementById("city");
		var state = document.getElementById("state");
		var pCode = document.getElementById("pCode");
		if(mSSN.value == ""){
			alert("SSN can't be null");
			return false;
		}		
		else if(chainName.value ==""){
			alert("Chain name can't be null");
			return false;
		}		
		else if(hotelName.value ==""){
			alert("Hotel name can't be null");
			return false;
		}		
		else if(starRating.value ==""){
			alert("Star Rating can't be null");
			return false;
		}		
		else if(streetNo.value ==""){
			alert("Street Number can't be null");
			return false;
		}		
		else if(streetName.value ==""){
			alert("Street Name can't be null");
			return false;
		}		
		else if(city.value ==""){
			alert("City can't be null");
			return false;
		}		
		else if(state.value ==""){
			alert("State can't be null");
			return false;
		}		
		else if(pCode.value ==""){
			alert("Postal Code can't be null");
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
				
				<td width="20%">Manager SSN:</td>
				<td width="20%"><input type="Text" id= "mSSN" name="mSSN"></td>
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
				<td width="20%">Star Rating (1-5):</td>
				<td width="20%"><input type="Text" id= "starRating" name="starRating"></td>
			</tr>
			<tr>
				<td width="20%">Street Number:</td>
				<td width="20%"><input type="Text" id= "streetNo" name="streetNo"></td>
			</tr>
			<tr>
				<td width="20%">Street Name:</td>
				<td width="20%"><input type="Text" id= "streetName" name="streetName"></td>
			</tr>
			<tr>
				<td width="20%">City:</td>
				<td width="20%"><input type="Text" id= "city" name="city"></td>
			</tr>
			<tr>
				<td width="20%">State:</td>
				<td width="20%"><input type="Text" id= "state" name="state"></td>
			</tr>
			<tr>
				<td width="20%">Postal Code:</td>
				<td width="20%"><input type="Text" id= "pCode" name="pCode"></td>
			</tr>
				<tr><td></td><td></td>
				<td><input type="submit" value="submit" onclick="return validate();"></td></tr>
		</TABLE>
		<input type="hidden" name="Operation" value=<%=(String) request.getAttribute("Operation")%> />
		<input type="hidden" name="Table" value=<%=(String) request.getAttribute("Table")%> />
	</form>

</body>
</html>