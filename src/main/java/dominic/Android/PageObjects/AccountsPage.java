package dominic.Android.PageObjects;

import org.openqa.selenium.WebElement;
import dominic.common.WaitUtil;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class AccountsPage {

    private AndroidDriver driver;

    // Constructor
    public AccountsPage(AndroidDriver driver) {
        this.driver = driver;
        new WaitUtil(driver);
    }

    // Locators
    private WebElement accentButton() {
        return driver.findElement(AppiumBy.xpath("//android.widget.TextView[@content-desc=\"New account\"]"));
    }

    // Action: Click on the accent button
    public void clickAccentButton() {
        accentButton().click();
    }

    // Locator for the element with accessibility ID "toqio-basic-text"
    private WebElement basicTextElement() {
        return driver.findElement(AppiumBy.accessibilityId("primary-button"));
    }

    // Action: Click on the element with accessibility ID "toqio-basic-text"
    public void clickBasicTextElement() {
        basicTextElement().click();
    }

    // Locator for the dropdown (Currency)
    private WebElement currencyDropdown() {
        return driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='toqio-select-content-box']"));
    }

    // Locator for the Euro option
    private WebElement euroOption() {
        return driver.findElement(AppiumBy.xpath("//android.view.ViewGroup[@content-desc='Euro']"));
    }

    // Locator for the Alias input
    private WebElement aliasInput() {
        return driver.findElement(AppiumBy.xpath("//android.widget.EditText[@content-desc='Alias']"));
    }

    // Locator for the Continue button
    private WebElement continueButton() {
        return driver.findElement(AppiumBy.xpath("//android.widget.Button[@content-desc='primary-button']"));
    }

    // Action: Select Currency as Euro
    public void selectCurrency() {
        currencyDropdown().click(); // Open the dropdown
        euroOption().click(); // Select the Euro option
    }

    // Action: Enter Alias
    public void enterAlias(String alias) {
        aliasInput().sendKeys(alias);
    }

    // Action: Click Continue
    public void clickContinue() {
        continueButton().click();
    }

    public void scrollDemo() {
        driver.findElement(
                AppiumBy.androidUIAutomator(
                        "new UiScrollable(new UiSelector()).scrollIntoView(text(\"Create account\"));"));
    }

    public WebElement createAccountButton() {
        return driver.findElement(AppiumBy
                .xpath("//android.widget.TextView[@content-desc=\"toqio-basic-text\" and @text=\"Create account\"]"));
    }

    // Action: Click Continue
    public void clickcreateAccountButton() {
        createAccountButton().click();
    }

}
