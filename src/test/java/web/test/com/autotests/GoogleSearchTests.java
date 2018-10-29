package web.test.com.autotests;

import org.testng.annotations.*;
import web.test.com.core.Browser;
import web.test.com.core.TestListener;
import web.test.com.pages.GoogleSearchPage;
import static org.testng.Assert.assertTrue;

@Listeners({TestListener.class})
public class GoogleSearchTests {

	@Test(description = "Open the first link on search results page. Verify that title contains searched word.")
	@Parameters({ "searchWord" })
	public void searchWordInTitleForFirstResultLink(
			@Optional("automation") String searchWord
	) {
		byte firstLinkIndex = 0;
		new GoogleSearchPage()
				.search(searchWord)
				.clickResultLink(firstLinkIndex);
		assertTrue(Browser.getTitle().toLowerCase().contains(searchWord),
				String.format("Search word '%s' was not detected in the title", searchWord));
	}

	@Test(description = "Verify that there is expected domain on search results link in the pages.")
	@Parameters({ "searchWord", "domainToCheck", "pageIndexTo" })
	public void searchDomainWordInResultLinksAndPages(
			@Optional("automation") String searchWord,
			@Optional("www.redhat.com") String domainToCheck,
			@Optional("5") int pageIndexTo) {
		assertTrue(
		        new GoogleSearchPage()
                        .search(searchWord)
                        .findDomainInResults(domainToCheck,pageIndexTo) > 0,
				String.format("Domain '%s' isn't in the result links from first page to page %s",
						domainToCheck,
						pageIndexTo));
	}

	@AfterMethod
	public void close() {
		Browser.close();
	}
}
