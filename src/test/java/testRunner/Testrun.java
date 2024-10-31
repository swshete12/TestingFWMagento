/*
@Owner : Swapnil Shete
This is Login Page Object Page
*/
package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = ".//Features/Login.feature" ,
        glue = "stepDefinitions",
        monochrome = true,
        dryRun = false,
        plugin = {"pretty","html:test-output"}
)
public class Testrun {


}
