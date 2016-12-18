/**
 * 
 */
package org.cybercafe.service;

import org.cybercafe.model.Status;
import org.cybercafe.repository.StatusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Bablu
 *
 */
@Service
public class StatusServiceImpl implements StatusService {
	
	@Autowired
	StatusRepository statusRepository;

	@Override
	public Status getStatusByName(String status) {
		return statusRepository.findOneByName(status);
	}

}
