@SearchPage
Feature: Search Page
  As an user
  I want to open browser and navigate to http:\\www.google.com url address

  Scenario: User navigates to page www.google.com
    Given I am on the "Google search" page on URL "www.google.com"
    When I fill in search field with "automation"
    When I click link "0" in the search results page
    Then I should see "automation" in the search results page caption