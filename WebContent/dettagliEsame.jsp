<%@page import="model.TipologiaEsame"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
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
div.ex {
    margin-left: 60px;
}
</style>
</head>
<body>
	<div class="jumbotron" align="center">
		<h1>Clinica Certosa</h1>
		<p>La salute prima di tutto!</p>
	</div>
	<div class="ex">
		<h3>Dettagli</h3>
		<p>Nome: ${esame.nome}</p>
		<p>Descrizione: ${esame.descrizione}</p>
		<p>Costo: ${esame.costo}€</p>
		<p></p>
		<p>Prerequisiti:</p>
		<ul type="square">
			<c:forEach var="prerequisito" items="${esame.prerequisiti}">
				<li>${prerequisito.nome}: ${prerequisito.descrizione}
			</c:forEach>
		</ul>
		<p></p>
		<p>Indicatori:</p>
		<ul type="square">
			<c:forEach var="indicatore" items="${esame.indicatori}">
				<li>${indicatore.name}
			</c:forEach>
		</ul>

	</div>
</body>
</html>