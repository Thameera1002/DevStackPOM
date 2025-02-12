package pom.utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;

public class TreadLocalWebDriver {
    private static ThreadLocal<WebDriver> threadLocalWebDriver = new ThreadLocal<>();

    public static synchronized WebDriver createWebDriver() {
        WebDriver driver = WebDriverManager.chromedriver().create();
        threadLocalWebDriver.set(driver);
        return driver;
    }

    public static synchronized WebDriver getWebDriver() {
        return threadLocalWebDriver.get();
    }

    public static synchronized void removeWebDriver() {
        threadLocalWebDriver.remove();
    }

}
