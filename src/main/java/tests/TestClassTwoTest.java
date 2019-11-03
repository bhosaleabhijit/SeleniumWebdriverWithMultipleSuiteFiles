package tests;

import multi.suite.test.Pages.TestClassTwo;

import org.testng.annotations.Test;

public class TestClassTwoTest extends BaseTest {

	@Test
	public static void testTwo() {
		TestClassTwo.methodTwo();
	}
}
