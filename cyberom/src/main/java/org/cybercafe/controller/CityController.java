/**
 * 
 */
package org.cybercafe.controller;

import java.util.List;

import org.cybercafe.model.City;
import org.cybercafe.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author Bablu Rajbhar
 *
 */
@RestController()
public class CityController {

	@Autowired
	private CityService cityService;
	
	@RequestMapping(value = "rest/cities", method = RequestMethod.GET)
	public List<City> getCitiesByStateId(@RequestParam("stateId") Long stateId) {
		return cityService.getCitiesByStateId(stateId);
	}
}
