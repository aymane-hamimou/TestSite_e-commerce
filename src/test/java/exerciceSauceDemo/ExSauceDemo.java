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
        Assertions.assertTrue(objproductPage.getProductPageUrl().contains("inventory.html"),"Error:The product page is not available");

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
        Thread.sleep(2000);
        objproductPage.clickAddToCartBikeLight();

        Assertions.assertTrue(objpanierpage.isArticleAddedToCart());
    }
    @Test
    public void t004_ClickOnCartAndCheckArticle(){
        panierpage objpanierpage = new panierpage(driver);
        CartPage objcartPage = new CartPage(driver);
        objpanierpage.clickOnCart();
        Assertions.assertTrue(objcartPage.getUrlWebPage().contains("cart.html"));
        Assertions.assertEquals(objcartPage.getArticleInCart(),"Sauce Labs Bike Light");
        objcartPage.CheckoutBtnClick();
    }

    @Test
    public void t005_checkout(){
    checkoutPage objcheckoutPage = new checkoutPage(driver);
    Assertions.assertTrue(objcheckoutPage.getUrlWebPage().contains("checkout-step-one.html"));
    objcheckoutPage.fillInformation();
    objcheckoutPage.clickContinueBtn();
    }

}
