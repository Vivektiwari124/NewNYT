package Com.NYT.BasePackage;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityModelProvider;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import Com.NYT.Pages.CustomizationTemplate;
import Com.NYT.Pages.HomePage;
import Com.NYT.Pages.LoginLinkPage;
import Com.NYT.Pages.LoginPage;
import Com.NYT.Pages.NYTHeader;
import Com.NYT.Pages.OverflowMenu;
import Com.NYT.Pages.SectionList;
import Com.NYT.Pages.SettingPage;
import Com.NYT.Pages.TextSize;
import ConfigProperties.report;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.functions.ExpectedCondition;
import io.appium.java_client.MobileElement;
import io.appium.java_client.PerformsTouchActions;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.ElementOption;
import io.appium.java_client.touch.offset.PointOption;

public class businessComponent extends BasePackage {

	public void verifyNYTlogo() {
		HomePage h = new HomePage(driver);
		boolean flag = h.checkhembergericon();
		// Assert.assertTrue(flag, "Logo is displayed");
		if (flag == true) {
			report.PassTest(test, "nytlogo is present");
		}

	}

	public void checkSections() throws InterruptedException {
		HomePage h = new HomePage(driver);
		h.clickHemberger();
		SectionList st = new SectionList(driver);
		st.clickSearch();
		Thread.sleep(2000);
	}

	public void validateSettingOption1(MobileElement element) {
		SettingPage st = new SettingPage(driver);
		LoginLinkPage lp = new LoginLinkPage(driver);
		if (element.isDisplayed() == true) {
			// Assert.assertTrue(element.isDisplayed());
			element.click();
			lp.clickBackButton();

		} else {
			System.out.println(element + "with this Xpath is not displayed");
		}
	}

	public void validateSettingOption2(MobileElement element) {
		SettingPage st = new SettingPage(driver);

		if (element.isDisplayed() == true) {
			Assert.assertTrue(element.isDisplayed());
			element.click();
			st.clickRadioButton1();
			st.clickRadioButton2();
			st.clickSheetCancel();

		} else {
			System.out.println("Element is not displayed");
		}
	}

	public void checkSettingoption() throws InterruptedException {

		HomePage hp = new HomePage(driver);
		hp.clickOverFlow();
		Thread.sleep(2000);
		OverflowMenu ov = new OverflowMenu(driver);
		ov.clickSetting();
		Thread.sleep(2000);
		SettingPage st = new SettingPage(driver);

		validateSettingOption1(st.LoginorRegitser);
		validateSettingOption1(st.notification);
		validateSettingOption2(st.VideoAutoplay);
		validateSettingOption2(st.BackgroundUpdate);
		validateSettingOption2(st.Offlinereading);
		validateSettingOption2(st.ImageDownload);
		scrollMethod();

		validateSettingOption1(st.AboutApplication);
		validateSettingOption1(st.AboutTeam);
		validateSettingOption1(st.NYTExperiment);

	}

	public void swipeSectionFront() {
		try {

			Dimension dim = driver.manage().window().getSize();
			int height = dim.getHeight();
			int width = dim.getWidth();

			// int stx = width / 2;
			// int ex = width / 2;
			// int sty = (int) (height * .40);
			// int ey = (int) (height * .10);

			int stx = (int) (dim.getWidth() * 0.40);
			int ex = (int) (dim.getWidth() * 0.05);
			int sty = height / 2;
			int ey = height / 2;
			new TouchAction((PerformsTouchActions) driver).press(PointOption.point(stx, sty))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(2))).moveTo(PointOption.point(ex, ey))
					.release().perform();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void clicksection(MobileElement section) {
		section.click();
	}

