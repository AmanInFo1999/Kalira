package property;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.offset.PointOption;

public class CommonUtils {
	public AppiumDriver driver;

	public static void implicitWait(AppiumDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}

	public static void explicitWait(AppiumDriver driver, String ele) {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ele)));
	}

	public static void scroll(AppiumDriver driver) {
		new TouchAction(driver).press(PointOption.point(790, 1050)).waitAction().moveTo(PointOption.point(860, 340))
				.release().perform();
	}

	public static void scrollDown(WebDriver driver) {
		int pressX = driver.manage().window().getSize().width / 2;
		int bottomY = driver.manage().window().getSize().height * 4 / 5;
		int topY = driver.manage().window().getSize().height / 8;
		scrollAndroid(pressX, bottomY, pressX, topY, driver);
	}

	public static void scrollAndroid(int fromX, int fromY, int toX, int toY, WebDriver driver) {
		try {
			TouchAction touchAction = new TouchAction((PerformsTouchActions) driver);
			touchAction.longPress(PointOption.point(fromX, fromY)).moveTo(PointOption.point(toX, toY)).release()
					.perform();
		} catch (Exception e) {
			System.out.println("We got an error scrolling!");
		}
	}
}
