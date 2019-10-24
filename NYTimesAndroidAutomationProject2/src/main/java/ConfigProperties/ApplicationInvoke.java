package ConfigProperties;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class ApplicationInvoke extends propertiesRead {

	static String systemDir = System.getProperty("user.dir");
	public static String Driverpath = System.getProperty("user.dir") + "\\src\\main\\java\\Drivers\\";

	public static AppiumDriver<MobileElement> InvokeApp() throws MalformedURLException {

		File app = new File(systemDir + "\\Build\\" + "reader-google-beta-7.8.0.apk");
		DesiredCapabilities capabilities = new DesiredCapabilities();
		capabilities.setCapability("deviceName", prop.getProperty("SamsungS9"));
		capabilities.setCapability("platformVersion", prop.getProperty("platformVersion"));
		capabilities.setCapability("platformName", "Android");
		// capabilities.setCapability("browserName", prop.getProperty("browser"));

		capabilities.setCapability("app-package", "com.nytimes.android.debug");
		capabilities.setCapability("app-activity", "com.nytimes.android.welcome.WelcomeActivity");
		capabilities.setCapability("fullReset", false);
		capabilities.setCapability("noReset", true);
		capabilities.setCapability("app", app.getAbsolutePath());
	//	System.setProperty("webdriver.chrome.driver", Driverpath + "chromedriver.exe");
		AppiumDriver<MobileElement> driver = new AppiumDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"),
				capabilities);
		// driver.get("http://www.google.com");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		return driver;
	}

}
