package Com.NYT.TestCases;

import org.testng.annotations.Test;

import com.aventstack.extentreports.Status;
import Com.NYT.BasePackage.businessComponent;

public class ToVerifyVerticalScroll extends businessComponent {

	 @Test
	public void ScrollTest() throws InterruptedException {
		scrollHomePageVertical();
		// CheckElementdisplayed();
	}
	
	//@Test
	public void Test2() throws InterruptedException {
		scrollTilltextnClick("CLASH IN WASHINGTON");
		Thread.sleep(3000);
		scrollTilltextnClick("ABORTION");
		Thread.sleep(3000);
		
	}
}
