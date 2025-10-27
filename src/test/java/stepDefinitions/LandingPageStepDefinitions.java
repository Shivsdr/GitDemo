package stepDefinitions;


import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinitions {
	
	public LandingPage landingPage;
	public String landingPageProductName;
	TestContextSetup testContextSetup;
	public LandingPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.landingPage = testContextSetup.pageObjectManager.getLandingPage();
	}
	@Given("User is on GreenCart Landing page")
	public void user_is_on_green_cart_landing_page() {
//		System.setProperty("webdriver.chrome.driver", "absolute path of chromedriver");
//	    testContextSetup.driver = new EdgeDriver();
//	    testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	    Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));
	}
	
	
	@When("^user searched with shortname (.+) and extracted actual name of product$")
	public void user_searched_with_shortname_and_extracted_actual_name_of_product(String shortName) {
		
	    landingPage.searchItem(shortName);
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	    testContextSetup.landingPageProductName = landingPage.getProductName();
	    System.out.println("Product Name from home page:- "+testContextSetup.landingPageProductName);
	    
	    
	}
	
	@When("Added {string} items of the selected products to cart")
	public void added_items_product(String count) throws InterruptedException {
		landingPage.incrementQuantity(Integer.parseInt(count));
		landingPage.addToCart();
		Thread.sleep(2000);
	}
	
	

	
}
