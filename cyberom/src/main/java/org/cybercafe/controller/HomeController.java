/**
 * 
 */
package org.cybercafe.controller;

import java.security.Principal;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bablu Rajbhar
 *
 */
@RestController
public class HomeController {
	
	@RequestMapping("/user")
	public Principal user(Principal user) {
		return user;
	}
	
}
