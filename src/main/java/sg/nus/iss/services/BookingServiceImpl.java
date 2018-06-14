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
		return brepos.saveAndFlush(bk);
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
	


	@Override
	@Transactional
	public Booking findBooking(Integer bid) {
		Booking b1 = (Booking) brepos.findBooking(bid);
		return b1;
	}

	@Override
	@Transactional
	public Booking changeBooking(Booking booking) {
		return brepos.saveAndFlush(booking);
	}

	@Override
	@Transactional
	public void removeBooking(Booking booking) {
		brepos.delete(booking);		
	}

	@Override
	@Transactional
	public ArrayList<Booking> findBookingsByStatus(String status) {
		ArrayList<Booking> a3 = (ArrayList<Booking>) brepos.findBookingsByStatus(status);
		return a3;
	}

	@Override
	public ArrayList<Booking> findBookingByMID(Integer mid) {
		ArrayList<Booking> a2 = (ArrayList<Booking>) brepos.findBookingByMID(mid);
		return a2;
	}

	@Override
	public ArrayList<Booking> findCurrentFutureBookings() {
		ArrayList<Booking> a4 = (ArrayList<Booking>) brepos.findCurrentFutureBookings();
		return a4;
	}

	@Override
	public ArrayList<Booking> findCurrentFutureBookingsByFID(Integer fid) {
		ArrayList<Booking> a5 = (ArrayList<Booking>) brepos.findCurrentFutureBookingsByFID(fid);
		return a5;
	}

	@Override
	public ArrayList<Booking> findBookingsByStatusNotEqual(String status) {
		ArrayList<Booking> a6 = (ArrayList<Booking>) brepos.findBookingsByStatusNotEqual(status);
		return a6;
	}

	@Override
	public ArrayList<Booking> findBookedDatesByStatusNotEqual(String status, Integer fid) {
		ArrayList<Booking> d1 = (ArrayList<Booking>) brepos.findBookedDatesByStatusNotEqual(status, fid);
		return d1;
	}	
	
	 
}
