package eilco.presentation.viewlayer;

import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import eilco.metier.beans.AccessCatalogueBeanRemote;
import eilco.metier.entities.Produit;
import eilco.metier.entities.ProduitCommande;

/**
 * Servlet implementation class ServletAjoutPanier
 */
@WebServlet("/AjoutPanier")
public class ServletAjoutPanier extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ServletAjoutPanier() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		List<ProduitCommande> panier;
		float total;
		if (session.getAttribute("panier") instanceof List) {
			panier = (List<ProduitCommande>) session.getAttribute("panier");
			total = Float.parseFloat(session.getAttribute("total").toString());
			//System.out.println("Panier existe");
		} else {
			panier = new ArrayList<ProduitCommande>();
			total = 0.f;
			//System.out.println("panier créé");
		}
		int idProduit = Integer.parseInt(request.getParameter("idProduit"));
		int quantite = Integer.parseInt(request.getParameter("quantite"));
		Produit produit = getProduitById(idProduit);
		total +=produit.getPrix().multiply(new BigDecimal(quantite)).floatValue();
		ProduitCommande produitCommande = new ProduitCommande();
		produitCommande.setProduit(produit);
		produitCommande.setQuantite(quantite);
		panier.add(produitCommande);
		session.removeAttribute("panier");
		session.removeAttribute("total");

		session.setAttribute("panier", panier);
		session.setAttribute("total", total);
		response.sendRedirect("panier.jsp");
	}

	protected Produit getProduitById(int id) {

		// Connexion JNDI (annuaire pour localiser l'EJB)
		try {
			final Hashtable jndiProperties = new Hashtable();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			final Context context = new InitialContext(jndiProperties);
			AccessCatalogueBeanRemote remote = (AccessCatalogueBeanRemote) context
					.lookup("java:global/earecommerce/ejbecommerce/AccessCatalogueBean!eilco.metier.beans.AccessCatalogueBeanRemote");
			Produit produit = remote.getProduitById(id);
			return produit;
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
