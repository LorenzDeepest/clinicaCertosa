<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
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

.carousel-inner>.item>img, .carousel-inner>.item>a>img {
	width: 70%;
	margin: auto;
}

.caption {
	font-family: Verdana, sans-serif;
	font-size: 10px;
	float: left;
	margin: 0;
	padding: 0;
	position: relative;
	overflow: hidden;
}

.caption img {
	float: center;
	margin: 0;
	padding: 0;
	background: #fff;
	border: none;
}

.caption span {
	float: center;
	margin: 0;
	padding: 10px;
	width: 100%;
	color: #dedede;
	background: #222; /* browser che non supportano rgba */
	background: rgba(0, 0, 0, 0.7);
	position: absolute;
	left: 0;
	bottom: 0;
}

.caption span strong {
	font-weight: bold;
	font-size: 11px;
	text-transform: uppercase;
	display: block;
	padding-bottom: 5px;
}
</style>
</head>
<body>
	<div class="jumbotron" align="center">
		<h1>Clinica Certosa</h1>
		<p>La salute prima di tutto!</p>
		<div class="container">
			<div style="float: right">
				<form action="controllerTipologie" method="get">
					<input class="btn btn-info" type="submit" name="sumbit"
						value="esami che svolgiamo" />

				</form>
				<p></p>
				<button type="button" class="btn btn-warning"
					onclick="document.location.href='loginAmministratore.jsp'">Area
					Privata</button>
			</div>
		</div>
	</div>
	<div class="container" align="center">
		<form class="form-inline" action="controllerLoginPaziente"
			method="post">
			<p>${idError}${erroreUsername}</p>
			<div class="form-group">
				<label for="username">Username:</label> <input type="text"
					class="form-control" name="id">
			</div>
			<p>${passwordError}${errorePassword}</p>
			<div class="form-group">
				<label for="pwd">Password:</label> <input type="password"
					class="form-control" name="password">
			</div>
			<p></p>
			<p> 
				<a href="registrazionePaziente.jsp"> registrati </a>
				<input type="submit" name="sumbit" value="entra">
			</p>
		</form>
		<br>
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner" role="listbox">
				<div class="item active">
					<div class="caption">
						<img
							src="http://servizisanitari.org/wp-content/uploads/2016/01/software-gestion-clinica-970x420.jpg"
							alt="App" width="970" height="420"> <span> <strong>ClinApp</strong>
							App ufficiale della clinica per saltare la fila
						</span>
					</div>
				</div>
				<div class="item">
					<div class="caption">
						<img src="http://www.swsensory.com/images/news/2/analisi.jpg"
							alt="laboratori" width="970" height="420"> <span> <strong>Nuovi
								Laboratori</strong> Permettono di avere risultati più precisi
						</span>
					</div>
				</div>
				<div class="item">
					<div class="caption">
						<img
							src="http://www.medicinalive.com/wp-content/uploads/2012/09/donna-incinta.jpg"
							alt="donnaincinta" width="970" height="420"> <span>
							<strong>Per donne in gravidanza over 40</strong> Analisi del
							sangue,Emocromo completo e Screening completamente gratuiti
						</span>
					</div>
				</div>
				<!-- Left and right controls -->
				<a class="left carousel-control" href="#myCarousel" role="button"
					data-slide="prev"> <span
					class="glyphicon glyphicon-chevron-left" aria-hidden="true"></span>
					<span class="sr-only">Previous</span>
				</a> <a class="right carousel-control" href="#myCarousel" role="button"
					data-slide="next"> <span
					class="glyphicon glyphicon-chevron-right" aria-hidden="true"></span>
					<span class="sr-only">Next</span>
				</a>
			</div>
			<h3>Chi Siamo</h3>
			<p>Siamo una clinica,che domande!</p>
		</div>
</body>
</html>