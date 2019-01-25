
<%@ include file="pagehead.jsp" %>

<div
	class="pricing-header px-3 py-3 pt-md-5 pb-md-4 mx-auto text-center">
	<h1 class="display-4">e-Boutique</h1>
	<p class="lead">Ce projet a été réalisé dans le cadre d'un module
		d'e-services, vous y trouverez un site proposant trois catégories de
		produits, des CD des DVD et des Livres, cliquez sur une catégorie de
		produit pour avoir une liste ensuite ajouter le produit qui vous
		intéresse au caddy.</p>
</div>
<div class="container">
	<div class="card-deck mb-3 text-center">
		<div class="card mb-4 shadow-sm">
			<div class="card-header">
				<h4 class="my-0 font-weight-normal">CD</h4>
			</div>
			<div class="card-body">
				<h1 class="card-title pricing-card-title">
					&lt; 5 &euro;<small class="text-muted">/ U</small>
				</h1>
				<ul class="list-unstyled mt-3 mb-4">
					<li>CD des années 90</li>
					<li>Musique POP</li>
					<li>Musique ROCK</li>
					<li>Hip Hop</li>
				</ul>
				<a href="Produit?idCategorie=1"
					class="btn btn-lg btn-block btn-primary">Découvrez</a>
			</div>
		</div>
		<div class="card mb-4 shadow-sm">
			<div class="card-header">
				<h4 class="my-0 font-weight-normal">Livre</h4>
			</div>
			<div class="card-body">
				<h1 class="card-title pricing-card-title">
					&lt; 12 &euro;<small class="text-muted">/ U</small>
				</h1>
				<ul class="list-unstyled mt-3 mb-4">
					<li>Littérature française</li>
					<li>Romans policiers</li>
					<li>Romans de fantaisie</li>
					<li>Livres romantiques</li>
				</ul>
				<a href="Produit?idCategorie=2"
					class="btn btn-lg btn-block btn-primary">Découvrez</a>
			</div>
		</div>
		<div class="card mb-4 shadow-sm">
			<div class="card-header">
				<h4 class="my-0 font-weight-normal">DVD</h4>
			</div>
			<div class="card-body">
				<h1 class="card-title pricing-card-title">
					&lt; 6 &euro; <small class="text-muted">/ U</small>
				</h1>
				<ul class="list-unstyled mt-3 mb-4">
					<li>Films d'auteur</li>
					<li>Films français</li>
					<li>Films américains</li>
					<li>Spectacles</li>
				</ul>
				<a href="Produit?idCategorie=3"
					class="btn btn-lg btn-block btn-primary">Découvrez</a>
			</div>
		</div>
	</div>
</div>
</body>
</html>