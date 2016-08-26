/**
 * 
 */
package org.cybercafe.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.codehaus.jackson.annotate.JsonIgnore;

/**
 * @author Bablu Rajbhar
 *
 */
@Entity
@Table(name = "tbl_user")
public class User extends AbstractEntity{
	
	@Column(name = "username")
	private String userName;
	
	@JsonIgnore
	@Column(name = "password")
	private String password;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "updated_on")
	private Date updatedOn;
	
	@Column(name = "random_uuid")
	private String randomUUID;
	
	@OneToOne(optional = false)
	@JoinColumn(name = "status_id")
	private Status status;
	

	@Override
	public String toString() {
		return "User [userName=" + userName 
				+ ", firstName=" + firstName + ", lastName=" + lastName
				+ ", email=" + email + ", updatedOn=" + updatedOn + "]";
	}
	
	

	public String getUserName() {
		return userName;
	}

	public String getPassword() {
		return password;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
		
	}

	public String getEmail() {
		return email;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public String getRandomUUID() {
		return randomUUID;
	}

	public void setRandomUUID(String randomUUID) {
		this.randomUUID = randomUUID;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}
	
	
	

}
