package tests;

import multi.suite.test.Pages.testClassOne;

import org.testng.annotations.Test;


public class TestClassOneTest extends BaseTest {

	@Test
	public static void testOne()
	{
		//First test
		testClassOne.methodOne();
	}
}
