package web.test.com.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import web.test.com.core.Browser;
import web.test.com.core.Log;

public class GoogleSearchPage extends BasePage {

	@FindBy(name = "q")
	private WebElement searchTextBox;

	public GoogleSearchPage() {
		Browser.open();
	}

	public GoogleResultsPage search(String stringToSearch) {
		Log.info("Search for '" + stringToSearch +"'");
		searchTextBox.clear();
		searchTextBox.sendKeys(stringToSearch + Keys.RETURN);
		return new GoogleResultsPage();
	}

}
