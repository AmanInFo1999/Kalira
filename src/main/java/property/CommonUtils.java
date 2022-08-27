package property;

import java.util.concurrent.TimeUnit;

import io.appium.java_client.AppiumDriver;

public class CommonUtils {
	public AppiumDriver driver;

	public static void implicitWait(AppiumDriver driver, int seconds) {
		driver.manage().timeouts().implicitlyWait(seconds, TimeUnit.SECONDS);
	}
}
