package com.security.dao;

import com.springsecurity.entity.User;

public interface UserDao {
	
	public User findByUserName(String userName);
	public void save(User user);
}
