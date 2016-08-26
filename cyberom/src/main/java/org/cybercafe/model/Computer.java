package org.cybercafe.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_system")
public class Computer extends AbstractEntity {
	
	@Column(name = "name")
	private String name;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "status_id")
	private Status status;
	
	@Column(name = "serial")
	private String serial;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "cybercafe_id")
	private Cybercafe cybercafe;
	
	@ManyToOne(optional = false)
	@JoinColumn(name = "updated_by")
	private User updatedBy;
	
	@Column(name = "updated_on")
	private Date updatedOn;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getSerial() {
		return serial;
	}

	public void setSerial(String serial) {
		this.serial = serial;
	}

	public Cybercafe getCybercafe() {
		return cybercafe;
	}

	public void setCybercafe(Cybercafe cybercafe) {
		this.cybercafe = cybercafe;
	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}
	
	

}
