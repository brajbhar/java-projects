package org.cybercafe.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "tbl_visitor")
public class Visitor extends Person {
	
	@NotNull
	@ManyToOne(optional = false)
	@JoinColumn(name = "cybercafe_id")
	private Cybercafe cybercafe;
	
	@NotNull
	@Column(name = "id_card_number")
	private String idCardNumber;
	
	@NotNull
	@ManyToOne(optional = false)
	@JoinColumn(name = "id_card_type")
	private IDCardType idCardType;
	
	@Column(name = "updated_on")
	private Date updatedOn;
	
	@ManyToOne
	@JoinColumn(name = "updated_by")
	public User updatedBy;
	
	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public User getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(User updatedBy) {
		this.updatedBy = updatedBy;
	}

	
	
	public Cybercafe getCybercafe() {
		return cybercafe;
	}

	public void setCybercafe(Cybercafe cybercafe) {
		this.cybercafe = cybercafe;
	}

	public String getIdCardNumber() {
		return idCardNumber;
	}

	public void setIdCardNumber(String idCardNumber) {
		this.idCardNumber = idCardNumber;
	}

	public IDCardType getIdCardType() {
		return idCardType;
	}

	public void setIdCardType(IDCardType idCardType) {
		this.idCardType = idCardType;
	}
	
	

}
