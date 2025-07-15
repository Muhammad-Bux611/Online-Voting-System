package com.vote.Config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.Hibernate;
import org.hibernate.SessionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ComponentScan(basePackages = "com.vote.DAO")
public class Config {

//	@Bean(name = "umaidwar")
//	public AdminDao getUmaidWar() {
//		
//		AdminDaoImpl adminDao = new AdminDaoImpl();
//		adminDao.setHibernate(getHibernate(getLocalSessionFactory()));
//		return adminDao;
//		
//	}
	@Bean
	 HibernateTemplate getHibernate(SessionFactory sessionFactory) {
		// TODO Auto-generated method stub
		HibernateTemplate hibernateTemplate = new HibernateTemplate(sessionFactory);
//		hibernateTemplate.setSessionFactory(getLocalSessionFactory());
		return hibernateTemplate;
	}
	@Bean
	 LocalSessionFactoryBean getLocalSessionFactory() {
		// TODO Auto-generated method stub
		
		LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
		sessionFactory.setDataSource(getDataSource());
		sessionFactory.setHibernateProperties(getHibernateProperties());
		sessionFactory.setAnnotatedClasses(com.vote.Entity.Admin.class, com.vote.Entity.Candidate.class);
		return sessionFactory;
	}

//	private Class<> getAnnotatedClasses() {
//		// TODO Auto-generated method stub
//		
//		return null;
//	}
	@Bean
	 Properties getHibernateProperties() {
		// TODO Auto-generated method stub
		
		Properties properties = new Properties();
		properties.setProperty("hibernate.show_sql", "true");
		properties.setProperty("hibernate.hbm2ddl.auto", "update");
		properties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL8Dialect");
		
		
		return properties;
	}
	@Bean
	 DataSource getDataSource() {
		// TODO Auto-generated method stub
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
		dataSource.setUrl("jdbc:mysql://localhost/onlinevotingsystem");
		dataSource.setUsername("root");
		dataSource.setPassword("software@muet19");
		return dataSource;
	}
	@Bean
	public HibernateTransactionManager transactionManager(SessionFactory sessionFactory) {
	    HibernateTransactionManager txManager = new HibernateTransactionManager();
	    txManager.setSessionFactory(sessionFactory);
	    return txManager;
	}
	
	
}
