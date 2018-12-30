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
import eilco.metier.entities.Produit;

/**
 * Servlet implementation class ControlerPanierServlet
 */
@WebServlet("/panier")
public class ControlerPanierServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ControlerPanierServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		String produitId = request.getParameter("id");
//		String ip = request.getLocalAddr();
//		Produit produit = getProduitById(Integer.parseInt(produitId));
//		
//		System.out.println("resultat request => produit id = "+produitId + " ip = "+ip);
//		System.out.println("resultat hibernate => "+produit.getNom());
		
	}

//	protected Produit getProduitById(int id) {
//		
//		// Connexion JNDI (annuaire pour localiser l'EJB)
//		try {
//			final Hashtable jndiProperties = new Hashtable();
//			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
//			final Context context = new InitialContext(jndiProperties);
//			ProduitBeanRemote remote = (ProduitBeanRemote) context.lookup("java:global/earecommerce/ejbecommerce/ProduitBean!eilco.metier.beans.ProduitBeanRemote");
//			Produit produit = remote.getProduitById(id);
//			return produit;
//		} catch (Exception e) {
//			e.printStackTrace();
//			return null;
//		}	
//	}
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
