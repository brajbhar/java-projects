package org.cybercafe.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.cybercafe.domain.SystemSearchFilter;
import org.cybercafe.model.System;
import org.springframework.data.jpa.domain.Specification;

public class SystemSpecification implements Specification<System> {
	
	private final SystemSearchFilter filter;
	
	public SystemSpecification(SystemSearchFilter filter) {
		this.filter = filter;
	}

	@Override
	public Predicate toPredicate(Root<System> root, CriteriaQuery<?> criteriaQuery, 
			CriteriaBuilder criteriaBuilder) {
		List<Predicate> predicates = new ArrayList<>();
		
		if(StringUtils.isNotBlank(filter.getName())) {
			String systemName = filter.getName().toLowerCase();
			if(!filter.isExactMatchRequired()) {
				systemName = systemName + "%";
			}
			predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.<String>get("name")), 
					systemName));
		}
		
		if(StringUtils.isNotBlank(filter.getSerial())) {
			String serial = filter.getSerial().toLowerCase();
			if(!filter.isExactMatchRequired()) {
				serial = serial + "%";
			}
			predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.<String>get("serial")),
					serial));
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
