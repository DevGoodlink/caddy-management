package eilco.metier.beans;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import eilco.metier.entities.Client;
import eilco.metier.entities.CommandeClient;
import eilco.metier.entities.ProduitCommande;

/**
 * Session Bean implementation class GestionCommandeBean
 */
@Stateless
public class GestionCommandeBean implements GestionCommandeBeanRemote {
	@PersistenceContext(unitName="ejbecommerce")
	private EntityManager entityManager;

	@Override
	public void validerCommande(Client customer, List<ProduitCommande> panier,BigDecimal total) {
		customer = persistCustomer(customer);
		CommandeClient ligneCommande = new CommandeClient();
		ligneCommande.setClient(customer);
		ligneCommande.setMontant(total);
		ligneCommande.setNoConfirmation(customer.getId());
		ligneCommande = persistCommandeClient(ligneCommande);
		for(ProduitCommande pc : panier) {
			pc.setCommandeClientId(ligneCommande.getId());
			entityManager.persist(pc);
			entityManager.flush();
			System.out.println("produit commande id = "+pc.getCommandeClientId());
		}
		
	}
	public Client persistCustomer(Client customer) {
		Client client;
		try {
		    TypedQuery<Client> tq = entityManager.createQuery("select c from Client c WHERE email=?", Client.class);
		    client = tq.setParameter(1, customer.getEmail()).getSingleResult();
		} catch(Exception noresult) {
			entityManager.persist(customer);
		    entityManager.flush();
			System.out.println("customer id = "+customer.getId());
			return customer;
		} 
		return client;
		
	}
	public CommandeClient persistCommandeClient(CommandeClient ligneCommande) {
		entityManager.persist(ligneCommande);
		entityManager.flush();
		System.out.println("ligne commande id = "+ligneCommande.getId());
		return ligneCommande;
	}


}
