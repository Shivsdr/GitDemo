package stepDefinitions;




import org.testng.Assert;


import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import utils.TestContextSetup;

//Factory Design Pattern  

public class OfferPageStepDefinitions {
	

	
	TestContextSetup testContextSetup;
	public String offersPageProductName;
	
	public OfferPageStepDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
	}

	
	@Then("^user searched for the (.+) shortname in offers page$")
	public void user_searched_for_the_same_shortname_in_offers_page(String shortName) {
		switchToOffersPage();
	    OffersPage offersPage = testContextSetup.pageObjectManager.getoffersPage();
	    offersPage.searchItem(shortName);
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    offersPageProductName = offersPage.getProductName();
	    System.out.println("Top deals Result:- "+offersPageProductName);
	    
	}
	
	public void switchToOffersPage() {
		//if(testContextSetup.driver.getCurrentUrl().equalsIgnoreCase("https://rahulshettyacademy.com/seleniumPractise/#/offers"))
//		LandingPage landingPage = new LandingPage(testContextSetup.driver);
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
	    landingPage.selectTopDealsPage();
	    testContextSetup.genericUtils.switchWindowToChild();
	    
	}
	
	
	@Then("validate product name in offer page matches with Landing Page")
	public void validate_product_name_in_offer_page_matches_with_Landing_Page() throws InterruptedException {
		
        Thread.sleep(1000);
		Assert.assertEquals(offersPageProductName, testContextSetup.landingPageProductName, "Name MisMatch");
		
		
	}
}