	public void swipeSectionFronthorizontal() throws InterruptedException {

		
		 /* HomePage home= new HomePage(driver); 
		  clicksection(home.mostpapular);
		  Thread.sleep(2000);
		  clicksection(home.sectionname); 
		  Thread.sleep(2000);
		  clicksection(home.world); 
		  Thread.sleep(2000); 
		  clicksection(home.ussection);
		  Thread.sleep(2000); 
		  clicksection(home.business); 
		  Thread.sleep(2000);
		  clicksection(home.sports); 
		  Thread.sleep(2000); 
		  clicksection(home.arts);
		  Thread.sleep(2000);
		  clicksection(home.newyork); 
		  Thread.sleep(2000);*/
		 

		HomePage h = new HomePage(driver);
		while (elementIsDislplayed(h.magazinesection) == false) {
			//swipeSectionFront();
			swipeHomePage();
			if (elementIsDislplayed(h.magazinesection) == true) {
				Assert.assertTrue(elementIsDislplayed(h.magazinesection));
				break;
			}
		}

	}

	public void swipeMethodUsingList() throws InterruptedException {
		HomePage h = new HomePage(driver);
		int len = 0;
		while (len == 0) {
			List<MobileElement> sectionelement = (List<MobileElement>) h
					.SectionNametoSwipeorScroll(prop.getProperty("SwipeSection"));
			len = sectionelement.size();
			System.out.println(len);
			swipeSectionFront();
			if (len > 0) {

				Thread.sleep(5000);
				for (MobileElement mobileElement : sectionelement) {
					System.out.println(
							"Section swiped is Completed  till " + mobileElement.getText() + "   " + "section");
				}
				break;
			}
		}

	}

	public static boolean elementIsDislplayed(MobileElement element) {
		boolean flag = false;
		try {
			flag = element.isDisplayed();
		} catch (Exception e) {
			flag = false;
		}
		return flag;
	}

	public static void scrollHomePageVertical() throws InterruptedException {

		HomePage h = new HomePage(driver);
		while (elementIsDislplayed(h.Opinionsection) == false) {
			scrollMethod();
			// verticalSwipeByPercentages(0.6, 0.3, 0.5);
			// scrollTillElement();
			if (elementIsDislplayed(h.Opinionsection) == true) {
				Assert.assertTrue(elementIsDislplayed(h.Opinionsection),
						"'" + h.Opinionsection + "' section is displayed");
				break;
			}
		}

		/*
		 * HomePage h = new HomePage(driver); int len = 0; while (len == 0) {
		 * List<MobileElement> sectionelement = (List<MobileElement>) h
		 * .SectionNametoSwipeorScroll(prop.getProperty("scrollsection")); len =
		 * sectionelement.size(); scrollMethod(); if (len > 0) { break; } }
		 */
	}

	public static void scrollSettingPage() {
		SettingPage st = new SettingPage(driver);
		int len = 0;
		while (len == 0) {
			len = st.getGroupName().size();
			scrollMethod();
			if (len > 0) {
				break;
			}
		}
	}

	public void checkSeekBar() {

		NYTHeader header = new NYTHeader(driver);
		header.overflowIcon.click();

		OverflowMenu ov = new OverflowMenu(driver);
		ov.clickTextSize();

		MobileElement seekBar = driver.findElement(By.id("com.nytimes.android:id/fontDlgSeekBar"));// Get start point of
																									// // seekbar.
		int startX = seekBar.getLocation().getX();
		System.out.println(startX); // Get end point of seekbar.
		int endX = seekBar.getSize().getWidth();
		System.out.println(endX);// Get vertical location of seekbar.
		int yAxis = seekBar.getLocation().getY();// Set slidebar move to position.this number is calculated based on //
													// (offset + 3/4width)
		int moveToXDirectionAt = 1000 - startX;
		System.out.println("Moving seek bar at " + moveToXDirectionAt + " In X direction."); // Moving seekbar
																								// usingTouchAction
																								// class.
		new TouchAction((PerformsTouchActions) driver).longPress(PointOption.point(startX, yAxis))
				.moveTo(PointOption.point(moveToXDirectionAt, yAxis)).release().perform();
		TextSize tsize = new TextSize(driver);
		tsize.ApplyButton.click();

	}

