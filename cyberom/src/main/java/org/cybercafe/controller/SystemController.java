/**
 * 
 */
package org.cybercafe.controller;

import java.security.Principal;
import java.util.Date;

import org.cybercafe.domain.SystemSearchFilter;
import org.cybercafe.model.System;
import org.cybercafe.service.StatusService;
import org.cybercafe.service.SystemService;
import org.cybercafe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bablu
 *
 */
@RestController
public class SystemController {
	
	@Autowired
	private SystemService systemService;
	
	@Autowired
	private StatusService statusService;
	
	@Autowired
	private UserService userService;
	
	public static final String REST_COMPUTERS_URL = "rest/systems";
	
	@RequestMapping(value = REST_COMPUTERS_URL, method = RequestMethod.GET)
	public Page<System> getComputersByPaging(Principal principal,
			@RequestParam("name") String systemName,
			@RequestParam("serial") String serial,
			@RequestParam("pageNumber") Integer pageNumber,
			@RequestParam("pageSize") Integer pageSize) {
		SystemSearchFilter filter = new SystemSearchFilter();
		filter.setName(systemName);
		filter.setSerial(serial);
		filter.setPageNumber(pageNumber);
		filter.setPageSize(pageSize);
		return systemService.getSystems(filter);
	}
	
	@RequestMapping(value = REST_COMPUTERS_URL, method= RequestMethod.POST)
	public System saveSystem(Principal principle, @RequestBody System system){
		system.setStatus(statusService.getStatusByName("active"));
		system.setUpdatedBy(userService.getUserByEmail(principle.getName()));
		system.setUpdatedOn(new Date());
		return systemService.addSystem(system);
	}

}
