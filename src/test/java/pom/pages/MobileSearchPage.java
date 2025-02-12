package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.utils.WebActions;

public class MobileSearchPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='gh-ac']")
    private WebElement searchBox;

    @FindBy(xpath = "//select[@id='gh-cat']")
    private WebElement categoryDropDown;

    @FindBy(xpath = "//button[@id='gh-search-btn']")
    private WebElement searchButton;

    public MobileSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchMobile(String mobileName){
        WebActions.type(searchBox, mobileName);
        WebActions.selectDropdownByText(categoryDropDown,"Cell Phones & Accessories");
        WebActions.click(searchButton);
    }

}
