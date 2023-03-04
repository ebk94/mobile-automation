package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.PointerInput;
import org.openqa.selenium.interactions.Sequence;

import java.time.Duration;
import java.util.Arrays;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static java.lang.Thread.sleep;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class SwipePage {
    private final AppiumDriver driver;

    private final By swipePageLocator = AppiumBy.accessibilityId("Swipe");
    private final By swipeScreenContent = AppiumBy.accessibilityId("Swipe-screen");

    public SwipePage(AppiumDriver driver) { this.driver = driver; }

    int startX = 500;
    int startY = 1000;
    int endX = -500;
    int endY = 1000;

    public void navigateToSwipePage()
    {
        WebElement swipePageLink = driver.findElement(swipePageLocator);
        swipePageLink.click();

        WebElement contentView = driver.findElement(swipeScreenContent);
        assertTrue(contentView.isDisplayed(), "Content view is not visible");
    }

    public void scrollDown()
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

    public void scrollUp() {
        try {
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 1);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(0), PointerInput.Origin.viewport(), 100, 100));
            swipe.addAction(finger.createPointerDown(0));
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), 100, 2000));
            swipe.addAction(finger.createPointerUp(0));
            driver.perform(Arrays.asList(swipe));

        } catch (Exception e) {
            System.err.println("swipeScreen(): TouchAction FAILED\n" + e.getMessage());
        }
    }

    public void performSwipe(int startX, int startY, int endX, int endY) {
        try {
            Dimension windowSize = driver.manage().window().getSize();
            System.out.println(windowSize);
            PointerInput finger = new PointerInput(PointerInput.Kind.TOUCH, "finger");
            Sequence swipe = new Sequence(finger, 0);
            swipe.addAction(finger.createPointerMove(Duration.ZERO, PointerInput.Origin.viewport(), startX, startY));
            swipe.addAction(finger.createPointerDown(PointerInput.MouseButton.RIGHT.asArg()));
            sleep(500);
            swipe.addAction(finger.createPointerMove(Duration.ofMillis(1000), PointerInput.Origin.viewport(), endX, endY));
            swipe.addAction(finger.createPointerUp(PointerInput.MouseButton.RIGHT.asArg()));
            driver.perform(Arrays.asList(swipe));
        } catch (Exception e) {
            System.err.println("performSwipe(): TouchAction FAILED\n" + e.getMessage());
        }
    }

    public void swipeRight() {
        int startX = 500;
        int startY = 1000;
        int endX = -500;
        int endY = 1000;

        performSwipe(startX, startY, endX, endY);
        performSwipe(startX, startY, endX, endY);
    }

}
