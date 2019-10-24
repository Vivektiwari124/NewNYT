package Com.NYT.Pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class VideoPage {
	AppiumDriver<MobileElement> driver;

	public VideoPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}
	
	@AndroidFindBy(id = "com.nytimes.android:id/sf_photo_video")
	public MobileElement videoarticle;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@text,'VIDEO') and @index='0']")
	public MobileElement videosectionname;
	
	@AndroidFindBy(id = "com.nytimes.android:id/sf_photo_video")
	public MobileElement videoframe;
	
	@AndroidFindBy(id = "com.nytimes.android:id/ad_overlay")
	public MobileElement adoverlay;

	
	public void clickFrame() {
		videoframe.click();
	}
	
	public void clickadoverlay() {
		adoverlay.click();
	}

	



}
