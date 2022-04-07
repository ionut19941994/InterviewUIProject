package cucumber.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "cucumber", tags = "@Test",
        plugin= {"pretty", "html:target/tests/TestReport.html", "junit:target/cucumber.xml"}
)

public class TestRunner extends AbstractTestNGCucumberTests {

}
