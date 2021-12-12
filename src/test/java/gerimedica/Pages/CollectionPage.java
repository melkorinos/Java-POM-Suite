// Contains the locators and methods for the collection page elements

package gerimedica.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CollectionPage {
    
    WebDriver driver;

    //Constructor will ve called with the object is created, to assign the driver
	public CollectionPage(WebDriver driver) {
		this.driver=driver;
	}

	//Locator for cookies button
	By CookiesButton = By.className("cookie-banner-button");
    //Locator for page header
    By CollectionsHeader = By.className("page-header-heading");
	//Locator for search box
	public By searchBox = By.className("collection-search-input");
	//Locator for results counter element
	By results	= By.className("collection-art-object-list-results");
	//Locator for the first search result
	public By firstSearchResult = By.className("collection-art-object-wrapper");
	//Locator for Objectgegevens element
	public By objectGegevens = By.className("accordion-item-button");
	//Locator for Objectgegevens info elements
	By objectGegevensInfoLabels = By.className("definition-list-item-label");
	//Locator for Objectgegevens value elements
	By objectGegevensInfoValues = By.className("definition-list-item-value");

	//hello
	//Method to click cookies button
	public void clickCookies() {
		driver.findElement(CookiesButton).click();
	}

    //Method to get page title
	public void getPageTitle() {
		driver.getTitle();
	}

	//Method to get page title
	public String getPageURL() {
		return driver.getCurrentUrl();
	}

    //Method to get the text from the page header
	public String getHeaderText() {
		return driver.findElement(CollectionsHeader).getText();
	}

	//Method to perform a search and press enter to submit it
	public void performSearch(String searchQuery) {
		driver.findElement(searchBox).sendKeys(searchQuery, Keys.ENTER);
	}

	//Method to get the text from the search results element
	public String getResultsText() {
		return driver.findElement(results).getText();
	}
	
	//Method to click cookies button
	public void clickFirstSearchResult() {
		driver.findElement(firstSearchResult).click();
	}

	//method to get the the object gegevens web element
	public WebElement getObjectGegevensElement(){
		return driver.findElement(objectGegevens);
	}

	//method to get the List of WebElements for product labels
	public List<WebElement> getListOfInfoLabels(){
		return driver.findElements(objectGegevensInfoLabels);
	}

	//method to get the List of WebElements for product values
	public List<WebElement> getListOfInfoValues(){
		return driver.findElements(objectGegevensInfoValues);
	}
}
