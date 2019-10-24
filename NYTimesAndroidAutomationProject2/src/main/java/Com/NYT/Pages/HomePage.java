package Com.NYT.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class HomePage {

	AppiumDriver<MobileElement> driver;

	public HomePage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}

	@AndroidFindBy(id = "com.nytimes.android:id/nameplate")
	public MobileElement nameplate;
	
	@AndroidFindBy(id = "com.nytimes.android:id/header")
	public MobileElement Articleheader;

	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'More options') and @index='0']")
	public MobileElement overflowIcon;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@index='0']")
	public MobileElement hemberger;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='MOST POPULAR']")
	public MobileElement mostpapular;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='OPINION']")
	public MobileElement sectionname;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='WORLD']")
	public MobileElement world;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='U.S.']")
	public MobileElement ussection;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='BUSINESS']")
	public MobileElement business;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='SPORTS']")
	public MobileElement sports;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='ARTS']")
	public MobileElement arts;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='NEW YORK']")
	public MobileElement newyork;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Opinion']")
	public MobileElement Opinionsection;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='MAGAZINE']")
	public MobileElement magazinesection;

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'ADVERTISEMENT') and @resource-id='com.nytimes.android:id/slug']")
	public MobileElement AdSlug;

	@AndroidFindBy(xpath = "//android.widget.ImageView[@resource-id='com.nytimes.android:id/share_icon']")
	public MobileElement shareicon;

	// This Method is for sending WebElement as Parameter the user want to scroll or
	// Swipe

	public List<MobileElement> SectionNametoSwipeorScroll(String sectionName) {
		String text = "//android.widget.TextView[@text='" + sectionName + "']";
		return driver.findElements(By.xpath(text));

	}

	public void clickOverFlow() {
		overflowIcon.click();
	}

	public void clickHemberger() {
		hemberger.click();
	}

	public void clickSectionname() {
		sectionname.click();
	}

	public boolean checkhembergericon() {
		return hemberger.isDisplayed();
	}

}
