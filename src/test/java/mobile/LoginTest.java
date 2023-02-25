package mobile;

import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import pages.LoginPage;
import utils.AppiumDriverUtil;
import utils.Constants;

import java.util.stream.Stream;

public class LoginTest {
    private static AppiumDriver driver;
    private LoginPage loginPage;

    public static Stream<String[]> validLoginData() {
        return Stream.of(
                new String[]{Constants.USERNAME, Constants.PASSWORD},
                new String[]{"anotheruser@example.com", "Password1234"}
        );
    }


    @BeforeAll
    public static void setup() {
        driver = AppiumDriverUtil.getDriver();
    }

    @AfterAll
    public static void teardown() {
        AppiumDriverUtil.quitDriver();
    }

    @Order(1)
    @DisplayName("Valid user data")
    @ParameterizedTest(name = "{index}: username={0}, password={1}")
    @MethodSource("validLoginData")
    public void userCanLoginWithValidData(String username, String password) {
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        loginPage.login(username, password);
        loginPage.checkLoginSuccess();
        loginPage.closeAlert();
    }

    @Test
    @Order(2)
    @DisplayName("Invalid user data")
    public void userCanNotLoginWithInvalidData()
    {
        loginPage = new LoginPage(driver);
        loginPage.navigateToLoginPage();
        loginPage.login("admin.ad", "123aa");
        loginPage.emailHintTextIsDisplayed();
        loginPage.passwordHintIsDiplayed();

        loginPage.login("admin@admin.ad", " ");
        loginPage.passwordHintIsDiplayed();

        loginPage.login("admin.ad", "123aa@78");
        loginPage.emailHintTextIsDisplayed();
    }
}



