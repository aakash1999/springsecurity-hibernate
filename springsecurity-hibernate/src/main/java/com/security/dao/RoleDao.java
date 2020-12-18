package com.security.dao;

import com.springsecurity.entity.Role;

public interface RoleDao {
	
	public Role findRoleByName(String name);
}
