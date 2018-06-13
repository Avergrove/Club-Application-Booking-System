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

	@Query("SELECT b from Booking b WHERE b.usr.memberid = :mid")
	ArrayList<Booking> findBookingByMID(@Param("mid") Integer mid);
	
	@Query(value = "SELECT * FROM booking WHERE bookingstatus = ?0", nativeQuery = true)
	ArrayList<Booking> findBookingsByStatus(String status);
	
	@Query("SELECT b from Booking b where b.bookingId = :bid")
	Booking findBooking(@Param("bid") Integer bid);
	
	@Query("SELECT b from Booking b where b.startdate >= CURRENT_DATE()")
	ArrayList<Booking> findCurrentFutureBookings();
	
	@Query("SELECT b from Booking b where b.facilityId =:fid AND b.startdate >= CURRENT_DATE()")
	ArrayList<Booking> findCurrentFutureBookingsByFID(@Param("fid") Integer fid);
	
	@Query("SELECT b from Booking b where b.bookstatus != :status")
	ArrayList<Booking> findBookingsByStatusNotEqual(@Param("status") String status);
	
	@Query("SELECT b from Booking b where b.startdate>= CURRENT_DATE() AND b.bookstatus != :status AND b.facilityId= :fid")
	ArrayList<Booking> findBookedDatesByStatusNotEqual(@Param("status") String status, @Param("fid") Integer fid);
	
	
}
