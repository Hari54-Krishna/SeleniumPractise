package SelFrameWork;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;



import SelFrameWork.pageobjects.Loginpage;
import SelFrameWork.pageobjects.ProductCatalouge;
import sel.TestComponents.BaseTest;
import sel.TestComponents.Retry;

public class ErrorValidationTest extends BaseTest {
	
@Test
 public void LoginErrorTest() throws IOException {
		ProductCatalouge pc=   lp.email("surampudi@.com", "Hari9@");  
		String name= lp.emailErrorMsgText();
		Assert.assertEquals(name, "*Enter Valid Email");
 }
@Test(groups={"smoke"}, retryAnalyzer = Retry.class)
public void incorrectEmailOrPassword() throws IOException {
	ProductCatalouge pc=   lp.email("surampudi@gmail.com.com", "Hi9@");  
	lp.emailorPassworError();
	Assert.assertEquals(lp.emailorPassworError(), "Incorrect email o password.");
}
}
