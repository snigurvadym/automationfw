package web.test.com.core.browsers;

import org.openqa.selenium.ie.InternetExplorerDriver;

public class InternetExplorer extends BaseBrowserType {

    public InternetExplorer() {
        driver = new InternetExplorerDriver();
    }
}
