package Com.NYT.TestCases;

import org.testng.annotations.Test;
import Com.NYT.BasePackage.businessComponent;

public class toVerifyLogin extends businessComponent {

	/*
	 * @DataProvider(name = "Getdata") public static Object[][] credentials() {
	 * return new Object[][] { { prop.getProperty("username"),
	 * prop.getProperty("password") } }; }
	 * 
	 * @Test(dataProvider = "Getdata") public void LoginviaDataProvider(String
	 * uname, String Pass) {
	 * 
	 * HomePage h = new HomePage(driver); h.clickOverFlow(); OverflowMenu ov = new
	 * OverflowMenu(driver); ov.ClickLoginorCreateAccount();
	 * 
	 * LoginLinkPage lp = new LoginLinkPage(driver); lp.clickLoginLink(); LoginPage
	 * lpage = new LoginPage(driver); lpage.EmailField.clear();
	 * lpage.EmailField.sendKeys(uname); lpage.passwordfieldd.clear();
	 * lpage.passwordfieldd.sendKeys(Pass); lpage.loginButton.click();
	 * 
	 * }
	 */

	@Test(priority = 1)
	public void LoginviaSettingOption() {

		try {
			loginviaSettingOption();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Test(priority = 2)
	public void loginSectionList() {
		try {
			loginviaSectionList();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * @Test(priority = 3) public void loginviaOverflowMenu() { try {
	 * loginviaOverflow(); } catch (Exception e) { e.printStackTrace(); } }
	 */

}
