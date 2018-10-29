package web.test.com.core.browsers;

import io.github.bonigarcia.wdm.FirefoxDriverManager;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Firefox extends BaseBrowserType {

    public Firefox() {
        FirefoxDriverManager.getInstance().setup();
        driver = new FirefoxDriver();
    }

}
