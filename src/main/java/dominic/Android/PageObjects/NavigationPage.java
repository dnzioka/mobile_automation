package dominic.Android.PageObjects;

import java.time.Duration;
import java.util.Collections;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;

public class NavigationPage {

    private AndroidDriver driver;

    // Constructor
    public NavigationPage(AndroidDriver driver) {
        this.driver = driver;
    }

    // tap the hamburger button
    public void tapHamburgerButton() {
        PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
        Sequence tap = new Sequence(finger, 1);
        tap.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 88, 148));
        tap.addAction(finger.createPointerDown(PointerInput.MouseButton.LEFT.asArg()));
        tap.addAction(finger.createPointerUp(PointerInput.MouseButton.LEFT.asArg()));
        driver.perform(Collections.singletonList(tap));
    }

    // Method to click the Home module
    public void clickHomeMenuItem() {
        driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"toqio-sidebar-item-content\"])[1]"))
                .click();
    }

    // Method to click the Accounts menu item
    private WebElement accountsMenuItem() {
        return driver.findElement(
                AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"toqio-sidebar-item-content\"])[2]"));
    }

    // Click Accounts and wait for page to load
    public void clickAccountsMenuItem() {
        accountsMenuItem().click();
    }

    // Method to click the Payments module
    public void clickPaymentsMenuItem() {
        driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"toqio-sidebar-item-content\"])[4]"))
                .click();
    }

    // Method to click the Cards module
    public void clickCardsMenuItem() {
        driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"toqio-sidebar-item-content\"])[5]"))
                .click();
    }

    // Method to click the My Expenses module
    public void clickMyExpensesMenuItem() {
        driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"toqio-sidebar-item-content\"])[6]"))
                .click();
    }

    // Method to click the Company Expenses module
    public void clickCompanyExpensesMenuItem() {
        driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"toqio-sidebar-item-content\"])[7]"))
                .click();
    }

    // Method to click the Team module
    public void clickTeamMenuItem() {
        driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"toqio-sidebar-item-content\"])[8]"))
                .click();
    }

    // Method to click the Exporting module
    public void clickExportingMenuItem() {
        driver.findElement(AppiumBy.xpath("(//android.view.ViewGroup[@resource-id=\"toqio-sidebar-item-content\"])[9]"))
                .click();
    }
}
