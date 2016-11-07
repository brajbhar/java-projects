/**
 * 
 */
package org.cybercafe.service;

import org.cybercafe.domain.SystemSearchFilter;
import org.cybercafe.model.System;
import org.springframework.data.domain.Page;

/**
 * @author Bablu
 *
 */
public interface SystemService {
	
	System addSystem(System system);
	
	Page<System> getSystems(SystemSearchFilter filter);

}
