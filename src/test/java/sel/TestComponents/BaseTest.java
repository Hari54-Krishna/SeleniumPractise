package sel.TestComponents;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import com.google.common.io.Files;

import SelFrameWork.pageobjects.Loginpage;

public class BaseTest {
public	WebDriver driver;
public	Loginpage lp;
	
	public WebDriver Initializer() throws IOException {
		Properties prop = new Properties();
		//C:\Users\JESUS\OneDrive\Desktop\SelFrameWork\src\main\java\sel\resources\GlobalData.properties
		FileInputStream fis = new FileInputStream(("C:/Users/JESUS/OneDrive/Desktop/SelFrameWork/src/main/java/sel/resources/GlobalData.properties"));
		prop.load(fis);
		String browserName =  prop.getProperty("browser");
		if(browserName.equalsIgnoreCase("chrome")) {
			driver= new ChromeDriver();
		}
			else if(browserName.equalsIgnoreCase("firefox")) {
			 driver = new FirefoxDriver();
			}
		
			else if(browserName.equalsIgnoreCase("Edgebrowser")) {
				 driver = new EdgeDriver();
			}
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://rahulshettyacademy.com/client/dashboard/dash");
		return driver;
		}
	public String screenShot(String testcaseName, WebDriver driver) throws IOException {
		TakesScreenshot ts =(TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		File file = new File(System.getProperty("user.dir")+"//reports//"+testcaseName+".png");
		Files.copy(src, file);
		return System.getProperty("user.dir")+"//reports//"+testcaseName+".png";

		}
	@BeforeMethod(alwaysRun=true)
	public Loginpage launchOpenPage() throws IOException {
		driver= Initializer();
		 lp= new Loginpage(driver);
		return lp;   //=   lp.email("surampudi@gmail.com", "Hari9490@");
	}
	
	@AfterMethod(alwaysRun=true)
	public void tearDown() {
		driver.quit();
	}
	
	
	
		
	}


