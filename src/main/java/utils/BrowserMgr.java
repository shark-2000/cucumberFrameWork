package utils;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;


public class BrowserMgr {
	WebDriver driver;

	public static WebDriver setProperty(WebDriver driver, String browser) {
		if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty(Constant.ChromeDriverKey, Constant.ChromeDriverPath);
			driver = new ChromeDriver();
			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty(Constant.EdgeDriverKey, Constant.EdgeDriverPath);
			driver = new EdgeDriver();
			driver.manage().window().maximize();

		} else if (browser.equalsIgnoreCase("firefox")) {
			System.setProperty(Constant.FirefoxDriverKey, Constant.FirefoxDriverPath);
			driver = new FirefoxDriver();
			driver.manage().window().maximize();

		}
		return driver;

	}

}
