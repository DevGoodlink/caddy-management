package eilco.presentation.viewlayer;

import java.io.IOException;
import java.math.BigDecimal;
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
import eilco.metier.beans.GestionCommandeBeanRemote;
import eilco.metier.entities.Client;
import eilco.metier.entities.CommandeClient;
import eilco.metier.entities.Produit;
import eilco.metier.entities.ProduitCommande;

/**
 * Servlet implementation class ServletValiderCommande
 */
@WebServlet("/ValiderCommande")
public class ServletValiderCommande extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletValiderCommande() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(true);
		
		Client customer = (Client)session.getAttribute("customer");
		BigDecimal total = new BigDecimal(session.getAttribute("total").toString());
		List<ProduitCommande> panier = (List<ProduitCommande>) session.getAttribute("panier");
		boolean result = placeCustomerOrder(customer,panier,total);
		if(result) {
			session.invalidate();
			response.getWriter().println("Commande enregistrée avec succés");
		}else {
			session.invalidate();
			response.getWriter().println("Commande pas enregistrée");
		}
		
		
	}
	
	protected boolean placeCustomerOrder(Client customer,List<ProduitCommande> panier, BigDecimal total) {
		// Connexion JNDI (annuaire pour localiser l'EJB)
		try {
			final Hashtable jndiProperties = new Hashtable();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			final Context context = new InitialContext(jndiProperties);
			GestionCommandeBeanRemote remote = (GestionCommandeBeanRemote) context.lookup(
					"java:global/earecommerce/ejbecommerce/GestionCommandeBean!eilco.metier.beans.GestionCommandeBeanRemote");
			remote.validerCommande(customer,panier,total);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
