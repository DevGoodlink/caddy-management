package eilco.metier.beans;

import java.util.List;

import javax.ejb.Remote;

import eilco.metier.entities.Categorie;
import eilco.metier.entities.Produit;

@Remote
public interface AccessCatalogueBeanRemote {
	List<Categorie> getListeCategories();
	List<Produit> getListeProduits(int idCategorie);
	Produit getProduitById(int idProduit);
}
