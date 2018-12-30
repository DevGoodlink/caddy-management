package eilco.presentation.viewlayer;

import java.io.IOException;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import eilco.metier.beans.AccessCatalogueBeanRemote;
import eilco.metier.entities.Produit;

/**
 * Servlet implementation class ServletProduit
 */
@WebServlet("/Produit")
public class ServletProduit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletProduit() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int idCategorie = Integer.parseInt(request.getParameter("idCategorie"));
		
		List<Produit> produits = getProduitsByCategorie(idCategorie);
		//TODO affichage des produits sur produits.jsp
		//response.getWriter().append("Catégorie"+idCategorie+ "Produits récupérés = "+produits.size()).append(request.getContextPath());
		request.setAttribute("categorie",produits.get(0).getCategorie().getNom() );//nom de la catégorie
		request.setAttribute("ListProduits", produits);
		request.setAttribute("NombreProduit", produits.size());
		request.getRequestDispatcher("produits.jsp").forward(request,response);
	}

	protected List<Produit> getProduitsByCategorie(int idCategorie) {
		// Connexion JNDI (annuaire pour localiser l'EJB)
		try {
			final Hashtable jndiProperties = new Hashtable();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			final Context context = new InitialContext(jndiProperties);
			AccessCatalogueBeanRemote remote = (AccessCatalogueBeanRemote) context.lookup(
					"java:global/earecommerce/ejbecommerce/AccessCatalogueBean!eilco.metier.beans.AccessCatalogueBeanRemote");
			List<Produit> produits = remote.getListeProduits(idCategorie);
			return produits;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
