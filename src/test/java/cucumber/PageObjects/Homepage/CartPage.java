package cucumber.PageObjects.Homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import cucumber.Cucumber.Base;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage extends Base{

    public WebDriver driver;
    By delete = By.xpath("//a[@class='emg-right remove-product btn-remove-product gtm_rp080219']");
    By cartTitle = By.xpath("//h1[@class='cart']");
    By pageTitle = By.xpath("//div[@class='title']");
    By backToHomeBtn = By.xpath(("//a[contains(@class,'empty-cart-primary-btn')]"));

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getProductName(String product) {
        return Base.driver.findElement(By.xpath("//a[contains(@title,'" + product + "')]"));
    }

    public boolean isProductVisible(String product) {
        try {
            return Base.driver.findElement(By.xpath("//a[contains(@title,'" + product + "')]")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement cartDeleteBtn() {
        return Base.driver.findElement(delete);
    }

    public WebElement basketTitle() {
        return Base.driver.findElement(cartTitle);
    }

    public WebElement backToHomeBtn() {
        return Base.driver.findElement(backToHomeBtn);
    }

    public WebElement pageTitle() {
        return Base.driver.findElement(pageTitle);
    }

    public boolean isBasketTitleDisplayed() {
        return basketTitle().isDisplayed();
    }

    public void deleteFromCart() throws Throwable{
        cartDeleteBtn().click();
        Thread.sleep(3000);
    }

    public boolean isDeletePresent() {
        try {
                cartDeleteBtn();
                return true;
            }
        catch(NoSuchElementException e) {
            return false;
        }
    }

    public boolean isBackToHomeButtonDisplayed() {
        return backToHomeBtn().isDisplayed();
    }
}
