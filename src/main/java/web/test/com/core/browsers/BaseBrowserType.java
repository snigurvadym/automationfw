package web.test.com.core.browsers;

import org.openqa.selenium.WebDriver;

abstract class BaseBrowserType {

    WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }
}
