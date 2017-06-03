/**
 * 
 */
package org.cybercafe.service;

import java.util.List;

import org.cybercafe.domain.SystemSearchFilter;
import org.cybercafe.model.System;
import org.springframework.data.domain.Page;

/**
 * @author Bablu
 *
 */
public interface SystemService {
	
	System addSystem(System system);
	
	Page<System> getSystemsWithPagination(SystemSearchFilter filter);
	
	List<System> getSystemsWithoutPagination(SystemSearchFilter filter);
	
	Page<System> getSystemsByName();
	
	System getSystem(Long systemId);
	
	System updateSystem(System system);

}
