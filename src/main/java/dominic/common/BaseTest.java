package dominic.common;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import java.io.File;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.time.Duration;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import dominic.Android.PageObjects.LoginPage;

public class BaseTest {
    protected AndroidDriver driver;
    public AppiumDriverLocalService service;

    @BeforeClass
    public void ConfigureAppium() throws MalformedURLException, URISyntaxException {

        service = new AppiumServiceBuilder()
                .withAppiumJS(new File(
                        "//Users//dominicmalile//.nvm//versions//node//v22.9.0//lib//node_modules//appium//build//lib//main.js"))
                .withIPAddress("127.0.0.1")
                .usingPort(4723)
                .build();
        service.start(); // Start the Appium server

        UiAutomator2Options options = new UiAutomator2Options();
        options.setDeviceName("MyPhone");
        options.setApp(System.getProperty("user.dir") + "/resources/apk/modulr.apk");

        driver = new AndroidDriver(new URI("http://127.0.0.1:4723").toURL(), options);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    // Reusable login method for all test classes
    protected void loginToApp(String username, String password, String pin) throws InterruptedException {
        // Initialize the LoginPage object
        LoginPage loginPage = new LoginPage(driver);

        // Step 1: Log in
        loginPage.enterUsername(username);
        loginPage.enterPassword(password);
        loginPage.clickRememberMe();
        loginPage.clickLogin();

        // Permission pop-up handling (if necessary)
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        WebElement permissionAllowButton = wait.until(ExpectedConditions.elementToBeClickable(
                AppiumBy.xpath(
                        "//android.widget.Button[@resource-id=\"com.android.permissioncontroller:id/permission_allow_button\"]")));
        permissionAllowButton.click();

        // Step 2: Enter PIN
        loginPage.enterPin(pin);
    }

    @AfterClass
    public void tearDown() {
        if (driver != null) {
            System.out.println("Closing the driver...");
            driver.quit();
        }
        if (service != null) {
            System.out.println("Stopping the Appium server...");
            service.stop();
        }
    }
}
