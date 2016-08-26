/**
 * 
 */
package org.cybercafe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Bablu Rajbhar
 *
 */
@Entity
@Table(name = "tbl_status")
public class Status extends AbstractEntity {
	
	@Column(name = "name")
	private String name;
	
	//protected Status() {}

	/*public Status(String name) {
		this.name = name;
	}*/
	@Override
	public String toString() {
		return "Status [name=" + name + "]";
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getName() {
		return name;
	}
	
	
}
