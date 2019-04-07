<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Employee Page</title>
<script>

	function validate() {
		var ssn = document.getElementById("SSN");
		//var upass = document.getElementById("upass");
		if(ssn.value == ""){
			alert("SSN can't be null");
			return false;
		}
		
		else
			return true;
	}

</script>
</head>
<body>

		
	
	
	<form method="post" action="empMenu">
		Perform Check-in on Customer SSN:<input type="text" id="SSN" name="SSN"><br>
		<button type="submit" value="submit" onclick="return validate();">Submit</button>
		<br>
		
		
	</form>
	
	<form method="post" action="empMenu2">
		<br>
		Update database
		<button type="submit" value="submit" onclick="return true;">Update</button>
		<input type="hidden" name="username" value=<%=(String) request.getAttribute("employee_id")%> />
	</form>
	
	

</body>
</html>