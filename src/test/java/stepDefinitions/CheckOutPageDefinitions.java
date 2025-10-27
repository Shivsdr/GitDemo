package stepDefinitions;


import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckOutPage;
import utils.TestContextSetup;


public class CheckOutPageDefinitions {
	
	
	public String landingPageProductName;
	TestContextSetup testContextSetup;
	CheckOutPage checkOutPage;
	public CheckOutPageDefinitions(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkOutPage = testContextSetup.pageObjectManager.getCheckOutPage();
	}
	
	@Then("^User proceeds to Checkout and validate the (.+) items in checkout page$")
	public void User_proceeds_to_Checkout_and_validate_the_items_in_checkout_page(String name) throws InterruptedException{
		
		checkOutPage.CheckoutItems();
		Thread.sleep(2000);
		System.out.println("Name in assertion:- "+name);
		Assert.assertTrue(checkOutPage.verifyItemInCheckOutPage(name));
	}
	
	@Then("verify the user has ability to enter promo code and place order")
	public void verify_the_user_has_ability_to_enter_promo_code_and_place_order() {
		
		Assert.assertTrue(checkOutPage.verifyPromoBtn()); 
		Assert.assertTrue(checkOutPage.verifyPlaceOrder()); 
	}
	

	
}
