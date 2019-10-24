package Com.NYT.Pages;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import Com.NYT.BasePackage.BasePackage;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class LoginPage extends BasePackage {

	AppiumDriver<MobileElement> driver;

	public LoginPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Email']")
	public MobileElement EmailField;

	@AndroidFindBy(xpath = "//android.widget.EditText[@text='Password']")
	public MobileElement passwordfieldd;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='Log In']")
	public MobileElement loginButton;

	public String userName = prop.getProperty("username");
	public String password = prop.getProperty("password");

	public void ClickonLoginbutton(String userName, String passwordfield) {
		EmailField.sendKeys(userName);
		passwordfieldd.sendKeys(password);
		loginButton.click();

	}


}
