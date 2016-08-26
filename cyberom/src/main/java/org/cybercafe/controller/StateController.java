/**
 * 
 */
package org.cybercafe.controller;

import java.util.List;

import org.cybercafe.model.State;
import org.cybercafe.service.StateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bablu Rajbhar
 *
 */
@RestController()
public class StateController {
	
	@Autowired
	private StateService stateService;
	

	@RequestMapping(method = RequestMethod.GET, value="rest/states")
	public List<State> getStates() {
		return stateService.getStates();
	}
}
