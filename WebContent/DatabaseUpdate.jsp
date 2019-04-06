<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script>

	function validate() {
		var radios = document.getElementsByTagName('Operation');
		var value=false;
		for (var i = 0; i < radios.length; i++) {
		    if (radios[i].type === 'radio' && radios[i].checked) {
		        // get value, set checked flag or do whatever you need to
		        value = true;       
		    }
		}
		
		
		var radios2 = document.getElementsByTagName('Table');
		var value2=false;
		for (var i = 0; i < radios.length; i++) {
		    if (radios[i].type === 'radio' && radios[i].checked) {
		        // get value, set checked flag or do whatever you need to
		        value2 true;      
		    }
		}

		if (value==false || value2 ==false) {
			alert("Radio buttons must be selected");
			return false;
		}else{
			return true;
		}
	}

</script>
</head>
<body>
<%=(String) request.getAttribute("employee_id")%>

	<form method="post" action="dbUpdate">
		<TABLE style="background-color: #ECE5B6;" WIDTH="100%">
			<tr>
				<td width="20%">Operation</td>
				<td width="20%"><input type="radio" name="Operation" value="INSERT">INSERT</td>
				<td width="20%"><input type="radio" name="Operation" value="UPDATE">UPDATE/DELETE</td>
			</tr>
			<tr>
				<td width="20%">Table</td>
				<td width="20%"><input type="radio" name="Table" value="CUSTOMER">CUSTOMER</td>
				<td width="20%"><input type="radio" name="Table" value="EMPLOYEE">EMPLOYEE</td>
				<td width="20%"><input type="radio" name="Table" value="HOTEL">HOTEL</td>
				<td width="20%"><input type="radio" name="Table" value="ROOM">ROOM</td>
			</tr>
				<tr><td></td><td></td>
				<td><input type="submit" value="submit" onclick="return validate();"></td></tr>
		</TABLE>
		
	</form>

</body>
</html>