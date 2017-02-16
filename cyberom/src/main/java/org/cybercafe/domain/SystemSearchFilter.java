package org.cybercafe.domain;

import org.cybercafe.model.System;

public class SystemSearchFilter extends System {
	
	
	private int pageNumber;
	
	private int pageSize;
	
	private boolean isExactMatchRequired;

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

	public boolean isExactMatchRequired() {
		return isExactMatchRequired;
	}

	public void setExactMatchRequired(boolean isExactMatchRequired) {
		this.isExactMatchRequired = isExactMatchRequired;
	}
	
	


}
