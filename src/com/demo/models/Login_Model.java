package com.demo.models;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Iterator;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.service.ServiceRegistryBuilder;

import com.demo.models.DBConnectivity;
import com.demo.pojo.users;

public class Login_Model {

	public String validateLogin(String username,String password){
		
		try{
			
			DBConnectivity db = new DBConnectivity();
			Statement statement = db.doConnection();
			ResultSet resultSet = statement.executeQuery("select count(*) from users where locale='en'");                                  
			String count = "";
			while(resultSet.next()){
				count = resultSet.getString(1);
			}
			System.out.println(count);
			resultSet.close();
			/*
			if(count == 1 ){
				return "success";
			}else{
				return "failed";
			}
			*/
			
			//users ab = new users();
			//user.add("asdf");
			return "index";
			
			
		}catch(Exception e){
			return "exception";
		}
		
	}
	
	
	public String doHibernateLogin(String username,String password){
		
		
		Configuration configuration = new Configuration().configure();
        ServiceRegistryBuilder registry = new ServiceRegistryBuilder();
        registry.applySettings(configuration.getProperties());
        ServiceRegistry serviceRegistry = registry.buildServiceRegistry();
         
        // builds a session factory from the service registry
        SessionFactory sessionFactory = configuration.buildSessionFactory(serviceRegistry);
         
        // obtains the session
        Session session = sessionFactory.openSession();
        session.beginTransaction();
        List users = session.createQuery("FROM users").list(); 
        for (Iterator iterator = 
                          users.iterator(); iterator.hasNext();){
           users user = (users) iterator.next(); 
           System.out.print("First Name: " + user.getname()); 
           System.out.print("  Last Name: " + user.getloginName()); 
		
        }
	/*	
		 Session session =  HibernateConnection.doHibernateConnection().openSession();
	      Transaction tx = null;
	      try{
	         tx = session.beginTransaction();
	         List users = session.createQuery("FROM users").list(); 
	         for (Iterator iterator = 
	                           users.iterator(); iterator.hasNext();){
	            users user = (users) iterator.next(); 
	            System.out.print("First Name: " + user.getname()); 
	            System.out.print("  Last Name: " + user.getloginName()); 
	         }
	         tx.commit();
	      }catch (HibernateException e) {
	         if (tx!=null) tx.rollback();
	         e.printStackTrace(); 
	      }finally {
	         session.close(); 
	      }*/
           
	      
		/*
		try{
			SessionFactory sf = HibernateConnection.doHibernateConnection();
			Session session = sf.openSession();
			
			session.beginTransaction();
			List<users> user = session.createQuery("From User where username='admin'").list();
			System.out.println(user.get(0).getname());
			session.close();
			
			if(user.size() == 1){
				return "success";
			}else{
				return "failed";
			}
			
		}catch(Exception e){
			return "exception";
		}
		
		*/
	
		return "";
	
	}
}
