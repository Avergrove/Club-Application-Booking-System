package sg.nus.iss.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import sg.nus.iss.model.Booking;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

}
