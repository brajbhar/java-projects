package org.cybercafe.service;

import java.util.List;

import org.cybercafe.domain.VisitorSearchFilter;
import org.cybercafe.exception.DuplicateVisitorException;
import org.cybercafe.model.Cybercafe;
import org.cybercafe.model.IDCardType;
import org.cybercafe.model.Visitor;
import org.springframework.data.domain.Page;

public interface VisitorService {
	
	Visitor addVisitor(Visitor visitor) throws DuplicateVisitorException;
	
	Visitor editVisitor(Visitor visitor);
	
	Visitor getVisitor(Long visitorId);
	
	List<Visitor> getVisitorsByCybercafe(Cybercafe cybercafe);
	
	List<IDCardType> getIDcardTypes();
	
	Page<Visitor> getVisitors(VisitorSearchFilter visitorFilter);
	
	List<Visitor> getVisitorsWithoutPaging(VisitorSearchFilter viitorFilter);
}
