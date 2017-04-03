/**
 * 
 */
package org.cybercafe.repository;

import java.util.List;

import org.cybercafe.model.Session;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Bablu
 *
 */
public interface SessionRepository extends CrudRepository<Session, Long> {
	
	List<Session> findAll();
	
}

