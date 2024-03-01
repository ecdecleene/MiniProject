package model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**  
* Ezra DeCleene - ecdecleene  
* CIS171 22149
* Feb 28, 2024  
*/
@Entity
public class OrganizerEvents {
	@Id
	@GeneratedValue
	private int id;
	private String listName;
	@ManyToOne(cascade=CascadeType.PERSIST)
	private Organizer organizer;
	@OneToMany(cascade=CascadeType.MERGE, fetch=FetchType.EAGER)
	private List<Events> eventsList;
	
	
	/**
	 * @param listName
	 * @param organizer
	 */
	public OrganizerEvents(String listName, Organizer organizer) {
		super();
		this.listName = listName;
		this.organizer = organizer;
	}
	/**
	 * @param listName
	 * @param organizer
	 * @param eventsList
	 */
	public OrganizerEvents(String listName, Organizer organizer, List<Events> eventsList) {
		super();
		this.listName = listName;
		this.organizer = organizer;
		this.eventsList = eventsList;
	}
	/**
	 * @param id
	 * @param listName
	 * @param organizer
	 * @param eventsList
	 */
	public OrganizerEvents(int id, String listName, Organizer organizer, List<Events> eventsList) {
		super();
		this.id = id;
		this.listName = listName;
		this.organizer = organizer;
		this.eventsList = eventsList;
	}
	/**
	 * 
	 */
	public OrganizerEvents() {
		super();
	}
	/**
	 * @return the id
	 */
	public int getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(int id) {
		this.id = id;
	}
	/**
	 * @return the listName
	 */
	public String getListName() {
		return listName;
	}
	/**
	 * @param listName the listName to set
	 */
	public void setListName(String listName) {
		this.listName = listName;
	}
	/**
	 * @return the organizer
	 */
	public Organizer getOrganizer() {
		return organizer;
	}
	/**
	 * @param organizer the organizer to set
	 */
	public void setOrganizer(Organizer organizer) {
		this.organizer = organizer;
	}
	/**
	 * @return the eventsList
	 */
	public List<Events> getEventsList() {
		return eventsList;
	}
	/**
	 * @param eventsList the eventsList to set
	 */
	public void setEventsList(List<Events> eventsList) {
		this.eventsList = eventsList;
	}
	
	
}
