package web.test.com.core;

public class Browser {

    public static void open() {
        Log.info("Open browser");
        DriverFactory.getWebDriver();
    }

    public static String getTitle() {
        Log.info("Get browser title");
        return DriverFactory.getWebDriver().getTitle();
    }

    public static void close() {
        Log.info("Close browser");
        if (DriverFactory.getWebDriver(false)!=null) {

            DriverFactory.getWebDriver().quit();
            DriverFactory.setWebDriver(null);
        }
    }
}