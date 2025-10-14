package SelFrameWork.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import sel.abstractComponents.AbstractComponents;

public class Loginpage extends AbstractComponents {
	WebDriver driver;
	public Loginpage(WebDriver driver) {
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	

	@FindBy(id="userEmail")
	WebElement username ;
	
	@FindBy(id="userPassword")
	WebElement password;
	
	@FindBy(id="login")
	WebElement loginButton;
	
	@FindBy(xpath="//div[contains(text(),'*Enter Valid Email')]")
	WebElement emailErrorMsg;
	
	@FindBy(xpath="//div[@role='alert']")
	WebElement emailorPassworError;
	
	
	public ProductCatalouge email(String emailId, String passwordLogin) {
		username.sendKeys(emailId);
		password.sendKeys(passwordLogin);
		loginButton.click();
		ProductCatalouge pc = new ProductCatalouge(driver);
		return pc;
	}
	
	public String emailErrorMsgText() {
	String message = emailErrorMsg.getText();
	return message;
	}
	
	public String emailorPassworError()  {
		
		return emailorPassworError.getText();
	}
//	
//	public void goTo() {
//		driver.get("https://rahulshettyacademy.com/client/dashboard/dash");
//	}
	
	

}
