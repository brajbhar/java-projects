/**
 * 
 */
package org.cybercafe.controller;

import java.security.Principal;
import java.util.Date;

import org.cybercafe.model.Cybercafe;
import org.cybercafe.model.Session;
import org.cybercafe.service.CybercafeService;
import org.cybercafe.service.SessionService;
import org.cybercafe.service.SessionStatusService;
import org.cybercafe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.gemstone.org.jgroups.util.GetNetworkInterfaces;

/**
 * @author Bablu
 *
 */
@RestController
public class SessionController {
	
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private SessionStatusService sessionStatusService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CybercafeService cybercafeService;
	
	@RequestMapping(value = "rest/sessions/{id}", method = RequestMethod.GET)
	public Session getSession(@PathVariable("id") Long id) {
		return sessionService.getSession(id);
	}
	
	@RequestMapping(value = "rest/sessions", method = RequestMethod.POST)
	public Session createSession(@RequestBody Session session, Principal principle) {
		Cybercafe cybercafe = cybercafeService.getCybercafe(principle.getName());
		session = sessionService.createNewSesion(session, cybercafe,
				userService.getUserByEmail(principle.getName()));
		sessionService.startSession(session.getId(), new Date(), 
				sessionStatusService.getInProgressStatus());
		return session;
	}
	
	

}
