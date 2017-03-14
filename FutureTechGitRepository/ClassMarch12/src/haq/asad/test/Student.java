package haq.asad.test;

import java.io.FileWriter;
import java.io.IOException;

public class Student {
	
	public String stnm;
	public String stjoindt;
	FileWriter flatFile;
	
	public Student(String studentName, String date) {
		studentName = this.stnm;
		date = this.stjoindt;
	}
	
	public void openFile() {
		try {
			flatFile = new FileWriter("NAME.txt");			
		} catch (IOException e) {			
			e.printStackTrace();
		}
	}
	
	public void stAdd(String student, String jndate) {
		
		try {			
			flatFile.write(student);
			flatFile.write("\t\t");
			flatFile.write(jndate);
			flatFile.write("\r\n");			
		} catch (IOException e) {			
			e.printStackTrace();
		}		
	}
	
	public void closeFile() {
		
		try {						
			flatFile.close();
		} catch (IOException e) {			
			e.printStackTrace();
		}		
	}

}
