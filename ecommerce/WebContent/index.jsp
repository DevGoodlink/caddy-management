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
		<!-- 		<table class="table table-stripped"> -->
		<!-- 			<thead> -->
		<!-- 				<th>Nom</th> -->
		<!-- 				<th>Description</th> -->
		<!-- 				<th>Prix</th> -->
		<!-- 				<th></th> -->
		<!-- 			</thead> -->
		<!-- 			<tbody> -->
		<%-- 			<c:forEach var="produit" items="${listproduits}"> --%>
		<!-- 				<tr> -->
		<%-- 					<td>${produit.getNom() }</td><td>${produit.getDescription() }</td><td>${produit.getPrix() }</td> --%>
		<%-- 					<td><a href="ecommerce/panier?id=${produit.getId() }">Ajouter au panier</a></td> --%>
		<!-- 				</tr> -->
		<%-- 			</c:forEach> --%>

		<!-- 			</tbody> -->
		<!-- 		</table> -->
		<a href="Categorie">Liste des catégories</a>
	</div>

</body>
</html>