/**
 * 
 */
package org.cybercafe.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.cybercafe.domain.SessionSearchFilter;
import org.cybercafe.model.Session;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author bablu
 *
 */
public class SessionSpecification implements Specification<Session> {
	
	private final SessionSearchFilter filter;
	
	public SessionSpecification(SessionSearchFilter filter) {
		this.filter = filter;
	}

	@Override
	public Predicate toPredicate(Root<Session> root, CriteriaQuery<?> criteriaQuery, 
			CriteriaBuilder criteriaBuilder) {
		
		List<Predicate> predicates = new ArrayList<>();
		
		if(filter.getSessionStatus() !=null && filter.getSessionStatus().getId() != null) {
			predicates.add(criteriaBuilder.equal(root.<String>get("sessionStatus"), 
					filter.getSessionStatus()));
		}
		
		if(filter.getVisitor() != null && filter.getVisitor().getId() != null) {
			predicates.add(criteriaBuilder.equal(root.<String>get("visitor"), 
					filter.getVisitor()));
		}
		
		if(filter.getCybercafe()!= null && filter.getCybercafe().getId() != null) {
			predicates.add(criteriaBuilder.equal(root.<String>get("cybercafe"), 
					filter.getCybercafe()));
		}
		
		return andTogether(predicates, criteriaBuilder);
	}
	
	private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder criteriaBuilder) {
	    return criteriaBuilder.and(predicates.toArray(new Predicate[0]));
	}

}
