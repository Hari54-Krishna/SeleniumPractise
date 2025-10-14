package SelFrameWork.pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import sel.abstractComponents.AbstractComponents;

public class CartPage extends AbstractComponents {
    WebDriver driver;
	public CartPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	@FindBy(xpath="//button[text()='Checkout']")
	WebElement checkoutButton;
	public CheckoutPage clickOnCheckOut() {
		checkoutButton.click();
		CheckoutPage ck = new CheckoutPage(driver);
		return ck;
	}
	
	

}
