package web.test.com.core.browsers;

import io.github.bonigarcia.wdm.EdgeDriverManager;
import org.openqa.selenium.edge.EdgeDriver;

public class Edge extends BaseBrowserType {

    public Edge() {
        EdgeDriverManager.getInstance().setup();
        driver = new EdgeDriver();
    }

}
