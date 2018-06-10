package sg.nus.iss.services;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.nus.iss.repo.FacilityRepository;

@Service
public class FacilityServiceImpl implements FacilityService {

	
	@Resource
	private FacilityRepository facrepos;
	
}
