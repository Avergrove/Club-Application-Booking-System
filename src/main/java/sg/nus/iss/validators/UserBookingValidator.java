package sg.nus.iss.validators;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.nus.iss.model.Booking;
import sg.nus.iss.services.BookingService;
@Component
public class UserBookingValidator implements Validator {
	@Autowired
	private BookingService bService;
	
	@Override
	public boolean supports(Class<?> arg0) {
		return Booking.class.isAssignableFrom(arg0);
	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Booking booking = (Booking) arg0;
		 if(booking.getStartdate()!=null && booking.getFacilityId()!=null) {
			DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			String date1= sdf.format(booking.getStartdate());
			ArrayList<Booking> bookings = bService.findBookedDatesByStatusNotEqual("CANCELLED", booking.getFacilityId());
			for(Booking b:bookings) {
				String date2 = sdf.format(b.getStartdate());
				if(date1.equals(date2)){
					arg1.reject("startdate", "date is not available");
					arg1.rejectValue("startdate", "error.booking.date.notavailable", "date is not available");
					break;
				}
			}
		}
		
		ValidationUtils.rejectIfEmpty(arg1, "bookingId", "error.booking.bookingId.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "facilityId", "error.booking.facilityId.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "startdate", "error.booking.date.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(arg1, "usr", "error.booking.userid.empty");
	    System.out.println(booking.toString());

	}

}
