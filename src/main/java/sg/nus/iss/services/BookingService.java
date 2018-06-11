package sg.nus.iss.services;

import java.util.ArrayList;

import sg.nus.iss.model.Booking;

public interface BookingService {

	Booking CreateBooking(Booking bk);
	
	ArrayList<Booking> findAllBooking();
	
	
}
