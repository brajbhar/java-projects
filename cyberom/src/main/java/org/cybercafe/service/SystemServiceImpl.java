/**
 * 
 */
package org.cybercafe.service;

import org.cybercafe.domain.SystemSearchFilter;
import org.cybercafe.model.System;
import org.cybercafe.repository.SystemRepository;
import org.cybercafe.repository.SystemSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

/**
 * @author Bablu
 *
 */
@Service
public class SystemServiceImpl implements SystemService {
	
	@Autowired
	SystemRepository systemRepository;
	
	@Override
	public System addSystem(System system) {
		return systemRepository.save(system);
	}

	@Override
	public Page<System> getSystems(SystemSearchFilter filter) {
		SystemSpecification specification = new SystemSpecification(filter);
		PageRequest pageRequest = new PageRequest(filter.getPageNumber(), filter.getPageSize());
		Page<System> computers = systemRepository.findAll(specification, pageRequest);
		return computers;
	}

}
