/**
 * 
 */
package org.cybercafe.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

/**
 * @author Bablu Rajbhar
 *
 */
@MappedSuperclass
public class AbstractEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected Long id;
	
	public Long getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		
		if(this == obj) {
			return true;
		}
		
		if(this.id == null || obj == null || !(this.getClass().equals(obj.getClass()))) {
			return false;
		}
		
		AbstractEntity that = (AbstractEntity)obj;
		return that.id.equals(that.getId());
				
	}
	
	@Override
	public int hashCode() {
		return id == null ? 0 : id.hashCode();
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	
	

}
