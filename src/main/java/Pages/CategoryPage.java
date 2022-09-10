package Pages;

import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.testng.Assert;

import io.appium.java_client.AppiumDriver;
import property.CommonUtils;

public class CategoryPage {
	public AppiumDriver driver;

	String categoryHeader = "(//android.widget.TextView[contains(@text,'Category')])[1]";
	String closeButton = "//android.widget.TextView[contains(@text,'X')]";
	String cottonTrye = "//android.widget.TextView[contains(@text,'Cotton')]/../android.widget.ImageView";

	public void verifycategoryHeader(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		Assert.assertTrue(driver.findElement(By.xpath(categoryHeader)).isDisplayed(),
				"category Header is not display!!");
	}

	public void verifyCloseButton(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		Assert.assertTrue(driver.findElement(By.xpath(closeButton)).isDisplayed(), "Close Button is not display!!");
	}

	public void clickOncottonType(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		CommonUtils.explicitWait(driver, cottonTrye);
		driver.findElement(By.xpath(cottonTrye)).click();
		CommonUtils.implicitWait(driver, 2);
	}

	public void clickOncloseButton(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		CommonUtils.explicitWait(driver, closeButton);
		driver.findElement(By.xpath(closeButton)).click();
		CommonUtils.implicitWait(driver, 2);
	}

	String sortFilter = "(//android.widget.TextView[contains(@text,'Sort')])[2]";

	public void verifySortFilter(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		Assert.assertTrue(driver.findElement(By.xpath(sortFilter)).isDisplayed(), "Sort Header is not display!!");
	}

	String under1000Filter = "//android.widget.TextView[contains(@text,'Under ₹1000')]";

	public void verifyunder1000Filter(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		Assert.assertTrue(driver.findElement(By.xpath(under1000Filter)).isDisplayed(), "Under 1000 is not display!!");
	}

	public void clickOnUnder1000Filter(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		CommonUtils.explicitWait(driver, under1000Filter);
		driver.findElement(By.xpath(under1000Filter)).click();
		CommonUtils.implicitWait(driver, 2);
	}

	String fabricFilter = "//android.widget.TextView[contains(@text,'Fabric')]";
	String selectProduct = "//android.widget.TextView[contains(@text,'Moss Chiffon')]";

	public void verifyFabricFilter(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 3);
		Assert.assertTrue(driver.findElement(By.xpath(fabricFilter)).isDisplayed(), "Fabric Header is not display!!");
	}

	public void clickOnMossChiffon(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		CommonUtils.implicitWait(driver, 2);
		CommonUtils.explicitWait(driver, selectProduct);
		driver.findElement(By.xpath(selectProduct)).click();
		CommonUtils.implicitWait(driver, 2);
	}

	String productName = "(//android.widget.TextView[contains(@text,'Cotton Mul-Mul Saree')])[1]";
	String productPrice = "(//android.widget.TextView[contains(@text,'1099')])[1]";
	String saveInVideo = "(//android.widget.TextView[contains(@text,'Save')]/..//android.widget.ImageView)[6]";
	String backButtonOnProduct = "(//android.widget.ImageView)[3]";

	public void verifyProductName(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		Assert.assertTrue(driver.findElement(By.xpath(productName)).isDisplayed(), "product Name is not display!!");
	}

	public void verifyProductPrice(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		Assert.assertTrue(driver.findElement(By.xpath(productPrice)).isDisplayed(), "product Price is not display!!");
	}

	public void verifyProductSaveButton(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		Assert.assertTrue(driver.findElement(By.xpath(saveInVideo)).isDisplayed(),
				"product save button is not display!!");
	}

	public void clickOnProduct(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		CommonUtils.explicitWait(driver, productPrice);
		driver.findElement(By.xpath(productPrice)).click();
		CommonUtils.implicitWait(driver, 2);
	}

	public void clickOnProductPageBack(AppiumDriver driver) {
		CommonUtils.implicitWait(driver, 2);
		CommonUtils.explicitWait(driver, backButtonOnProduct);
		driver.findElement(By.xpath(backButtonOnProduct)).click();
		CommonUtils.implicitWait(driver, 2);
	}
}
