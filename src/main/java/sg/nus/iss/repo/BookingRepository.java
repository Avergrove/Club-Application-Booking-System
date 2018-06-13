package sg.nus.iss.repo;

import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import sg.nus.iss.model.Booking;
import sg.nus.iss.model.Facility;

public interface BookingRepository extends JpaRepository<Booking, Integer> {

	@Query(value = "SELECT b from Booking b WHERE b.usr.memberid = :memberId")
	ArrayList<Booking> findBookingsByMemberId(@Param("memberId") int memberId);
	
	@Query(value = "SELECT b from Booking b WHERE b.bookingId = :bookingId")
	Booking findBookingByBookingId(@Param("bookingId") int bookingId);	
	
}
