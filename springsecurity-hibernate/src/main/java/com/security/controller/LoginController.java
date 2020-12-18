package com.security.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.security.models.CRMUser;
import com.security.service.UserService;
import com.security.validation.CustomValidator;
import com.springsecurity.entity.User;

@Controller
public class LoginController {
	
	@Autowired
	private CustomValidator customValidator;
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/showLoginPage")
	public String showLoginPage() {
		return "login";
	}

	@GetMapping("/access-denied")
	public String showErrorPage() {
		return "access-denied";
	}
	
	@GetMapping("/showRegistrationPage")
	public String showRegistrationPage(ModelMap modelMap) {
		modelMap.addAttribute("crmUser", new CRMUser());
		return "registration-form";
	}
	
	@PostMapping("/processRegistrationForm")
	public String processRegistrationForm(@Valid @ModelAttribute("crmUser") CRMUser user, BindingResult result, ModelMap map) {
		customValidator.validate(user, result);
		if(result.hasErrors())
			return "registration-form";
		
		User existing = userService.findByUserName(user.getUserName());
        if (existing != null){
        	map.addAttribute("crmUser", new CRMUser());
			map.addAttribute("registrationError", "User name already exists.");

        	return "registration-form";
        }
     // create user account        						
        userService.save(user);
        
        
        return "registration-confirmation";
		
	}

}
