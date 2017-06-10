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

import org.apache.commons.lang3.StringUtils;
import org.cybercafe.domain.VisitorSearchFilter;
import org.cybercafe.model.Visitor;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author Bablu
 *
 */
public class VisitorSpecification implements Specification<Visitor> {
	
	private final VisitorSearchFilter filter;
	
	
	public VisitorSpecification(VisitorSearchFilter filter) {
		this.filter = filter;
	}

	@Override
	public Predicate toPredicate(Root<Visitor> root, CriteriaQuery<?> criteriaQuery, 
			CriteriaBuilder criteriaBuilder) {
		List<Predicate> predicates = new ArrayList<>();
		//http://stackoverflow.com/questions/4014390/jpa-criteria-api-like-equal-problem
		if(StringUtils.isNotBlank(filter.getFirstName())) {
			predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.<String>get("firstName")), filter.getFirstName().toLowerCase() + "%"));
		}
		if(StringUtils.isNotBlank(filter.getLastName())) {
			predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.<String>get("lastName")), filter.getLastName().toLowerCase() + "%"));
		}
		if(StringUtils.isNotBlank(filter.getMobile())) {
			predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.<String>get("mobile")), filter.getMobile() + "%"));
		}
		if(filter.getCybercafe()!= null && filter.getCybercafe().getId() != null) {
			predicates.add(criteriaBuilder.equal(root.<String>get("cybercafe"), filter.getCybercafe()));
		}
		return andTogether(predicates, criteriaBuilder);
	}
	
	private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
	    return cb.and(predicates.toArray(new Predicate[0]));
	}

}
