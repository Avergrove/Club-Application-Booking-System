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
	public boolean supports(Class<?> clazz) {
		return Booking.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object arg1, Errors errors) {
		Booking booking = (Booking) arg1;
		SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		
		if ((booking.getFacilityId()!=null && booking.getStartdate()!=null)){
			for(Booking b:bService.findCurrentFutureBookingsByFID(booking.getFacilityId())) {
				if(booking.getFacilityId()==b.getFacilityId()&&dateFormat.format((booking.getStartdate())).equals(dateFormat.format(b.getStartdate()))) {
					errors.reject("startdate", "Invalid date");
					errors.rejectValue("startdate", "errors.date", "Invalid date");
					break;
				}
			}
	
		}
				
		ValidationUtils.rejectIfEmpty(errors, "bookingId", "error.booking.bookingId.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "facilityId", "error.booking.facilityId.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "startdate", "error.booking.date.empty");
	    System.out.println(booking.toString());
	    
	}

}
