package com.haqasad.flatinput;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FlatFileClass {
	
	public void writeToFile(String studentName) {
		
		try {
			FileWriter flatFile = new FileWriter("NAME.txt");
			flatFile.write(studentName);
			flatFile.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	public String retrieveFromFile() {
		File file = new File("NAME.txt");
		try {
			BufferedReader readFile = new BufferedReader(new FileReader(file));			
			return readFile.readLine();
			
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

}
