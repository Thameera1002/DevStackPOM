package pom.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pom.pages.ClothSearchPage;
import pom.pages.MobileSearchPage;
import pom.pages.SearchItemPage;
import pom.utils.TreadLocalWebDriver;

public class SearchTest {
//    private MobileSearchPage mobileSearchPage;
//    private ClothSearchPage clothSearchPage;
    private SearchItemPage searchItemPage;

    @BeforeMethod
    public void setup(){
        WebDriver driver = TreadLocalWebDriver.createWebDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
//        mobileSearchPage = new MobileSearchPage(driver);
//        clothSearchPage = new ClothSearchPage(driver);
        searchItemPage = new SearchItemPage(driver);
    }

//    @Test
//    public void searchForIphone() throws InterruptedException {
//        mobileSearchPage.searchMobile("iPhone");
//    }
//
//    @Test
//    public void searchForMensTShirts() throws InterruptedException {
//        clothSearchPage.searchClothing("Men's T-shirt");
//    }
    @Test
    public void searchItemIphone() throws InterruptedException {
        searchItemPage.searchItem("iphone","Cell Phones & Accessories");
    }

    @Test
    public void searchItemClothing() throws InterruptedException {
        searchItemPage.searchItem("Men's t-shirt","Clothing, Shoes & Accessories");
    }

    @AfterMethod
    public void tearDown(){
        WebDriver webDriver = TreadLocalWebDriver.getWebDriver();
        if(webDriver !=null){
            webDriver.quit();
            TreadLocalWebDriver.removeWebDriver();
        }
    }

}
