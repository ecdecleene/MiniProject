package model;

import java.time.LocalDate;

import javax.persistence.Column;
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
@Table(name="events")
public class Events {
	@Id
	@GeneratedValue
	@Column(name="ID")
	private int id;
	@Column(name="NAME")
	private String name;
	@Column(name="DATE")
	private LocalDate date;
	
	/**
	 * @param id
	 * @param name
	 * @param organizer
	 */
	public Events(String name, LocalDate date) {
		super();
		this.name = name;
		this.date = date;
	}
	
	/**
	 * @param name
	 * @param organizer
	 */
	public Events(String name) {
		super();
		this.name = name;
	}
	
	public Events() {
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the date
	 */
	public LocalDate getDate() {
		return date;
	}
	/**
	 * @param date the date to set
	 */
	public void setDate(LocalDate date) {
		this.date = date;
	}
}
