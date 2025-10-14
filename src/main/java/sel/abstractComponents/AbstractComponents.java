package sel.abstractComponents;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import SelFrameWork.pageobjects.CartPage;
import SelFrameWork.pageobjects.OrderPage;

public class AbstractComponents {
	
	WebDriver driver ;

	public AbstractComponents(WebDriver driver) {
  this.driver= driver;
 PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(xpath="//ul//button[contains(text(),'Cart')]")
	WebElement cartPage;
	
	@FindBy(xpath="//ul//li//button[@routerlink='/dashboard/myorders']")
		WebElement orderPage;
	
	

	
	
	
	public void WaitingForVisibility(List<WebElement> prodcts) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10)) ;
		
		wait.until(ExpectedConditions.visibilityOfAllElements(prodcts));
			
		
	}
	
	
	public CartPage clickOnCartPage() {
		cartPage.click();
		CartPage cp = new CartPage(driver);
		return cp;
	}
	
	public OrderPage orderPageClick() {
	orderPage.click();
	OrderPage op = new OrderPage(driver);
	return op;
	
	}
	
	
	

	
	 

}
