package eilco.metier.beans;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import eilco.metier.entities.Categorie;
import eilco.metier.entities.Produit;
import eilco.metier.entities.User;

/**
 * Session Bean implementation class ManagementBean
 */
@Stateless
@LocalBean
public class ManagementBean implements ManagementBeanRemote {
	@PersistenceContext(unitName = "ejbecommerce")
	private EntityManager entityManager;

	public ManagementBean() {
	}

	public boolean authentification(String username, String hashedPassword) {

		try {
			TypedQuery<User> tq = entityManager.createQuery("select u from User u WHERE username=? and password=?", User.class);
			tq.setParameter(1, username);
			tq.setParameter(2, hashedPassword);
			User user=tq.getSingleResult();
			user.setLastlogin(new Date());
			entityManager.merge(user);
			return true;
		} catch (Exception noresult) {
			return false;
		}

	}

	public void addUser(String username, String hashedPassword) {
		User user = new User();
		user.setUsername(username);
		user.setPassword(hashedPassword);
		entityManager.persist(user);
	}
	public void updateUser(User u ) {
		if(!u.equals(null)) {
			entityManager.merge(u);
		}
	}
	@Override
	public List<User> getAllUser() {
		return entityManager.createNamedQuery("User.findAll",User.class).getResultList();
	}

	public void addProduit(Produit p) {
		if(!p.equals(null))
			entityManager.persist(p);
	}
	public void updateProduit(Produit p) {
		if(!p.equals(null))
			entityManager.merge(p);
	}
	@Override
	public List<Produit> getAllProduit() {
		return entityManager.createNamedQuery("Produit.findAll",Produit.class).getResultList();
	}

	
	public void addCategorie(Categorie c) {
		if(!c.equals(null))
			entityManager.persist(c);
	}
	
	public void updateCategorie(Categorie c) {
		if(!c.equals(null))
			entityManager.merge(c);
	}
	
	@Override
	public List<Categorie> getAllCategorie() {
		return entityManager.createNamedQuery("Categorie.findAll",Categorie.class).getResultList();
	}

	@Override
	public Produit getProduitById(int id) {
		return entityManager.find(Produit.class, id);
	}

	@Override
	public void deleteProduit(Produit p) {
		entityManager.remove(entityManager.find(Produit.class, p.getId()));
		
	}

	@Override
	public Categorie getCategorieById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Categorie.class, id);
	}


	@Override
	public void deleteCategorie(Categorie c) {
		entityManager.remove(entityManager.find(Categorie.class, c.getId()));
		
	}
	

}
