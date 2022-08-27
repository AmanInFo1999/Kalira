package kalira.mobile_automation;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.*;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.*;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;

public class Base {
	AppiumDriver driver;

	@BeforeMethod
	public void setUp() throws MalformedURLException {
		DesiredCapabilities caps = new DesiredCapabilities();
		caps.setCapability("platformName", "Android");
		caps.setCapability("platformVersion", "10.0");
		caps.setCapability("deviceName", "samsung"); // , samsung
		caps.setCapability("udid", "bf2690bc"); // bf2690bc
		caps.setCapability("app", System.getProperty("user.dir") + "\\src\\app-release.apk");
		driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
		driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	}

	// adb uninstall io.appium.uiautomator2.server
	@Test
	public void loginNew() throws InterruptedException {
		String mobileNumber = "9319671845";

		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		Assert.assertTrue(driver.findElement(By.xpath("//*[@text='Skip']")).isDisplayed());
		System.out.println("SKIP");
		Thread.sleep(5000);
		driver.findElement(By.xpath("//android.widget.EditText[@text='Enter Mobile Number']")).sendKeys(mobileNumber);
		Thread.sleep(3000);
		driver.findElement(By.xpath("//*[@text='Send OTP']")).click();
		Thread.sleep(15000);
		driver.findElement(By.xpath("//*[@text='Continue']")).click();
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).isDisplayed());
	}
}
