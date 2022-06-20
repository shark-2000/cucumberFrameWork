package pages;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import utils.BrowserMgr;
import utils.ReadPropertyFile;

public class Common {
	public static WebDriver driver;
	public static WebElement element;

	public static void openURL(String browser) throws IOException {
		driver = BrowserMgr.setProperty(driver, ReadPropertyFile.readFileBrwoserProperty(browser));
		driver.get(ReadPropertyFile.readFileBaseURLProperty());
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
	}

	public static WebElement searchBox(WebDriver driver) {
		String xPath = "//input[@id='twotabsearchtextbox']";
		element = driver.findElement(By.xpath(xPath));
		return element;
	}

	public static WebElement submitButton(WebDriver driver) {
		String xPath = "//input[@id='nav-search-submit-button']";
		element = driver.findElement(By.xpath(xPath));
		return element;

	}

	public static WebElement product(WebDriver driver) {
		String xPath = "//*[@id='search']/div[1]/div[1]/div/span[3]/div[2]/div[4]/div/div/div/div/div/div[2]/div/div/div[1]/h2/a/span";
		element = driver.findElement(By.xpath(xPath));
		return element;
	}

	public static WebElement size(WebDriver driver) {
		String xPath = "//*[@id=size_name_5]/span/input";
		element = driver.findElement(By.xpath(xPath));
		return element;
	}

	public static WebElement buyNow(WebDriver driver) {
		String xPath = "//input[@id='buy-now-button']";
		element = driver.findElement(By.xpath(xPath));
		return element;
	}

	public static WebElement enterUsername(WebDriver driver) {
		String xPath = "//input[@id='ap_email']";
		element = driver.findElement(By.xpath(xPath));
		return element;
	}

	public static WebElement enterPassword(WebDriver driver) {
		String xPath = "//input[@id='ap_password']";
		element = driver.findElement(By.xpath(xPath));
		return element;
	}

	public static WebElement clickOnContinue(WebDriver driver) {
		String xPath = "//input[@id='continue']";
		element = driver.findElement(By.xpath(xPath));
		return element;
	}

	public static WebElement clickOnSignIn(WebDriver driver) {
		String xPath = "//input[@id='signInSubmit']";
		element = driver.findElement(By.xpath(xPath));
		return element;
	}

	public static WebElement checkCheckOut() {
		String xPath = "//*[@id='header']/div/div[3]/h1";
		element = driver.findElement(By.xpath(xPath));
		return element;
	}

	public static void enterProduct(String product) {
		Common.searchBox(driver).sendKeys(product);
		JavascriptExecutor js = (JavascriptExecutor) driver;

		// Common.searchBox(driver).clear();
	}

	public static void viewProduct() {
		Common.product(driver).click();
		ArrayList<String> tabs2 = new ArrayList<String>(driver.getWindowHandles());
		driver.switchTo().window(tabs2.get(1));
	}

	public static void checkHomePage() {
		String expected = "Online Shopping site in India: Shop Online for Mobiles, Books, Watches, Shoes and More - Amazon.in";
		String actual = driver.getTitle();
		Assert.assertEquals(expected, actual);
		System.out.println(actual);
	}

	public static void BuyNow() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,250)", Common.buyNow(driver));
		Common.buyNow(driver).click();
	}

	public static void clicksOnSearchButton() {
		Common.submitButton(driver).click();
	}

	public static void sendUserName() throws IOException {
		Common.enterUsername(driver).sendKeys(ReadPropertyFile.readUserName());
	}

	public static void sendPassword() throws IOException {
		Common.clickOnContinue(driver).click();
		Common.enterPassword(driver).sendKeys(ReadPropertyFile.readPassword());
		Common.clickOnSignIn(driver).click();
	}

	public static void assertPage() {
		String actual = Common.checkCheckOut().getText();
		String expected = "Checkout";
		Assert.assertEquals(actual, expected);
		System.out.println("Succefully landed on home page");
	}

}
