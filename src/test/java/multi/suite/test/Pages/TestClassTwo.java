package multi.suite.test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class TestClassTwo extends BaseClass {

	public static void methodTwo()
	{
		driver.get("https://www.google.com");
		
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// Get search eleement
		WebElement searchbox = driver.findElement(By.name("q"));
		
		searchbox.sendKeys("This is Test Method Two.");
		
		
	}
}
