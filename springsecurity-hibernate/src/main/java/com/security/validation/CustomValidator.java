package com.security.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.security.models.CRMUser;

@Component
public class CustomValidator implements Validator {
	
	private Pattern pattern;
	private Matcher matcher;
	private static final String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
			+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	@Override
	public void validate(Object target, Errors errors) {
		CRMUser user = (CRMUser)target;
		pattern = Pattern.compile(EMAIL_PATTERN);
		if(user.getEmail()==null)
			errors.rejectValue("email", "","Email Should not be empty");
		matcher = pattern.matcher(user.getEmail());
		if(!matcher.matches())
			errors.rejectValue("email", "","Email is not in the proper format");
		
		String password = user.getPassword();
		String matchingPassword = user.getMatchingPassword();
		
		if(!password.equals(matchingPassword)) {
			errors.rejectValue("password", "","The password and matching password dosent match");
			errors.rejectValue("matchingPassword", "","The password and matching password dosent match");
		}
			
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return false;
	}
	
	
	
	

}
