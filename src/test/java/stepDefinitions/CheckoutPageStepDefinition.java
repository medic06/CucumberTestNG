package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObjects.CheckoutPage;
import utils.TestContextSetup;

public class CheckoutPageStepDefinition {
	public WebDriver driver;
	public String landingPageProductName;
	public String offersPageProductName;
	public CheckoutPage checkoutPage;

	TestContextSetup testContextSetup;

	public CheckoutPageStepDefinition(TestContextSetup testContextSetup) {
		this.testContextSetup = testContextSetup;
		this.checkoutPage = testContextSetup.pageObjectManager.getCheckoutPage();
	}

	@Then("Verify the user has the abbility to enter promo code and place order")
	public void verify_the_user_has_the_abbility_to_enter_promo_code_and_place_order() {
		Assert.assertTrue(checkoutPage.VerifyPromoButton());
		Assert.assertTrue(checkoutPage.VerifyPlaceOrder());
//		throw new io.cucumber.java.PendingException();
	}

	@Then("^User proceeds to checkout and validate the (.+) items on checkout page$")
	public void user_proceeds_to_checkout_and_validate_the_tom_items_on_checkout_page(String name)
			throws InterruptedException {
		checkoutPage.CheckoutItems();
		Thread.sleep(2000);
	}

}
