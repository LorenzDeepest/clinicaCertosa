<%@page import="model.Esame"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="model.*"%>
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

form {
	min-width: 200px; /* set the min width here */
	width: 50%;
	max-width: 400px; /* set the max width here */
	margin: 0 auto;
}
</style>
<script>
	function show_alert() {
		alert("Confermi inserimento dati?")
	}
</script>
</head>
<body>
	<div class="jumbotron" align="center">
		<h1>Clinica Certosa</h1>
		<p>La salute prima di tutto!</p>
		<div class="container">
			<div style="float: left">
				<button style=""
					onclick="document.location.href='file:///home/emanuele/Scrivania/Sito/home.html'">
					<img
						src="http://paxtechnica.org/wp-content/uploads/2015/03/home.png"
						style="width: 50px; height: 50px;">
				</button>
			</div>
		</div>
	</div>
	<div class="alert alert-warning" align="center">
		<strong>Attenzione!</strong>Si prega di compilare tutti i moduli
		sottostanti
	</div>
	<div class="container" align="center">
		<form action="controllerRegistrazione" method="post">
			<div class="form-group">
				<p>${nomeError}</p>
				<label for="name">Nome:</label> <input type="text"
					class="form-control" name="nome">
			</div>
			<div class="form-group">
				<p>${cognomeError}</p>
				<label for="surname">Cognome:</label> <input type="text"
					class="form-control" name="cognome">
			</div>
			<div class="form-group">
				<p>${dataDiNascitaError}</p>
				<label for="born">Data di Nascita:</label> <input type="text"
					class="form-control" name="dataDiNascita" value="dd/mm/yyyy">
			</div>
			<div class="form-group">
				<p>${codiceFiscaleError}</p>
				<label for="code">Codice Fiscale:</label> <input type="text"
					class="form-control" name="codiceFiscale">
			</div>
			<div class="form-group">
				<p>${mailError}</p>
				<label for="code">Mail:</label> <input type="text"
					class="form-control" name="mail">
			</div>
			<div class="form-group">
				<p>${mailError}</p>
				<label for="code">Inserire di nuovo la mail:</label> <input
					type="text" class="form-control" name="mail2">
			</div>
			<div class="form-group">
				<p>${passwordError}</p>
				<label for="code">Password:</label> <input type="password"
					class="form-control" name="password">
			</div>
			<div class="form-group">
				<p>${passwordError}</p>
				<label for="code">Inserire di nuovo la password:</label> <input
					type="password" class="form-control" name="password2">
			</div>
			<div class="form-group">
				<input type="submit" name="sumbit" value="invia" />
			</div>
		</form>
	</div>


</body>
</html>