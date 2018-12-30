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
import eilco.metier.entities.Categorie;

/**
 * Servlet implementation class ServletCategorie
 */
@WebServlet("/Categorie")
public class ServletCategorie extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletCategorie() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		List<Categorie> categories = getAllCategories();
		// TODO affichage des categories sur categorie.jsp
		request.setAttribute("ListCategories", categories);
		request.setAttribute("nombreCategorie", categories.size());
		request.getRequestDispatcher("categories.jsp").forward(request,response);
	}

	protected List<Categorie> getAllCategories() {

		// Connexion JNDI (annuaire pour localiser l'EJB)
		try {
			final Hashtable jndiProperties = new Hashtable();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			final Context context = new InitialContext(jndiProperties);
			AccessCatalogueBeanRemote remote = (AccessCatalogueBeanRemote) context.lookup(
					"java:global/earecommerce/ejbecommerce/AccessCatalogueBean!eilco.metier.beans.AccessCatalogueBeanRemote");
			List<Categorie> categories = remote.getListeCategories();
			return categories;
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	

}
