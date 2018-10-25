package web.test.com.core.browsers;

import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox extends BaseBrowserType {

    public Firefox() {
        driver = new FirefoxDriver();
    }
}
