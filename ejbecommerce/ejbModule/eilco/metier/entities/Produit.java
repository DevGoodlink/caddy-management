package eilco.metier.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;


/**
 * The persistent class for the produit database table.
 * 
 */
@Entity
@NamedQuery(name="Produit.findAll", query="SELECT p FROM Produit p")
public class Produit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	@Column(name="dernier_maj")
	private Timestamp dernierMaj;

	private String description;

	private String nom;

	private BigDecimal prix;

	//bi-directional many-to-one association to Categorie
	@ManyToOne
	private Categorie categorie;

	//bi-directional many-to-one association to ProduitCommande
	@OneToMany(mappedBy="produit")
	private List<ProduitCommande> produitCommandes;

	public Produit() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Timestamp getDernierMaj() {
		return this.dernierMaj;
	}

	public void setDernierMaj(Timestamp dernierMaj) {
		this.dernierMaj = dernierMaj;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public BigDecimal getPrix() {
		return this.prix;
	}

	public void setPrix(BigDecimal prix) {
		this.prix = prix;
	}

	public Categorie getCategorie() {
		return this.categorie;
	}

	public void setCategorie(Categorie categorie) {
		this.categorie = categorie;
	}

	public List<ProduitCommande> getProduitCommandes() {
		return this.produitCommandes;
	}

	public void setProduitCommandes(List<ProduitCommande> produitCommandes) {
		this.produitCommandes = produitCommandes;
	}

	public ProduitCommande addProduitCommande(ProduitCommande produitCommande) {
		getProduitCommandes().add(produitCommande);
		produitCommande.setProduit(this);

		return produitCommande;
	}

	public ProduitCommande removeProduitCommande(ProduitCommande produitCommande) {
		getProduitCommandes().remove(produitCommande);
		produitCommande.setProduit(null);

		return produitCommande;
	}

}