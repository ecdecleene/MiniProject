package controller;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.OrganizerEvents;

/**  
* Ezra DeCleene - ecdecleene  
* CIS171 22149
* Feb 28, 2024  
*/
public class OrganizerEventsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MiniProject");
	
	public void insertNewOrganizerEvents(OrganizerEvents o) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(o);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<OrganizerEvents> getLists(){
		EntityManager em = emfactory.createEntityManager();
		List<OrganizerEvents> allEvents = em.createQuery("SELECT e FROM OrganizerEvents e").getResultList();
		return allEvents;
	}
	
	public void deleteList(OrganizerEvents toDelete) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<OrganizerEvents> typedQuery = em.createQuery("select event from OrganizerEvents event where event.id = :selectedId", OrganizerEvents.class);
		typedQuery.setParameter("selectedId", toDelete.getId());
		typedQuery.setMaxResults(1);
		OrganizerEvents result = typedQuery.getSingleResult();
		em.remove(result);
		em.getTransaction().commit();
		em.close();
	}
	
	public OrganizerEvents searchForOrganizerEventsById(Integer tempId) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		OrganizerEvents found = em.find(OrganizerEvents.class, tempId);
		em.close();
		return found;
	}
	
	public void updateList(OrganizerEvents toEdit) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}
}
