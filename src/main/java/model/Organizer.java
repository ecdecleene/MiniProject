package model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**  
* Ezra DeCleene - ecdecleene  
* CIS171 22149
* Feb 23, 2024  
*/
@Entity
@Table(name="organizer")
public class Organizer {
	@Id
	@GeneratedValue
	private int id;
	private String organizerName;
	
	public Organizer() {
		super();
	}
	
	public Organizer(int id, String organizerName) {
		super();
		this.id = id;
		this.organizerName = organizerName;
	}
	
	/**
	 * @param organizerName
	 */
	public Organizer(String organizerName) {
		super();
		this.organizerName = organizerName;
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
	 * @return the organizerName
	 */
	public String getOrganizerName() {
		return organizerName;
	}
	/**
	 * @param organizerName the organizerName to set
	 */
	public void setOrganizerName(String organizerName) {
		this.organizerName = organizerName;
	}
	
	
}
