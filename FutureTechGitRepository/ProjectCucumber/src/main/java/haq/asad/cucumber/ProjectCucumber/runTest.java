package haq.asad.cucumber.ProjectCucumber;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(
				features = "C:\\Users\\Mushfiq\\workspace\\ProjectCucumber\\src\\main\\java\\haq\\asad\\cucumber\\ProjectCucumber\\appTest.feature"
				,glue={"AppStepDefinition"}
				)

public class runTest {

}
