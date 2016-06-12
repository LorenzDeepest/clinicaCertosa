<%@page import="model.TipologiaEsame"%>
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
	background-color: #CC0033; /* Blue */
	color: #66FF33;
}

div.ex {
	margin-left: 60px;
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
	<div class="ex">
		<div class="container" align="center">
			<form action="controllerCreaEsame" method="post">
				<p>Tipologia esame:</p>
				<c:forEach var="tipologiaEsame" items="${tipologieEsame}">
					<p>
						<input type="radio" name="tipologiaEsame" value="${tipologiaEsame.nome}"> ${tipologiaEsame.nome}
					</p>
				</c:forEach>
				<p>Codice fiscale del paziente:</p>
				<p>${errorePaziente}
					<input type="text" name="paziente">
				</p>
				<p>Codice fiscale del medico:</p>
				<p>${erroreMedico}
					<input type="text" name="medico">
				</p>
				<p>Data:</p>
				<p>
					<input name="data" type="text" value="dd/mm/yyyy" title="dd/mm/yyyy" onfocus = "if (this.value == this.title) this.value = '';"
							onblur = "if (this.value == '') this.value = this.title" />
				<p>Ora:</p>
				<p>
					<input name="ora" type="text" value="hh:mm" title="hh:mm" onfocus = "if (this.value == this.title) this.value = '';"
						onblur = "if (this.value == '') this.value = this.title" />
	
					
					
				</p>
				<p>
					<input type="submit" name="inserireAltroEsame" value="inserireAltroEsame"> 
					<input type="submit" name="finito" value="finito">
				</p>
			</form>
		</div>
	</div>
</body>
</html>