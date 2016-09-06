/**
 * 
 */
package org.cybercafe.repository;

import java.util.List;

import org.cybercafe.model.Computer;
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
	
	List<Computer> findAll();

}
