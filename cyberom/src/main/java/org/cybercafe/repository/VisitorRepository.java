package org.cybercafe.repository;

import java.util.List;

import org.cybercafe.model.Cybercafe;
import org.cybercafe.model.IDCardType;
import org.cybercafe.model.Visitor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VisitorRepository extends PagingAndSortingRepository<Visitor, Long>, JpaSpecificationExecutor<Visitor> {
	
	@SuppressWarnings("unchecked")
	Visitor save(Visitor visitor);
	
	Visitor findOne(Long id);
	
	Visitor findByFirstNameAndLastName(String firstName, String lastName);

	Visitor findByFirstNameAndLastNameAndMobileAndCybercafe(String firstName, String lastName, String mobile, Cybercafe cybercafe);

	Visitor findByIdCardNumberAndIdCardTypeAndCybercafe(String idCardNumber, IDCardType idCardType, Cybercafe cybercafe);
	
	Page<Visitor> findAll(Specification specification, Pageable pageable);
	
	List<Visitor> findAll(Specification specification);

}
