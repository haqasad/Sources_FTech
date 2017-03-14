package haq.asad.test;

import java.util.Scanner;

public class TestStudent {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);		
		
		System.out.println("Enter the name the of the student: ");
		String studentNm=scanner.next();
		System.out.println(studentNm);
		
		System.out.println("Enter the name the of the student join date: ");
		String studentDt=scanner.next();		
		System.out.println(studentDt);
		
		Student student = new Student("studentNm", "studentDt");
		System.out.println("Student Name: " + student.stnm + "\n\rJoin Date: " + student.stjoindt);
		student.openFile();
		
		while(!(studentNm.equalsIgnoreCase("q")) || !(studentNm.equalsIgnoreCase("q"))) {			
			student.stAdd(student.stnm, student.stjoindt);
		}
		
//		student.openFile();		
		/*student.stAdd("Student Name", "Join Date");
		student.stAdd("=============", "=============");
		student.stAdd("testst001\t", "10-Jan-17");
		student.stAdd("testst002\t", "11-Jan-17");
		student.stAdd("testst003\t", "12-Jan-17");
		student.stAdd("testst004\t", "13-Jan-17");
		student.stAdd("testst005\t", "14-Jan-17");
		student.stAdd("testst006\t", "15-Jan-17");
		student.stAdd("testst007\t", "16-Jan-17");
		student.stAdd("testst008\t", "17-Jan-17");
		student.stAdd("testst009\t", "18-Jan-17");
		student.stAdd("testst010\t", "19-Jan-17");
		student.stAdd("testst011\t", "20-Jan-17");
		student.stAdd("testst012\t", "21-Jan-17");*/
		student.closeFile();
		
		System.out.println("Written to File");
		scanner.close();

	}

}
