package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.utils.WebActions;

public class ClothSearchPage {
    private WebDriver driver;

    @FindBy(xpath = "//input[@id='gh-ac']")
    private WebElement searchBox;

    @FindBy(xpath = "//select[@id='gh-cat']")
    private WebElement categoryDropDown;

    @FindBy(xpath = "//button[@id='gh-search-btn']")
    private WebElement searchButton;

    public ClothSearchPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchClothing(String clothingItem){
        WebActions.type(searchBox, clothingItem);
        WebActions.selectDropdownByText(categoryDropDown,"Clothing, Shoes & Accessories");
        WebActions.click(searchButton);
    }
}
