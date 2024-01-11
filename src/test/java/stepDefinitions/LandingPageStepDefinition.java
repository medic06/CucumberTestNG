package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import pageObjects.LandingPage;
import utils.TestContextSetup;

public class LandingPageStepDefinition {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	TestContextSetup testContextsetup;
	LandingPage landingPage;

	public LandingPageStepDefinition(TestContextSetup testContextsetup) {
		this.testContextsetup = testContextsetup;
		this.landingPage = testContextsetup.pageObjectManager.getLandingPage();
	}

	@Given("user is on the GreenCart landing  page")
	public void user_is_on_the_green_cart_landing_page() throws InterruptedException {
		Assert.assertTrue(landingPage.getTitleLandingPage().contains("GreenKart"));

	}

	@When("^user serches with shortname (.+) and extracted actual name of product$")
	public void user_serches_with_shortname_and_extracted_actual_name_of_product(String shortName)
			throws InterruptedException {
		LandingPage landingPage = testContextsetup.pageObjectManager.getLandingPage();
		landingPage.searchItem(shortName);
		Thread.sleep(2000);
		testContextsetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
		System.out.println(landingPageProductName + " is extracted from Home page");
	}
	
	@When("Added {string} items of the selected product to cart")
		public void Added_product_items(String quantity) {
			landingPage.incrementQuantity(Integer.parseInt(quantity));
			landingPage.addToCart();
		}

}
