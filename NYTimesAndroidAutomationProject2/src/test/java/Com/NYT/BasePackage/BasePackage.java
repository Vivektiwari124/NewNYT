package Com.NYT.BasePackage;

import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import ConfigProperties.ApplicationInvoke;
import ConfigProperties.propertiesRead;
import ConfigProperties.Util;
import ConfigProperties.report;
import ConfigProperties.GlobalTestData;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;

public class BasePackage {

	public static ExtentTest test;
	public static ExtentReports extent;
	public static ExtentHtmlReporter htmlReporter;
	public static String systemDir = System.getProperty("user.dir");
	public static String ExcelPath;
	public static String ResultFolderPath;
	public static String Driverpath = System.getProperty("user.dir") + "\\src\\main\\java\\Drivers\\";
	public static String TestDataSheetPath = System.getProperty("user.dir") + "\\src\\main\\java\\TestData\\";
	public static AppiumDriver<MobileElement> driver;
	public static Properties prop;

	@BeforeSuite
	public void installApp() {
		//ResultFolderPath = systemDir + "/test-output" + "/" + GlobalTestData.CurrentDateFolder + "/";
		//Util.CreateFolder(ResultFolderPath);
		prop = propertiesRead.readProperties();
		//htmlReporter = report.StartHtmlFinalReport(htmlReporter, prop.getProperty("devicename"), ResultFolderPath);
		//extent = report.StartExtentReport(htmlReporter, extent);
	}

	
/*	@BeforeClass
	public void setupReport(ITestContext contextContext) {
		try {
			test = report.testCreate(extent, "Test :->> " + contextContext.getName());
		} catch (Exception e) {
			e.getMessage();
		}
	}*/

	@BeforeMethod
	public void Appinvoke() {
		try {
			driver = ApplicationInvoke.InvokeApp();
			driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
			System.out.println("App is invoked successfully");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}

	@AfterMethod
	public void QuitApp() throws IOException {

		driver.quit();
		//report.endReport(extent);
		System.out.println("Driver is closed");

	}

}
