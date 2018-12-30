package eilco.metier.entities;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the client database table.
 * 
 */
@Entity
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int id;

	private String adresse;

	private String email;

	private String nom;

	private String telephone;
//
//	//bi-directional many-to-one association to CommandeClient
//	@OneToMany(mappedBy="client")
//	private List<CommandeClient> commandeClients;

	public Client() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAdresse() {
		return this.adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getTelephone() {
		return this.telephone;
	}

	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

//	public List<CommandeClient> getCommandeClients() {
//		return this.commandeClients;
//	}
//
//	public void setCommandeClients(List<CommandeClient> commandeClients) {
//		this.commandeClients = commandeClients;
//	}
//
//	public CommandeClient addCommandeClient(CommandeClient commandeClient) {
//		getCommandeClients().add(commandeClient);
//		commandeClient.setClient(this);
//
//		return commandeClient;
//	}
//
//	public CommandeClient removeCommandeClient(CommandeClient commandeClient) {
//		getCommandeClients().remove(commandeClient);
//		commandeClient.setClient(null);
//
//		return commandeClient;
//	}

}