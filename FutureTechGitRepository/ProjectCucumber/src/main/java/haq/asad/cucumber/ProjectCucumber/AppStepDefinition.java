package haq.asad.cucumber.ProjectCucumber;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class AppStepDefinition {
	
	String actualValue;
	WebDriver driver;
	
	@Given("^The browser is invoked and url is loaded$")
	public void the_browser_is_invoked_and_url_is_loaded() throws Throwable {
		System.setProperty("webdriver.gecko.driver", "C:\\geckodriver.exe");
		driver = new FirefoxDriver();
		driver.get("https://www.etsy.com");
	}

	@When("^I get actual linktitle from (||d+)$")
	public void i_get_actual_linktitle_from(int idNum) throws Throwable {	    
		String xpathValue = "catnav-primary-link-" + idNum + "-link";
		actualValue = driver.findElement(By.id(xpathValue)).getText();
	}

	@Then("^Verify \"([^\"]*)\" equals actual link$")
	public void verify_equals_actual_link(String expectedValue) throws Throwable {	 
		Assert.assertEquals("Check if actual value equals expected value", actualValue, expectedValue);
	}

}
