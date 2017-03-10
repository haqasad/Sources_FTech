package com.cucumber.SimpleCucumberMaven;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import junit.framework.Assert;

public class StepDefOfSum {
	
	int actualResult = 0;

	 @Given("^Two integer number \"([^\"]*)\" and \"([^\"]*)\"$")
	 public void two_integer_number_and(String a, String b) throws Throwable {
	  System.out.println("Two number are " + a + " and " + b);

	 }

	 @When("^We perform addition of \"([^\"]*)\" and \"([^\"]*)\"$")
	 public void we_perform_addition_of_and(String arg1, String arg2) throws Throwable {
	  actualResult = Integer.parseInt(arg1) + Integer.parseInt(arg2);

	 }

	 @Then("^We should get sum of two number \"([^\"]*)\"$")
	 public void we_should_get_sum_of_two_number(String expectedResult) throws Throwable {
	  int inExpectedResult = Integer.parseInt(expectedResult);
	  Assert.assertEquals(inExpectedResult, actualResult);
	 }
}
