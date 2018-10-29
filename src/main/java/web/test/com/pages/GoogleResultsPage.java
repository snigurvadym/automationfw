package web.test.com.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import web.test.com.core.Log;
import web.test.com.core.Utils;
import java.util.ArrayList;
import java.util.List;

public class GoogleResultsPage extends BasePage {

	@FindBy(how = How.XPATH, using = "//*[@class='r']/a[@href]")
	private List<WebElement> resultLinks;

    @FindBy(how = How.XPATH, using = "//*[@class='csb ch']/parent::a")
    private List<WebElement> paginationLinks;

	public int findDomainInResults(String domainToCheck, int pageIndexTo) {
	    int detectedDomains = 0;
        detectedDomains += Utils.checkDomainInResultLinks(getResultLinks(), domainToCheck);
        for (int page = 2; page <= pageIndexTo; page++) {
            pickResultPage(Integer.toString(page));
            detectedDomains += Utils.checkDomainInResultLinks(getResultLinks(), domainToCheck);
        }
	    return detectedDomains;
    }

	private void pickResultPage(String index) {
		Log.info("Pick pagination index " + index);
		try {
            for (WebElement paginationLink:paginationLinks) {
                if (paginationLink.getText().equalsIgnoreCase(index)) {
                    paginationLink.click();
                    break;
                }
            }
		} catch (Exception e) {
			Log.error(e.getMessage());
		}
	}

	public void clickResultLink(int linkNum) {
		Log.info("Click result link " + linkNum);
		resultLinks.get(linkNum).click();
	}

	private List<String> getResultLinks() {
		Log.info("Get result links from the page");
		List<String> links = new ArrayList<String>();
		for (WebElement link : resultLinks) {
			links.add(link.getAttribute("href"));
		}
		return links;
	}
}
