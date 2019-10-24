package Com.NYT.Pages;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class OverflowMenu {

	AppiumDriver<MobileElement> driver;

	public OverflowMenu(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Log In or Create Account']")
	public MobileElement LoginORCreateAccount;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='vivek.tiwari@nytimes.com']")
	public MobileElement UserDetail;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
	public MobileElement Setting;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Text Size']")
	public MobileElement TextSize;
	
	public void clickSetting() {
		Setting.click();
	}
	
	public void clickTextSize() {
		TextSize.click();
	}
	
	public void ClickLoginorCreateAccount() {
		LoginORCreateAccount.click();
	}
	
	public String Getlogindetail() {
		return UserDetail.getText();
	}


}
