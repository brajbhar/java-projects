/**
 * 
 */
package org.cybercafe.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.cybercafe.model.Visitor;
import org.springframework.data.jpa.domain.Specification;

/**
 * @author Bablu
 *
 */
public class VisitorSpecification implements Specification<Visitor> {
	
	private final Visitor visitor;
	
	
	public VisitorSpecification(Visitor visitor) {
		this.visitor = visitor;
	}

	@Override
	public Predicate toPredicate(Root<Visitor> root, CriteriaQuery<?> criteriaQuery, 
			CriteriaBuilder criteriaBuilder) {
		List<Predicate> predicates = new ArrayList<>();
		//http://stackoverflow.com/questions/4014390/jpa-criteria-api-like-equal-problem
		if(StringUtils.isNotBlank(visitor.getFirstName())) {
			predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.<String>get("firstName")), visitor.getFirstName().toLowerCase() + "%"));
		}
		if(StringUtils.isNotBlank(visitor.getLastName())) {
			predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.<String>get("lastName")), visitor.getLastName().toLowerCase() + "%"));
		}
		if(StringUtils.isNotBlank(visitor.getMobile())) {
			predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.<String>get("mobile")), visitor.getMobile() + "%"));
		}
		if(visitor.getCybercafe()!= null && visitor.getCybercafe().getId() != null) {
			predicates.add(criteriaBuilder.equal(root.<String>get("cybercafe"), visitor.getCybercafe()));
		}
		return andTogether(predicates, criteriaBuilder);
	}
	
	private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
	    return cb.and(predicates.toArray(new Predicate[0]));
	}

}
