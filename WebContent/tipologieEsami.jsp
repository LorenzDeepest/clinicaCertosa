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

table {
	border-spacing: 15px;
}
</style>
</head>
<body>
	<div class="jumbotron" align="center">
		<h1>Clinica Certosa</h1>
		<p>La salute prima di tutto!</p>
		<div class="container">
			<div style="float: left">
				<button style="" onclick="document.location.href='home.jsp'">
					<img
						src="http://paxtechnica.org/wp-content/uploads/2015/03/home.png"
						style="width: 50px; height: 50px;">
				</button>
			</div>
		</div>
	</div>
	<div class="container" align="center">
		<h3>Analisi</h3>
		<table>
			<c:forEach var="esame" items="${esami}">
				<tr>
					<td><form action="controllerTipologie" method="get">
							<p>
								<input type="submit" name="nomeEsame" value="${esame.nome}" />
							</p>

						</form></td>
				</tr>
			</c:forEach>

		</table>
	</div>
</body>
</html>