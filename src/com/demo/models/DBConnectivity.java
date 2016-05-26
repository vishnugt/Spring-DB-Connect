package com.demo.models;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

public class DBConnectivity {

	Connection conn;
	Statement statement;
	
	String url="jdbc:mysql://192.168.0.172:3306/";
	String dbName = "devtrac";
	String username = "devtrac";
	String password="devtrac";
	
	public Statement doConnection(){
		
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection(url + dbName,username,password);
			statement = conn.createStatement();	
			return statement;
		}catch(Exception e){
		
			return null;
		}
		
		
	}
	
	
}
