
<%@ include file="pagehead.jsp"%>
<div class=" jumbotron-fluid jumbotron bg-primary">
<p class="text-center blockquote " >Bienvenu dans l'espace d'admnistration de la boutique en ligne</p>
</div>
<div class="container">
	<h4>Gestion des catégories</h4>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>#</th>
				<th>Libelle</th>
				<th class="text-right"><button class="btn btn-info btn-sm"
						id="editcategorie">
						Ajouter <i class="fa fa-pencil" aria-hidden="true"></i>
					</button></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="categorie" items="${categories}">
				<tr id="${categorie.id}">
					<td>${categorie.id}</td>
					<td>${categorie.nom}</td>
					<td class="text-right">
						<button class="btn btn-danger btn-sm" id="deletecategorie">
							<i class="fa fa-trash-o" aria-hidden="true"></i>
						</button>
					</td>
				</tr>
			</c:forEach>
			<tr id="categorieform" style="display: none">
				<td colspan="2"><input type="text" class="form-control"
					id="nom" placeholder="nom catégorie" /></td>
				<td>
					<button class="btn btn-sm btn-primary" id="savecategorie">
						<i class="fa fa-save" aria-hidden="true"></i>
					</button>
					<button class="btn btn-sm btn-success" id="resetcategorie">
						<i class="fa fa-recycle" aria-hidden="true"></i>
					</button>
				</td>
			</tr>
		</tbody>
	</table>

	<h4>Gestion des Produits</h4>
	<table class="table table-hover">
		<thead>
			<tr>
				<th>#</th>
				<th>Libelle</th>
				<th>Description</th>
				<th>Prix</th>
				<th>M. à jour</th>
				<th class="text-right">
					<button class="btn btn-info btn-sm" id="editproduct">
						Ajouter <i class="fa fa-pencil" aria-hidden="true"></i>
					</button>
				</th>
			</tr>
		</thead>
		<c:forEach var="produit" items="${produits}">
			<tr id="${produit.id}">
				<td>${produit.id}</td>
				<td>${produit.nom }</td>
				<td><small class="form-text text-muted">
						${produit.description } </small></td>
				<td>${produit.prix }</td>
				<td>${produit.getDernierMaj() }</td>
				<td class="text-right">
					<button class="btn btn-danger btn-sm" id="deleteproduct">
						<i class="fa fa-trash-o" aria-hidden="true"></i>
					</button>

				</td>
			</tr>

		</c:forEach>
		<tr id="produitform" style="display: none">
			<td><input type="text" id="libelle" class="form-control"
				placeholder="Libelle" required /></td>
			<td><input type="text" id="description" class="form-control"
				placeholder="Description" required /></td>
			<td><input type="text" id="prix" class="form-control"
				placeholder="0.99" pattern="^\d+(\.\d{1,4})?$" required /></td>
			<td><select id="categorie" class="custom-select" required>
					<c:forEach var="categorie" items="${categories}">
						<option value="${categorie.id }">${categorie.nom }</option>
					</c:forEach>
			</select></td>
			<td colspan="2">
				<button class="btn btn-sm btn-primary" id="saveproduct">
					<i class="fa fa-save" aria-hidden="true"></i>
				</button>
				<button class="btn btn-sm btn-success" id="resetproduct">
					<i class="fa fa-recycle" aria-hidden="true"></i>
				</button>
			</td>
		</tr>
	</table>
	<script>
		$(document).ready(function() {
			$("button").click(function() {
				let id = $(this).closest('tr').attr('id');
				switch (this.id) {
				case "deletecategorie":
					console.log("delete categorie" + id);
					async("delete",{id:id,operation:"deletecategorie"})
					break;
				case "editcategorie":
					console.log("new categorie");
					$("#categorieform").toggle("slow");
					break;
				case "savecategorie":
					console.log("save categorie");
					nom = $("#nom").val();
					async("put",{nom:nom,operation:"savecategorie"})
					break;
				case "resetcategorie":
					console.log("reset categorie");
					break;
				case "deleteproduct":
					console.log("delete product" + id);
					async("delete",{id:id,operation:"deleteproduit"})
					break;
				case "editproduct":
					console.log("new product");
					$("#produitform").toggle("slow");
					break;
				case "saveproduct":
					console.log("save product");
					libelle=$("#libelle").val();
					description=$("#description").val();
					prix=$("#prix").val();
					categorie=$("#categorie").val();
					async("PUT",{libelle:libelle,
						description:description,
						prix:prix,
						categorie:categorie,
						operation:"saveproduct"});
					break;
				case "resetproduct":
					console.log("reset product");
					break;
				}
			})
		function async(method,data){
				console.log(data);
				$.ajax({
					url:"Management",
					data:data,
					method:method
			})
			.done(
					function(data){
						console.log(data);
						if(data){
							location.href="Management"
						}
					}
			);
		}

		})
		
	</script>
</div>
</body>
</html>