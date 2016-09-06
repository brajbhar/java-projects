package org.cybercafe.repository;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.apache.commons.lang3.StringUtils;
import org.cybercafe.model.Computer;
import org.springframework.data.jpa.domain.Specification;

public class ComputerSpecification implements Specification<Computer> {
	
	private final Computer computer;
	
	public ComputerSpecification(Computer computer) {
		this.computer = computer;
	}

	@Override
	public Predicate toPredicate(Root<Computer> root, CriteriaQuery<?> criteriaQuery, 
			CriteriaBuilder criteriaBuilder) {
		List<Predicate> predicates = new ArrayList<>();
		if(StringUtils.isNotBlank(computer.getName())) {
			predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.<String>get("name")), 
					computer.getName().toLowerCase() + "%"));
		}
		
		if(StringUtils.isNotBlank(computer.getSerial())) {
			predicates.add(criteriaBuilder.like(criteriaBuilder.lower(root.<String>get("serial")),
					computer.getSerial().toLowerCase() + "%"));
		}
		return andTogether(predicates, criteriaBuilder);
	}
	
	private Predicate andTogether(List<Predicate> predicates, CriteriaBuilder cb) {
	    return cb.and(predicates.toArray(new Predicate[0]));
	}
	
}
