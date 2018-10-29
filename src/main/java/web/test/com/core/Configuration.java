package web.test.com.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private final static String confFile = "src/main/java/web/test/com/resources/config.properties";

    private static Properties properties = new Properties();

    private static InputStream input = null;

    protected static Configuration data = new Configuration();

    private String baseUrl;

    private String browserName;

    private String waitTimeSeconds;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    protected String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    protected String getWaitTimeSeconds() {
        return waitTimeSeconds;
    }

    protected void setWaitTimeSeconds(String waitTimeSeconds) {
        this.waitTimeSeconds = waitTimeSeconds;
    }

    public static void readProperties() {
        try {
            input = new FileInputStream(confFile);
            properties.load(input);

            data.setBaseUrl(properties.getProperty("baseUrl"));
            data.setBrowserName(properties.getProperty("browserName"));
            data.setWaitTimeSeconds(properties.getProperty("waitTimeSeconds"));

        } catch (IOException ex) {
            ex.printStackTrace();
        } finally {
            if (input != null) {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
