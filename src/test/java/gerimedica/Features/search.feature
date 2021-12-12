Feature: Collection page search functionality

    Scenario: Search the collection page with a specific query and verify amount of results

        Given Open the browser and launch the "https://www.vangoghmuseum.nl/nl/collectie"
        When Select the search box and enter "Het Gele Huis"
        Then Get the amount of results and verify the number is higher than amount "700"
        And Close the browser


    Scenario: Search the collection page,get the first result and verify it is accurate

        Given Open the browser and launch the "https://www.vangoghmuseum.nl/nl/collectie"
        When Select the search box and enter "Het Gele Huis"
        Then Click on the first result collect and verify image data against test data 1st label "F-nummer", 1st value "F0464", 2nd label "JH-nummer", 2nd value "JH1589", 3rd label "Inventarisnummer", 3rd value "s0032V1962"
        And  Close the browser