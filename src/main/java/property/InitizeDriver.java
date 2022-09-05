package property;

import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import property.Dataprovider;

public class InitizeDriver {
	AppiumDriver driver;
	public Properties pro = new Properties();
	public static final String AUTOMATE_USERNAME = "qateam_U85wEK";
	public static final String AUTOMATE_ACCESS_KEY = "bTdJZ7aqhLMGVK9CWud5";
	public static final String URL = "https://" + AUTOMATE_USERNAME + ":" + AUTOMATE_ACCESS_KEY
			+ "@hub-cloud.browserstack.com/wd/hub";

	public String getData(String name) throws IOException {
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\property\\config.properties");
		pro.load(fis);
		return pro.getProperty(name);
	}

	@BeforeMethod
	public AppiumDriver setup() throws InterruptedException, IOException {
		InitizeDriver initize = new InitizeDriver();
		String browserstack = initize.getData("browserstack");
		DesiredCapabilities caps = new DesiredCapabilities();
		if (browserstack.contains("No")) {
			caps.setCapability("platformName", "Android");
			caps.setCapability("platformVersion", "10.0");
			caps.setCapability("deviceName", "samsung"); // samsung
			caps.setCapability("udid", "bf2690bc"); // bf2690bc
			caps.setCapability("app", System.getProperty("user.dir") + "\\src\\app-release.apk");
			driver = new AndroidDriver(new URL("http://localhost:4723/wd/hub"), caps);
			driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
		} else {
			DesiredCapabilities capabilities = new DesiredCapabilities();
			capabilities.setCapability("app", "bs://adc8069b2cf95de76b58a75cfb365f27ccbc621e");
			capabilities.setCapability("project", "Kalira");
			capabilities.setCapability("build", "browserstack-build-1");
			capabilities.setCapability("name", "Mobile Automation");
			capabilities.setCapability("browserstack.debug", true);
			capabilities.setCapability("device", "Google Pixel 3");
			capabilities.setCapability("os_version", "9.0");
			capabilities.setCapability("autoGrantPermissions", "true");
			capabilities.setCapability("automationName", "uiAutomator2");
			capabilities.setCapability("platformName", "Android");
			driver = new AndroidDriver(new URL(URL), capabilities);
		}
		return driver;
	}

	@AfterMethod
	public void teardown() throws InterruptedException {
		Thread.sleep(2000);
		driver.quit();
	}
}
