// Contains the locators and methods for the landing page elements

package gerimedica.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    
    WebDriver driver;

    //Constructor will ve called with the object is created, to assign the driver
	public LandingPage(WebDriver driver) {
		this.driver=driver;
	}

    //Locator for cookies
	By CookiesButton = By.className("cookie-banner-button");
    //Locator for collection page link
    By CollectionLink = By.xpath("//*[@id='vgm-app']/div/main/section/section/article[7]/section[1]/ul/li[1]/a");
    

    //Method to click cookies button
	public void clickCookies() {
		driver.findElement(CookiesButton).click();
	}

    //Method to click collections button
	public void clickCollectionLink() {
		driver.findElement(CollectionLink).click();
	}

	//method to wait until the header element of the collections page is located

}
