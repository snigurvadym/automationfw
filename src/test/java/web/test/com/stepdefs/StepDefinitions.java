package web.test.com.stepdefs;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import web.test.com.core.Browser;
import web.test.com.pages.GoogleResultsPage;
import web.test.com.pages.GoogleSearchPage;

import static org.testng.Assert.assertTrue;

public class StepDefinitions {

    private GoogleSearchPage googleSearchPage;

    private GoogleResultsPage googleResultsPage;

    @Given("^I am on the \"([^\"]*)\" page on URL \"([^\"]*)\"$")
    public void i_am_on_the_page_on_URL(String siteName, String siteUrl) {
        googleSearchPage = new GoogleSearchPage();
    }

    @When("^I fill in search field with \"([^\"]*)\"$")
    public void i_fill_in_search_field_with(String searchWord) {
        googleResultsPage = googleSearchPage.search(searchWord);
    }

    @When("^I click link \"([^\"]*)\" in the search results page$")
    public void i_click_link_in_the_search_results_page(String linkNumber) {
        googleResultsPage.clickResultLink(linkNumber);
    }

    @Then("^I should see \"([^\"]*)\" in the search results page caption$")
    public void i_should_see_caption(String searchWord) {
        assertTrue(Browser.getTitle().toLowerCase().contains(searchWord),
                String.format("Search word '%s' was not detected in the title", searchWord));
    }
}