package Com.NYT.Pages;

import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class CustomizationTemplate {
	AppiumDriver<MobileElement> driver;

	public CustomizationTemplate(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'com.nytimes.android:id/listItem_sectionCustomization_sectionTitle') and @text='Opinion']")
	public MobileElement opinionSecton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'com.nytimes.android:id/listItem_sectionCustomization_sectionTitle') and @text='World']")
	public MobileElement worldSecton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[contains(@resource-id,'com.nytimes.android:id/listItem_sectionCustomization_sectionTitle') and @text='Business']")
	public MobileElement businessSecton;
	
	@AndroidFindBy(id = "android:id/button1")
	public MobileElement Savebutton;
	
	public void clickSave() {
		Savebutton.click();
	}

}
