package PageObjectsModel;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ProductPage {
    //                                                    factory page
    @FindBy(xpath = "//select[@data-test='product-sort-container']")
    private WebElement filterButton;
    @FindBy(xpath = "//option[@value='lohi']")
    private WebElement filterLoHi ;
    @FindBy(xpath = "//div[@class='inventory_item_price']")
    private List<WebElement> listprice;
    WebDriver driver;
    @FindBy(xpath = "//*[@id=\"add-to-cart-sauce-labs-bike-light\"]")
    private WebElement addToCartBikeLight ;

    public ProductPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public String getProductPageUrl(){
        return driver.getCurrentUrl();
    }
    //                                                     Model Page
    public void setFilterLoHi (){
        filterButton.click();
        filterLoHi.click();
    }
    public boolean isListInOrder(){
        //list string vide ou on va récupérer tous les élement de Webelement
        List<String> listVide = new ArrayList<>();
        //crée une boucle FOR, permet de lire chque élement de listprice pour les ajouter dans list
        for (WebElement orderlist : listprice) {
            listVide.add(orderlist.getText().replaceAll("[^\\d]", "")); // récupérer just des chiffre
        }
        // iterator = taille de list
        Iterator<String> iterator = listVide.iterator();
        //convertir le ptemier element d'iterator en un int
        int current , previous = Integer.parseInt(iterator.next());
        while (iterator.hasNext()){
            current = Integer.parseInt(iterator.next());
            if(previous > current){
                return false;
            }
            previous = current;
        }
        return true;
    }
    public void clickAddToCartBikeLight (){
        addToCartBikeLight.click();
    }

}
