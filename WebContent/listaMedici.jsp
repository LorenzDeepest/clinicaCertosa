<%@page import="model.Medico"%>
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
		<h3>Lista Medici</h3>
		<table style="width: 100%">
			<c:forEach var="medico" items="${medici}">
				<tr>
					<td>
						<form action="controllerESM" method="get">
							<input type="submit" name="nomeMedico"
								value="dott: ${medico.nome} ${medico.cognome} ${medico.email}">
						</form>
					</td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>