	/*
	 * public void SeekBarrTest() { NYTHeader header = new NYTHeader(driver);
	 * header.overflowIcon.click();
	 * 
	 * OverflowMenu ov = new OverflowMenu(driver); ov.clickTextSize();
	 * 
	 * MobileElement slider =
	 * driver.findElement(By.id("com.nytimes.android:id/fontDlgSeekBar")); int
	 * xAxisStartPoint = slider.getLocation().getX(); int xAxisEndPoint =
	 * xAxisStartPoint + slider.getSize().getWidth(); int yAxis =
	 * slider.getLocation().getY(); TouchAction act = new TouchAction(driver); //
	 * pressed x axis & y axis of seekbar and move seekbar till the end // new
	 * TouchAction((PerformsTouchActions) //
	 * driver).longPress(PointOption.point(xAxisStartPoint, yAxis)) //
	 * .moveTo(PointOption.point(xAxisEndPoint-1, yAxis)).release().perform();
	 * 
	 * //
	 * act.longPress(xAxisStartPoint,yAxis).moveTo(xAxisEndPoint-1,yAxis).release().
	 * perform();
	 * 
	 * }
	 */

	public void dragSeekBarTo(int perc) throws InterruptedException {

		NYTHeader header = new NYTHeader(driver);
		header.overflowIcon.click();
		Thread.sleep(2000);
		OverflowMenu ov = new OverflowMenu(driver);
		ov.clickTextSize();
		MobileElement seekBar = driver.findElement(By.id("com.nytimes.android:id/fontDlgSeekBar"));
		int start = seekBar.getLocation().getX();
		System.out.println("Startpoint - " + start);
		int end = start + seekBar.getSize().getWidth();
		System.out.println("End point - " + end);
		int y = seekBar.getLocation().getY();
		System.out.println("Yaxis - " + y);
		TouchAction action = new TouchAction(driver);
		int moveTo = (int) (end * ((float) perc / 100));
		System.out.println(moveTo);
		action.press(PointOption.point(start, y)).moveTo(PointOption.point(moveTo, y)).release().perform();
		Thread.sleep(2000);
		TextSize tsize = new TextSize(driver);
		tsize.ApplyButton.click();

	}

	public void dragFullSeekbar() throws InterruptedException {
		NYTHeader header = new NYTHeader(driver);
		header.overflowIcon.click();
		Thread.sleep(2000);
		OverflowMenu ov = new OverflowMenu(driver);
		ov.clickTextSize();
		MobileElement seekBar = driver.findElement(By.id("com.nytimes.android:id/fontDlgSeekBar"));
		int start = seekBar.getLocation().getX();
		System.out.println("Startpoint - " + start);
		int end = start + seekBar.getSize().getWidth();
		System.out.println("End point - " + end);
		int y = seekBar.getLocation().getY();
		System.out.println("Yaxis - " + y);

		TouchAction action = new TouchAction(driver);
		action.press(PointOption.point(start, y)).moveTo(PointOption.point(end, y)).release().perform();
		TextSize tsize = new TextSize(driver);
		tsize.ApplyButton.click();
		Thread.sleep(2000);

	}

	public void scrollSectionListVertical() throws InterruptedException {
		HomePage h = new HomePage(driver);
		h.clickHemberger();
		SectionList st = new SectionList(driver);
		while (elementIsDislplayed(st.DealBooksection) == false) {
			scrollMethod();
			// scrollTillElement();
			if (elementIsDislplayed(st.DealBooksection) == true) {
				Thread.sleep(3000);
				Assert.assertTrue(elementIsDislplayed(st.DealBooksection));
				break;
			}
		}

	}

