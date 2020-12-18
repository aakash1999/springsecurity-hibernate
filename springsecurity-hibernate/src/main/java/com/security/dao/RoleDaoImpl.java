package com.security.dao;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springsecurity.entity.Role;

@Repository
public class RoleDaoImpl implements RoleDao {
	
//	@Autowired
//	private EntityManager entityManager;
	
	@Autowired
	private SessionFactory sessionFactory;


	@Override
	public Role findRoleByName(String name) {
		
		//Session session = entityManager.unwrap(Session.class);
		Session session = sessionFactory.getCurrentSession();
		// now retrieve/read from database using name
				Query<Role> theQuery = session.createQuery("from Role where name=:roleName", Role.class);
				theQuery.setParameter("roleName", name);
				
				Role theRole = null;
				
				try {
					theRole = theQuery.getSingleResult();
				} catch (Exception e) {
					theRole = null;
				}
				
				return theRole;
	}

}
