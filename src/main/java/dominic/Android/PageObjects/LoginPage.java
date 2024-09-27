package dominic.Android.PageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dominic.common.BaseTest;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

import java.time.Duration;

public class LoginPage extends BaseTest {
    private WebDriverWait wait;

    // Constructor
    public LoginPage(AndroidDriver driver) {
        // Correct type parameterization for WebDriverWait
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(30));
    }

    // Locators
    private WebElement usernameField() {
        // Properly parameterize the WebDriverWait usage
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
            AppiumBy.xpath("//android.widget.EditText[@content-desc=\"User name\"]")));
    }

    private WebElement passwordField() {
        return wait.until(ExpectedConditions.visibilityOfElementLocated(
            AppiumBy.xpath("//android.widget.EditText[@content-desc=\"Password\"]")));
    }

    private WebElement rememberMeCheckbox() {
        return wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.xpath("//android.widget.CheckBox[@content-desc=\"Remember me\"]/android.view.ViewGroup")));
    }

    private WebElement loginButton() {
        return wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.xpath("//android.widget.Button[@content-desc=\"primary-button\"]")));
    }

    private WebElement oTPDigit(String digit) {
        return wait.until(ExpectedConditions.elementToBeClickable(
            AppiumBy.xpath("//android.widget.TextView[@content-desc='toqio-basic-text' and @text='" + digit + "']")));
    }



    // Actions
    public void enterUsername(String username) {
        usernameField().sendKeys(username);
    }

    public void enterPassword(String password) {
        passwordField().sendKeys(password);
    }

    public void clickRememberMe() {
        rememberMeCheckbox().click();
    }

    public void clickLogin() {
        loginButton().click();
    }
    public void enterPinDigit(String digit) {
        oTPDigit(digit).click();
    }
    // Optional: Method to enter a full PIN
    public void enterPin(String pin) {
        for (char digit : pin.toCharArray()) {
            enterPinDigit(String.valueOf(digit));
        }
    }
}
