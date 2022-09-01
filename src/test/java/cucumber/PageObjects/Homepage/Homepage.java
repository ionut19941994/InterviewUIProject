package cucumber.PageObjects.Homepage;

import cucumber.Cucumber.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Homepage extends Base{

    public static WebDriver driver;
    By search=By.xpath("//input[@type='search']");
    By homeLink=By.className("navbar-brand");
    By button=By.xpath("//button[@class='btn btn-default searchbox-submit-button']");
    By addToCartButton=By.xpath("//button[@class='btn btn-sm btn-primary btn-emag btn-block yeahIWantThisProduct']");
    By closeProductSummary=By.xpath("//i[@class='em em-close gtm_6046yfqs']");
    By myCart=By.xpath("//a[@id='my_cart']");

    public Homepage(WebDriver driver){
        Homepage.driver =driver;
    }

    public WebElement searchBox(){
        return Base.driver.findElement(search);
        }

    public WebElement homepageLink(){
        return Base.driver.findElement(homeLink);
    }

    public WebElement searchBtn(){
        return Base.driver.findElement(button);
        }

    public WebElement addToCartBtn(){
        return Base.driver.findElement(addToCartButton);
    }

    public WebElement closeProdBrn(){
        return Base.driver.findElement(closeProductSummary);
    }

    public WebElement myCartBtn(){
        return Base.driver.findElement(myCart);
    }

    public void searchForAProduct(String product) {
        homepageLink().click();
        searchBox().sendKeys(product);
        searchBtn().click();
    }

    public void addToCart() throws Throwable{
        addToCartBtn().click();
        Thread.sleep(3000);
        closeProdBrn().click();
    }

    public void navigateToMyCart() {
        myCartBtn().click();
    }


}
