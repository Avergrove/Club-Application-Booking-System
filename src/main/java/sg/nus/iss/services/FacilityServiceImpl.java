package sg.nus.iss.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.nus.iss.model.Facility;
import sg.nus.iss.repo.FacilityRepository;

@Service
public class FacilityServiceImpl implements FacilityService {

	
	@Resource
	private FacilityRepository facrepos;

	@Override
	public Facility CreateFacility(Facility f) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Facility> findAllFacility() {
		ArrayList<Facility> bl = (ArrayList<Facility>) facrepos.findAll();
		return bl;
	}
	
}
