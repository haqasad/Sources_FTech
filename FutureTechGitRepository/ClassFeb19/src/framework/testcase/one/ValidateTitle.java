package framework.testcase.one;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class ValidateTitle {
	
	WebDriver driver;
	
	public void openBrowser(String browserName) {
		
		String browser = browserName;
		
		switch (browser) {
		case "firefox":
			System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
			driver = new FirefoxDriver();
			
		case "chrome":
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver = new ChromeDriver();
		}
	}
	
	public void testMethod(String URL, String idName) {
		driver.get(URL);
		System.out.println(driver.findElement(By.id(idName)).getText());
	}
	
	public boolean validatePage(String URL, String expectedTitle) {
		
		driver.get(URL);
		String sTitle = driver.getTitle();
		
		if (sTitle.equals(expectedTitle)) {
			return true;
		} else {
			return false;
		}		
	}
	
	public boolean validateLink(String idName, String expectedValue) {
		
		String sLink = driver.findElement(By.id(idName)).getText();
		
		if (sLink.equals(expectedValue)) {
			return true;						
		} else {
			return false;
		}
		
	}
	
	public void closeBrowser() {
		driver.close();
	}

}
