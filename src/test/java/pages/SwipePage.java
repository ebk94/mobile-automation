package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwipePage {
    private final AppiumDriver driver;

    private final By swipePageLocator = AppiumBy.accessibilityId("Swipe");
    private final By swipeScreenContent = AppiumBy.accessibilityId("Swipe-screen");

    public SwipePage(AppiumDriver driver) { this.driver = driver; }

    public void navigateToSwipePage()
    {
        WebElement swipePageLink = driver.findElement(swipePageLocator);
        swipePageLink.click();

        WebElement contentView = driver.findElement(swipeScreenContent);
        assertTrue(contentView.isDisplayed(), "Content view is not visible");
    }

    public void swipeScreen()
    {
        try {
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 100, 100));
            swipe.addAction(finger.createPointerDown(0));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), 100, -2000));
            swipe.addAction(finger.createPointerUp(0));
            driver.perform(Arrays.asList(swipe));

        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
        }

    }

}
