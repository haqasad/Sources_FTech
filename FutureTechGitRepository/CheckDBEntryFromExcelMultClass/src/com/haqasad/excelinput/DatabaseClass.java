//************************************************************************************
//                             DatabaseClass.java
//************************************************************************************

package com.haqasad.excelinput;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseClass {
	
	private Connection connection;
	
	public void connectToDB(String hostName, String portNumber, String sid, String userName, String password) {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			System.out.println("Where is your Oracle JDBC Driver?");
			e.printStackTrace();
			return;
		}
		
		connection = null;
		
		try {
			connection = DriverManager.getConnection("jdbc:oracle:thin:@" + hostName + ":" + portNumber + ":" + sid, userName, password);			
		} catch (SQLException e) {
			System.out.println("\nConnection Failed! Check output console\n");
			e.printStackTrace();
			return;
		} 
	}
	
	public void verifyDB(String name) {
		
		try {
			Statement sqlStatement = connection.createStatement();
			ResultSet rows = sqlStatement.executeQuery("select * from student");
			
			while (rows.next()) {
				
				if (rows.getString(2).equals(name)) {
					System.out.println("Entry found in database STUDENT: " + name);
					break;
				} 
			}			
			connection.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}			
	}

}
