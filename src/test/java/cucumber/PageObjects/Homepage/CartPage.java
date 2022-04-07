package cucumber.PageObjects.Homepage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CartPage {

    public WebDriver driver;
    By delete = By.xpath("//a[@class='emg-right remove-product btn-remove-product gtm_rp080219']");
    By cartTitle = By.xpath("//h1[@class='cart']");
    By pageTitle = By.xpath("//div[@class='title']");

    public CartPage(WebDriver driver) {
        this.driver = driver;
    }

    public WebElement getProductName(String product) {
        return driver.findElement(By.xpath("//a[contains(@title,'" + product + "')]"));
    }

    public boolean isProductVisible(String product) {
        try {
            return driver.findElement(By.xpath("//a[contains(@title,'" + product + "')]")).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }

    public WebElement cartDeleteBtn() {
        return driver.findElement(delete);
    }

    public WebElement basketTitle() {
        return driver.findElement(cartTitle);
    }

    public WebElement pageTitle() {
        return driver.findElement(pageTitle);
    }

    public boolean isBasketTitleDisplayed() {
        return basketTitle().isDisplayed();
    }

    public void deleteFromCart() throws Throwable{
        cartDeleteBtn().click();
        Thread.sleep(3000);
    }
}
