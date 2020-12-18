package com.security.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.security.models.CRMUser;
import com.springsecurity.entity.User;

public interface UserService extends UserDetailsService {
	
	public User findByUserName(String userName);
	public void save(CRMUser user);

}
