<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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

		<h2>Récapitulatif de vos informations</h2>
		<!-- 	TODO Ajouter la liste des informations clients -->
		<table class="table table-hover">
			<thead>
				<th>Nom</th>
				<th>Email</th>
				<th>Téléphone</th>
				<th>Adresse</th>
			</thead>
			<tr>
				<td>${customer.getNom() }</td>
				<td>${customer.getEmail() }</td>
				<td>${customer.getTelephone() }</td>
				<td>${customer.getAdresse() }</td>
			</tr>
		</table>
		<h2>Récapitulatif de votre commande :</h2>
		<table class="table table-bordered">
			<thead>
				<th>Nom et description</th>
				<th>Quantité</th>
				<th>Prix unitaire</th>
			</thead>
			<tbody>
				<c:forEach var="elt" items="${panier}">
					<tr>
						<td>${elt.getProduit().getNom()}
						<small class="form-text text-muted">${elt.getProduit().getDescription()}</small></td>
						<td>${elt.getQuantite()}</td>
						<td>${elt.getProduit().getPrix()}</td>
					</tr>
				</c:forEach>
				<tr>
					<td colspan="3" align="right">Total de votre panier ${total}
					</td>
				</tr>
			</tbody>
		</table>
		<a href="ValiderCommande" class="btn btn-warning">Valider la commande</a>
		<c:if test="${success == true }">
			<div class="alert alert-success">
				<p>${result } </p>
			</div>
		</c:if>
		<c:if test="${success == false }">
			<div class="alert alert-warning">
				<p>${result } </p>
			</div>
		</c:if>
	</div>
</body>
</html>