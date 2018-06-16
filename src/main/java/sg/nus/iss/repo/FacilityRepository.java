package sg.nus.iss.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.nus.iss.model.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Integer> {

	@Query("SELECT f FROM Facility f where f.facilityId = :id")
	Facility findFacilityById(@Param("id") Integer id);	
	
	@Query("SELECT f from Facility f WHERE f.categoryid = :categoryId")
	ArrayList<Facility> findFacilitiesByCategoryId(@Param("categoryId") int categoryId);
		
	@Query("SELECT f from Facility f WHERE f.facilityname LIKE %:facilityName%")
	ArrayList<Facility> findFacilitiesByFacilityName(@Param("facilityName") String facilityName);
	
	@Query("SELECT f from Facility f WHERE upper(f.facilitystatus)='ACTIVE' AND f.categoryid = :categoryId")
	ArrayList<Facility> findActiveFacilitiesByCategoryId(@Param("categoryId") int categoryId);
	
	@Query("SELECT f from Facility f WHERE upper(f.facilitystatus)='ACTIVE'")
	ArrayList<Facility> findAllActiveFacilities();
	
	
}
