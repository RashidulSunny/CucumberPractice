package runner;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/Features",
        glue = {"step_definitions"},
        plugin = {"pretty", "summary", "json:target/cucumber.json"},
//        publish = true
        tags = "@dataDriven_test or @negative_test or @positive_test"
)
public class TestRunner {
}