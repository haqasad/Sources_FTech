package test.framework.testngsecond;

import org.testng.annotations.Test;

public class AnnotationDependency {
	
	@Test
	public void openingBrowser() {
		System.out.println("Test 1: Opening Browser in AnnotationDependency");
	}
	
	@Test (dependsOnMethods = {"openingBrowser"}, alwaysRun = true)
	public void flightBooking() {
		System.out.println("Test 2: Booking Flight in AnnotationDependency, runs even if openingBrowser do not execute");
	}
	
	@Test (enabled = false)
	public void payment() {
		System.out.println("Test 3: Do not run this test case in AnnotationDependency");
	}
	
	@Test (timeOut = 5000)
	public void checkOut() {
		System.out.println("Test 4: If this method does not execute 5s, it will be marked as failed: in AnnotationDependency");
	}

}
