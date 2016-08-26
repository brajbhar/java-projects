/**
 * 
 */
package org.cybercafe.domain;

import org.cybercafe.model.Visitor;

/**
 * @author Bablu
 *
 */
public class VisitorSearchFilter extends Visitor {

	private int pageNumber;
	
	private int pageSize;

	public int getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber-1;
	}

	public int getPageSize() {
		return pageSize;
	}

	public void setPageSize(int pageSize) {
		this.pageSize = pageSize;
	}
	
	
}
