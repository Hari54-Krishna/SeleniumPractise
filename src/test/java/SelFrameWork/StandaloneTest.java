package SelFrameWork;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
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
	public void submitOrderTest(String email, String password, String productName) throws InterruptedException, IOException {

		ProductCatalouge pc = lp.email(email, password);
		pc.addingProductsToArratlist(productName);
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
public Object[][] getData() {
return new Object[][] {{"surampudi@gmail.com","Hari9490@","ZARA COAT 3"},{"pavani1008@gmail.com","Pavani1008@","ADIDAS ORIGINAL"}};
}



}
