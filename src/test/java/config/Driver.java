package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Driver {

	private static WebDriver driver;

	public static WebDriver getDriver() {
		System.setProperty("webdriver.chrome.driver", "/home/Desktop/chrome32/chromedriver");

		String operatingSystem = System.getProperty("os.name");
		if (System.getProperty("os.name").equals("Mac OS X")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/mac/chromedriver");
		} else if (System.getProperty("os.name").contains("Windows")) {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/windows/chromedriver.exe");
		} else {
			System.setProperty("webdriver.chrome.driver", "src/test/resources/drivers/linux/chromedriver");
		}

		driver = new ChromeDriver();
		return driver;
	}
}
