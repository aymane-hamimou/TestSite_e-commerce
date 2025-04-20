package PageObjectsModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CheckoutPart2page {

    @FindBy(xpath = "//*[@id=\"item_0_title_link\"]/div")
    private WebElement TitleArticle;
    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[1]/div[3]/div[2]/div[2]/div")
    private WebElement PriceArticle;
    @FindBy(xpath = "//*[@id=\"checkout_summary_container\"]/div/div[2]/div[8]")
    private WebElement TotalPriceArticle;
    @FindBy(css = "#finish")
    private WebElement FinishButton;

    WebDriver driver;

    public CheckoutPart2page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getUrlWebPage() {
        return driver.getCurrentUrl();
    }
    public String getTitleArticleText(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(TitleArticle));
        return TitleArticle.getText();
    }
    public String getPriceArticleText(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(PriceArticle));
        return PriceArticle.getText();
    }
    public String getTotalPriceArticleText(){
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.visibilityOf(TotalPriceArticle));
        return TotalPriceArticle.getText();
    }
    public void clickFinishBtn(WebDriver driver){
        this.driver = driver;
        new WebDriverWait(driver, Duration.ofSeconds(10)).until(ExpectedConditions.elementToBeClickable(FinishButton));
        FinishButton.click();
    }
}
