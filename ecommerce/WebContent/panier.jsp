
<%@ include file="pagehead.jsp" %>
	<div class="container">

		<h2>Votre panier contient : ${panier.size()} éléments</h2>
		<table class="table table-bordered  table-hover">
			<th>#</th>
			<th>Nom et description</th>
			<th>Quantité</th>
			<th>Prix unitaire</th>
			<th>Montant</th>
			<th>Edition</th>
			<c:set var="count" value="0" scope="page" />
			
			<c:forEach var="elt" items="${panier}">
				<tr id="${elt.getProduit().getId()}">
					<td><c:set var="count" value="${count + 1}" scope="page"/>${count }</td>
					<td>${elt.getProduit().getNom()}
					<span>${elt.getProduit().getDescription()}</span></td>
					<td name="${elt.getProduit().getId()}">
					 ${elt.getQuantite()}</td>
					<td><span id="prix${elt.getProduit().getId()}">${elt.getProduit().getPrix()}</span></td>
					<td><span id="montant${elt.getProduit().getId()}">${elt.getProduit().getPrix() * elt.getQuantite()}</span></td>
					<td>
					
					<select name="${elt.getProduit().getId()}">
							<option value="1">1</option>
							<option value="2">2</option>
							<option value="3">3</option>
							<option value="4">4</option>
					</select>
					<button class="btn btn-sm btn-success" id="update">Mettre à jour <i class="fa fa-recycle" aria-hidden="true"></i></button>
					<button class="btn btn-sm btn-danger">Supprimer <i class="fa fa-trash" aria-hidden="true"></i></button>
					
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td colspan="5" align="right">
				Total en euros : <span id="montanttotal">${total}</span>
				<td><a href="register.jsp" class="btn btn-warning">Valider la commande <i class="fa fa-check-circle" aria-hidden="true"></i></a></td>
			</tr>
			
		</table>
		<a href="Categorie">Revenir à la page des catégories de produits</a>
	</div>
	<script>
	$('tr #update').click(function(){
	    id = $(this).closest('tr').attr('id');
	    value=$('select[name='+ id +']').val();
	    prix=$("#prix"+id).text();
	    $('td[name='+ id +']').html(""+value);
	    $("#montant"+id).html(""+Math.round((parseInt(value) * parseFloat(prix))*100)/100);
	    $.post('AjoutPanier',{ idProduit: id, quantite: value },function(data){
			$("#montanttotal").text(data)
			console.log(data);
		    })
	    .done(function(){alert("Mise à jour effectuée avec succés")})
	    .fail(function(){alert("Echec de mise à jour")});
	});
	</script>
</body>
</html>