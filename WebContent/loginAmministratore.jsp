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
<script>
  $(document).ready(function(){
  $("#serial").keyup(function(e){
     if(e.keyCode == '13')
     {
      document.location.href="file:///home/emanuele/Scrivania/Sito/paginaAmministrazione.html"
     }
  });
  });
  </script>
<style>
.jumbotron {
	background-color: #CC0033; /* Blue */
	color: #66FF33;
}

form {
	min-width: 200px; /* set the min width here */
	width: 50%;
	max-width: 400px; /* set the max width here */
	margin: 0 auto;
}
</style>
</head>
<body>
	<div class="jumbotron" align="center">
		<h1>Clinica Certosa</h1>
		<p>La salute prima di tutto!</p>
	</div>
	<div class="container" align="center">
		<form  action="controllerLoginAmministratore" method="post">
			<p>${idError}</p><p>${erroreUsername}</p>
			<div class="form-group">
				<label for="username">mail:</label> <input type="text" name="id"class="form-control" id="username">
			</div>
			<p>${passwordError}</p><p>${errorePassword}</p>
			<div class="form-group">
				<label for="serial">password:</label> <input type="password" name="password" class="form-control" id="serial">
			</div>
			<div><input type="submit" name="sumbit" value="invia"></div>
		</form>
		
	</div>
</body>
</html>

