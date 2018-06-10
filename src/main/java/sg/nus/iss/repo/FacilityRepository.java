package sg.nus.iss.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.nus.iss.model.Facility;

public interface FacilityRepository extends JpaRepository<Facility, Integer> {
	

}
