/* Requirements:
 * Input oracle database name from keyboard
 * The program should connect to database
 * The output should insert a list of values from a predefined array in the program*/



package com.ftf.student.dbinfo;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) throws SQLException {
		
		System.out.println("Input database name: ");
		
		Scanner input = new Scanner(System.in);
		String option = input.next();
		
		StringToArray myArray = new StringToArray();
		myArray.initializeFile();
		int arrayLength = myArray.countWords();
		String[] varArray = new String[arrayLength];						
		varArray = myArray.convertArray();	
		
		ConnectToDB database = new ConnectToDB();				
		
		for (int i=0; i<arrayLength; i++) {			
			if (varArray[i] != null && varArray[i].equals(option)) {				
				database.countryDataBase(varArray[i+1]); 				
			}			
		}
		
		myArray.closeFile();
	}
}
