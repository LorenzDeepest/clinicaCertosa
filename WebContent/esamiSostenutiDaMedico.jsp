<%@page import="model.Esame"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.*"%>
<%
	Amministratore amministratore = (Amministratore) session.getAttribute("amministratoreCorrente");
	boolean autorizzato = true;
	if (amministratore != null)
		autorizzato = true;
	else
		autorizzato = false;
	if (!autorizzato) {
		out.clear();
		RequestDispatcher rd = application.getRequestDispatcher("/home.jsp");
		rd.forward(request, response);
		return;
	}
%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>clinicacertosa.it</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
<script
	src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>
<style>
.jumbotron {
	background-color: #0066CC; /* Blue */
	color: #ffffff;
}

table, th, td {
	border: 1px solid black;
	border-collapse: collapse;
}

th, td {
	padding: 5px;
}

div.ex {
	margin-left: 60px;
}
</style>
</head>
<body>
	<div class="jumbotron" align="center">
		<h1>Clinica Certosa</h1>
		<p>La salute prima di tutto!</p>
		<div class="container">
			<div style="float: left">
				<button style="" onclick="document.location.href='Sito/home.html'">
					<img
						src="http://paxtechnica.org/wp-content/uploads/2015/03/home.png"
						style="width: 50px; height: 50px;">
				</button>
			</div>
		</div>
	</div>
	<div class="ex">
		<h3>Analisi</h3>
		<div>
		<ul type="square">
			<c:forEach var="esame" items="${esami}">
				<li>${esame.tipologiaEsame.nome} effettuato il ${esame.dataEsame}</li>
			</c:forEach>
		</ul>
		</div>
	</div>
</body>
</html>