package basics;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class InvokeFirefox {
		
	public void openBrowser() {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		WebDriver driver = new FirefoxDriver();
		driver.get("http://localhost:8080/asad/index.html");
		System.out.println(driver.findElement(By.tagName("h1")).getText());
		//System.out.println(driver.getCurrentUrl());
		//System.out.println(driver.getPageSource());
		/*driver.findElement(By.xpath(".//*[@id='login-menu']/a[1]")).click();
		driver.findElement(By.xpath(".//*[@id='instructable-page']/div[9]/div/div[2]/form/input[1]")).sendKeys("asad90");
		driver.findElement(By.xpath(".//*[@id='instructable-page']/div[9]/div/div[2]/form/input[2]")).sendKeys("r071112");
		driver.findElement(By.xpath(".//*[@id='instructable-page']/div[9]/div/div[2]/form/button")).click();*/
		driver.close();
	}

}
