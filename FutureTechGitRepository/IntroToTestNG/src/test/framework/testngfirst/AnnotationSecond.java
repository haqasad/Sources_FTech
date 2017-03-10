package test.framework.testngfirst;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

public class AnnotationSecond {
	
	@BeforeSuite
	public void installSoftware() {
		System.out.println("Before everything: Install the software");
	}
	
	@AfterSuite
	public void unistallSoftware() {
		System.out.println("After everything: Uninstall the software");
	}

}
