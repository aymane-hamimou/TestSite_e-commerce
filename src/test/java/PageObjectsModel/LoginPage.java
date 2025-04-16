package PageObjectsModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    //                                                   page Factory
    //username
    @FindBy(id="user-name")
    private WebElement userNameInput;

    //password
    @FindBy(id="password")
    private WebElement passwordInput;

    //button login
    @FindBy(id="login-button")
    private WebElement loginButton;

    WebDriver driver;

    //Constructeur
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //                                                 page Object

    public void loginAsUser(){
        userNameInput.click();
        userNameInput.sendKeys("standard_user");
        passwordInput.click();
        passwordInput.sendKeys("secret_sauce");
        loginButton.click();

    }


}
