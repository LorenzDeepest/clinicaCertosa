<%@page import="model.TipologiaEsame"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.*"%>
<%
	Paziente paziente = (Paziente) session.getAttribute("pazienteCorrente");
	boolean autorizzato = true;
	if (paziente != null)
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

table, th, td {
	border: 1px solid black;
	padding: 5px;
}

table {
	border-spacing: 15px;
}
</style>
</head>
<body>
	<div class="jumbotron" align="center">
		<h1>Clinica Certosa</h1>
		<p>La salute prima di tutto!</p>
	</div>
	<div class="container" align="center">
		<p>
			<b>Esami sostenuti:</b>
		</p>
		<ul type="square">
			<c:forEach var="esameSostenuto" items="${esamiPaziente}">
				<p>
				<form action="controllerRisultatiEsame" method="get">
					<input align="left" type="submit" name="nomeEsame"
						value="${esameSostenuto.tipologiaEsame.nome} : ${esameSostenuto.dataEsame}" />
				</form>
				</p>
			</c:forEach>
		</ul>

	</div>
</body>
</html>