	public void toVerifySectionListItem() {
		HomePage h = new HomePage(driver);
		h.clickHemberger();

		List<MobileElement> ActualSectionList;
		List<String> SectionlistItem = Arrays.asList("Subscribe", "Log In or Create Account", "Podcasts Beta",
				"CUSTOMIZED SECTIONS", "Top Stories", "Most Popular", "World", "U.S.", "Business", "Sports", "Arts",
				"New York", "Magazine", "Video");
		System.out.println("Section list items are" + SectionlistItem);
		System.out.println(SectionlistItem.size());

		SectionList st = new SectionList(driver);
		ActualSectionList = st.getAllSectionlistItem();
		for (MobileElement stitem : ActualSectionList) {
			System.out.println(ActualSectionList.size());
			System.out.println(stitem.getText());
		}

	}

	// if you are using appium client less then 6.0.0 then no need to use
	// pointoption & wait method action method
	// we can directly use press method & in that we can pass Parameters of x axis &
	// y axis & move to method

	public static void scrollMethod() {
		try {

			HomePage h = new HomePage(driver);
			Dimension dim = driver.manage().window().getSize();
			int height = dim.getHeight();
			int width = dim.getWidth();
			int startx = width / 2;
			int endx = width / 2;
			int starty = (int) (dim.getHeight() * 0.55);
			int endy = (int) (dim.getHeight() * 0.15);
			new TouchAction((PerformsTouchActions) driver).press(PointOption.point(startx, starty))
					.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(endx, endy))
					.release().perform();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void scrollTillElement() {
		Dimension dim = driver.manage().window().getSize();
		Double scrollheightstart = dim.getHeight() * 0.5;
		int scrollstart = scrollheightstart.intValue();

		Double scrollheightend = dim.getHeight() * 0.2;
		int scrollend = scrollheightend.intValue();

		new TouchAction((PerformsTouchActions) driver).press(PointOption.point(0, scrollstart))
				.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(0, scrollend))
				.release().perform();

	}

	@SuppressWarnings("unchecked")
	public static void scrollTilltextnClick(String text) {
		((AndroidDriver<MobileElement>) driver).findElementByAndroidUIAutomator(
				"new UIScrollable(new UiSelector).scrollable(true).instance(0)).scrollIntoView(new UiSelector().text(\""
						+ text + "\")).instance(0))")
				.click();
	}

	public void loginviaSettingOption() throws InterruptedException, IOException {

		Thread.sleep(2000);
		HomePage hp = new HomePage(driver);
		hp.overflowIcon.click();
		Thread.sleep(5000);
		OverflowMenu ov = new OverflowMenu(driver);
		ov.Setting.click();
		SettingPage st = new SettingPage(driver);
		st.LoginorRegitser.click();
		LoginLinkPage lp = new LoginLinkPage(driver);
		lp.loginWithEmaillink.click();
		LoginPage lpage = new LoginPage(driver);
		EnterValue(lpage.EmailField, 10, lpage.userName);
		EnterValue(lpage.passwordfieldd, 5, lpage.password);
		lpage.loginButton.click();
		String str = st.readlogindetail();
		System.out.println(str);
		Assert.assertEquals(lpage.userName, str);

		st.clicklogoutoption();
		st.clicklogpopup();
		Thread.sleep(2000);
	}

	public static void EnterValue(MobileElement element, int timeout, String value) {
		LoginPage lp = new LoginPage(driver);
		new WebDriverWait(driver, timeout).until(ExpectedConditions.visibilityOf(element));
		element.sendKeys(value);
	}

	// This Method is used for login flow via Login option displayed in Section list
	public void loginviaSectionList() throws InterruptedException {
		HomePage h = new HomePage(driver);
		h.clickHemberger();
		SectionList st = new SectionList(driver);
		st.clickLogin();
		LoginLinkPage lp = new LoginLinkPage(driver);
		lp.clickLoginLink();

		LoginPage lpage = new LoginPage(driver);
		lpage.ClickonLoginbutton(lpage.userName, lpage.password);
		Thread.sleep(5000);
		h.clickHemberger();
		String str = st.getlogintext();
		System.out.println(str);
		Assert.assertEquals(lpage.userName, str);

	}

