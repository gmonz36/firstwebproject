<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Area selection</title>
<script>

	function validate() {
		var state = document.getElementById("state");
		var city = document.getElementById("city");
		if(state.value == ""){
			alert("state can't be null");
			return false;
		}
		
		else if(city.value ==""){
			alert("password can't be null");
			return false;
		}
		else
			return true;
	}

</script>
</head>
<body>
	Enter an area.
	<br>
	<form method="post" action="areaSearch">
		state:<input type="text" id="state" name="state"><br>
		<br> city:<input type="text" id="city" name="city"><br>
		<br>
		<button type="submit" value="submit" onclick="return validate();">submit</button>
		<button type="reset" value="reset">reset</button>
	</form>
</body>
</html>