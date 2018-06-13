package sg.nus.iss.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import sg.nus.iss.model.Category;
@Component
public class CategoryValidator implements Validator {

	@Override
	public boolean supports(Class<?> arg0) {
		return Category.class.isAssignableFrom(arg0);

	}

	@Override
	public void validate(Object arg0, Errors arg1) {
		Category category = (Category) arg0;
		ValidationUtils.rejectIfEmpty(arg1, "categoryname", "error.category.categoryname.empty");
		
		
	}

}