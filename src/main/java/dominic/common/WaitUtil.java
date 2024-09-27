package dominic.common;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import io.appium.java_client.AppiumBy;

public class WaitUtil {

    private WebDriver driver;

    // Constructor
    public WaitUtil(WebDriver driver) {
        this.driver = driver;
    }

    // Dynamic wait method for locating elements by any locator type (XPath, ID,
    // etc.)
    public WebElement waitForElementToBeClickable(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    // Specific wait method for locating elements by Android UI Automator with a
    // custom duration
    public WebElement waitForElementToBeClickableByUIAutomator(String uiAutomator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.androidUIAutomator(uiAutomator)));
    }

    // New method: Dynamic wait for visibility of elements
    // /Users/dominicmalile/QAMobile/appiumframework/src/test/java/dominic/tests/AppiumTest.java
    public WebElement waitForElementToBeVisible(By locator, int seconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(seconds));
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
