/**
 * 
 */
package org.cybercafe.controller;

import org.cybercafe.exception.RandomUUIDNotFoundException;
import org.cybercafe.model.User;
import org.cybercafe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author Bablu Rajbhar
 *
 */
@Controller
public class UserController {
	
	private static final String SOMETHING_WENT_WRONG_ERROR_MESSAGE = "Something went wrong !";

	private static final String ACCOUNT_ACTIVATION_VIEW = "accountActivation";

	private static final String MESSAGE = "message";

	private static final String RANDOM_UUID_NOT_FOUND_ERROR_MESSAGE = "We were unable to activate your account. "
			+ "Please make sure you clicked on correct link.";
	
	private static final String ACTIVATION_SUCCESSFUL_MESSAGE = "your account has been successfully activated."; 

	private static final String ID = "id";

	private static final String USER_OBJECT = "user";

	private static final String ACTIVATE_ACCOUNT_URL = "/activateAccount";
	
	@Autowired
	UserService userService;

	@RequestMapping(ACTIVATE_ACCOUNT_URL)
	public ModelAndView activateUser(@RequestParam(ID) String id) {
		ModelAndView modelAndView = new ModelAndView();
		User user = null;
		try {
			user = userService.activateUser(id);
		} catch (RandomUUIDNotFoundException e) {
			modelAndView.addObject(MESSAGE, RANDOM_UUID_NOT_FOUND_ERROR_MESSAGE);
			e.printStackTrace();
		} catch (Exception exception) {
			modelAndView.addObject(MESSAGE, SOMETHING_WENT_WRONG_ERROR_MESSAGE);
			exception.printStackTrace();
		}
		modelAndView.addObject(MESSAGE, ACTIVATION_SUCCESSFUL_MESSAGE);
		modelAndView.setViewName(ACCOUNT_ACTIVATION_VIEW);
		modelAndView.addObject(USER_OBJECT, user);
		return modelAndView;
	}
	
	
	
	
	 

}
