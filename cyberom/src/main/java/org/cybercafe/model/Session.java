/**
 * 
 */
package org.cybercafe.model;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
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
	
	@OneToOne(fetch = FetchType.EAGER)
	@Column(name = "visitor_id")
	private Visitor visitor;
	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	@JoinTable(name = "tbl_session_system_usage", joinColumns={@JoinColumn(name = "session_id")}, 
	inverseJoinColumns = {@JoinColumn(name = "system_usage_id")})
	private Set<SystemUsage> systemsUsed;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "start_time")
	private Date startTime;
	
	@Column(name = "end_time")
	private Date endTime;

	public Visitor getVisitor() {
		return visitor;
	}

	public void setVisitor(Visitor visitor) {
		this.visitor = visitor;
	}

	public Set<SystemUsage> getSystemsUsed() {
		return systemsUsed;
	}

	public void setSystemsUsed(Set<SystemUsage> systemsUsed) {
		this.systemsUsed = systemsUsed;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
	

}
