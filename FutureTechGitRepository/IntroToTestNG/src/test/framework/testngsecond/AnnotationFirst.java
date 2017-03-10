package test.framework.testngsecond;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
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
	
	@Test (groups = {"Priority1"})
	public void flightBooking(){
		System.out.println("Test1: Flight Booking");
	}
	
	@Test (groups = {"Priority2"})
	public void flightCancel(){
		System.out.println("Test3: Flight Cancelling");
	}

}
