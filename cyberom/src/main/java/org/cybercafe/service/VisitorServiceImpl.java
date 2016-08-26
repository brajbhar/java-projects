package org.cybercafe.service;

import java.util.Date;
import java.util.List;

import org.cybercafe.domain.VisitorSearchFilter;
import org.cybercafe.exception.DuplicateVisitorException;
import org.cybercafe.model.IDCardType;
import org.cybercafe.model.Visitor;
import org.cybercafe.repository.IDCardTypeRepository;
import org.cybercafe.repository.VisitorRepository;
import org.cybercafe.repository.VisitorSpecification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
public class VisitorServiceImpl implements VisitorService {

	@Autowired
	private VisitorRepository visitorRepository;
	
	@Autowired
	private IDCardTypeRepository idCardTypeRepository;
	
	@Override
	public Visitor addVisitor(Visitor visitor) throws DuplicateVisitorException {
		visitor.setUpdatedOn(new Date());
		checkIfVisitorAlreadyExist(visitor);
		return visitorRepository.save(visitor);
	}

	private void checkIfVisitorAlreadyExist(Visitor visitor) throws DuplicateVisitorException {
		Visitor visitorFoundByNameAndMobile = visitorRepository.findByFirstNameAndLastNameAndMobileAndCybercafe(visitor.getFirstName(), 
				visitor.getLastName(), visitor.getMobile(), visitor.getCybercafe());
		if(visitorFoundByNameAndMobile!=null) {
			throw new DuplicateVisitorException("Visitor with name "+visitor.getFirstName() 
			+ " " + visitor.getLastName() + " having mobile number "+visitor.getMobile() + " already exist.");
		}
		
		Visitor visitorFoundByIDCard = visitorRepository.findByIdCardNumberAndIdCardTypeAndCybercafe(visitor.getIdCardNumber(), 
				visitor.getIdCardType(), visitor.getCybercafe());
		
		if(visitorFoundByIDCard!=null) {
			throw new DuplicateVisitorException("Visitor with same id card already exist");
		}
	}

	@Override
	public Visitor getVisitor(Long visitorId) {
		return visitorRepository.findOne(visitorId);
	}

	public VisitorRepository getVisitorRepository() {
		return visitorRepository;
	}

	public void setVisitorRepository(VisitorRepository visitorRepository) {
		this.visitorRepository = visitorRepository;
	}

	@Override
	public List<IDCardType> getIDcardTypes() {
		return (List<IDCardType>) idCardTypeRepository.findAll();
	}

	@Override
	public List<Visitor> getVisitors() {
		
		return (List<Visitor>)visitorRepository.findAll();
	}

	@Override
	public Visitor editVisitor(Visitor visitor) {
		visitor.setUpdatedOn(new Date());
		return visitorRepository.save(visitor);
	}

	@Override
	public Page<Visitor> getVisitors(VisitorSearchFilter visitorFilter) {
		VisitorSpecification specification = new VisitorSpecification(visitorFilter);
		PageRequest pageRequest = new PageRequest(visitorFilter.getPageNumber(), visitorFilter.getPageSize());
		Page<Visitor> visitors = visitorRepository.findAll(specification, pageRequest);
		return visitors; 
	}

}
