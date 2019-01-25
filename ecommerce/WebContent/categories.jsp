
<%@ include file="pagehead.jsp" %>
	<div class="container">
		<h2>
			Nombre de catégories disponibles sur le site :
			<c:out value="${nombreCategorie}"></c:out>
		</h2>
		<table class="table table-hover">
			<c:forEach var="categorie" items="${ListCategories}">
				<tr>
					<td><a href="Produit?idCategorie=${categorie.getId()}">${categorie.getNom() }</a></td>
				</tr>
			</c:forEach>
		</table>
	</div>
</body>
</html>