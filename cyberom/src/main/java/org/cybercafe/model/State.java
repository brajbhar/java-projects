/**
 * 
 */
package org.cybercafe.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Bablu Rajbhar
 *
 */
@Entity
@Table(name = "tbl_state")
public class State extends AbstractEntity {
	
	private String name;
	
	public State() {}

	public State(long id,String name) {
		super();
		this.name = name;
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
			
}
