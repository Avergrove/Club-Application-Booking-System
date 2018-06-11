package sg.nus.iss.services;

import java.util.ArrayList;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import sg.nus.iss.model.Booking;
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
}
