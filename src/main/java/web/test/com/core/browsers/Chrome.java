package web.test.com.core.browsers;

import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Chrome extends BaseBrowserType {

    public Chrome() {
        ChromeDriverManager.getInstance().setup();
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
    }

}
