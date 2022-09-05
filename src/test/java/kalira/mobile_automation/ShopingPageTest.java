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

	@Test(priority = 1, dataProvider = "HomePage", dataProviderClass = Dataprovider.class)
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
}
