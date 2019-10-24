package Com.NYT.TestCases;

import org.testng.annotations.Test;
import Com.NYT.BasePackage.businessComponent;
import ConfigProperties.report;

public class toVerifyHomePageElement extends businessComponent {

	@Test
	public void NYTlogoisDisplayed() throws InterruptedException {

		try {
			

			// Handle Survey
			verifyNYTlogo();
			report.InfoTest(test, "Navigate to customer support Page");
			Thread.sleep(2000);
		
			report.EndTest(test, driver);

		} catch (Exception e) {
			report.InfoTest(test, " message " + e.getMessage());
			report.FailTest(test, driver, "Element not visible ", "Element");
		}
	}
}
