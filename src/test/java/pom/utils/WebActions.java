package pom.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class WebActions {

    private static final int TIMEOUT_SECONDS = 10;

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

    }

    public static void click(WebElement element) {
        try{
            WebElement el = waitForElement(element);
            el.click();
        }catch (NoSuchElementException e){
            e.printStackTrace();
        }
    }


}
