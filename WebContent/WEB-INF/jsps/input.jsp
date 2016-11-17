<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Input Information</title>
</head>
<body>
	<h1>Please enter student information</h1>
	<form action="processForm" method="post">
		ID:<input type ="text" name = "id"/><br>
		Name:<input type = "text" name = "name"/><br><br>
		<input type = "submit" value = "Add Student"/>
		
	</form>

</body>
</html>