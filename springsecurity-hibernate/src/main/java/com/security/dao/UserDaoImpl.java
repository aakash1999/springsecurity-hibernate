package com.security.dao;

import java.util.List;

import javax.persistence.EntityManager;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.springsecurity.entity.Test;
import com.springsecurity.entity.User;

@Repository
public class UserDaoImpl implements UserDao {
	
//	@Autowired
//	private EntityManager entityManager;
	
	@Autowired
	private SessionFactory sessionFactory;

	@Override
	public User findByUserName(String userName) {
		//Session session = entityManager.unwrap(Session.class);
		Session session = sessionFactory.getCurrentSession();
		Query<Test> query2 = session.createQuery("from Test where id=:theId", Test.class);
		query2.setParameter("theId", 1); 
		Test test = query2.getSingleResult();
		System.out.println(test);
		Query<User> query = session.createQuery("from User where userName=:username", User.class);
		query.setParameter("username", userName);
		
		User user = null;
		
		try {
			user = query.getSingleResult();
			
		} catch (Exception e) {
			user = null;
		}
		System.out.println(user);
		
		return user;
	}

	@Override
	public void save(User user) {
		
		//Session session = entityManager.unwrap(Session.class);
		Session session = sessionFactory.getCurrentSession();
		session.saveOrUpdate(user);

	}

}
