//************************************************************************************
//                             InputClass.java
//************************************************************************************

package com.haqasad.excelinput;

import java.util.Scanner;

public class InputClass {
	
	private String hostName;
	private String portNumber;
	private String sid;
	private String userName;
	private String password;
	private String studentName;
	
	private Scanner scanner = new Scanner(System.in);
	
	public void inputFromKeyboard() {
		setHostName();
		setPortNumber();
		setSID();
		setUserName();
		setPassword();
		setStudentName();
		scanner.close();
	}
	
	public void setHostName() {
		System.out.println("Please input Oracle database host name: ");
		hostName = scanner.next();
	}
	
	public String getHostName() {
		return hostName;
	}
	
	public void setPortNumber() {
		System.out.println("Please input Oracle database port number: ");
		portNumber = scanner.next();
	}
	
	public String getPortNumber() {
		return portNumber;
	}
	
	public void setSID() {
		System.out.println("Please input Oracle database sid: ");
		sid = scanner.next();
	}
	
	public String getSID() {
		return sid;
	}
	
	public void setUserName() {
		System.out.println("Please input Oracle database user name: ");
		userName = scanner.next();
	}
	
	public String getUserName() {
		return userName;
	}
	
	public void setPassword() {
		System.out.println("Please input Oracle database password: ");
		password = scanner.next();
	}
	
	public String getPassword() {
		return password;
	}
	
	public void setStudentName() {
		System.out.println("Please input student name: ");
		studentName = scanner.next();
	}
	
	public String getStudentName() {
		return studentName;
	}
	
}
