/**
 * 
 */
package org.cybercafe.model;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Bablu Rajbhar
 *
 */
@Entity
@Table(name = "tbl_city")
public class City extends AbstractEntity {
	
	
	private String name;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "state_id")
	private State state;

	public String getName() {
		return name;
	}

	public State getState() {
		return state;
	}
	
	protected City() {}

	public City(long id, String name, State state) {
		super();
		this.id = id;
		this.name = name;
		this.state = state;
	}
	
	
	
}
