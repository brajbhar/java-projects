/**
 * 
 */
package org.cybercafe.model;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Bablu
 *
 */
@Entity
@Table(name = "tbl_session")
public class Session extends AbstractEntity {
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Visitor visitor;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
	@JoinTable(name="tbl_session_system_usage", joinColumns={@JoinColumn(name="session_id", referencedColumnName="id")}
    , inverseJoinColumns={@JoinColumn(name="system_usage_id", referencedColumnName="id")})
	private Set<SystemUsage> systemUsages;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	private Cybercafe cybercafe;
	
	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "session_status_id")
	private SessionStatus sessionStatus;
	
	@Column(name = "start_time")
	private Date startTime;
	
	@Column(name = "end_time")
	private Date endTime;
	
	@Column(name = "created_on")
	private Date createdOn;
	
	
	@Column(name = "updated_on")
	private Date updatedOn;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "updated_by")
	private User updatedBy;
	
	public Date getStartTime() {
		return startTime;
	}

	public void setStartTime(Date startTime) {
		this.startTime = startTime;
	}

	public Date getEndTime() {
		return endTime;
	}

	public void setEndTime(Date endTime) {
		this.endTime = endTime;
	}

	public Date getCreateOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

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

	public Visitor getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public Set<SystemUsage> getSystemUsages() {
		return systemUsages;
	}

	public void setSystemUsages(Set<SystemUsage> systemUsages) {
		this.systemUsages = systemUsages;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public Cybercafe getCybercafe() {
		return cybercafe;
	}

	public void setCybercafe(Cybercafe cybercafe) {
		this.cybercafe = cybercafe;
	}

	public SessionStatus getSessionStatus() {
		return sessionStatus;
	}

	public void setSessionStatus(SessionStatus sessionStatus) {
		this.sessionStatus = sessionStatus;
	}

}
