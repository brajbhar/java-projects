/**
 * 
 */
package org.cybercafe.controller;

import org.cybercafe.model.User;
import org.cybercafe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bablu Rajbhar
 *
 */
@RestController
public class LoginController {
	
	@Autowired
	UserService userService;
	
	@RequestMapping(value = "/signin", method = RequestMethod.POST)
	public User login(@RequestBody User user){
		return userService.getUserByUserName(user.getUserName());
	}

}
