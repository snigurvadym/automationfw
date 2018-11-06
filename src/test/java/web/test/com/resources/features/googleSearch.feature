@SearchPage
Feature: Search Page
  As an user
  I want to search some term in the http:\\www.google.com page and verify results

  Background: User navigates to http:\\www.google.com page
    Given I am on the "Google search" page on URL "www.google.com"
    When I fill in search field with "automation"

  Scenario: User navigates to page www.google.com and verify caption for first page in the search result
    When I click link "0" in the search results page
    Then I should see "automation" in the search results page caption

  Scenario: User navigates to page www.google.com, search for the word and verify required domain in the result links
    Then I should see "testautomationday.com" in the some result page till pagination "5"
