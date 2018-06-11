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
}
