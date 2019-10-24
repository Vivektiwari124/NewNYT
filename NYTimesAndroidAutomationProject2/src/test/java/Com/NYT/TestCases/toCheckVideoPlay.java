package Com.NYT.TestCases;

import org.testng.annotations.Test;

import Com.NYT.BasePackage.businessComponent;
import Com.NYT.Pages.HomePage;
import Com.NYT.Pages.SectionList;
import Com.NYT.Pages.VideoPage;

public class toCheckVideoPlay extends businessComponent {

	@Test
	public void checkVideoPlay() throws InterruptedException {
		HomePage h = new HomePage(driver);
		h.clickHemberger();
		Thread.sleep(2000);
		SectionList st = new SectionList(driver);
		st.Videosection.click();

		VideoPage vt = new VideoPage(driver);
		if (vt.videosectionname.isDisplayed() == true) {

			vt.clickFrame();
			Thread.sleep(10000);

			vt.adoverlay.click();
			Thread.sleep(5000);

		}

	}

}
