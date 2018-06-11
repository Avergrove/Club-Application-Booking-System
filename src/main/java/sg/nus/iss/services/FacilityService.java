package sg.nus.iss.services;

import java.util.ArrayList;
import sg.nus.iss.model.Facility;

public interface FacilityService {
	
	Facility CreateFacility(Facility f);
	
	ArrayList<Facility> findAllFacility();

}
