package web.test.com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import web.test.com.core.DriverFactory;

public abstract class BasePage {

	public BasePage() {
		PageFactory.initElements(DriverFactory.getWebDriver(), this);
	}

	protected WebElement scrollIntoView(WebElement webElement) {
		((JavascriptExecutor) DriverFactory.getWebDriver())
				.executeScript("arguments[0].scrollIntoView(true)", webElement);
		return webElement;
	}

}