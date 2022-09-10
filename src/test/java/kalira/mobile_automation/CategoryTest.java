package kalira.mobile_automation;

import java.io.IOException;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.springframework.context.annotation.Description;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import Pages.CategoryPage;
import Pages.LoginPage;
import Pages.ShopPage;
import io.appium.java_client.AppiumDriver;
import property.CommonUtils;
import property.Dataprovider;
import property.InitizeDriver;

public class CategoryTest {

	public AppiumDriver driver;
	LoginPage login = new LoginPage();
	ShopPage shop = new ShopPage();
	CategoryPage category = new CategoryPage();

	@BeforeMethod
	public void beforeTest() throws InterruptedException, IOException {
		InitizeDriver initize = new InitizeDriver();
		driver = initize.setup();
	}

	@Test(priority = 1, dataProvider = "HomePage", dataProviderClass = Dataprovider.class)
	@Description("TC : 003 : Verify that Back arrow button should be visible on the top left corner and when user click on it then user should be redirected to the Shop page.\r\n"
			+ "TC : 004 : Verfiy backarrow should be clickable."
			+ "TC : 005, 006 : Verify that following filters should be clickable as per the figma.Sort,Fabric, Price, Filter,Etc"
			+ "TC : 001 :Verify that when user click on the banner then user should be redirected to Categories page."
			+ "TC : 002 : Verify that Categories name should be visible on the top left."
			+ "TC : 037 : Verify that when user clicks on the sub categories products, then user should be navigate to the particular products category screen."
			+ "TC : 033 : Verify that the Images of product are displayed correctly or not.."
			+ "TC : 034 : Verify that the Price of product is displayed or not."
			+ "TC : 035 : Verify that the product specifications are displayed or not."
			+ "TC : 038 : Verify that when user click on the Save icon then product should be saved and Icon color should be changed into the pink as per the figma."
			+ "TC : 040 : Verify that when user click on the any product then user should be navigate to the Product video feed.")
	public void subProductCategory(String mobileNumber, String OTP) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Thread.sleep(20000);
		CommonUtils.implicitWait(driver, 50);
		login.clickOnSkipButton(wait, driver);
		shop.clickOnSareeBanner(driver);
		shop.verifyText(driver, "SAREE");
		shop.verifyText(driver, "Sort");
		shop.verifyText(driver, "Fabric");
		shop.verifyText(driver, "Price");
		shop.verifyText(driver, "Filter");
		shop.verifyClickText(driver, "Linen");
		shop.verifyText(driver, "LINEN");
		shop.verifyClickText(driver, "LINEN");
		category.verifyProductName(driver);
		category.verifyProductPrice(driver);
		category.clickOnProduct(driver);
		category.clickOnProductPageBack(driver);

	}

	 @Test(priority = 2, dataProvider = "HomePage", dataProviderClass =
	 Dataprovider.class)
	@Description("TC : 008 : Verify that when user tap on the filter then filter window should be visible.\r\n"
			+ "TC : 009 : Verify that required filters field should be visible in the filter window."
			+ "TC : 010 : Verify that when user tap on the cross icon then filter window should be closed."
			+ "TC : 011 : Verify that sorting works correctly on the pages containing the filtered result, after applying filters.\r\n"
			+ "TC_012 : Verify clear all and apply button should be visible."
			+ "TC_013 :	Verify that sorting works correctly on the category pages.")
	public void verifyFilter(String mobileNumber, String OTP) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Thread.sleep(20000);
		CommonUtils.implicitWait(driver, 50);
		login.clickOnSkipButton(wait, driver);
		shop.clickOnSareeBanner(driver);
		shop.verifyText(driver, "SAREE");
		shop.verifyText(driver, "Filter");
		shop.verifyClickText(driver, "Filter");
		category.verifycategoryHeader(driver);
		category.clickOncottonType(driver);
		shop.verifyText(driver, "Clear All");
		shop.verifyClickText(driver, "Apply");
		shop.verifyClickText(driver, "SAREE");
	}

	 @Test(priority = 3, dataProvider = "HomePage", dataProviderClass =
	 Dataprovider.class)
	@Description("TC_015 : Verify that all the sort options work correctly – correctly sort the products based on the sort option chosen.\r\n"
			+ "TC_016 : Verify that when user click on the Clear All button then apply filter should be cleared.\r\n"
			+ "TC_017 : Verify that Popularity filter should be select by default."
			+ "TC_019 : Verify that when user select New Arrivals filters then only New Arrivals products should be visible.\r\n"
			+ "TC_020 : Verify that when user select Price - Low to High then only Low to High Price products should be visible.\r\n"
			+ "TC_021 : Verify that when user select Price - High to Low then only High to Low Price products should be visible.")
	public void verifySortFilter(String mobileNumber, String OTP) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Thread.sleep(20000);
		CommonUtils.implicitWait(driver, 50);
		login.clickOnSkipButton(wait, driver);
		shop.clickOnSareeBanner(driver);
		shop.verifyText(driver, "SAREE");
		shop.verifyClickText(driver, "Sort");
		category.verifySortFilter(driver);
		category.verifyCloseButton(driver);
		shop.verifyText(driver, "New Arrivals");
		shop.verifyText(driver, "High to Low");
		shop.verifyText(driver, "Low to High");
		shop.verifyClickText(driver, "High to Low");
		CommonUtils.implicitWait(driver, 3);
	}

	 @Test(priority = 4, dataProvider = "HomePage", dataProviderClass =
	 Dataprovider.class)
	@Description("TC_025 : Verify that when user click on the Price filter then Price range filter window should be visible.\r\n"
			+ "TC_026 : Verify that when user Select price range and click on the Apply button then Particular price range product should be visible.\r\n"
			+ "TC_027 : Verify that when user click on the Clear All button then apply filter should be cleared.")
	public void verifyPriceFilter(String mobileNumber, String OTP) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Thread.sleep(20000);
		CommonUtils.implicitWait(driver, 50);
		login.clickOnSkipButton(wait, driver);
		shop.clickOnSareeBanner(driver);
		shop.verifyText(driver, "SAREE");
		shop.verifyClickText(driver, "Price");
		shop.verifyText(driver, "Price Range");
		category.verifyCloseButton(driver);
		category.verifyunder1000Filter(driver);
		category.clickOnUnder1000Filter(driver);
		shop.verifyText(driver, "Clear All");
		shop.verifyClickText(driver, "Apply");
		CommonUtils.implicitWait(driver, 3);

	}

	@Test(priority = 5, dataProvider = "HomePage", dataProviderClass = Dataprovider.class)
	@Description("TC_028 : Verify that when user click on the Fabric then Fabric filter window should be visible."
			+ "TC_029 : Verify that when user select Fabric filter and click on the Apply button then particular Fabric filter should be visible.\r\n"
			+ "TC_030 : Verify that when user click on the Clear All button then apply filter should be cleared.")
	public void verifyFabricFilter(String mobileNumber, String OTP) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver, 120);
		Thread.sleep(20000);
		CommonUtils.implicitWait(driver, 50);
		login.clickOnSkipButton(wait, driver);
		shop.clickOnSareeBanner(driver);
		shop.verifyText(driver, "SAREE");
		shop.verifyClickText(driver, "Fabric");
		CommonUtils.implicitWait(driver, 2);
		category.verifyFabricFilter(driver);
		category.verifyCloseButton(driver);
		category.clickOnMossChiffon(driver);
		shop.verifyText(driver, "Clear All");
		shop.verifyClickText(driver, "Apply");
		CommonUtils.implicitWait(driver, 3);

	}
}
