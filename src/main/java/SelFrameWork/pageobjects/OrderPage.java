package SelFrameWork.pageobjects;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import sel.abstractComponents.AbstractComponents;

public class OrderPage extends AbstractComponents {
	
WebDriver driver; 
	public OrderPage(WebDriver driver) {	
		super(driver);
    this.driver=driver;		
	}
	@FindBy(xpath="//tr//td[2]")
	List<WebElement> productsInOrders;
	
	boolean b;
	public  boolean OrderConfirmation(String productName) {
		for(WebElement productInOrder: productsInOrders) {
			if(productInOrder.getText().equalsIgnoreCase(productName)) {
			 	productInOrder.getText();
			 	b=true;
				break;
			}
		}
		return b;
	}

}
