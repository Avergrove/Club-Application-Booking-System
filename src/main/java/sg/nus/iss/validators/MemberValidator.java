package sg.nus.iss.validators;

import org.springframework.stereotype.Component;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import sg.nus.iss.model.User;


@Component
public class MemberValidator implements org.springframework.validation.Validator {

	public MemberValidator() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return User.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		User s = (User) target;
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "firstname", "error.user.firstname.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "surname", "error.user.surname.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "dob", "error.user.dob.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "joindate", "error.user.joindate.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "expirydate", "error.user.expirydate.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "error.user.email.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "userid", "error.user.userid.empty");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "error.user.password.empty");
		
		
		System.out.println(s.toString());
	}
}
