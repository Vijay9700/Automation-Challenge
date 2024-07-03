package listener;

import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ISuite;
import org.testng.ISuiteListener;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import base_test.Base_Test;

/**
 * @author Vijay Ganesan
 */
public class Listener_Implementation implements ITestListener, ISuiteListener {
	public ExtentReports report;
	public static ExtentTest test;

	@Override
	public void onStart(ISuite suite) {
		System.out.println("Report confifguration");
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		ExtentSparkReporter spark = new ExtentSparkReporter("./AdvanceReport/report_" + time + ".html");
		spark.config().setDocumentTitle("CRM Test Suite Results");
		spark.config().setReportName("CRM Report");
		spark.config().setTheme(Theme.DARK);
		// add Env information & create test
		report = new ExtentReports();
		report.attachReporter(spark);
		report.setSystemInfo("OS", "Windows-11");
		report.setSystemInfo("BROWSER", "CHROME-126.0.6478.127");
	}

	@Override
	public void onFinish(ISuite suite) {
		System.out.println("Report backUP");
		report.flush();
	}

	@Override
	public void onTestStart(ITestResult result) {
		System.out.println("===== =====>" + result.getMethod().getMethodName() + ">===START======");
		test = report.createTest(result.getMethod().getMethodName());
		test.log(Status.INFO, result.getMethod().getMethodName() + "==> STARTED <====");
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		System.out.println("===== =====>" + result.getMethod().getMethodName() + ">=====END======");
		test.log(Status.PASS, result.getMethod().getMethodName() + "==> COMPLETED <====");
	}

	@Override
	public void onTestFailure(ITestResult result) {
		String testNAme = result.getMethod().getMethodName();
		TakesScreenshot eDriver = (TakesScreenshot) Base_Test.driver;
		String filePath = eDriver.getScreenshotAs(OutputType.BASE64);
		String time = new Date().toString().replace(" ", "_").replace(":", "_");
		test.addScreenCaptureFromBase64String(filePath, testNAme + "_" + time);
		test.log(Status.FAIL, result.getMethod().getMethodName() + "==> FAILED <====");
	}

}
