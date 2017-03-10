package com.haqasad.flatinput;

public class Main {
		
	public static void main(String[] args) {
		
		InputClass input = new InputClass();
		FlatFileClass file = new FlatFileClass();
		DatabaseClass database = new DatabaseClass();
		
		input.inputFromKeyboard();
		file.writeToFile(input.getStudentName());
		database.connectToDB(input.getHostName(), input.getPortNumber(), input.getSID(), input.getUserName(), input.getPassword());
		database.verifyDB(file.retrieveFromFile());
	}
	
}
