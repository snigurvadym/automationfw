package web.test.com.autotests;

import org.testng.annotations.Test;
import web.test.com.core.DriverFactory;

public class OtherSiteTests {

	@Test(description = "")
	public void openOtherSiteInBrowser() {
		DriverFactory.getWebDriver();
	}
}
