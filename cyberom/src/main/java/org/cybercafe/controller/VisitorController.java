package org.cybercafe.controller;

import java.security.Principal;
import java.util.List;

import org.cybercafe.domain.VisitorSearchFilter;
import org.cybercafe.exception.DuplicateVisitorException;
import org.cybercafe.model.Cybercafe;
import org.cybercafe.model.IDCardType;
import org.cybercafe.model.Visitor;
import org.cybercafe.service.CybercafeService;
import org.cybercafe.service.VisitorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class VisitorController {
	
	private static final String REST_VISITORS_URL = "rest/visitors";
	
	@Autowired
	private VisitorService visitorService;
	
	@Autowired
	private CybercafeService cybercafeService;
	
	@RequestMapping(value = REST_VISITORS_URL, method = RequestMethod.POST)
	public Visitor addVisitor(@RequestBody Visitor visitor) throws DuplicateVisitorException{
		try {
			visitor =  visitorService.addVisitor(visitor);
		} catch (DuplicateVisitorException e) {
			throw e;
		}
		return visitor;
	}
	
	@RequestMapping(value = REST_VISITORS_URL, method = RequestMethod.PUT)
	public Visitor editVisitor(@RequestBody Visitor visitor) {
		return visitorService.editVisitor(visitor);
	}
	
		
	@RequestMapping(value = REST_VISITORS_URL, method = RequestMethod.GET)
	public Page<Visitor> getVisitorsByPaging(
			@RequestParam("mobileNumber") String mobileNumber,
			@RequestParam("firstName") String firstName,
			@RequestParam("lastName") String lastName,
			@RequestParam("pageNumber") Integer pageNumber,
			@RequestParam("pageSize") Integer pageSize,
			Principal principal){
		String username = principal.getName();
		Cybercafe cybercafe = cybercafeService.getCybercafe(username);
		VisitorSearchFilter visitorSearchFilter = new VisitorSearchFilter();
		visitorSearchFilter.setMobile(mobileNumber);
		visitorSearchFilter.setFirstName(firstName);
		visitorSearchFilter.setLastName(lastName);
		visitorSearchFilter.setPageNumber(pageNumber);
		visitorSearchFilter.setPageSize(pageSize);
		visitorSearchFilter.setCybercafe(cybercafe);
		return visitorService.getVisitors(visitorSearchFilter);
	}
	
	@RequestMapping(value = REST_VISITORS_URL + "/{visitorId}", method = RequestMethod.GET)
	public Visitor getVisitor(@PathVariable("visitorId") Long visitorId) {
		return visitorService.getVisitor(visitorId);
	}
	
	@RequestMapping(value = "rest/idcardtypes", method = RequestMethod.GET)
	public List<IDCardType> getIdCardTypes(Principal principal) {
		return visitorService.getIDcardTypes();
	}
	
}
