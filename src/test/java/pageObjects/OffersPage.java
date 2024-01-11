package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import utils.TestBase;
import utils.TestContextSetup;

public class OffersPage {
	public WebDriver driver;
	public TestBase testBase;
	TestContextSetup testContextsetup;

	public OffersPage(WebDriver driver) {
		this.driver = driver;
	}

	private By search = By.xpath("//input[@type='search']");
	private By productName = By.cssSelector("tr td:nth-child(1)");

	public void searchItem(String name) {
		driver.findElement(search).sendKeys(name);
	}

	public void getSeaarchText() {
		driver.findElement(search).getText();
	}

	public String getProductName() {
		return driver.findElement(productName).getText();
	}

}
