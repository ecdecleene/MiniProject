package controller;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import model.Events;

/**  
* Ezra DeCleene - ecdecleene  
* CIS171 22149
* Feb 23, 2024  
*/
public class EventsHelper {
	static EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("MiniProject");

	public void insertEvent(Events e) {
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}
	
	public List<Events> showAllEvents() {
		EntityManager em = emfactory.createEntityManager();
		List<Events> allEvents = em.createQuery("SELECT e FROM Events e").getResultList();
		return allEvents;
	}

	public void deleteEvent(Events toDelete) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Events> typedQuery = em.createQuery(
				"select e from Events e where e.name = :selectedName and e.date = :selectedDate",
				Events.class);
		// Substitute parameter with actual data from the toDelete item
		typedQuery.setParameter("selectedName", toDelete.getName());
		typedQuery.setParameter("selectedDate", toDelete.getDate());

		// we only want one result
		typedQuery.setMaxResults(1);

		// get the result and save it into a new list item
		Events result = typedQuery.getSingleResult();

		// remove it
		em.remove(result);
		em.getTransaction().commit();
		em.close();

	}

	public Events searchForEventById(int idToEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		Events found = em.find(Events.class, idToEdit);
		em.close();
		return found;
	}

	public void updateEvent(Events toEdit) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		em.merge(toEdit);
		em.getTransaction().commit();
		em.close();
	}

	public List<Events> searchForEventByName(String name) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Events> typedQuery = em.createQuery("select e from Events e where e.name = :selectedName", Events.class);
		typedQuery.setParameter("selectedName", name);
		List<Events> found = typedQuery.getResultList();
		em.close();
		return found;
	}

	public List<Events> searchForEventByDate(LocalDate date) {
		// TODO Auto-generated method stub
		EntityManager em = emfactory.createEntityManager();
		em.getTransaction().begin();
		TypedQuery<Events> typedQuery = em.createQuery("select e from Events e where e.date = :selectedDate", Events.class);
		typedQuery.setParameter("selectedDate", date);
		List<Events> found = typedQuery.getResultList();
		em.close();
		return found;
	}
	
	public void cleanUp(){
		emfactory.close();
	}
}
