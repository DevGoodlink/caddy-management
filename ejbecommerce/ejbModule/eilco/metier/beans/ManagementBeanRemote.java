package eilco.metier.beans;

import java.util.List;

import javax.ejb.Remote;

import eilco.metier.entities.Categorie;
import eilco.metier.entities.Produit;
import eilco.metier.entities.User;

@Remote
public interface ManagementBeanRemote {
	
	public boolean authentification(String username, String hashedPassword);
	
	public void addUser(String username, String hashedPassword);
	public void updateUser(User u);
	public List<User> getAllUser();
	
	public void addProduit(Produit p);
	public Produit getProduitById(int id);
	public void updateProduit(Produit p);
	public void deleteProduit(Produit p);
	public List<Produit> getAllProduit();
	
	public void addCategorie(Categorie c);
	public Categorie getCategorieById(int id);
	public void updateCategorie(Categorie c);
	public void deleteCategorie(Categorie c);
	public List<Categorie> getAllCategorie();
}
