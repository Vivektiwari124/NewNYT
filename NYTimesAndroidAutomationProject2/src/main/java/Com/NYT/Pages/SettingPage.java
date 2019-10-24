package Com.NYT.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SettingPage {

	AppiumDriver<MobileElement> driver;

	public SettingPage(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='vivek.tiwari@nytimes.com']")
	MobileElement logindetail;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Log Out']")
	MobileElement Logout;

	@AndroidFindBy(xpath = "//android.widget.ImageButton[@content-desc='Navigate up']")
	MobileElement Backsection;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Log In or Register']")
    public MobileElement LoginorRegitser;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Notifications']")
	 public MobileElement notification;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Text Size']")
	 MobileElement TextSize;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Video Autoplay']")
	 public MobileElement VideoAutoplay;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='English Edition']")
	 MobileElement EnglishEdition;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='NYT en Español']")
	 MobileElement SpanishEsiction;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Background Update']")
	 public MobileElement BackgroundUpdate;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Offline Reading']")
	public MobileElement Offlinereading;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Image Download Settings']")
	public MobileElement ImageDownload;
	
	@AndroidFindBy(xpath = "//android.widget.ImageButton[@index='0']")
	public MobileElement backButton;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
	public MobileElement Settingtext;

	@AndroidFindBy(xpath = "//android.widget.Button[@text='LOG OUT']")
	public MobileElement LogoutPopup;
	
	@AndroidFindBy(id = "com.nytimes.android:id/cancel_button")
	public MobileElement CancelButton;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@index='0']")
	public MobileElement Radiobutton1;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@index='1']")
	public MobileElement Radiobutton2;
	
	@AndroidFindBy(xpath = "//android.widget.RadioButton[@index='2']")
	public MobileElement Radiobutton3;
	
	@AndroidFindBy(id = "com.nytimes.android:id/pref_bottom_sheet_cancel")
	public MobileElement SheetCancelbutton;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='About the Application']")
	public MobileElement AboutApplication;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='About Our Team']")
	public MobileElement AboutTeam;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='NYT Experiments']")
	public MobileElement NYTExperiment;
	
	

	@FindBy(xpath = "//android.widget.TextView[@text='NYT Experiments']")
	List<MobileElement> allelements;
	public List<MobileElement> getGroupName() {
		return allelements;

	}

	public void clickLogin() {
		LoginorRegitser.click();
	}

	public void clicklogoutoption() {
		Logout.click();
	}
	
	public void clicklogpopup() {
		LogoutPopup.click();
	}

	public boolean validateLoginorRegister() {
		return LoginorRegitser.isDisplayed();
	}
	public boolean validatenotification() {
		return notification.isDisplayed();
	}
	
	public void clickNotification() {
		notification.click();
	}
	
	public void clickTextSize() {
		TextSize.click();
	}
	
	public void clickCancelButton() {
		CancelButton.click();
	}

	public boolean validateTextSize() {
		return TextSize.isDisplayed();
	}

	public boolean validateVideoAutoPlay() {
		return VideoAutoplay.isDisplayed();
	}
	
	public void clickVideoAutoplay() {
		VideoAutoplay.click();
	}
	
	
	public String readlogindetail() {
		return logindetail.getText();
	}
	
	public void clickRadioButton1() {
		Radiobutton1.click();
	}
	
	public void clickRadioButton2() {
		Radiobutton2.click();
	}
	
	public void clickRadioButton3() {
		Radiobutton3.click();
	}

	public void clickSheetCancel() {
		SheetCancelbutton.click();
	}
}
