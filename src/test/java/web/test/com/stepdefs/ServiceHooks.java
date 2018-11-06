package web.test.com.stepdefs;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import web.test.com.core.Browser;

public class ServiceHooks {
    @After
    public void embedScreenshot(Scenario scenario) {
        Browser.close();
    }
}
