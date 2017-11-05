/**
 * 
 */
package org.cybercafe.repository;

import java.util.List;

import org.cybercafe.model.Session;
import org.cybercafe.model.SessionStatus;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * @author Bablu
 *
 */
public interface SessionRepository extends PagingAndSortingRepository<Session, Long>, JpaSpecificationExecutor<Session>{
	
	List<Session> findAll();
	
	List<Session> findBySessionStatus(SessionStatus sessionStatus);
	
}

