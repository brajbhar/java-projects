package org.cybercafe.controller;

import org.cybercafe.model.Cybercafe;
import org.cybercafe.model.User;
import org.cybercafe.service.CybercafeService;
import org.cybercafe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class CybercafeController {
	
	@Autowired
	private CybercafeService cybercafeService;
	
	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "rest/cybercafes", method = RequestMethod.POST)
	public Cybercafe registerCybercafe(@RequestBody Cybercafe cybercafe) throws Exception {
		cybercafe = cybercafeService.register(cybercafe);
		return cybercafe;
	}
	
	@RequestMapping(value = "rest/users", method = RequestMethod.GET)
	public User getUserByUserName(@RequestParam("userName") String userName, 
			@RequestParam("email") String email) {
		User user = userService.getUserByEmail(email);
		if(user==null) {
			user = userService.getUserByUserName(userName);
		}
		return user;
	}
	
	@RequestMapping(value = "rest/cybercafes/{id}", method = RequestMethod.GET)
	public Cybercafe getCybercafeById(@PathVariable("id") Long id) throws Exception{
		return cybercafeService.getCybercafe(id);
	}
}
