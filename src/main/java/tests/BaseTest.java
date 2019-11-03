package tests;

//import java.io.IOException;
//import java.lang.reflect.Method;

//import org.testng.ITestResult;
import multi.suite.test.Pages.BaseClass;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
//import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
//import org.testng.annotations.Optional;
//import org.testng.annotations.Parameters;
//import org.testng.annotations.Test;

public class BaseTest {
	
	// Before test
	@BeforeTest
	public void setTestRunEnvironment() {
		System.out.println("Set Test Run Method Before Test.");
	}

	
	@BeforeClass
	public void initializeDriver() {
		System.out.println("Initialize driver method Before Class.");
		BaseClass.initializeDriver();
	}

	@BeforeMethod
	public void beforeMethodSetUp() {
		System.out.println("After method.");
	}

	@AfterMethod
//	public void afterMethod(ITestResult result) throws IOException {
	public void afterMethod() {	
		System.out.println("After Method.");
	}

	@AfterClass
	public void classTearDown() {
		System.out.println("After class.");
	}

	 
	 @AfterTest 
	 public void tearDown() 
	 { 
		 BaseClass.closeDriver();
		 System.out.println("After Test. Closed Driver");
		 
	 }
}
