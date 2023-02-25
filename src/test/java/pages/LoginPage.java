package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginPage {
    private final AppiumDriver driver;

    private final By usernameFieldLocator = AppiumBy.accessibilityId("input-email");
    private final By passwordFieldLocator = AppiumBy.accessibilityId("input-password");
    private final By loginButtonLocator = AppiumBy.accessibilityId("button-LOGIN");
    private final By navigateLoginPageLocator = AppiumBy.accessibilityId("Login");
    private final By alertTitleLocator = AppiumBy.id("android:id/alertTitle");
    private final By alertMessageLocator = AppiumBy.id("android:id/message");
    private final By alerContentViewLocator = AppiumBy.id("android:id/content");
    private final By alertOKButtonLocator = AppiumBy.id("android:id/button1");
    private final By emailHintTextLocator = AppiumBy.xpath("//android.widget.TextView[@text='Please enter a valid email address']");
    private final By passwordHintTextLocator = AppiumBy.xpath("//android.widget.TextView[@text='Please enter at least 8 characters']");


    public LoginPage(AppiumDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String username)
    {
        WebElement usernameField = driver.findElement(usernameFieldLocator);
        usernameField.clear();
        usernameField.sendKeys(username);
    }

    public void enterPassword(String password)
    {
        WebElement passwordField = driver.findElement(passwordFieldLocator);
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public void clickLoginButton()
    {
        WebElement loginButton = driver.findElement(loginButtonLocator);
        loginButton.click();
    }

    public void navigateToLoginPage()
    {
        WebElement navigateLoginPage = driver.findElement(navigateLoginPageLocator);
        navigateLoginPage.click();
    }

    public void checkLoginSuccess()
    {
        WebElement contentView = driver.findElement(alerContentViewLocator);
        assertTrue(contentView.isDisplayed(), "Content view is not visible");

        WebElement alertTitle = driver.findElement(alertTitleLocator);
        assertEquals("Success", alertTitle.getText(), "Alert title is not 'Success'");

        WebElement message = driver.findElement(alertMessageLocator);
        assertEquals("You are logged in!", message.getText(), "Message text is not 'You are logged in!'");
    }

    public void closeAlert()
    {
        WebElement alertOKButton = driver.findElement(alertOKButtonLocator);
        alertOKButton.click();
    }

    public void emailHintTextIsDisplayed()
    {
        WebElement emailHint = driver.findElement(emailHintTextLocator);
        assertTrue(emailHint.isDisplayed());
    }

    public void passwordHintIsDiplayed()
    {
        WebElement passwordHint = driver.findElement(passwordHintTextLocator);
        assertTrue(passwordHint.isDisplayed());
    }
    public void login(String username, String password)
    {
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
    }

}

