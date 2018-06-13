package sg.nus.iss.services;

import java.util.ArrayList;

import sg.nus.iss.model.Booking;

public interface BookingService {

	Booking CreateBooking(Booking bk);
	
	ArrayList<Booking> findAllBooking();
	
	ArrayList<Booking> findBookingByMemberId(int memberId);
	
	Booking findBookingByBookingId(int bookingId);
	
	public Booking updateBooking(Booking b);
	
	ArrayList<Booking> findBookingByMID(Integer mid);
	
	Booking findBooking(Integer bid);

	Booking changeBooking(Booking booking);

	void removeBooking(Booking booking);

	ArrayList<Booking> findBookingsByStatus(String status);
	
	ArrayList<Booking> findCurrentFutureBookings();
	
	ArrayList<Booking> findCurrentFutureBookingsByFID(Integer fid);

	ArrayList<Booking> findBookingsByStatusNotEqual(String status);
	
	ArrayList<Booking> findBookedDatesByStatusNotEqual(String status, Integer fid);
}
