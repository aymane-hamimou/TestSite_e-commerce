package PageObjectsModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class panierpage  {

    @FindBy(xpath ="//*[@id=\"shopping_cart_container\"]/a")
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
    public void clickOnCart(){
        shoppinCart.click();
    }
}
