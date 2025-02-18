package pom.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pom.utils.ExtentReportManager;
import pom.utils.WebActions;

public class SearchItemPage {

    private WebDriver driver;

    @FindBy(xpath = "//input[@id='gh-ac']")
    private WebElement searchBox;

    @FindBy(xpath = "//select[@id='gh-cat']")
    private WebElement categoryDropDown;

    @FindBy(xpath = "//button[@id='gh-search-btn']")
    private WebElement searchButton;

    public SearchItemPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void searchItem(String itemName,String categoryName) throws InterruptedException {
        ExtentReportManager.writeToReport("Start of Search Item");
        WebActions.type(searchBox, itemName);
        Thread.sleep(1000);
        WebActions.selectDropdownByText(categoryDropDown,categoryName);
        Thread.sleep(1000);
        WebActions.click(searchButton);
        ExtentReportManager.writeToReport("End of Search Item");
    }
}
