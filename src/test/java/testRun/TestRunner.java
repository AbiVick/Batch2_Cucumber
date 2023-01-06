package testRun;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;




@RunWith(Cucumber.class)
@CucumberOptions(
		
				//features = ".\\Features\\",
				features = ".\\Features\\login.feature",
				glue = "step",
				plugin = {"pretty" ,"html: test-output"},
				monochrome = true,
				dryRun = false,
				tags = "@ibm_sanity"
				//tags = "@ibm_regression"
				//tags = "@ibm_sanity"
				//tags = "@regression or @smoke"
				)



public class TestRunner {

	
	
	
}
