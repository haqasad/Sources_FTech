package basics;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class InvokeInternetExplorer {
	
	public void openBrowser() {
		System.setProperty("webdriver.ie.driver", "C:\\Users\\Mushfiq\\Downloads\\IEDriverServer_32.exe");
		WebDriver driver = new InternetExplorerDriver();
		driver.get("https://gitlab.com/");
		System.out.println(driver.getTitle());
		System.out.println(driver.getCurrentUrl());
		System.out.println(driver.getPageSource());
		driver.close();
	}

}
