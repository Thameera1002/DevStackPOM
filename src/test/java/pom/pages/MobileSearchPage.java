package pom.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MobileSearchPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='gh-ac']")
    private WebElement searchBox;

    @FindBy(xpath = "//select[@id='gh-cat']")
    private WebElement categoryDropDown;

    @FindBy(xpath = "//button[@id='gh-search-btn']")
    private WebElement searchButton;


}
