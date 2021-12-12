Feature: Site navigation

  @firstTest
  Scenario: Verification of functioning link and nagivation to the correct page
    Given Open the browser and launch the "https://www.vangoghmuseum.nl/nl"
    When  Click the link to the collection page
    Then  Verify the page title is "Collectie - Van Gogh Museum", page header is "Collectie" and page URL is "https://www.vangoghmuseum.nl/nl/collectie"
    And   Close the browser