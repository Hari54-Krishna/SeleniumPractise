package SelFrameWork;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SubmitTestCase {
	
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
	    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/dashboard/dash");
		driver.findElement(By.id("userEmail")).sendKeys("surampudi@gmail.com");
		driver.findElement(By.id("userPassword")).sendKeys("Hari9490@");
		driver.findElement(By.id("login")).click();
		List<WebElement> products= driver.findElements(By.xpath("//div[@class='card']//b"));
		ArrayList<String> al = new ArrayList<String>();
		for(WebElement product: products) {
			String name = product.getText();
			if(name.equalsIgnoreCase("ADIDAS ORIGINAL")) {
				product.findElement(By.xpath(".//parent::h5/following-sibling::button[contains(text(),'Add To Cart')]")).click();
			}
			
		}
		System.out.println(al);	
//		for(WebElement product: products){
//			if(al.contains("ADIDAS ORIGINAL")) {
//				product.findElement(By.xpath(".//parent::h5/following-sibling::button[contains(text(),'Add To Cart')]")).click();
//				break;
//			}
//		}
		Thread.sleep(3000);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//ul//button[contains(text(),'Cart')]")));
		driver.findElement(By.xpath("//ul//button[contains(text(),'Cart')]")).click();
		driver.findElement(By.xpath("//button[contains(text(),'Checkout')]")).click();
		driver.findElement(By.xpath("//input[@placeholder='Select Country']")).sendKeys("ind");
		List<WebElement> countries = driver.findElements(By.xpath("//section//div//button//span"));
		for(WebElement country:countries) {
		country.getText();
		if(country.getText().equalsIgnoreCase("India")){
			country.click();
			break;
		}
		}
		
		driver.findElement(By.xpath("//a[text()='Place Order ']")).click();
		
			
	}

}
