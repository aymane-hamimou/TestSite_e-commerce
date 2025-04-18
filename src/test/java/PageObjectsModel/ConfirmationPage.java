package PageObjectsModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
    @FindBy(css = "#back-to-products")
    public WebElement backToProducts;

    WebDriver driver;
    public ConfirmationPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getCurrentUrl() {
       return driver.getCurrentUrl();
    }
}
