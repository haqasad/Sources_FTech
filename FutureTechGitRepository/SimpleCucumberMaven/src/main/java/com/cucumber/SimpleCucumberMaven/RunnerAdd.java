package com.cucumber.SimpleCucumberMaven;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
   features={"C:\\Users\\Mushfiq\\workspace\\SimpleCucumberMaven\\src\\main\\java\\com\\cucumber\\SimpleCucumberMaven\\AddNumber.feature"}
   ,glue={"C:\\Users\\Mushfiq\\workspace\\SimpleCucumberMaven\\src\\main\\java\\com\\cucumber\\SimpleCucumberMaven\\StepDefOfSum"}
  )
public class RunnerAdd {

}
