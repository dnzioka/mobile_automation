package dominic.tests;

import org.json.simple.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import dominic.Android.PageObjects.AccountsPage;
import dominic.Android.PageObjects.NavigationPage;
import dominic.common.BaseTest;
import dominic.common.WaitUtil;
import io.appium.java_client.AppiumBy;
import dominic.common.JsonReader;

public class AccountsModule extends BaseTest {

        @Test
        public void VerifyEuroAccountCreation() throws InterruptedException {
                // instance of the JsonReader
                JsonReader jsonReader = new JsonReader();
                // Read data
                String filePath = System.getProperty("user.dir") + "/resources/testdata/testdata.json";

                JSONObject jsonData = jsonReader.readData(filePath);

                // Fetch
                JSONObject user = (JSONObject) jsonData.get("user");
                JSONObject otp = (JSONObject) jsonData.get("OTP");
                JSONObject accountDetails = (JSONObject) jsonData.get("accountDetails");

                String username = (String) user.get("username");
                String password = (String) user.get("password");
                String pin = (String) otp.get("pin");
                String accountAlias = (String) accountDetails.get("accountAlias");

                // Initialize the page objects
                NavigationPage navigationPage = new NavigationPage(driver);
                AccountsPage accounts = new AccountsPage(driver);
                WaitUtil waitUtil = new WaitUtil(driver);

                // Login to the App
                loginToApp(username, password, pin);

                // Assertions
                String title = driver.findElement(AppiumBy.accessibilityId("Total balance")).getText();
                Assert.assertEquals(title, "Total balance");

                // Tap the hamburger button
                navigationPage.tapHamburgerButton();
                // go to Accounts module
                navigationPage.clickAccountsMenuItem();

                // loading... -> Thread.sleep(5000);
                waitUtil.waitForElementToBeClickable(
                                AppiumBy.xpath("//android.widget.TextView[@content-desc=\"New account\"]"),
                                10);
                // Assert the "Accounts" label
                String accountsLabel = driver.findElement(
                                AppiumBy.androidUIAutomator("new UiSelector().text(\"Accounts\").instance(0)"))
                                .getText();
                Assert.assertEquals(accountsLabel, "Accounts");
                // Assert the "+ New account" button
                String newAccountButton = driver.findElement(
                                AppiumBy.xpath("//android.widget.TextView[@content-desc=\"New account\"]")).getText();
                Assert.assertEquals(newAccountButton, "New account");
                // Assert the "Accounts" tab
                String accountsTab = driver.findElement(
                                AppiumBy.androidUIAutomator("new UiSelector().text(\"Accounts\").instance(1)"))
                                .getText();
                Assert.assertEquals(accountsTab, "Accounts");
                // Assert the "Transactions" tab
                String transactionsTab = driver.findElement(
                                AppiumBy.xpath("//android.widget.TextView[@content-desc=\"Transactions\"]")).getText();
                Assert.assertEquals(transactionsTab, "Transactions");

                // Create a new account flow
                accounts.clickAccentButton();
                accounts.clickBasicTextElement();
                // Select Currency as Euro
                accounts.selectCurrency();
                // Enter Alias
                accounts.enterAlias(accountAlias);
                // Click Continue to create the account
                accounts.clickContinue();
                // scrolltoBottom
                accounts.scrollDemo();
                // Tap the Create Account button
                accounts.clickcreateAccountButton();

        }

}
