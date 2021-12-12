# Gerimedica Selenium Web Driver assessment
Create a maven project in java that contains pageObject java classes, testCases java classes and utils java classes (if needed) to test the following test cases in the website of Van Gogh Museum. 

## Solution

The solution contains the following elements:  
- 2 cucumber feature files (site navigation feature and collection page search feature) which define the test steps
- 1 java file containing the test methods
- 1 test runner java file 
- 2 java files generating page object instances for the landing page and the collection page

To run the suite please add include the ChromeDriver location in your PATH environment variable, load the solution in your preferred IDE and run `mvn test` for all tests OR `mvn test -Dcucumber.filter.tags="@SCENARIO_NAME"` and replace scenario name with a test tag name to run a specific scenario.  

Future improvements:  
- Implement parallel execution  
- Split test steps into multiple files  
- Remove remaining Thread.Sleep calls

## Test Scenarios

**Scenario #1 :** Verification of functioning link and nagivation to the correct page  
**Expected result :** The site properly nagivates the user to the collection page after he clicks the link  
**Test Steps :** Landing page -> Click Ontdek de collectie -> Verify page URL,title and header text matches the test data

**Scenario #2 :** Search the collection page with a specific query and verify amount of results  
**Expected result :** The search results should be more than 700  
**Test Steps :** Collection page -> Enter query in search field -> Get the amount of results from the appropriate web element -> Verify the number is higher than 700.

**Scenario #3 :** Search the collection page,get the first result and verify it is accurate  
**Expected result :** The image data should match the image data of the test case   
**Test Steps :** Collection page -> Enter query in search field -> Click on first result -> Nagivate to the data section -> Collect image data -> Verify collected data matches the image data of the test case 





