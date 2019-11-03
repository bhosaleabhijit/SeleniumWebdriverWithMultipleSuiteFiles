package multi.suite.test.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class testClassOne extends BaseClass {

	public static void methodOne()
	{
		driver.get("https://www.google.com");
		
		WebElement searchbox = driver.findElement(By.name("q"));
		
		searchbox.sendKeys("This is Test Method One.");
		
		
	}
}
