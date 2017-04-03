/**
 * 
 */
package org.cybercafe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Bablu
 *
 */
@Entity
@Table(name = "tbl_session_status")
public class SessionStatus extends AbstractEntity {
	
	@Column(name = "name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
