package exerciceSauceDemo;

import PageObjectsModel.LoginPage;
import PageObjectsModel.ProductPage;
import PageObjectsModel.*;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

@TestMethodOrder(MethodOrderer.MethodName.class)
public class ExSauceDemo {
    static ChromeDriver driver;

    @BeforeAll
    public static void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.saucedemo.com");
    }

    @Test
    public void t001_logInUser(){
        LoginPage objloginPage = new LoginPage(driver);
        ProductPage objproductPage = new ProductPage(driver);
        objloginPage.loginAsUser();
        Assertions.assertTrue(objproductPage.getProductPageUrl().contains("inventory.html"),"Error:Wrong URL");

    }

    @Test
    public void t002_filterByPrice(){
        ProductPage objproductPage = new ProductPage(driver);
        objproductPage.setFilterLoHi();
        Assertions.assertTrue(objproductPage.isListInOrder(),"Error:List not ordred correctly");
    }

    @Test
    public void t003_AddArticleToCart() throws InterruptedException {
        ProductPage objproductPage = new ProductPage(driver);
        panierpage objpanierpage = new panierpage(driver);
        Thread.sleep(6000);
        objproductPage.clickAddToCartBikeLight();
        Thread.sleep(1000);
        // Assertions.assertTrue(objpanierpage.isArticleAddedToCart());
    }
    @Test
    public void t004_ClickOnCartAndCheckArticle() throws InterruptedException {
        panierpage objpanierpage = new panierpage(driver);
        CartPage objcartPage = new CartPage(driver);
        Thread.sleep(2000);
        objpanierpage.clickOnCart();
        Thread.sleep(1000);
        Assertions.assertTrue(objcartPage.getUrlWebPage().contains("cart.html"));
        Assertions.assertEquals(objcartPage.getArticleInCart(),"Sauce Labs Bike Light");
        objcartPage.CheckoutBtnClick();
    }

    @Test
    public void t005_checkout(){
    checkoutPage objcheckoutPage = new checkoutPage(driver);
    Assertions.assertTrue(objcheckoutPage.getUrlWebPage().contains("checkout-step-one.html"),"Error:Wrong URL");
    objcheckoutPage.fillInformation();
    objcheckoutPage.clickContinueBtn();
    }

    @Test
    public void t006_confirmationInformation(){
    CheckoutPart2page objcheckoutPart2page = new CheckoutPart2page(driver);
    Assertions.assertTrue(objcheckoutPart2page.getUrlWebPage().contains("checkout-step-two.html"),"Error:Wrong URL");
    Assertions.assertTrue(objcheckoutPart2page.getTitleArticleText().contains(" Bike Light") && objcheckoutPart2page.getPriceArticleText().contains("9.99") && objcheckoutPart2page.getTotalPriceArticleText().contains("10.79"));
    objcheckoutPart2page.clickFinishBtn();
    }
    @Test
    public void t007_ConfirmationPayment(){
        ConfirmationPage objconfirmationPage = new ConfirmationPage(driver);
        Assertions.assertTrue(objconfirmationPage.getCurrentUrl().contains("checkout-complete.html"));


    }
    @BeforeAll
    public static void tearDown(){
        driver.quit();
    }
}
