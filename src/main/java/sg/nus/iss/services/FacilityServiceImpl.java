package sg.nus.iss.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.nus.iss.model.Facility;
import sg.nus.iss.repo.FacilityRepository;

@Service
public class FacilityServiceImpl implements FacilityService {

	@Resource
	private FacilityRepository facilityRepository;
	
	@Override
	@Transactional
	public ArrayList<Facility> findAllFacilities() {
		ArrayList<Facility> facilities = (ArrayList<Facility>) facilityRepository.findAll();
		return facilities;
	}

	@Override
	@Transactional
	public Facility findFacility(int facilityId) {
		return facilityRepository.findOne(facilityId);
	}

	@Override
	@Transactional
	public Facility createFacility(Facility facility) {
		return facilityRepository.saveAndFlush(facility);
	}

	@Override
	@Transactional
	public Facility changeCourse(Facility facility) {
		// TODO Auto-generated method stub
		return facilityRepository.saveAndFlush(facility);
	}

	@Override
	public void removeCourse(Facility facility) {
		// TODO Auto-generated method stub
		facilityRepository.delete(facility);
		
	}

	@Override
	public ArrayList<Facility> findFacilitiesByCategory(int categoryId) {
		return facilityRepository.findFacilitiesByCategoryId(categoryId);
	}
	
	
	
}
