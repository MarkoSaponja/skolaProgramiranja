<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="model.User" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>admin</title>

<link
	type = "text/css"
	rel = "stylesheet"
	href = "../css/style.css"
		/>
</head>
		<!--moramo da ubacimo jstl.jar u lib-->
<body>
	<jsp:useBean id="user" scope="session" class="model.User"></jsp:useBean>
	<h1>Dobrodosli na administratorsku stranicu</h1>
	<p style="display: inline;">Ulogovan je: ${user.userName} </p>
	<a href="logout.jsp" style="margin-left: 30px;"><img alt="slika logout" src="../slike/logout.png">
	</a><br>
	<img alt="slika admina" src="../slike/admin_page.png"><br>
	<a href="addStudent.jsp"><button>ADD STUDENT</button></a>
	<a href="addProfesor.jsp"><button>ADD PROFESOR</button></a>
	<a href="addAdministrator.jsp"><button>ADD ADMINISTRATOR</button></a><br><br>
	<a href="dodajPredmet.jsp"><button>DODAJ PREDMET</button></a>
	<a href="dodajSmer.jsp"><button>DODAJ SMER</button></a><br><br>
	<a href="../PrikaziProfesoreController"><button>PRIKAZI PROFESORE</button></a>
	<a href="../SmerPredmetController"><button>PRIKAZI SMEROVE</button></a>
	<a href="../PrikaziStudenteController"><button>PRIKAZI STUDENTE</button></a><br><br>
	
	
</body>
</html>