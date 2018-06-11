package sg.nus.iss.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.nus.iss.model.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Integer> {

	@Query("SELECT f from Facility f WHERE f.categoryId = :categoryId")
	ArrayList<Facility> findFacilitiesByCategoryId(@Param("categoryId") int categoryId);
		

}
