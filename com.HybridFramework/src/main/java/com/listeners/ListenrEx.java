package com.listeners;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.Utility.DriverUtils;
import com.Utility.ReportUtils;
import com.aventstack.extentreports.Status;

public class ListenrEx implements ITestListener{

	public void onFinish(ITestContext result) {
		ReportUtils.report.flush();// to save the report
		
	}

	public void onStart(ITestContext result) {
		ReportUtils.reportInit();
		
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
		
	}

	public void onTestFailure(ITestResult result) {
		ReportUtils.test.log(Status.FAIL, "testcase failed with name: "+result.getName());
		String path = DriverUtils.getScreenshot(result.getName());
		ReportUtils.test.addScreenCaptureFromPath(path);
	}

	public void onTestSkipped(ITestResult result) {
		ReportUtils.test.log(Status.SKIP, "testcase skipped with name: "+result.getName());
		
	}

	public void onTestStart(ITestResult result) {
		ReportUtils.test= ReportUtils.report.createTest(result.getName());
		
	}

	public void onTestSuccess(ITestResult result) {
		ReportUtils.test.log(Status.PASS, "testcase passed with name: "+result.getName());
		
	}

	
}
