package sg.nus.iss.services;

import java.util.ArrayList;

import sg.nus.iss.model.Booking;

public interface BookingService {

	Booking CreateBooking(Booking bk);
	
	ArrayList<Booking> findAllBooking();
	
	ArrayList<Booking> findBookingByMemberId(int memberId);
	
	Booking findBookingByBookingId(int bookingId);
	
	public Booking updateBooking(Booking b);
}
