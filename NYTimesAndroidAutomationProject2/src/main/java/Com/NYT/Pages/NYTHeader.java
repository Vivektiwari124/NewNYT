package Com.NYT.Pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class NYTHeader {
	AppiumDriver<MobileElement> driver;

	public NYTHeader(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}
	
	@AndroidFindBy(id = "com.nytimes.android:id/nameplate")
	public MobileElement NYTNameplate;
	
	@AndroidFindBy(xpath = "//android.widget.ImageView[contains(@content-desc,'More options') and @index='0']")
	public MobileElement overflowIcon;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@index='0']")
	MobileElement hemberger;

}
