/**
 * 
 */
package org.cybercafe.controller;

import java.security.Principal;
import java.util.Date;

import org.cybercafe.domain.SystemSearchFilter;
import org.cybercafe.model.Cybercafe;
import org.cybercafe.model.System;
import org.cybercafe.service.CybercafeService;
import org.cybercafe.service.StatusService;
import org.cybercafe.service.SystemService;
import org.cybercafe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	@Autowired
	private CybercafeService cybercafeService;
	
	public static final String REST_COMPUTERS_URL = "rest/systems";
	
	@RequestMapping(value = REST_COMPUTERS_URL, method = RequestMethod.GET)
	public Page<System> getComputersByPaging(Principal principal,
			@RequestParam(value = "name", required = false) String systemName,
			@RequestParam(value = "serial", required = false) String serial,
			@RequestParam(value = "isExactMatchRequired", required = false, defaultValue = "false") boolean isExactMatchRequired,
			@RequestParam(value = "isPagingRequired", required = false, defaultValue = "false") boolean isPagingRequired,
			@RequestParam(value = "pageNumber", required = true, defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", required = true, defaultValue= "5") Integer pageSize) {
		String userName = principal.getName();
		Cybercafe cybercafe = cybercafeService.getCybercafe(userName);
		SystemSearchFilter filter = new SystemSearchFilter();
		filter.setName(systemName);
		filter.setSerial(serial);
		filter.setPageNumber(pageNumber);
		filter.setPageSize(pageSize);
		filter.setExactMatchRequired(isExactMatchRequired);
		filter.setCybercafe(cybercafe);
		if(isPagingRequired) {
			return systemService.getSystemsWithPagination(filter);
		}
		return new PageImpl<> (systemService.getSystemsWithoutPagination(filter));
	}
	
	@RequestMapping(value = REST_COMPUTERS_URL + "/{systemId}", method = RequestMethod.GET)
	public System getSystem(@PathVariable("systemId") Long systemId) {
		return systemService.getSystem(systemId); 	
	}
	
	@RequestMapping(value = REST_COMPUTERS_URL, method= RequestMethod.POST)
	public System saveSystem(Principal principle, @RequestBody System system){
		system.setStatus(statusService.getStatusByName("active"));
		system.setUpdatedBy(userService.getUserByEmail(principle.getName()));
		system.setUpdatedOn(new Date());
		return systemService.addSystem(system);
	}
	
	@RequestMapping(value = REST_COMPUTERS_URL, method = RequestMethod.PUT)
	public System editSystem(Principal principle, @RequestBody System system){
		system.setUpdatedBy(userService.getUserByEmail(principle.getName()));
		system.setUpdatedOn(new Date());
		return systemService.updateSystem(system);
	}
	
	
}
