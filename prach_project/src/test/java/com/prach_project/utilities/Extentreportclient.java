package com.prach_project.utilities;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import com.prach_project.testcases.Baseclass;

public class Extentreportclient extends Baseclass implements ITestListener {

	Utilities ut = new Utilities();

	ExtentSparkReporter htmlreport;
	ExtentReports ereport;
	ExtentTest test;

	public void configureReport() {

		htmlreport = new ExtentSparkReporter("Spark " + ut.dateFromHere() + ".html");
		ereport = new ExtentReports();
		ereport.attachReporter(htmlreport);

		ereport.setSystemInfo("author", "Dimple");
		ereport.setSystemInfo("OS", "Windows");
		ereport.setSystemInfo("module", "functional");

		htmlreport.config().setDocumentTitle("Day one html report for client");
		htmlreport.config().setReportName("first report");
		htmlreport.config().setTheme(Theme.DARK);
		htmlreport.config().setTimeStampFormat(ut.dateFromHere());

	}

	public void onStart(ITestContext result) {

		configureReport();
		System.out.println("onStart method invoked...........");

	}

	public void onFinish(ITestContext result) {

		System.out.println("onFinish method invoked...........");
		ereport.flush();

	}

	public void onTestStart(ITestResult result) {
//		String testname = result.getName();
//
//		System.out.println("onTestStart method executed : ..........." + testname);
//		test = ereport.createTest(testname).assignAuthor("Bakar").assignCategory("smoke test").assignDevice("this is in chrome");
//		test.log(Status.INFO, "test started successfully " + testname);
		
//		=== changing this for removing duplicates
		Baseclass bc = new Baseclass();
		bc.setupapp();   // if called here @beforetest will get problem
	}

	public void onTestSuccess(ITestResult result) {
		String testname = result.getName();

		System.out.println("onTestSuccess method executed : ..........." + testname);
		test = ereport.createTest(testname);
		test.log(Status.PASS, MarkupHelper.createLabel("this test is success " + testname, ExtentColor.GREEN));
	}

	public void onTestFailure(ITestResult result) {
		String testname = result.getName();

		System.out.println("onTestFailure method executed : ..........." + testname);
		System.out.println("onTestFailure method executed check it here : " + result.getThrowable());
		test = ereport.createTest(testname);
		test.log(Status.FAIL, MarkupHelper.createLabel("this test is failed " + testname, ExtentColor.RED));

		/*
		 * TakesScreenshot tss = (TakesScreenshot)driver; File src =
		 * tss.getScreenshotAs(OutputType.FILE); String dest =
		 * "C:\\Users\\kahme\\eclipse-workspace\\prach_project\\Screenshorts\\" + testname +"
		 * _"+ ut.dateFromHere() +".png"; File de = new File(dest); try {
		 * FileUtils.copyFile(src, de); } catch (IOException e) { // TODO Auto-generated
		 * catch block e.printStackTrace(); } test.addScreenCaptureFromPath(dest);
		 */
		/*
		 * you can use any one to take the screenshot (either above or below) below line
		 * will get the screenshot method from utilities
		 */

		ut.screenShotM(testname);
		String dest = null;
		test.addScreenCaptureFromPath(ut.screenShotM(dest));

	}

	public void onTestSkipped(ITestResult result) {
		String testname = result.getName();

		System.out.println("onTestSkipped method executed : ..........." + testname);
		test = ereport.createTest(testname);
		test.log(Status.SKIP, MarkupHelper.createLabel("this test is skipped " + testname, ExtentColor.YELLOW));
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {

	}

	public void onTestFailedWithTimeout(ITestResult result) {

	}

}
