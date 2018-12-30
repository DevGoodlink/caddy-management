package eilco.metier.entities;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the produit_commande database table.
 * 
 */
/**
 * @author yasse
 *
 */
@Entity
@Table(name="produit_commande")
@NamedQuery(name="ProduitCommande.findAll", query="SELECT p FROM ProduitCommande p")
public class ProduitCommande implements Serializable {
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int idproduitcommande;//id artificiel
	
	@Column(name="commande_client_id")
	private int commandeClientId;

	private int quantite;

//	//bi-directional one-to-one association to CommandeClient
//	@OneToOne
//	@JoinColumn(name="commande_client_id")
//	private CommandeClient commandeClient;

	//bi-directional many-to-one association to Produit
	@ManyToOne
	private Produit produit;

	public int getIdproduitcommande() {
		return idproduitcommande;
	}

	public void setIdproduitcommande(int idproduitcommande) {
		this.idproduitcommande = idproduitcommande;
	}

	public ProduitCommande() {
	}

	public int getCommandeClientId() {
		return this.commandeClientId;
	}

	public void setCommandeClientId(int commandeClientId) {
		this.commandeClientId = commandeClientId;
	}

	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

//	public CommandeClient getCommandeClient() {
//		return this.commandeClient;
//	}
//
//	public void setCommandeClient(CommandeClient commandeClient) {
//		this.commandeClient = commandeClient;
//	}

	public Produit getProduit() {
		return this.produit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

}