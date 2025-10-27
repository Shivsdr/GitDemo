package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LandingPage {
	 public WebDriver driver;
	public LandingPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By search = By.cssSelector("input.search-keyword");
	private By productName = By.cssSelector("h4.product-name");
	private By topDeals = By.xpath("//a[text()='Top Deals']");
	private By incrementBtn = By.cssSelector("a.increment");
	private By addToCartBtn = By.cssSelector("div.product-action button");
	
	
	public void searchItem(String shortName) {
		WebElement searchBar = driver.findElement(search);
	    searchBar.sendKeys(shortName);
	}
	
	public String getProductName() {
		WebElement firstResult = driver.findElement(productName);
		return firstResult.getText().split("-")[0].trim();
	}
	
	public void selectTopDealsPage() {
		driver.findElement(topDeals).click();
	}
	
	public String getTitleLandingPage() {
		return driver.getTitle();
	}
	
	public void incrementQuantity(int quantity) {
		while(quantity>1) {
			driver.findElement(incrementBtn).click();
			quantity--;
		}
	}
	
	public void addToCart() {
		driver.findElement(addToCartBtn).click();
	}
}
