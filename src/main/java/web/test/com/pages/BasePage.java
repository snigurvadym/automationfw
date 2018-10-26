package web.test.com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import web.test.com.core.DriverFactory;

public abstract class BasePage {

	public BasePage() {
		PageFactory.initElements(DriverFactory.getWebDriver(), this);
	}

	/**
	 * scroll page to the needed element and return this element for next actions
	 * @param webElement - invisible element or visible partially
	 * @return web element after scrolling
	 */
	protected WebElement scrollIntoView(WebElement webElement) {
		((JavascriptExecutor) DriverFactory.getWebDriver())
				.executeScript("arguments[0].scrollIntoView(true)", webElement);
		return webElement;
	}

}