package sg.nus.iss.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;

import sg.nus.iss.model.Userrole;



@Component
public class RoleIdValidator implements org.springframework.validation.Validator {

	
	public RoleIdValidator()
	{
	
	}
	
	@Override
	public boolean supports(Class<?> clazz) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		// TODO Auto-generated method stub
		
		 Userrole userrole=(Userrole) target;
		ValidationUtils.rejectIfEmpty(errors, "rolename", "Role name can't be empty");
		System.out.println(userrole.toString());
	
		
		
	}

}
