package test.framework.testngfirst;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;


public class AnnotationFirst {
	
	@BeforeTest
	public void deleteCookiesBefore() {
		System.out.println("Before Test: Deleting cookies before test");
	}
	
	@AfterTest
	public void deleteCookiesAfter() {
		System.out.println("After Test: Deleting cookies after test");
	}
	
	@BeforeMethod
	public void generateUserID() {
		System.out.println("Before Method: Generating User ID");
	}
	
	@AfterMethod
	public void addingReport() {
		System.out.println("After Method: Add result to report");
	}
	
	@Test
	public void openingBrowser() {
		System.out.println("Test2: Opening Browser");
	}
	
	@Test
	public void flightBooking(){
		System.out.println("Test1: Flight Booking");
	}
	
	@Test
	@Parameters({"adminUserID"})	
	public void adminLogIn(String userID){
		System.out.println("Test: Admin User Name: " + userID);
	}
	
	@Test (dataProvider = "getData", groups = {"Priority1"})
	public void logIn(String userName, String password, String email) {
		System.out.println("Data Provider: Printing User name, Password, Email");
		System.out.println(userName);
		System.out.println(password);
		System.out.println(email);
	}
	
	@DataProvider
	public Object[][] getData() {
		
		// row = number of times test case should run
		// column = number of parameters it should send for one go
		Object[][] data = new Object[3][3];
		
		data[0][0] = "asad";
		data[0][1] = "xyz";
		data[0][2] = "asad@email.com";
		
		data[1][0] = "sameer";
		data[1][1] = "mno";
		data[1][2] = "sameer@email.com";
		
		data[2][0] = "troy";
		data[2][1] = "abc";
		data[2][2] = "troy@email.com";
		
		return data;
	}
	
	

}
