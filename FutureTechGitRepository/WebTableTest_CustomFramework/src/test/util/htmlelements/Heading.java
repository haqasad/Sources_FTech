package test.util.htmlelements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Heading {
	
WebDriver driver;
	
	public void openChrome() {
		System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	public void openFirefox() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		driver = new FirefoxDriver();
	}
	
	public void goToPage(String URL) {
		driver.get(URL);
	}
	
	public String getTag(String tagName) {
		return driver.findElement(By.tagName(tagName)).getText();				
	}

	public void closeBrowser() {
		driver.close();
	}
	
}
