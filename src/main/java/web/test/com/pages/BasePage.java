package web.test.com.pages;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import web.test.com.core.Configuration;
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
	protected WebElement scrolIntoView(WebElement webElement) {
		((JavascriptExecutor) DriverFactory.getWebDriver()).executeScript("arguments[0].scrollIntoView(true)", webElement);
		return webElement;
	}

	/**
	 * wait until page in ready state for the next actions
	 */
	public void waitPageReady() {
		new WebDriverWait(DriverFactory.getWebDriver(), Long.getLong(Configuration.data.getWaitTimeSeconds()))
				.until((ExpectedCondition<Boolean>) d -> ((JavascriptExecutor) d)
						.executeScript("return document.readyState").equals("complete"));
	}

	/**
	 * wait until element is clickable in the page
	 * @param webElement element to wait
	 * @return webElement for the next actions
	 */
	public WebElement waitUntilClickable(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getWebDriver(), Long.getLong(Configuration.data.getWaitTimeSeconds()));
		wait.until(ExpectedConditions.elementToBeClickable(webElement));
		wait.until(ExpectedConditions.visibilityOf(webElement));
		return webElement;
	}

	/**
	 * wait until element disappear from the page
	 * @param webElement - element should disappear
	 */
	public void waitUntilDisappear(WebElement webElement) {
		WebDriverWait wait = new WebDriverWait(DriverFactory.getWebDriver(), Long.getLong(Configuration.data.getWaitTimeSeconds()));
		wait.until(ExpectedConditions.invisibilityOf(webElement));
	}

}
