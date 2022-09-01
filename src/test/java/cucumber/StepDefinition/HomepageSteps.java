package cucumber.StepDefinition;

import cucumber.Cucumber.Base;
import cucumber.PageObjects.Homepage.CartPage;
import cucumber.PageObjects.Homepage.Homepage;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class HomepageSteps{
    public WebDriver driver;
    Homepage h = new Homepage(driver);
    CartPage c = new CartPage(driver);


    @Given("that the user is on the landing page")
    public void user_is_on_landing_page() throws Throwable{
        driver = Base.getDriver();
    }

    @And("he is able to search for {string}")
    public void user_searched_for_keyword(String product) {
        h.searchForAProduct(product);
    }

    @When("the user clicks on add to basket button")
    public void user_add_to_basket() throws Throwable{
        h.addToCart();
    }

    @Then("he is able to navigate to the basket page")
    public void user_verifies_the_basket_page() {
        h.navigateToMyCart();
        assertThat(c.isBasketTitleDisplayed(), is(true));
    }

    @Then("he is able to delete an item from the cart")
    public void user_deletes_an_item() throws Throwable{
        c.deleteFromCart();
    }

    @And("the user will see that the basket was updated with {string}")
    public void user_sees_the_updated_basket(String str){
        assertThat(c.getProductName(str).getText().toLowerCase().contains(str.toLowerCase()), is(true));
    }

    @And("he sees that the item {string} is not present anymore in the cart")
    public void user_asserts_the_item_is_no_longer_present(String str) {
        assertThat(c.isProductVisible(str), is(false));

    }

    @And("he sees that no items are present anymore")
    public void user_asserts_to_no_items_are_present_anymore() {
        assertThat(c.pageTitle().getText(),is("Cosul tau este gol"));
    }

    @And("he is not able to delete any more item from the cart")
    public void user_asserts_that_user_can_no_longer_delete_items() throws Throwable{
        assertThat(c.isDeletePresent(), is(false));
        assertThat(c.isBackToHomeButtonDisplayed(), is(true));
    }
}
