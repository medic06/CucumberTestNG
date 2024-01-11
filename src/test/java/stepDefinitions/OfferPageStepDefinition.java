package stepDefinitions;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import io.cucumber.java.en.Then;
import pageObjects.LandingPage;
import pageObjects.OffersPage;
import pageObjects.PageObjectManager;
import utils.TestContextSetup;

public class OfferPageStepDefinition {
	public WebDriver driver;
	public String landingPageProductName;
	public String offerPageProductName;
	TestContextSetup testContextSetup;
	PageObjectManager pageObjectManager;

	public OfferPageStepDefinition(TestContextSetup testContextsetup) {
		this.testContextSetup = testContextsetup;
	}

	@Then("^user searches for the same shortname (.+) on the offers page$")
	public void user_searches_for_the_same_shortname_on_the_offers_page(String shortName) throws InterruptedException {
		switchToOffersPage();
		OffersPage offersPage = testContextSetup.pageObjectManager.OffersPage();
		offersPage.searchItem(shortName);
		Thread.sleep(2000);
		offerPageProductName = offersPage.getProductName();
	}

	public void switchToOffersPage() {
		// LandingPage landingPage = new LandingPage(testContextsetup.driver);
		// landingPage.selectTopDeals();
		LandingPage landingPage = testContextSetup.pageObjectManager.getLandingPage();
		landingPage.selectTopDeals();
		testContextSetup.genericUtils.SwitchWindowToChild();
	}

	@Then("validate product name on landing page and home page match")
	public void validate_product_name_in_offers_page() {
		Assert.assertEquals(offerPageProductName, testContextSetup.landingPageProductName);
	}

}
