/**
 * 
 */
package org.cybercafe.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Bablu Rajbhar
 *
 */
@Entity
@Table(name = "tbl_cybercafe")
public class Cybercafe extends AbstractEntity {
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "phone_no")
	private String mobileNo;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	
	@Column(name = "updated_on")
	private Date updatedOn;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "status_id")
	private Status status;
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "user_id")
	private User user;
	
	protected Cybercafe() {}
	
	public Cybercafe(String name, String phoneNo, Address address, Date updatedOn, Status status,User user) {
		this.name = name;
		this.mobileNo = phoneNo;
		this.address = address;
		this.updatedOn = updatedOn;
		this.status = status;
		this.user = user;
	}

	
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNo() {
		return mobileNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.mobileNo = phoneNo;
	}

	
	@Override
	public String toString() {
		return "Cybercafe [name=" + name + ", phoneNo=" + mobileNo
				+ ", address=" + address + ", updatedOn=" + updatedOn + "]";
	}

	public Address getAddress() {
		return address;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public Status getStatus() {
		return status;
	}

	public User getUser() {
		return user;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
}
