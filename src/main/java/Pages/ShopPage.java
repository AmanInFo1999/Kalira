package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import property.CommonUtils;

public class ShopPage {
	public AppiumDriver driver;

	String sareeBanner = "(//android.widget.ImageView)[4]";
	String kurtasetBanner = "(//android.widget.ImageView)[5]";
	String savedIcon = "(//android.widget.ImageView)[1]";

	public void verifySavedIcon(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		Assert.assertTrue(driver.findElement(By.xpath(savedIcon)).isDisplayed(), "Saved Icon is not display!!");
	}

	public void verifySareeBanner(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		Assert.assertTrue(driver.findElement(By.xpath(sareeBanner)).isDisplayed(), "Saree banner is not display!!");
	}
	public void clickOnSavedIcon(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		CommonUtils.explicitWait(driver, savedIcon);
		driver.findElement(By.xpath(savedIcon)).click();
		CommonUtils.implicitWait(driver, 2);
	}

	public void clickOnSareeBanner(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		CommonUtils.explicitWait(driver, sareeBanner);
		driver.findElement(By.xpath(sareeBanner)).click();
		CommonUtils.implicitWait(driver, 2);
	}

	public void clickOnKurtaSetBanner(AppiumDriver driver) throws InterruptedException {
		CommonUtils.implicitWait(driver, 2);
		Thread.sleep(3000);
		CommonUtils.explicitWait(driver, kurtasetBanner);
		driver.findElement(By.xpath(kurtasetBanner)).click();
		CommonUtils.implicitWait(driver, 2);
	}

	public boolean verifyText(AppiumDriver driver, String text) throws InterruptedException {
		Thread.sleep(3000);
		CommonUtils.explicitWait(driver, "//android.widget.TextView[contains(@text, '" + text + "')]");
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[contains(@text, '" + text + "')]"))
				.isDisplayed(), text + " is not displayed!!");
		return driver.findElement(By.xpath("//android.widget.TextView[contains(@text, '" + text + "')]")).isDisplayed();
	}

	public void verifyClickText(AppiumDriver driver, String text) throws InterruptedException {
		Thread.sleep(3000);
		CommonUtils.explicitWait(driver, "//android.widget.TextView[contains(@text, '" + text + "')]");
		Assert.assertTrue(driver.findElement(By.xpath("//android.widget.TextView[contains(@text, '" + text + "')]"))
				.isDisplayed(), text + " is not displayed!!");
		driver.findElement(By.xpath("//android.widget.TextView[contains(@text, '" + text + "')]")).click();
		CommonUtils.implicitWait(driver, 2);
	}
}
