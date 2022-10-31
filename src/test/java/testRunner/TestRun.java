package testRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions
        (
                features = ".//Features/Customers.feature",
                glue = "stepDefinitions",
                dryRun = false,
                plugin = {"pretty", "html:test-output"}
        )
public class TestRun {
}
