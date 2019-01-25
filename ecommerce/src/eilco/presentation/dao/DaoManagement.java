package eilco.presentation.dao;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.Hashtable;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;

import eilco.metier.beans.ManagementBeanRemote;
import eilco.metier.entities.Categorie;
import eilco.metier.entities.Produit;

public class DaoManagement {
	private ManagementBeanRemote managementBean;

	public DaoManagement() {
		try {
			final Hashtable jndiProperties = new Hashtable();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			final Context context = new InitialContext(jndiProperties);
			managementBean = (ManagementBeanRemote) context.lookup(
					"java:global/earecommerce/ejbecommerce/ManagementBean!eilco.metier.beans.ManagementBeanRemote");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean authentification(String username, String clearPassword) {
		MessageDigest digest;
		try {
			digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(clearPassword.getBytes(StandardCharsets.UTF_8));
			String hashedPassword = Base64.getEncoder().encodeToString(hash);
			return managementBean.authentification(username, hashedPassword);
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return false;
		}
	}
	public void addProduit(Produit p) {
		managementBean.addProduit(p);
	}
	public void addCategorie(Categorie c) {
		managementBean.addCategorie(c);
	}
	public List<Produit> getAllProduit(){
		return managementBean.getAllProduit();
	}
	
	public void removeProduit(Produit p) {
		managementBean.deleteProduit(p);
	}
	public Produit getProduitById(int id) {
		return managementBean.getProduitById(id);
	}

	public List<Categorie> getAllCategorie(){
		
		return managementBean.getAllCategorie();
	}
	public Categorie getCategorieById(int id) {
		return managementBean.getCategorieById(id);
	}
	
	public void removeCategorie(Categorie c) {
		managementBean.deleteCategorie(c);
	}
	
	
}

