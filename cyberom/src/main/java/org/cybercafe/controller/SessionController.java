/**
 * 
 */
package org.cybercafe.controller;

import org.cybercafe.model.Session;
import org.cybercafe.service.SessionService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bablu
 *
 */
@RestController
public class SessionController {
	
	private SessionService sessionService;
	
	@RequestMapping(value = "rest/sessions/{id}", method = RequestMethod.GET)
	public Session getSession(@PathVariable("id") Long id) {
		return sessionService.getSession(id);
	}
	
	@RequestMapping(value = "rest/sessions", method = RequestMethod.POST)
	public Session startSession(Session Session) {
		
		return null;
	}

}
