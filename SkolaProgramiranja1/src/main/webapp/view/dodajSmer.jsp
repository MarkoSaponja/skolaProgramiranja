<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>dodaj smer</title>
<link
	type = "text/css"
	rel = "stylesheet"
	href = "../css/style.css"
		/>
</head>
<body>
	<h1>DODAJ SMER</h1>
	
	<a href="admin.jsp">back to admin page</a>
	
	<form action="../DodajSmerController" method="get">
		NAZIV SMERA: <input type="text" name="nazivSmera" required><br>	
		SIFRA SMERA: <input type="text" name="sifraSmera" required><br>
		<input type="submit" value="ADD SMER">
</body>
</html>