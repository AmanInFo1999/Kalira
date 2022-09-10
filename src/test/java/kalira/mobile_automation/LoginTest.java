package kalira.mobile_automation;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Description;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;
import io.appium.java_client.AppiumDriver;
import property.CommonUtils;
import property.Dataprovider;
import property.InitizeDriver;

public class LoginTest {
	public AppiumDriver driver;
	LoginPage login = new LoginPage();

	@BeforeMethod
	public void beforeTest() throws InterruptedException, IOException {
		InitizeDriver initize = new InitizeDriver();
		driver = initize.setup();
	}

//	@Test(priority = 1, dataProvider = "Login", dataProviderClass = Dataprovider.class)
	@Description("TC:009 -> Verify that the mobile number field should display the accepted format of the mobile number as the placeholder text for user assistance."
			+ "TC : 010 -> Add a valid mobile number and verify the field should accept the correct mobile number."
			+ "TC: 012-> Verify mobile number field should accept only the numeric value by entering alphabets and the special character"
			+ "TC : 013 -> Verify by entering the less number than the actual mobile number, And verified following message should be visible 'Invalid! Please enter 10 digit mobile number.'"
			+ "TC : 014 -> Verify the behaviour by adding more digits than the actual mobile number."
			+ "TC : 015 -> Verify field accepts the space (s) between the mobile number or not."
			+ "TC : 016 -> Verify an error message shown for the blank input for the Mobile Number Field."
			+ "TC: 018 -> Verify that Send OTP button should be visible in the disabled state, As per the figma."
			+ "TC : 020 -> Verify that country code is visible along with mobile number field."
			+ "TC : 021 -> Verify that OTP is generated while entering the valid number."
			+ "TC : 022 -> Verify that user click on the Mobile input box  Keyboard should be open."
			+ "TC : 024 -> Verify that \"Terms of Use\" link is visible in below and when user click on it Terms of Use page should be open."
			+ "TC : 025 -> Verify that \"Privacy policy\"  link is visible in below and when user click on it Privacy policy page should be open."
			+ "TC : 026 -> Verify that when user click on Send OTP button after enter the mobile number then user should be navigate to the Enter OTP screen."
			+ "TC : 027 -> Verify that Enter OTP text is visible in bold and user number is visible in top on OTP box, As per the figma."
			+ "TC : 028 -> Verify that Resend OTP is visible on below."
			+ "TC : 029 -> Verify Continue button is visible in below, As per the figma."
			+ "TC : 030 -> Verify Back text arrow is visble on top left corner.")
	public void LoginValidation(String mobileNumber) throws InterruptedException {
		Thread.sleep(20000);
		CommonUtils.implicitWait(driver, 50);
		login.verifyMobileNumberField(driver);
		login.EnterMobileNumber(driver, "erwre!@@");
		Assert.assertNotEquals(login.getMobileFieldText(driver), "erwre!@@");
		login.EnterMobileNumber(driver, "11111");
		login.clickOnSendOTPButton(driver);
		CommonUtils.implicitWait(driver, 5);
		login.VerifyTermLink(driver);
		login.VerifyPrivacyLink(driver);
		Assert.assertTrue(driver.findElement(By.xpath("//*[contains(@text,'Invalid mobile number.')]")).isDisplayed(),
				"Less than digit accepted");
		System.out.println("Number" + login.getMobileFieldText(driver));
		Assert.assertTrue(driver.findElement(By.xpath("//*[@text='+91']")).isDisplayed(),
				"Country code is not displayed");
		login.EnterMobileNumber(driver, mobileNumber + " 1111");
		Assert.assertEquals(login.getMobileFieldText(driver), mobileNumber);
		Assert.assertTrue(login.verifySendOTPButtonEnabled(driver), "Send OTP Button is not enabled!!");
		login.clickOnSendOTPButton(driver);
		login.verifyResendOTPLink(driver);
		login.verifyBackButton(driver);
		CommonUtils.implicitWait(driver, 12);
		login.verifyContniueButton(driver);
		Thread.sleep(3000);
		login.clickOnContniueButton(driver);
	}

	// @Test(priority = 2, dataProvider = "Login", dataProviderClass =
	// Dataprovider.class)
	@Description("TC : 031 -> Verify four box is visible for enter the OTP."
			+ "TC : 039 -> Verify by adding the valid OTP application must accept the code successfully."
			+ "TC : 035 -> Test the count for the OTP code generated should not be less than required."
			+ "TC : 046 -> Verify mobileNumber field should be display when user click on Back button."
			+ "TC : 045 -> Verify back button should be clickable"
			+ "TC : 019 -> Verify that Skip link should be visible and working properly."
			+ "TC : 49 -> Back button not visible in get started page.")
	public void OTPValidation(String mobileNumber) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Thread.sleep(20000);
		CommonUtils.implicitWait(driver, 50);
		login.verifyMobileNumberField(driver);
		try {
			Assert.assertFalse(driver.findElement(By.xpath(login.BackButton)).isDisplayed(),
					"Back Button is not display!!");
		} catch (NoSuchElementException e) {
			e.printStackTrace();
		}
		login.EnterMobileNumber(driver, mobileNumber);
		login.clickOnSendOTPButton(driver);
		Thread.sleep(2000);
		login.enterOTP(driver, "12");
		login.clickOnContniueButton(driver);
		Thread.sleep(2000);
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[contains(@text,'Please enter correct OTP.')]")).isDisplayed(),
				"Less than digit accepted");
		login.enterOTP(driver, "1223");
		login.clickOnContniueButton(driver);
		Thread.sleep(2000);
		Assert.assertTrue(
				driver.findElement(By.xpath("//*[contains(@text,'Please enter correct OTP.')]")).isDisplayed(),
				"Incorrect OTP accepted!!");
		login.verifyBackButton(driver);
		login.clickOnBackButton(driver);
		login.verifyGetStartHeader(driver);
		login.clickOnSkipButton(wait,driver);
		Thread.sleep(3000);
		Assert.assertTrue(driver.findElement(By.xpath("(//android.widget.ImageView)[1]")).isDisplayed());
	}

	@Test(priority = 3, dataProvider = "HomePage", dataProviderClass = Dataprovider.class)
	@Description("TC : 47 : Verify four box is clickable for enter the OTP."
			+ "Shop Page TC : 006 -> Kalira logo should be visible on the top center."
			+ "TC : 048 -> Verify that when user click on the Continue button after enter the valid OTP then user should be navigate to the Home screen.")
	public void verifyHome(String mobileNumber, String OTP) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Thread.sleep(20000);
		CommonUtils.implicitWait(driver, 50);
		login.loginApp(driver, mobileNumber, OTP);
	}
}
