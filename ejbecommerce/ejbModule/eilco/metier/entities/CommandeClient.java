package eilco.metier.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;


/**
 * The persistent class for the commande_client database table.
 * 
 */
@Entity
@Table(name="commande_client")
@NamedQuery(name="CommandeClient.findAll", query="SELECT c FROM CommandeClient c")
public class CommandeClient implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private BigDecimal montant;

	@Column(name="no_confirmation")
	private int noConfirmation;

	//bi-directional many-to-one association to Client
	@ManyToOne
	private Client client;

//	//bi-directional one-to-one association to ProduitCommande
//	@OneToOne(mappedBy="commandeClient")
//	private ProduitCommande produitCommande;

	public CommandeClient() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public BigDecimal getMontant() {
		return this.montant;
	}

	public void setMontant(BigDecimal montant) {
		this.montant = montant;
	}

	public int getNoConfirmation() {
		return this.noConfirmation;
	}

	public void setNoConfirmation(int noConfirmation) {
		this.noConfirmation = noConfirmation;
	}

	public Client getClient() {
		return this.client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

//	public ProduitCommande getProduitCommande() {
//		return this.produitCommande;
//	}
//
//	public void setProduitCommande(ProduitCommande produitCommande) {
//		this.produitCommande = produitCommande;
//	}

}