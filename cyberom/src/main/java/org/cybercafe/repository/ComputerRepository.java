/**
 * 
 */
package org.cybercafe.repository;

import org.cybercafe.model.Computer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Bablu
 *
 */
public interface ComputerRepository extends PagingAndSortingRepository<Computer, Long>, 
JpaSpecificationExecutor<Computer>{
	
	Computer save(Computer computer);
	
	Computer findOne(Long id);
	
	Page<Computer> findAll(Specification specification, Pageable pageable);

}
