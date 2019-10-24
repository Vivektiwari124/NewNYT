package Com.NYT.Pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class TextSize {
	AppiumDriver<MobileElement> driver;

	public TextSize(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}
	
	@AndroidFindBy(id = "com.nytimes.android:id/apply_button")
	public MobileElement ApplyButton;
	
	@AndroidFindBy(id = "com.nytimes.android:id/cancel_button")
	public MobileElement CancelButton;

	

}
