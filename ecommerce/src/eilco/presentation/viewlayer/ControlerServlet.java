package eilco.presentation.viewlayer;

import java.io.IOException;
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
import eilco.metier.entities.Categorie;
import eilco.metier.entities.Produit;
import eilco.metier.entities.ProduitCommande;

/**
 * Servlet implementation class controlerServlet
 */
/**
 * @author yasse
 *
 */
@WebServlet("/controller")
public class ControlerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlerServlet() {
        super();
    }
    
    /**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String uri = request.getRequestURI();
//		HttpSession session = request.getSession(true);
//		String view="404.jsp";
		//String model = "Error : Action non définie";
//		System.out.println("Lien vers "+uri);
//		if(uri.endsWith("/accueil")) {
//			List<Produit> produits = getAllProduits();
//			System.out.println("nombre produits = "+produits.size());
//			session.setAttribute("listproduits", produits);
//		}else
//		if(uri.endsWith("/cd")) {
//			
//			view="/cd.jsp";
//		}else if(uri.endsWith("/livre")){
//			
//			view="/livre.jsp";
//		}else if(uri.endsWith("/dvd")) {
//			view="/dvd.jsp";
//		}else if(uri.endsWith("/categories")) {
//			List<Categorie> categories = getAllCategories();
//			session.setAttribute("listcategorie", categories);
//			view="/categories.jsp";
//		}
		
		this.getServletContext().getRequestDispatcher("index.jsp").forward(request, response);
	}
//	protected List<Categorie> getAllCategories() {
//		
////		// Connexion JNDI (annuaire pour localiser l'EJB)
////		try {
////			final Hashtable jndiProperties = new Hashtable();
////			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
////			final Context context = new InitialContext(jndiProperties);
////			CategorieBeanRemote remote = (CategorieBeanRemote) context.lookup("java:global/earecommerce/ejbecommerce/CategorieBean!eilco.metier.beans.CategorieBeanRemote");
////			List<Categorie> categories = remote.getAllCategorie();
////			return categories;
////		} catch (Exception e) {
////			e.printStackTrace();
////			return null;
////		}	
//	}
//	protected List<Produit> getAllProduits() {
//		
////		// Connexion JNDI (annuaire pour localiser l'EJB)
////		try {
////			final Hashtable jndiProperties = new Hashtable();
////			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
////			final Context context = new InitialContext(jndiProperties);
////			ProduitBeanRemote remote = (ProduitBeanRemote) context.lookup("java:global/earecommerce/ejbecommerce/ProduitBean!eilco.metier.beans.ProduitBeanRemote");
////			List<Produit> produits = remote.getAllProduit();
////			return produits;
////		} catch (Exception e) {
////			e.printStackTrace();
////			return null;
////		}	
//	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
