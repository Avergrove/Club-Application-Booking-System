package sg.nus.iss.services;

import java.util.ArrayList;

import sg.nus.iss.model.Facility;

public interface FacilityService {
	ArrayList<Facility> findAllFacilities();

	Facility findFacility(int facilityId);

	Facility createFacility(Facility facility);

	Facility changeCourse(Facility facility);

	void removeCourse(Facility facility);

	ArrayList<Facility> findFacilitiesByCategory(int categoryId);
	
	ArrayList<Facility> findFacilitiesByFacilityName(String facilityName);
	

	
	//
	
	Facility CreateFacility(Facility f);
	
	ArrayList<Facility> findAllFacility();

	Facility findFacilityById(int s);
	
	Facility changeFacility(Facility f);

	ArrayList<Facility> findActiveFacilitiesByCategoryId(int categoryId);
	
	ArrayList<Facility> findAllActiveFacilities();
	
	
}
