package basics;

import java.io.FileWriter;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class TestClass {
	
		public String invokeBrowser() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://www.google.com/");
		return driver.getTitle();
	}
		
		public void checkTitle() {
			String title = invokeBrowser();
			String expectedTitle = "google";
			FileWriter reportFile;
			try {
				reportFile = new FileWriter("reportfile.dat");
				reportFile.write("URL\t\t" + "Expected Result\t\t" + "P/F\r\n");
				if (expectedTitle.equals(title)) {
					reportFile.write("google.com\t\t" + "title = google\t\t" + "P");
				} else {
					reportFile.write("google.com\t\t" + "title = google\t\t" + "F");
				}
				reportFile.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}	
			
		}
}
