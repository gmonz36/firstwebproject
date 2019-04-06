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
				<td width="20%">Find customer to update:</td>
				
			</tr>
			<tr>				
				<td width="20%">SSN:</td>
				<td width="20%"><input type="Text" id= "SSN" name="SSN"></td>
			</tr>
			<tr>
				<td><input type="submit" value="Search" name="submit" onclick="return validate();"></td>
			</tr>
		</TABLE>
		<input type="hidden" name="Operation" value="UPDATE" />
		<input type="hidden" name="Table" value="CUSTOMER" />
	</form>
</body>
</html>