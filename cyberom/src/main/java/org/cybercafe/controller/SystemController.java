/**
 * 
 */
package org.cybercafe.controller;

import java.security.Principal;
import java.util.List;

import org.cybercafe.model.System;
import org.cybercafe.service.SystemService;
import org.springframework.beans.factory.annotation.Autowired;
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
	private SystemService computerService;
	
	public static final String REST_COMPUTERS_URL = "rest/computers";
	
	@RequestMapping(value = REST_COMPUTERS_URL, method = RequestMethod.GET)
	public List<System> getComputersByPaging(Principal principal,
			@RequestParam("name") String systemName,
			@RequestParam("serial") String serial,
			@RequestParam("pageNumber") String pageNumber,
			@RequestParam("pageSize") String pageSize) {
		return null;
	}

}
