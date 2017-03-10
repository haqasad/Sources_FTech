package com.ftf.student.dbinfo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

public class StringToArray {
	
	String[][] codes;
	int i = 0;
	int count = 0;
	int totalWords = 0;
	
	private Scanner readCodes;
	public File file;
	public BufferedReader buffer;
	
	@SuppressWarnings("resource")
	public void initializeFile() {
		try {
			file = new File("Test.txt");
			readCodes = new Scanner(file);
			buffer = new BufferedReader(new FileReader(file));
			
		} catch (Exception e) {
			System.out.println("Could not locate the data file");
		}
	}
	
	public int countWords() {

		String lines;
		
		try {
			
			while ((lines = buffer.readLine()) != null) {				
				String[] myWords = lines.replaceAll("\\s+", " ").split(" ");
				totalWords += myWords.length;								
			}
			
		} catch (Exception e) {			
			e.printStackTrace();
		}
		
		return totalWords;
	}
	
	public String[] convertArray() {
		int index = 0;
		int wordNum = countWords();
		String[] arryWords = new String[wordNum];
		
		readCodes.useDelimiter(",");
		
		while(readCodes.hasNext()) {			
			if (index < wordNum) {
				arryWords[index] = readCodes.next().replaceAll(" ", "");				
				index++;
			}						
		}				
		return arryWords;
	}
	
	public void closeFile() {
		readCodes.close();
	}
	
}
