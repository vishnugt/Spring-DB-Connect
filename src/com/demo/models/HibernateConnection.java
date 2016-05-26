	package com.demo.models;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;

import com.demo.pojo.users;

public class HibernateConnection {

	public static SessionFactory sf;
	
	public static SessionFactory  doHibernateConnection(){
		Properties database = new Properties();
		database.setProperty("hibernate.connection.driver_class", "com.mysql.jdbc.Driver");
		database.setProperty("hibernate.connection.username", "devtrac");
		database.setProperty("hibernate.connection.password", "devtrac");
		database.setProperty("hibernate.connection.url", "jdbc:mysql://192.168.0.172:3306/devtrac");
		database.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5Dialect");
		
		Configuration config = new Configuration().setProperties(database)
													.addPackage("com.demo.pojo")
													.addAnnotatedClass(users.class)
													.addResource("users.hbm.xml");
		
		StandardServiceRegistryBuilder ssrb = new StandardServiceRegistryBuilder().applySettings(config.getProperties());
		sf = config.buildSessionFactory(ssrb.build());
		
		return sf;
	}
	
}
