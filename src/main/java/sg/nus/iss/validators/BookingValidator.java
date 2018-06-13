package sg.nus.iss.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.nus.iss.model.Booking;

public class BookingValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return Booking.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		Booking b = (Booking) target;
		ValidationUtils.rejectIfEmpty(errors, "bookingId", "error.booking.bookingId.empty");
		ValidationUtils.rejectIfEmpty(errors, "managerInCharge", "error.booking.managerInCharge.empty");
	    System.out.println(b.toString());
	}
	
}
