package SelFrameWork.pageobjects;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sel.abstractComponents.AbstractComponents;

public class ProductCatalouge extends AbstractComponents {
	WebDriver driver;
	public ProductCatalouge(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(xpath="//div[@class='card']//b")
	List<WebElement> products ;
	
	
	By productToCart = By.xpath(".//parent::h5/following-sibling::button[contains(text(),'Add To Cart')]");
	ArrayList<String> al;
	public ArrayList<String> addingProductsToArratlist(String nameOfProduct) {
		WaitingForVisibility(products);
		 al= new ArrayList<String>();
		for(WebElement product:products) {
			al.add(product.getText());
			String name= product.getText();
			if(name.equalsIgnoreCase(nameOfProduct)) {
				product.findElement((productToCart)).click();
			}
		}
		return al;		
	}
//public void	clickOnProduct(String nameOfProduct) {
//	for(WebElement product: products){
//		if(al.contains(nameOfProduct)) {
//			product.findElement((productToCart)).click();
//			break;
//		}
//	}

	
	
	
	


}
