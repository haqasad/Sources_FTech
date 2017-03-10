package com.haqasad.flatinput;

import java.util.Scanner;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
	
	static FileWriter flatFile;
	static Connection connection;
	static String hostName;
	static String portNumber;
	static String sid;
	static String userName;
	static String password;
	static String studentName;

	public static void main(String[] args) {
		inputFromKeyboard();
		writeToFile();
		connectToDB();
		verifyDB();

	}
	
	public static void inputFromKeyboard() {
		Scanner scanner = new Scanner(System.in);		
		
		System.out.println("Please input Oracle DB host name: ");
		hostName = scanner.next();
		
		System.out.println("Please input Oracle DB port number: ");
		portNumber = scanner.next();
		
		System.out.println("Please input Oracle DB sid: ");
		sid = scanner.next();
		
		System.out.println("Please input Oracle DB user name: ");
		userName = scanner.next();
		
		System.out.println("Please input Oracle DB password: ");
		password = scanner.next();
		
		System.out.println("Please input student name: ");
		studentName = scanner.next();
		
		scanner.close();
	}
	
	public static void writeToFile() {
		//String name = inputFromKeyboard();
		try {
			flatFile = new FileWriter("NAME.txt");
			flatFile.write(studentName);
			flatFile.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
	}
	
	public static String retrieveFromFile() {
		File file = new File("NAME.txt");
		try {
			BufferedReader readFile = new BufferedReader(new FileReader(file));			
			return readFile.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static void connectToDB() {
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
	
	public static void verifyDB() {
		String name = retrieveFromFile();
		
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
