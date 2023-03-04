package mobile;

import io.appium.java_client.AppiumDriver;
import org.junit.jupiter.api.*;
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
    @Order(1)
    //@DisplayName("scroll down")
    public void userCanScrollDown()
    {
        swipePage = new SwipePage(driver);
        swipePage.navigateToSwipePage();
        swipePage.scrollDown();
    }

    @Test
    @Order(2)
    //@DisplayName("scroll up")
    public void userCanScrollUp()
    {
        swipePage = new SwipePage(driver);
        swipePage.navigateToSwipePage();
        swipePage.scrollUp();
    }

    @Test
    @Order(3)
    public void userCanSwipeRight()
    {
        swipePage = new SwipePage(driver);
        swipePage.navigateToSwipePage();
        swipePage.swipeRight();
    }
}
