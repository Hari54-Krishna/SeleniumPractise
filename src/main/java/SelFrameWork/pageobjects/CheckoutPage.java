package SelFrameWork.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import sel.abstractComponents.AbstractComponents;

public class CheckoutPage extends AbstractComponents {
 WebDriver driver;
	public CheckoutPage(WebDriver driver) {
		super(driver);
		this.driver=driver;
	}
	
	@FindBy(xpath="//input[@placeholder='Select Country']")
	WebElement dropDownClick;
	
	@FindBy(xpath="//section//div//button//span")
	List<WebElement> countries;
	@FindBy(xpath="//a[text()='Place Order ']")
	WebElement placeOrder;
	
	
	
	public void selectingCountrty(String search, String countryName) {
		dropDownClick.sendKeys(search);
		
		for(WebElement country:countries) {
			country.getText();
			if(country.getText().equalsIgnoreCase(countryName)){
				country.click();
				break;
			}
			}	
		placeOrder.click();
	}
	
	
	

}
