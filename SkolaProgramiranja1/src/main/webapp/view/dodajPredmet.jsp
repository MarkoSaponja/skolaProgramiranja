<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>dodaj predmet</title>
<link
	type = "text/css"
	rel = "stylesheet"
	href = "../css/style.css"
		/>
</head>
<body>
	<h1>DODAJ PREDMET</h1>
	
	<a href="admin.jsp">back to admin page</a>
	
	<form action="../DodajPredmetController" method="post">
		NAZIV PREDMETA: <input type="text" name="nazivPredmeta" required><br>	
		SIFRA PREDMETA: <input type="text" name="sifraPredmeta" required><br>
		<input type="submit" value="ADD PREDMET">
	
	</form>

</body>
</html>