package com.demo.pojo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.NotBlank;


public class users {
	   private int id;
	   private String loginName; 
	   private String name;   

	   public users() 
	   {
		   
	   }
	   
	   public users(String loginName, String name)
	   {
	      this.loginName = loginName;
	      this.name = name;
	   }
	   public int getId() {
	      return id;
	   }
	   public void setId( int id ) {
	      this.id = id;
	   }
	   public String getloginName() {
	      return loginName;
	   }
	   public void setloginName( String loginName ) {
	      this.loginName = loginName;
	   }
	   public String getname() {
	      return name;
	   }
	   public void setname( String name ) {
	      this.name = name;
	   }
	}