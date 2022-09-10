package Pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import property.CommonUtils;

public class LoginPage {
	public AppiumDriver driver;

	String skipButton = "//*[@text='Skip']";
	// [@text='Enter Mobile Number']
	String mobileNumberField = "//android.widget.EditText";
	String sendOTP = "//*[@text='Send OTP']";
	String continueButton = "//*[@text='Continue']";
	String termLink = "//*[contains(@text,'Terms of Use')]";
	String privacyLink = "//*[contains(@text,'Privacy Policy')]";
	String resendOTP = "//*[contains(@text,'Resend OTP')]";
	public String BackButton = "//*[contains(@text,'Back')]";
	String headerInOTP = "//*[contains(@text,'Enter OTP')]";
	String getStart = "//*[contains(@text,'Get Started')]";

	public void verifySkipButton(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		Assert.assertTrue(driver.findElement(By.xpath(skipButton)).isDisplayed(), "Skip Button is not display!!");
	}

	public void verifyGetStartHeader(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		Assert.assertTrue(driver.findElement(By.xpath(getStart)).isDisplayed(), "Get Start header is not display!!");
	}

	public void verifyOTPHeader(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		Assert.assertTrue(driver.findElement(By.xpath(headerInOTP)).isDisplayed(), "OTP header is not display!!");
	}

	public void verifyBackButton(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		Assert.assertTrue(driver.findElement(By.xpath(BackButton)).isDisplayed(), "Back Button is not display!!");
	}

	public void clickOnBackButton(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		driver.findElement(By.xpath(BackButton)).click();
		CommonUtils.implicitWait(driver, 2);
	}

	public void verifyResendOTPLink(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		Assert.assertTrue(driver.findElement(By.xpath(resendOTP)).isDisplayed(), "Resend OTP is not display!!");
	}

	public void VerifyPrivacyLink(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		Assert.assertTrue(driver.findElement(By.xpath(privacyLink)).isDisplayed(), "Privacy link is not display!!");
	}

	public void VerifyTermLink(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		Assert.assertTrue(driver.findElement(By.xpath(termLink)).isDisplayed(), "Term link is not display!!");
	}

	public void clickOnSkipButton(WebDriverWait wait, AppiumDriver driver) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(skipButton)));
		CommonUtils.implicitWait(driver, 2);
		driver.findElement(By.xpath(skipButton)).click();
	}

	public void verifyMobileNumberField(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		Assert.assertTrue(driver.findElement(By.xpath(mobileNumberField)).isDisplayed(),
				"MobileField is not display!!");
	}

	public String getMobileFieldText(AppiumDriver driver) {
		return driver.findElement(By.xpath(mobileNumberField)).getText();
	}

	public void EnterMobileNumber(AppiumDriver driver, String number) {
		CommonUtils.implicitWait(driver, 2);
		driver.findElement(By.xpath(mobileNumberField)).clear();
		CommonUtils.implicitWait(driver, 1);
		driver.findElement(By.xpath(mobileNumberField)).sendKeys(number);
		CommonUtils.implicitWait(driver, 1);
	}

	public void verifySendOTPButtonDisplay(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		Assert.assertTrue(driver.findElement(By.xpath(sendOTP)).isDisplayed(), "Send OTP Button is not display!!");
	}

	public boolean verifySendOTPButtonEnabled(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		return driver.findElement(By.xpath(sendOTP)).isEnabled();
	}

	public void clickOnSendOTPButton(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		driver.findElement(By.xpath(sendOTP)).click();
	}

	public void verifyContniueButton(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		Assert.assertTrue(driver.findElement(By.xpath(continueButton)).isDisplayed(),
				"Contniue Button is not display!!");
	}

	public void clickOnContniueButton(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		driver.findElement(By.xpath(continueButton)).click();
	}

	public void enterOTP(AppiumDriver driver, String OTP) {
		for (int i = 0; i < OTP.length(); i++) {
			char c = OTP.charAt(i);
			CommonUtils.implicitWait(driver, 1);
			int n = i + 1;
			if (n == 1) {
				driver.findElement(By.xpath("(//android.widget.EditText)[1]")).clear();
				CommonUtils.implicitWait(driver, 1);
				driver.findElement(By.xpath("(//android.widget.EditText)[1]")).sendKeys(String.valueOf(c));
			} else if (n == 2) {
				driver.findElement(By.xpath("(//android.widget.EditText)[2]")).clear();
				CommonUtils.implicitWait(driver, 1);
				driver.findElement(By.xpath("(//android.widget.EditText)[2]")).sendKeys(String.valueOf(c));
			} else if (n == 3) {
				driver.findElement(By.xpath("(//android.widget.EditText)[3]")).clear();
				CommonUtils.implicitWait(driver, 1);
				driver.findElement(By.xpath("(//android.widget.EditText)[3]")).sendKeys(String.valueOf(c));
			} else if (n == 4) {
				driver.findElement(By.xpath("(//android.widget.EditText)[4]")).clear();
				CommonUtils.implicitWait(driver, 1);
				driver.findElement(By.xpath("(//android.widget.EditText)[4]")).sendKeys(String.valueOf(c));
			} else {
				System.out.println("OTP field is not display!!");
			}
			CommonUtils.implicitWait(driver, 1);
		}
		CommonUtils.implicitWait(driver, 1);
		driver.findElement(By.xpath(headerInOTP)).click();
	}

	public void loginApp(AppiumDriver driver, String mobileNumber, String OTP) throws InterruptedException {
		this.verifyMobileNumberField(driver);
		CommonUtils.implicitWait(driver, 2);
		this.EnterMobileNumber(driver, mobileNumber);
		CommonUtils.implicitWait(driver, 2);
		this.clickOnSendOTPButton(driver);
		CommonUtils.implicitWait(driver, 2);
		// this.enterOTP(driver, OTP);
		Thread.sleep(13000);
		CommonUtils.implicitWait(driver, 4);
		this.clickOnContniueButton(driver);
		CommonUtils.implicitWait(driver, 2);
		Thread.sleep(4000);
		Assert.assertTrue(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).isDisplayed());
	}
}
