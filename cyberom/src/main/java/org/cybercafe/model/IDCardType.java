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
@Table(name = "tbl_id_card_type")
public class IDCardType extends AbstractEntity {
	
	@Column(name = "name")
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
	
}
