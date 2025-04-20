package PageObjectsModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class panierpage  {

    @FindBy(className = "shopping_cart_link")
    private WebElement shoppinCart ;

    WebDriver driver;

    public panierpage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public Boolean isArticleAddedToCart(){
        if(shoppinCart.getText().equals("1")){ return true; }
        else return false;
    }
    public void clickOnCart(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(shoppinCart));
        wait.until(ExpectedConditions.elementToBeClickable(shoppinCart));

        Actions actions = new Actions(driver);
        actions.moveToElement(shoppinCart).click().perform();


    }
}
