package cucumber.PageObjects.Homepage;

import cucumber.Cucumber.Base;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Template extends Base {

//  Template for locator definition
    @FindBy(/*locatorType ex:*/id = "locatorPath, locatorElement")
    protected /*locatorInterface ex:8*/ WebElement variable;

//  Actions
    public void actionMethod() {
//      Write code
    }
}
