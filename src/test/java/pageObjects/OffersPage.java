package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class OffersPage {
	
	public WebDriver driver;
	
	
	public OffersPage(WebDriver driver){
		this.driver = driver;
	}
	
	private By search = By.cssSelector("input#search-field[type='search']");
	private By productName = By.xpath("//table[@class='table table-bordered']//td[1]");
	
	
	public void searchItem(String shortName) {
		WebElement searchBar = driver.findElement(search);
	    searchBar.sendKeys(shortName);
	}
	
	public String getProductName() {
		return driver.findElement(productName).getText();
	}
}


