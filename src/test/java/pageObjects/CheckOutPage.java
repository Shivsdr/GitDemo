package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CheckOutPage {
	 public WebDriver driver;
	public CheckOutPage(WebDriver driver) {
		this.driver = driver;
	}
	
	private By cartBtn = By.cssSelector("img[alt='Cart']");
	private By proceedToCheckOutBtn = By.xpath("//button[text()='PROCEED TO CHECKOUT']");
	
	private By firstItemInCart = By.xpath("//p[@class='product-name']");
	
	
	private By promoApplyBtn = By.cssSelector("button.promoBtn");
	private By placeOrderBtn = By.xpath("//button[text()='Place Order']");
	
	
	public void CheckoutItems() throws InterruptedException {
		driver.findElement(cartBtn).click();
		Thread.sleep(1000);
		driver.findElement(proceedToCheckOutBtn).click();
		
	}
	
	public boolean verifyItemInCheckOutPage(String name) {
		String Item = driver.findElement(firstItemInCart).getText().split("-")[0];
		return Item.contains(name);
	}
	
	public boolean verifyPromoBtn() {
		return driver.findElement(promoApplyBtn).isDisplayed();
	}
	
	public boolean verifyPlaceOrder() {
		return driver.findElement(placeOrderBtn).isDisplayed();
	}
	
	

}
