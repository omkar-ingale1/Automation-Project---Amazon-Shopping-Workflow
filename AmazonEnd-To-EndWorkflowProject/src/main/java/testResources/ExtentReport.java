package testResources;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReport {

	
	public static  ExtentReports getReportObject()
	{
		String path = System.getProperty("user.dir")+"//Reports//TestReport.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setDocumentTitle("TestResults");		
		reporter.config().setReportName("Amazon Automation Test Report");
				
		ExtentReports extent = new ExtentReports	();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Automation QA Engineer", "Omkar");
		return extent;
				
				
				
				
				
				
	}
	
}
