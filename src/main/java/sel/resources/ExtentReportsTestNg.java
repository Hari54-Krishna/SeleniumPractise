package sel.resources;

import com.aventstack.extentreports.*;
import com.aventstack.extentreports.reporter.*;
	

public class ExtentReportsTestNg {
	public  ExtentReports getReportObject() {
		String path= System.getProperty("user.dir")+"//reports//index.html";
		  ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		  reporter.config().setReportName("Automation results");
		  reporter.config().setDocumentTitle("Test Results");
		  ExtentReports extent = new ExtentReports();
		  extent.attachReporter(reporter);
		  extent.setSystemInfo("Tester", "HariSurampudi");
		  return extent;
		  
	}

}
