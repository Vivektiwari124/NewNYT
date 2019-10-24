package Com.NYT.BasePackage;

import org.openqa.selenium.WebDriver;

import io.appium.java_client.PerformsTouchActions;

public class MobileDriver{
	private static WebDriver Driver;

	public static WebDriver getDriver() {
		return Driver;
	}

	static void setWebDriver(WebDriver driver) {
		Driver = driver;
	}

}
