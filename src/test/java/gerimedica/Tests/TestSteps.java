//contains all the test methods called by the cucumber feature files

package gerimedica.Tests;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.text.NumberFormat;
import java.text.ParseException;
import java.time.Duration;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import gerimedica.Pages.CollectionPage;
import gerimedica.Pages.LandingPage;

public class TestSteps {

    LandingPage landingPage;
    CollectionPage collection;
    WebDriver driver;

    @Given("Open the browser and launch the {string}")
    public void open_the_browser_and_launch_the_website(String URL) {
    
        //Instantiating chrome driver
		driver = new ChromeDriver();
		//Opening Van Gogh Website
		driver.get(URL);
		//maximize the window
		driver.manage().window().maximize();

		//Creating object of Landing page and passing the driver
		landingPage = new LandingPage(driver);
		
		//Creating object of Collection page and passing the driver
		 collection = new CollectionPage(driver);

    }

    @When("Click the link to the collection page")
    public void click_the_link_to_the_collection_page() {
    
        //click the cookies banner because it will be in the way
		landingPage.clickCookies();
	
		//locate the collection link element and click it
		landingPage.clickCollectionLink();

		//wait until the header element of the collections page is located
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated((collection.searchBox)));
    
    }

    @Then("Verify the page title is {string}, page header is {string} and page URL is {string}")
    public void verify_the_page_title(
    String testDataTitle, String testDataHeader, String testDataURL) 
        {
    
        //get the text of the header h1 element
		String headerText = collection.getHeaderText();
    	//get the page title
		String title = driver.getTitle();
		//get the page URL
        String currentURL = collection.getPageURL();

        //ensure the page title is Collectie - Van Gogh Museum, the header is Collections and the URL matches the one declared in the page object.
		Assert.assertEquals(title, testDataTitle);
		Assert.assertEquals(headerText, testDataHeader);
        Assert.assertEquals(currentURL, testDataURL);

        }

    
    @When("Select the search box and enter {string}")
	public void Select_the_search_box_and_enter_query(String searchQuery) {

        //click the cookies banner because it will be in the way
		collection.clickCookies();

		//enter the search term to the search box and press enter to search
        collection.performSearch(searchQuery);
    
	}

    //2nd test, verify there are more that 700 results

    Integer testAmount;

    @Then("Get the amount of results and verify the number is higher than amount {string}")
	public void get_the_amount_of_results_and_verify_the_number_is_higher_than_amount(String testScenarioAmount) throws ParseException {

		Integer testDataAmount = Integer.parseInt(testScenarioAmount);

		//wait until the result counter element of the collections page is located
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(collection.firstSearchResult));

        //Get the text property from the result counter element
        String resultsCounter = collection.getResultsText();

        //Get the number part of the string, discard the rest (NumberFormat class will only parse the string until it reaches a non-parseable character) and convert to INT
        testAmount = ((Number)NumberFormat.getInstance().parse(resultsCounter)).intValue();

		//ensure the amount is greater than 700
		Assert.assertTrue("More than 700 results", testAmount > testDataAmount);
	}

    //3rd test verify the search result image data

    @Then("Click on the first result collect and verify image data against test data 1st label {string}, 1st value {string}, 2nd label {string}, 2nd value {string}, 3rd label {string}, 3rd value {string}")                                   
	public void Click_on_the_first_result_collect_and_verify_image_data_against_test_data(
        String firstLabel, String firstValue, 
        String secondLabel, String secondValue,
        String thirdLabel, String thirdValue) throws InterruptedException{

        //wait a second for results to load after entering a search query
        Thread.sleep(1000);

        //Get the the first result and click it
        collection.clickFirstSearchResult();

        //wait until the object gegevens element of the specific item page is located
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOfElementLocated(collection.objectGegevens));

        //Click the object gegevens web element
        WebElement objectGegevens =  collection.getObjectGegevensElement();

        //Required to scroll down to bring an element within Viewport
        JavascriptExecutor js = (JavascriptExecutor) driver;
        
        //Scroll into view of the web element we want to click
        js.executeScript("arguments[0].scrollIntoView();", objectGegevens); 

        //wait a second for the scroll to occur
        Thread.sleep(1000);

        //click the webElement
        objectGegevens.click();

        //collect all the web elements product info labels
        List<WebElement> labels = collection.getListOfInfoLabels();
        //collect all the web elements product info values
        List<WebElement> values = collection.getListOfInfoValues();

		//assert that the correct labels and values are listed
        Assert.assertEquals(labels.get(0).getText(), firstLabel);
		Assert.assertEquals(values.get(0).getText(), firstValue);
        Assert.assertEquals(labels.get(1).getText(), secondLabel);
		Assert.assertEquals(values.get(1).getText(), secondValue);
        Assert.assertEquals(labels.get(2).getText(), thirdLabel);
		Assert.assertEquals(values.get(2).getText(), thirdValue);
        
    }

    @And("Close the browser")
    public void close_the_browser() {
        //quit the driver
		driver.quit();

    }

}
