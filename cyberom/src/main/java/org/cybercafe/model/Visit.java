/**
 * 
 */
package org.cybercafe.model;

import java.util.Date;

/**
 * @author Bablu Rajbhar
 *
 */
public class Visit extends AbstractEntity {
	
	private Visitor visitor;
	
	private Date startDate;
	
	private Date endDate;
	
	private Device device;
	
	private double amountCharged;
	
	private String comment;
	
	
}
