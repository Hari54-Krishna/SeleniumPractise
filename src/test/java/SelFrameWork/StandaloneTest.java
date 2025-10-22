package SelFrameWork;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.google.common.io.Files;

import SelFrameWork.pageobjects.CartPage;
import SelFrameWork.pageobjects.CheckoutPage;
import SelFrameWork.pageobjects.Loginpage;
import SelFrameWork.pageobjects.OrderPage;
import SelFrameWork.pageobjects.ProductCatalouge;
import sel.TestComponents.BaseTest;

public class StandaloneTest extends BaseTest {
	String productName2 = "ZARA COAT 3";

	@Test(dataProvider="getData", groups= {"submitorder"})
	public void submitOrderTest(HashMap<String,String> input) throws InterruptedException, IOException {

		ProductCatalouge pc = lp.email(input.get("email"), input.get("password"));
		pc.addingProductsToArratlist(input.get("product"));
	//	pc.clickOnProduct(productName);
		Thread.sleep(3000);
		CartPage cp = pc.clickOnCartPage();
		CheckoutPage ck = cp.clickOnCheckOut();
		ck.selectingCountrty("ind", "india");

	}
@Test(dependsOnMethods = "submitOrderTest")
	public void productConfirmation() {
		ProductCatalouge pc = lp.email("surampudi@gmail.com", "Hari9490@");
		OrderPage op = pc.orderPageClick();
		Assert.assertTrue(op.OrderConfirmation(productName2));

	}

@DataProvider
public Object[][] getData() throws Exception {
List<HashMap<String,String>> data=	readDataAndConvertToMap(System.getProperty("user.dir")+"\\src\\test\\java\\sel\\data\\purchaseOrder.json");
	
	return new Object[][] {{data.get(0)},{data.get(1)}};
	
}
//}
//@DataProvider
//public Object[][] getData() {
//	
//return new Object[][] {{"surampudi@gmail.com","Hari9490@","ZARA COAT 3"},{"pavani1008@gmail.com","Pavani1008@","ADIDAS ORIGINAL"},};

//HashMap<String, String> map = new HashMap<String,String>();
//map.put("email", "surampudi@gmail.com");
//map.put("password", "Hari9490@");
//map.put("product", "ZARA COAT 3");
//HashMap<String, String> map1 = new HashMap<String,String>();
//map1.put("email", "pavani1008@gmail.com");
//map1.put("password", "Pavani1008@");
//map1.put("product", "ADIDAS ORIGINAL");

}

