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

	@Override
	public ArrayList<Facility> findFacilitiesByFacilityName(String facilityName) {
		return facilityRepository.findFacilitiesByFacilityName(facilityName);
	}
	

	@Override	
	public Facility CreateFacility(Facility f) {
		// TODO Auto-generated method stub
		return facilityRepository.saveAndFlush(f);
	}

	@Override
	public ArrayList<Facility> findAllFacility() {
		ArrayList<Facility> bl = (ArrayList<Facility>) facilityRepository.findAll();
		return bl;
	}
	
	@Override
	public Facility findFacilityById(int s) {
		return facilityRepository.findFacilityById(s);
	}
	
	@Override
	public Facility changeFacility(Facility f) {
		return facilityRepository.saveAndFlush(f);
	}

	@Override
	public ArrayList<Facility> findActiveFacilitiesByCategoryId(int categoryId) {
		ArrayList<Facility> arraylist1 = facilityRepository.findActiveFacilitiesByCategoryId(categoryId);
		return arraylist1;
	}

	@Override
	public ArrayList<Facility> findAllActiveFacilities() {
		return facilityRepository.findAllActiveFacilities();
	}

		
	
}
