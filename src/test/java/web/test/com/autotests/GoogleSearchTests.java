package web.test.com.autotests;

import org.testng.annotations.*;
import web.test.com.core.Browser;
import web.test.com.core.Log;
import web.test.com.core.TestListener;
import web.test.com.core.Utils;
import web.test.com.pages.GooglePage;
import static org.testng.Assert.assertTrue;

@Listeners({TestListener.class})
public class GoogleSearchTests {
	
	@Test(description = "Open the first link on search results page. Verify that title contains searched word.")
	@Parameters({ "searchWord", "resultLink" })
	public void searchWordInTitleForFirstResultLink(
			@Optional("automation") String searchWord,
			@Optional("1") int resultLink
	) {
		new GooglePage()
				.search(searchWord)
				.clickResultLink(resultLink);
		Log.info(String.format("Verify that browser title contains '%s'",searchWord));
		assertTrue(Browser.getTitle().toLowerCase().contains(searchWord),
				String.format("Search word '%s' was not detected in the title", searchWord));
	}

	@Test(description = "Verify that there is expected domain on search results link in the pages.")
	@Parameters({ "searchWord", "domainToCheck", "pageIndexFrom", "pageIndexTo" })
	public void searchDomainWordInResultLinksAndPages(
			@Optional("automation") String searchWord,
			@Optional("www.redhat.com") String domainToCheck,
			@Optional("1") int pageIndexFrom,
			@Optional("5") int pageIndexTo) {
		int detectedDomains = 0;
		GooglePage googlePage = new GooglePage().search(searchWord);
		Log.info(String.format("Verify '%s' domain in the results links from page %s to %s",
				domainToCheck, pageIndexFrom, pageIndexTo));
		for (int page = pageIndexFrom; page <= pageIndexTo; page++) {
			detectedDomains += Utils.checkDomainInResultLinks(googlePage.getResultLinks(), domainToCheck);
			if (page+1 > pageIndexTo) break;
			else googlePage.pickResultPage(Integer.toString(page+1));
		}

		assertTrue(detectedDomains > 0,
				String.format("Domain '%s' isn't in the result links from page %s to page %s",
					domainToCheck,
					pageIndexFrom,
					pageIndexTo));
	}
	
	@AfterMethod
	public void close() {
		Browser.close();
	}
}
