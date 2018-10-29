package web.test.com.core;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.BrowserType;
import org.testng.Reporter;
import web.test.com.core.browsers.Chrome;
import web.test.com.core.browsers.Edge;
import web.test.com.core.browsers.Firefox;

public class DriverFactory {

    private static ThreadLocal<WebDriver> webDriver = new ThreadLocal<>();

    static void setWebDriver(WebDriver driver) {
        webDriver.set(driver);
    }

    public static WebDriver getWebDriver(boolean createDriver) {
        if (createDriver) {
            return getWebDriver();
        }
        return webDriver.get();
    }

    public static WebDriver getWebDriver() {
        if (webDriver.get()==null) {
            Configuration.readProperties();
            String browserToUse=Configuration.data.getBrowserName();
            Log.info("Instantiate web driver " + browserToUse);
            try {
                switch (browserToUse) {
                    case BrowserType.CHROME : {
                        setWebDriver(new Chrome().getDriver());
                        break;
                    }
                    case BrowserType.FIREFOX : {
                        setWebDriver(new Firefox().getDriver());
                        break;
                    }
                    case BrowserType.EDGE : {
                        setWebDriver(new Edge().getDriver());
                        break;
                    }
                    default: {
                        Log.error("This browser is not defined!");
                        Reporter.log("Browser is not defined in the framework.");
                    }
                }
                int waitTimeForAppear = Integer.valueOf(Configuration.data.getWaitTimeSeconds());
                webDriver.get().manage().timeouts().implicitlyWait(waitTimeForAppear, TimeUnit.SECONDS);
                if (!browserToUse.equalsIgnoreCase(BrowserType.FIREFOX)) {
                    webDriver.get().manage().timeouts().pageLoadTimeout(waitTimeForAppear, TimeUnit.SECONDS);
                }
                webDriver.get().manage().window().maximize();
                webDriver.get().get(Configuration.data.getBaseUrl());
            } catch (Exception e) {
                Log.error("Fail to initialize WebDriver!");
            }
        }
        return webDriver.get();
    }
}