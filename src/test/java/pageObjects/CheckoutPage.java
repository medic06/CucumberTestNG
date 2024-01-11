package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CheckoutPage {
	public WebDriver driver;

	public CheckoutPage(WebDriver driver) {
		this.driver = driver;
	}

	By cart = By.cssSelector("[alt='Cart']");
	By checkOutButton = By.xpath("//button[contains(text(),'PROCEED TO CHECKOUT')]");
	By promoApplyButton = By.cssSelector(".promoBtn");
	By placeOrderButton = By.xpath("//button[contains(text(), 'Place Order')]");

	public void CheckoutItems() {
		driver.findElement(cart).click();
		driver.findElement(checkOutButton).click();
	}

	public boolean VerifyPromoButton() {
		return driver.findElement(promoApplyButton).isDisplayed();
	}

	public boolean VerifyPlaceOrder() {
		return driver.findElement(placeOrderButton).isDisplayed();
	}

}
