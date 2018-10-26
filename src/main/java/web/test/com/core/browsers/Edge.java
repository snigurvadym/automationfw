package web.test.com.core.browsers;

import org.openqa.selenium.edge.EdgeDriver;

public class Edge extends BaseBrowserType {
    public Edge() {
        driver = new EdgeDriver();
    }
}
