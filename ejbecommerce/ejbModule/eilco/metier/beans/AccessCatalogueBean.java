package eilco.metier.beans;

import java.util.List;
import java.util.stream.Collectors;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import eilco.metier.entities.Categorie;
import eilco.metier.entities.Produit;

/**
 * Session Bean implementation class AccessCatalogueBean
 */
@Stateless
@LocalBean
public class AccessCatalogueBean implements AccessCatalogueBeanRemote {
	@PersistenceContext(unitName="ejbecommerce")
	private EntityManager entityManager;
	
    /**
     * Default constructor. 
     */
    public AccessCatalogueBean() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public List<Categorie> getListeCategories() {
		TypedQuery<Categorie> q = (TypedQuery<Categorie>) entityManager.createNamedQuery("Categorie.findAll",Categorie.class);
		List<Categorie> categories = (List<Categorie>) q.getResultList();
		return categories;
	}

	@Override
	public List<Produit> getListeProduits(int idCategorie) {
		//TypedQuery<Produit> q = (TypedQuery<Produit>) entityManager.createQuery("select p from Produit p where p.id_categorie = :c",Produit.class).setParameter("c", idCategorie);
		TypedQuery<Produit> q = (TypedQuery<Produit>) entityManager.createNamedQuery("Produit.findAll",Produit.class);
		List<Produit> produits = (List<Produit>) q.getResultList().stream().filter(p->p.getCategorie().getId()==idCategorie).collect(Collectors.toList());
		
		return produits;
	}

	@Override
	public Produit getProduitById(int idProduit) {
		Produit produit = entityManager.find(Produit.class, idProduit);
		return produit;
	}

}
