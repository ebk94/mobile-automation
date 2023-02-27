package mobile;

import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import pages.SwipePage;
import utils.AppiumDriverUtil;

public class SwipeTest {
    private static AppiumDriver driver;
    private SwipePage swipePage;

    @BeforeAll
    public static void setup() {
        driver = AppiumDriverUtil.getDriver();
    }

    @AfterAll
    public static void teardown() {
        AppiumDriverUtil.quitDriver();
    }

    @Test
    public void userCanScrollVertically()
    {
        swipePage = new SwipePage(driver);
        swipePage.navigateToSwipePage();
        swipePage.swipeScreen();
    }
}
