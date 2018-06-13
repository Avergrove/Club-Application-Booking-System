package sg.nus.iss.validators;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.nus.iss.model.Booking;
import sg.nus.iss.model.User;

public class UserValidator implements Validator{

	@Override
	public boolean supports(Class<?> clazz) {
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User u = (User) target;

		ValidationUtils.rejectIfEmpty(errors, "firstname", "error.booking.bookingId.empty");		
		ValidationUtils.rejectIfEmpty(errors, "secondname", "error.booking.bookingId.empty");		
		ValidationUtils.rejectIfEmpty(errors, "surname", "error.booking.bookingId.empty");		
		ValidationUtils.rejectIfEmpty(errors, "firstname", "error.booking.bookingId.empty");		
		ValidationUtils.rejectIfEmpty(errors, "dob", "error.booking.bookingId.empty");		
		ValidationUtils.rejectIfEmpty(errors, "email", "error.booking.bookingId.empty");		
		// ValidationUtils.rejectIfEmpty(errors, "Phone", "error.booking.bookingId.empty");		
		ValidationUtils.rejectIfEmpty(errors, "username", "error.booking.bookingId.empty");		
		ValidationUtils.rejectIfEmpty(errors, "password", "error.booking.bookingId.empty");		
		
	    System.out.println(u.toString());
	}
	
}
