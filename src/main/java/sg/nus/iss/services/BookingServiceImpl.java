package sg.nus.iss.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import sg.nus.iss.model.Booking;
import sg.nus.iss.model.Facility;
import sg.nus.iss.repo.BookingRepository;

@Service
public class BookingServiceImpl implements BookingService {

	
	@Resource
	private BookingRepository brepos;

	@Override
	public Booking CreateBooking(Booking bk) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<Booking> findAllBooking() {
		ArrayList<Booking> bl = (ArrayList<Booking>) brepos.findAll();
		return bl;
	}
	
	
	@Override
	public ArrayList<Booking> findBookingByMemberId(int memberId) {
		ArrayList<Booking> bookings = (ArrayList<Booking>)brepos.findBookingsByMemberId(memberId);
		return bookings;
	}

	@Override
	public Booking findBookingByBookingId(int bookingId) {
		Booking b = brepos.findBookingByBookingId(bookingId);
		return b;
	}
	
	@Override
	@Transactional
	public Booking updateBooking(Booking b) {
		// TODO Auto-generated method stub
		return brepos.saveAndFlush(b);
	}
	 
}
