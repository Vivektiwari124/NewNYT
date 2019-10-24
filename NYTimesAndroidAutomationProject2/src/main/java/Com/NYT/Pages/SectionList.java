package Com.NYT.Pages;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class SectionList {

	AppiumDriver<MobileElement> driver;

	public SectionList(AppiumDriver<MobileElement> driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(this.driver), this);
	}

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Settings']")
	MobileElement Settingtext;

	@AndroidFindBy(id = "com.nytimes.android:id/search")
	MobileElement Search;
	@AndroidFindBy(id = "com.nytimes.android:id/settings")
	MobileElement Settingicon;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Subscribe']")
	MobileElement SubscribeText;
	
	@AndroidFindBy(id = "com.nytimes.android:id/profileSecondary")
	MobileElement loginaccounttext;
	
	@AndroidFindBy(id = "com.nytimes.android:id/profilePrimary")
	MobileElement profileSummary;
	
	@AndroidFindBy(xpath = "com.nytimes.android.debug:id/profilePrimary")
	MobileElement profileSummaryy;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Podcasts Beta']")
	MobileElement podcastText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='CUSTOMIZED SECTIONS']")
	MobileElement CustText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='EDIT']")
	MobileElement EditText;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Home']")
	MobileElement HomeSection;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Most Popular']")
	MobileElement MostPopularSection;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Opinion']")
	MobileElement OpinionSection;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='World']")
	MobileElement WorldSection;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='U.S.']")
	MobileElement USSection;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Business']")
	MobileElement BusinessSection;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Sports']")
	MobileElement SportsSection;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Arts']")
	MobileElement ArtsSection;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='New York']")
	MobileElement NewYorkSection;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Magazine']")
	MobileElement MagazineSection;
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='Video']")
	public MobileElement Videosection;
	
	@AndroidFindBy(xpath = "//android.widget.TextView[@text='DealBook']")
	public MobileElement DealBooksection;
	
	
	@FindBy(xpath = "//android.widget.TextView[@text='DealBook']")
	List<MobileElement> allelements;
	
	public List<MobileElement> getSectionListSectionName() {
		return allelements;

	}
	
	@FindBy(id = "//com.nytimes.android:id/title")
	List<MobileElement> SectionListItem;
	
	public List<MobileElement> getAllSectionlistItem(){
		return  SectionListItem;
	}
	
    public void clickEdit() {
    	EditText.click();
    }

	public void clickSearch() {
		Search.click();
	}

	public void clickSettingicon() {
		Settingicon.click();
	}

	public void clickLogin() {
		loginaccounttext.click();
	}
	
	public String getlogintext()
	{
		return profileSummary.getText();
	}
		
}
