package pom.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebActions {

    private static final int TIMEOUT_SECONDS = 10;
    private static final int POLLING = 500;

    public static WebDriver getDriver() {
        return TreadLocalWebDriver.getWebDriver();
    }

    //explicit wait
    public static WebElement waitForElement(WebElement element) {
        WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(TIMEOUT_SECONDS));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    //fluent wait
    private static WebElement fluentWaitForElement(WebElement element) {
        FluentWait<WebDriver> wait = new FluentWait<>(getDriver())
                .withTimeout(Duration.ofSeconds(TIMEOUT_SECONDS))
                .ignoring(NoSuchElementException.class)
                .pollingEvery(Duration.ofMillis(POLLING));

        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public static void click(WebElement element) {
        try{
            WebElement el = waitForElement(element);
            el.click();
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }


    public static void type(WebElement element, String text) {
        try{
            WebElement el = fluentWaitForElement(element);
            el.click();
            el.clear();
            el.sendKeys(text);
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

    public static void selectDropdownByText(WebElement element, String text) {
        try{
            WebElement el = waitForElement(element);
            Select select = new Select(el);
            select.selectByVisibleText(text);
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }

}
