/**
 * 
 */
package org.cybercafe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * @author Bablu Rajbhar
 *
 */
@Entity
@Table(name="tbl_address")
public class Address extends AbstractEntity{
		
	@Column(name="address_line1")
	private String addressLine1;
	
	@Column(name="address_line2")
	private String addressLine2;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "city_id")
	private City city;
	
	@Column(name="pin_no")
	private String pin;
	
	protected Address() {}
	
	public Address(String addressLine1, String addressLine2, String pin, City city) {
		super();
		this.addressLine1 = addressLine1;
		this.addressLine2 = addressLine2;
		this.pin = pin;
		this.city = city;
	}



	public String getAddressLine1() {
		return addressLine1;
	}

	public void setAddressLine1(String addressLine1) {
		this.addressLine1 = addressLine1;
	}

	public String getAddressLine2() {
		return addressLine2;
	}

	public void setAddressLine2(String addressLine2) {
		this.addressLine2 = addressLine2;
	}

	public String getPin() {
		return pin;
	}

	public City getCity() {
		return city;
	}


	
}