	public void loginviaOverflow() throws InterruptedException {

		HomePage h = new HomePage(driver);
		h.clickOverFlow();
		OverflowMenu ov = new OverflowMenu(driver);
		ov.ClickLoginorCreateAccount();

		LoginLinkPage lp = new LoginLinkPage(driver);
		lp.clickLoginLink();

		LoginPage lpage = new LoginPage(driver);
		lpage.ClickonLoginbutton(lpage.userName, lpage.password);

		Thread.sleep(2000);
		h.clickOverFlow();
		Thread.sleep(2000);
		String str = ov.Getlogindetail();
		System.out.println(str);
		Assert.assertEquals(lpage.userName, str);

	}

	public static MediaEntityModelProvider Takescreenshot(String filename) throws IOException {

		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		// Now you can do whatever you need to do with it, for example copy somewhere
		FileUtils.copyFile(scrFile, new File(systemDir + "\\test-output\\" + filename + ".jpg"));
		return null;

	}

	public static String captureScreen() throws IOException {
		TakesScreenshot screen = (TakesScreenshot) driver;
		File src = screen.getScreenshotAs(OutputType.FILE);
		String dest = systemDir + getcurrentdateandtime() + ".png";
		File target = new File(dest);
		FileUtils.copyFile(src, target);
		return dest;
	}

	public static String getcurrentdateandtime() {
		String str = null;
		try {
			DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss:SSS");
			Date date = new Date();
			str = dateFormat.format(date);
			str = str.replace(" ", "").replaceAll("/", "").replaceAll(":", "");
		} catch (Exception e) {

		}
		return str;
	}

	/*
	 * Thread.sleep(2000); scrollSettingPage(); List<MobileElement> element1 =
	 * driver.findElements(By.xpath("//android.widget.TextView")); for
	 * (MobileElement Settingitem2 : element1) { //
	 * System.out.println(Settingitem2.getText()); boolean flag1 =
	 * Settingitem2.isDisplayed(); if (flag1 == true) { System.out.println("Element"
	 * + "    " + Settingitem2.getText() + "   " + "is displayed Successfully"); } }
	 * System.out.println("All Elements displayed successfully");
	 */

	public void manageSections() throws InterruptedException {
		HomePage h = new HomePage(driver);
		h.clickHemberger();
		Thread.sleep(2000);

		SectionList st = new SectionList(driver);
		st.clickEdit();
		Thread.sleep(2000);
		CustomizationTemplate ct = new CustomizationTemplate(driver);
		ct.opinionSecton.click();
		ct.worldSecton.click();
		ct.businessSecton.click();

		ct.clickSave();

	}

	public static void verticalSwipeByPercentages(double startPercentage, double endPercentage,
			double anchorPercentage) {
		Dimension size = driver.manage().window().getSize();
		int anchor = (int) (size.width * anchorPercentage);
		int startPoint = (int) (size.height * startPercentage);
		int endPoint = (int) (size.height * endPercentage);

		new TouchAction(driver).press(PointOption.point(anchor, startPoint))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(anchor, endPoint))
				.release().perform();
	}

	public void swipeHomePage() {
		try {

			Dimension dim = driver.manage().window().getSize();
			
			int height= dim.getHeight();
			int widht=dim.getWidth();
						
			int startx=(int)(widht*0.90);
			int endx=(int)(widht*0.20);
			int y=(int)(height*0.50);

			
			new TouchAction((PerformsTouchActions) driver).press(PointOption.point(startx, y))
					.waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
					.moveTo(PointOption.point(endx, y)).release().perform();

			Thread.sleep(3000);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	public void TestArticleSwipe() throws InterruptedException {
		HomePage hm = new HomePage(driver);
		hm.Articleheader.click();
		Thread.sleep(2000);
		swipeHomePage();
		
	}

}
