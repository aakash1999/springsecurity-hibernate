package com.security;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import com.springsecurity.entity.Role;
import com.springsecurity.entity.User;

@Configuration
@EnableTransactionManagement
public class HibernateConfig {
	@Bean
	public DataSource myDataSource() {
		// create connection pool
		DriverManagerDataSource myDataSource = new DriverManagerDataSource();

		// set the jdbc driver
		try {
			myDataSource.setDriverClassName("com.mysql.jdbc.Driver");	
		}
		catch (Exception exc) {
			throw new RuntimeException(exc);
		}
		
		// set database connection props
		myDataSource.setUrl("jdbc:mysql://localhost:3310/security-hibernate-demo");
		myDataSource.setUsername("root");
		myDataSource.setPassword("root");

		return myDataSource;
	}
	
	private Properties getHibernateProperties() {

		// set hibernate properties
		Properties props = new Properties();

		props.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQLDialect");
		props.setProperty("hibernate.show_sql", "true");
		
		return props;				
	}

	
	// need a helper method 
	// read environment property and convert to int
	
	@Bean
	public LocalSessionFactoryBean sessionFactory(){
		
		// create session factorys
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		
		// set the properties
		sessionFactory.setDataSource(myDataSource());
		sessionFactory.setHibernateProperties(getHibernateProperties());
		sessionFactory.setPackagesToScan("com.*");
		return sessionFactory;
	}
	
	@Bean
	@Autowired
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
		
		// setup transaction manager based on session factory
		HibernateTransactionManager txManager = new HibernateTransactionManager();
		txManager.setSessionFactory(sessionFactory);

		return txManager;
	}
}
