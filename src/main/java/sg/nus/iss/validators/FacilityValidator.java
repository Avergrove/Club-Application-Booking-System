package sg.nus.iss.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.nus.iss.model.Facility;
@Component
public class FacilityValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Facility.class.isAssignableFrom(arg0);

	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Facility facility = (Facility) arg0;
		ValidationUtils.rejectIfEmpty(arg1, "facilityname", "error.facility.facilityname.empty");
		ValidationUtils.rejectIfEmpty(arg1, "facilitydescription", "error.facility.facilitydescription.empty");
		ValidationUtils.rejectIfEmpty(arg1, "location", "error.facility.location.empty");
		
	}

}