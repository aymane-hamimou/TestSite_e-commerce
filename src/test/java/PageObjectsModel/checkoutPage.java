package PageObjectsModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class checkoutPage {
    @FindBy(css = "#first-name")
    private WebElement firstName;
    @FindBy(css = "#last-name")
    private WebElement lastName;
    @FindBy(css = "#postal-code")
    private WebElement postalCode;
    @FindBy(css = "#continue")
    private WebElement continueBtn;

    WebDriver driver;

    public checkoutPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    public String getUrlWebPage(){
    return driver.getCurrentUrl();
    }
    public void fillInformation(){
        firstName.click();
        firstName.sendKeys("Test");
        lastName.click();
        lastName.sendKeys("Test");
        postalCode.click();
        postalCode.sendKeys("12345");
    }
    public void clickContinueBtn(){
        continueBtn.click();
    }
}
