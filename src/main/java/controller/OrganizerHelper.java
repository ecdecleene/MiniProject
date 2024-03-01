package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Organizer;

/**  
* Ezra DeCleene - ecdecleene  
* CIS171 22149
* Feb 28, 2024  
*/
public class OrganizerHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MiniProject");
	
	public void insertOrganizer(Organizer o) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Organizer> showAllOrganizers(){
		EntityManager em = emfactory.createEntityManager();
		List<Organizer> allOrganizers = em.createQuery("SELECT o FROM ORGANIZER o").getResultList();
		return allOrganizers;
	}
	
	public Organizer findOrganizer(String nameToLookUp) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Organizer> typedQuery = em.createQuery("select o from Organizer o where o.organizerName = :selectedName", Organizer.class);
		typedQuery.setParameter("selectedName", nameToLookUp);
		typedQuery.setMaxResults(1);
		Organizer foundOrganizer;
		try {
			foundOrganizer = typedQuery.getSingleResult();
		} catch(NoResultException ex) {
			foundOrganizer = new Organizer(nameToLookUp);
		}
		em.close();
		return foundOrganizer;
	}
}
