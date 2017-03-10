/* Asadul Haque
 * Date: 01/22/2017
 * 
 * Takes a student name input from keyboard
 * Writes the student name into an excel file
 * Checks if the student name in excel file exists in an Oracle database table (already created)
 * To test this code create a table  named student with two columns named 'student_id' of type integer and 'student_name'
 * of type varchar2(10)
 * To connect to database input information related to database such as host name, port number, sid, user name, password 
 * */

//************************************************************************************
//                             Main.java
//************************************************************************************

package com.haqasad.excelinput;

public class Main {
		
	public static void main(String[] args) {
		
		InputClass input = new InputClass();
		ExcelFileClass file = new ExcelFileClass();
		DatabaseClass database = new DatabaseClass();
		
		input.inputFromKeyboard();
		file.writeToFile(input.getStudentName());
		database.connectToDB(input.getHostName(), input.getPortNumber(), input.getSID(), input.getUserName(), input.getPassword());
		database.verifyDB(file.retrieveFromFile());
	}
	
}
