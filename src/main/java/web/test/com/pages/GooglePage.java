package web.test.com.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.log4testng.Logger;
import web.test.com.core.Browser;
import web.test.com.core.DriverFactory;
import web.test.com.core.Log;

public class GooglePage extends BasePage {

	final static Logger logger = Logger.getLogger(GooglePage.class);
	
	private static String HREF = "href";

	@FindBy(name = "q")
	private WebElement searchTextBox;

	@FindBy(how = How.XPATH, using = "//*[@id='nav']//a")
	private List<WebElement> oResultIndexes;

	@FindBy(how = How.CSS, using = "csb.ch")
	private List<WebElement> numResultIndexes;

//	@FindBy(how = How.XPATH, using = "//*[@id='rso']//h3/..")
	@FindBy(how = How.XPATH, using = "//*[@class='r']/a[@href][1]")
	private List<WebElement> resultLinks;

	@FindBy(how = How.ID, using = "flyr")
	private WebElement pageLock;

	public GooglePage() {
		Browser.open();
	}

	/**
	 * type search word in google page and press enter
	 */
	public GooglePage search(String stringToSearch) {
	    Log.info("Search for '" + stringToSearch +"'");
		// new Actions(webDriver).moveToElement(searchTextBox).click().perform(); //DOES NOT WORK WITH FireFox
		searchTextBox.clear();
		searchTextBox.sendKeys(stringToSearch + Keys.RETURN);
		return this;
	}
	
	/**
	 * Pick result page by index
	 */
	public void pickResultPage(String index) {
        Log.info("Pick pagination index " + index);
		try {
			DriverFactory.getWebDriver().findElement(By.linkText(index)).click();
			//waitUntilDisappear(pageLock);
		} catch (Exception e) {
			logger.error(e);
		}
	}

	/**
	 * click result link by number if count from 0 in the current page
	 */
	public void clickResultLink(int linkNum) {
	    Log.info("Click result link " + linkNum);
		resultLinks.get(linkNum).click();
	}

	/**
	 * get all search links from the page and return them as list of strings
	 */
	public List<String> getResultLinks() {
	    Log.info("Get result links from the page");
		List<String> links = new ArrayList<String>();
		for (WebElement link : resultLinks) {
			links.add(link.getAttribute(HREF));
		}
		return links;
	}
}
