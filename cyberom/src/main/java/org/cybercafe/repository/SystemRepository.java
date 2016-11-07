/**
 * 
 */
package org.cybercafe.repository;

import org.cybercafe.model.System;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Bablu
 *
 */
public interface SystemRepository extends PagingAndSortingRepository<System, Long>, 
JpaSpecificationExecutor<System>{
	
	System save(System system);
	
	System findOne(Long id);
	
	Page<System> findAll(Specification specification, Pageable pageable);

}
