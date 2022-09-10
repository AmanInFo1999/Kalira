package kalira.mobile_automation;

import java.io.IOException;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.LoginPage;
import Pages.ShopPage;
import io.appium.java_client.AppiumDriver;
import property.CommonUtils;
import property.Dataprovider;
import property.InitizeDriver;

public class ShopingPageTest {
	public AppiumDriver driver;
	LoginPage login = new LoginPage();
	ShopPage shop = new ShopPage();

	@BeforeMethod
	public void beforeTest() throws InterruptedException, IOException {
		InitizeDriver initize = new InitizeDriver();
		driver = initize.setup();
	}

	 @Test(priority = 1, dataProvider = "HomePage", dataProviderClass =
	 Dataprovider.class)
	@Description("TC_006 : Kalira logo should be visible on the top center."
			+ "TC_009 : Verify user should be landing on Shop page by default, and icon color should be pink"
			+ "TC_010 : Verify Daily new icon or text is clickable."
			+ "TC_011 : Verify that when user click on the Daily New icon then user should be redirected to Daily New screen, and menu icon should be changed from grey to pink."
			+ "TC_012 : Verify Orders or text is clickable."
			+ "TC_013 : Verify that when user click on the Orders nav icon then user should be redirected to Orders screen, and menu icon should be changed from grey to pink."
			+ "TC_014 : Verify order header should be display when click on orders icon/text."
			+ "TC_015 : Verify Saved icon or text is clickable.\r\n"
			+ "TC_016 : Verify that when user click on the Saved nav icon then user should be redirected to Saved screen, and menu icon should be changed from grey to pink."
			+ "TC_017 : Verify saved header should be display when click on saved icon/text."
			+ "TC_018 : Verify that all the product banner should be visible clearly."
			+ "TC_019 : Verify that the user is able to navigate through all the products across different categories."
			+ "TC_020 : Verify that the user is able to see navigate categoriers then see categories header."
			+ "TC_021 : Verify that all the links and banners should redirecting to correct product/category pages and none of the links should broken.")
	public void verifyShop(String mobileNumber, String OTP) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Thread.sleep(20000);
		CommonUtils.implicitWait(driver, 50);
		login.loginApp(driver, mobileNumber, OTP);
		shop.clickOnSareeBanner(driver);
		shop.verifyText(driver, "SAREE");
		shop.verifyClickText(driver, "SAREE");
		shop.clickOnKurtaSetBanner(driver);
		shop.verifyText(driver, "KURTA SET");
		shop.verifyClickText(driver, "KURTA SET");
		shop.verifyText(driver, "Daily New");
		shop.verifyClickText(driver, "Daily New");
		Thread.sleep(3000);
		CommonUtils.scrollDown(driver);
		shop.verifyText(driver, "Filter");
		shop.verifyText(driver, "Orders");
		shop.verifyClickText(driver, "Orders");
		shop.verifyText(driver, "Saved");
		shop.verifyClickText(driver, "Saved");
		shop.verifyText(driver, "Shop");
		shop.verifyClickText(driver, "Shop");
		shop.verifySareeBanner(driver);
	}

//	@Test(priority = 2, dataProvider = "HomePage", dataProviderClass = Dataprovider.class)
//	@Description("TC_001 : Verify that when user click on the Orders nav icon then user should be redirected to Orders screen, and menu icon should be changed from grey to pink.\r\n"
//			+ "TC_002 : Verify that Orders text should be visible on the Top left side."
//			+ "TC_003 : Verify that Save icon should be visible on the Top right side corner."
//			+ "TC_004 : Verify that \"For any order related question or enquiry , reach out to us on Whatsapp or Call on: +916363209447\" text should be visible in the center as per the figma.\r\n"
//			+ "TC_005 : Verify that Click to Start Whatsapp Chat button should be visible as per the figma."
//			+ "TC_006 : Verify Saved header should be display when click on save button on ordes page."
//			+ "TC_007 : Verify saved button should be clickable on orders page.")
//	public void verifyOrders(String mobileNumber, String OTP) throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, 120);
//		Thread.sleep(20000);
//		CommonUtils.implicitWait(driver, 50);
//		login.clickOnSkipButton(wait, driver);
//		shop.verifyText(driver, "Orders");
//		shop.verifyClickText(driver, "Orders");
//		shop.verifyText(driver, "Orders");
//		shop.verifySavedIcon(driver);
//		shop.verifyText(driver, "Click to Start Whatsapp Chat");
//		shop.verifyText(driver, "For any order related question or enquiry, reach out to us on Whatapp");
//		shop.verifyText(driver, "Call on: +916363209447");
//		shop.clickOnSavedIcon(driver);
//		shop.verifyText(driver, "Saved");
//	}
//	@Test(priority = 2, dataProvider = "HomePage", dataProviderClass = Dataprovider.class)
//	@Description("TC_001 : Verify that when user click on the Saved Nav bar then user should be redirected to the Saved screen."
//			+ "TC_004 : Verify that You have not saved any products. text should be visible."
//			+ "TC_005 : Verify that Start Shopping button should be visible as per the figma and when user click on it then user should be redirectd to the Categories screen."
//			+ "TC_006 : Verify home page should be visible when user click on start shopping page.")
//	public void verifySaved(String mobileNumber, String OTP) throws InterruptedException {
//		WebDriverWait wait = new WebDriverWait(driver, 120);
//		Thread.sleep(20000);
//		CommonUtils.implicitWait(driver, 50);
//		login.clickOnSkipButton(wait, driver);
//		shop.verifyText(driver, "Saved");
//		shop.verifyClickText(driver, "Saved");
//		shop.verifyText(driver, "Saved");
//		shop.verifyText(driver, "You have not saved any products.");
//		shop.verifyText(driver, "Start Shopping");
//		shop.verifyClickText(driver, "Start Shopping");
//	}
}
