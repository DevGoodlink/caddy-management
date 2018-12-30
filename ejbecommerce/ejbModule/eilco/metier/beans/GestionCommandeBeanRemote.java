package eilco.metier.beans;

import java.math.BigDecimal;
import java.util.List;

import javax.ejb.Remote;

import eilco.metier.entities.ProduitCommande;
import eilco.metier.entities.Categorie;
import eilco.metier.entities.Client;
@Remote
public interface GestionCommandeBeanRemote {
	//public ProduitCommande createCommande();
	public void validerCommande(Client customer,List<ProduitCommande> panier, BigDecimal total);
}
