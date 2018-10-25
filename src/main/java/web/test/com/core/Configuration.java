package web.test.com.core;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Configuration {

    private final static String confFile = "src/main/java/web/test/com/resources/config.properties";

    static Properties properties = new Properties();

    static InputStream input = null;
    public static Configuration data = new Configuration();

    private String baseUrl;
    private String browserName;
    private String driverName;
    private String driverPath;
    private String waitTimeSeconds;

    public String getBaseUrl() {
        return baseUrl;
    }

    public void setBaseUrl(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public String getBrowserName() {
        return browserName;
    }

    public void setBrowserName(String browserName) {
        this.browserName = browserName;
    }

    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getDriverPath() {
        return driverPath;
    }

    public void setDriverPath(String driverPath) {
        this.driverPath = driverPath;
    }

    public String getWaitTimeSeconds() {
        return waitTimeSeconds;
    }

    public void setWaitTimeSeconds(String waitTimeSeconds) {
        this.waitTimeSeconds = waitTimeSeconds;
    }

    public static void readProperties() {
        try {
            input = new FileInputStream(confFile);
            properties.load(input);

            data.setBaseUrl(properties.getProperty("baseUrl"));
            data.setBrowserName(properties.getProperty("browserName"));
            data.setDriverName(properties.getProperty("driverName"));
            data.setDriverPath(properties.getProperty("driverPath"));
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
