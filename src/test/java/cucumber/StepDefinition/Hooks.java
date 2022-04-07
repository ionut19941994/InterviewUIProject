package cucumber.StepDefinition;


import cucumber.Cucumber.Base;
import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks extends Base {



    @Before("@Test")
    public void beforeValidation() {
    }

    @After("@Test")
    public void afterSeleniumTest() {
        driver.close();
    }
}
