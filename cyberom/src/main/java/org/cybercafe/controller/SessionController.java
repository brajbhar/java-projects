/**
 * 
 */
package org.cybercafe.controller;

import java.security.Principal;
import java.util.Date;

import org.cybercafe.domain.SessionSearchFilter;
import org.cybercafe.model.Cybercafe;
import org.cybercafe.model.Session;
import org.cybercafe.service.CybercafeService;
import org.cybercafe.service.SessionService;
import org.cybercafe.service.SessionStatusService;
import org.cybercafe.service.UserService;
import org.cybercafe.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
public class SessionController {
	
	@Autowired
	private SessionService sessionService;
	
	@Autowired
	private SessionStatusService sessionStatusService;
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private CybercafeService cybercafeService;
	
	@Autowired
	private VisitorService visitorService;
	
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
	
	@RequestMapping(value = "rest/sessions", method = RequestMethod.GET)
	public Page<Session> getSessions(Principal principal,
			@RequestParam(value = "visitorId", required = false) Long visitorId,
			@RequestParam(value = "pageNumber", required = true, defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", required = true, defaultValue= "5") Integer pageSize) {
		
		SessionSearchFilter filter = new SessionSearchFilter();
		filter.setPageNumber(pageNumber);
		filter.setPageSize(pageSize);
		filter.setVisitor(visitorService.getVisitor(visitorId));
		String userName = principal.getName();
		Cybercafe cybercafe = cybercafeService.getCybercafe(userName);
		filter.setCybercafe(cybercafe);
		return sessionService.getSessions(filter);
		
	}
	
	

}
