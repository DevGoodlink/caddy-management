<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<link rel="styleSheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" />
<link rel="styleSheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap-theme.min.css"
	integrity="sha384-rHyoN1iRsVXV4nD0JutlnGaslCJuC7uwjduW9SVrLvRYooPp2bWYgmgJQIXwl/Sp"
	crossorigin="anonymous" />
<title>Accueil</title>
</head>
<body style="margin: 0px; padding: 0px;">
	<nav class="navbar navbar-expand-lg navbar-dark bg-primary">
		<a class="navbar-brand" href="#">Site du E-Commerce</a>
		<button class="navbar-toggler" type="button" data-toggle="collapse"
			data-target="#navbarColor01" aria-controls="navbarColor01"
			aria-expanded="false" aria-label="Toggle navigation">
			<span class="navbar-toggler-icon"></span>
		</button>

		<div class="collapse navbar-collapse" id="navbarColor01">
			<ul class="navbar-nav mr-auto">
				<li class="nav-item active"><a class="nav-link"
					href="/ecommerce">Home <span class="sr-only">(current)</span></a></li>
				<li class="nav-item"><a class="nav-link"
					href="Produit?idCategorie=3">Livres</a></li>
				<li class="nav-item"><a class="nav-link"
					href="Produit?idCategorie=1">CD</a></li>
				<li class="nav-item"><a class="nav-link"
					href="Produit?idCategorie=2">DVD</a></li>
			</ul>
		</div>
	</nav>
	<div class="container">
		<!-- 	//TODO Lister les objets du panier avec le montant -->
		<h1 class="page-header">Enregistrement client</h1>
		<form action="Client" method="post">
			<div class="form-group row">
				<label for="customerName" class="col-2 col-form-label">Nom</label>
				<div class="col-10">
					<input required class="form-control" type="text" placeholder="Nom"
						id="customerName" name="customerName" >
				</div>
			</div>
			<div class="form-group row">
				<label for="customerEmail" class="col-2 col-form-label">Email</label>
				<div class="col-10">
					<input required class="form-control" type="email"
						placeholder="client@ecommerce.com" id="customerEmail"
						name="customerEmail">
				</div>
			</div>
			<div class="form-group row">
				<label for="customerAdress" class="col-2 col-form-label">Adresse</label>
				<div class="col-10">
					<input required class="form-control" type="text"
						placeholder="Adresse" id="customerAdress" name="customerAdress">
				</div>
			</div>
			<div class="form-group row">
				<label for="example-tel-input" class="col-2 col-form-label">Telephone</label>
				<div class="col-10">
					<input required class="form-control" type="tel"
						placeholder="0649776148" id="customerPhone" name="customerPhone" >
				</div>
			</div>
			<input type="reset" value="Effacer" class="btn btn-success" /> <input
				type="submit" value="Valider" class="btn btn-primary" />
		</form>
	</div>
	<footer class="container py-5">
		<div class="row">
			<div class="col-12 col-md">
				<svg xmlns="http://www.w3.org/2000/svg" width="24" height="24"
					viewBox="0 0 24 24" fill="none" stroke="currentColor"
					stroke-width="2" stroke-linecap="round" stroke-linejoin="round"
					class="d-block mb-2" focusable="false" role="img">
					<title>Product</title>
					<circle cx="12" cy="12" r="10"></circle>
					<line x1="14.31" y1="8" x2="20.05" y2="17.94"></line>
					<line x1="9.69" y1="8" x2="21.17" y2="8"></line>
					<line x1="7.38" y1="12" x2="13.12" y2="2.06"></line>
					<line x1="9.69" y1="16" x2="3.95" y2="6.06"></line>
					<line x1="14.31" y1="16" x2="2.83" y2="16"></line>
					<line x1="16.62" y1="12" x2="10.88" y2="21.94"></line></svg>
				<small class="d-block mb-3 text-muted">&copy; 2017-2018</small>
			</div>
			<div class="col-6 col-md">
				<h5>Features</h5>

			</div>
			<div class="col-6 col-md">
				<h5>Resources</h5>

			</div>
			<div class="col-6 col-md">
				<h5>Resources</h5>

			</div>
			<div class="col-6 col-md">
				<h5>About</h5>

			</div>
		</div>
	</footer>
</body>
</html>