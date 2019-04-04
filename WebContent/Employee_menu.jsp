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
		
	//	else if(upass.value ==""){
		//	alert("password can't be null");
			//return false;
	//	}
		else
			return true;
	}

</script>
</head>
<body>

	<form method="post" action="empMenu">
		Perform Check-in on Customer SSN:<input type="text" id="SSN" name="customerSSN"><br>
		<button type="submit" value="submit" onclick="return validate();">Submit</button>
		<br>
		<br>
		Update database
		<button type="submit" value="Update" onclick="return validate();">Update</button>
		
		
	</form>

</body>
</html>