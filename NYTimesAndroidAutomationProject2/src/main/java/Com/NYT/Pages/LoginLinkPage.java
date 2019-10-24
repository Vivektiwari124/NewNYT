package Com.NYT.Pages;

import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginLinkPage {

	AppiumDriver<MobileElement> driver;

	public LoginLinkPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Log in with email instead »']")
	public MobileElement loginWithEmaillink;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@index='0']")
    public MobileElement backbutton;
	
	public void clickLoginLink() {
		loginWithEmaillink.click();
	}
	
	public void clickBackButton() {
		backbutton.click();
	}

}
