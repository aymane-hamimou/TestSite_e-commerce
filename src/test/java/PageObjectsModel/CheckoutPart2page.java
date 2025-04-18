package PageObjectsModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

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

    public String getUrlWebPage(){
        return driver.getCurrentUrl();
    }
    public String getTitleArticleText(){
        return TitleArticle.getText();
    }
    public String getPriceArticleText(){
        return PriceArticle.getText();
    }
    public String getTotalPriceArticleText(){
        return TotalPriceArticle.getText();
    }
    public void clickFinishBtn(){
        FinishButton.click();
    }
}
