package multi.suite.test.Pages;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BaseClass {
	
	protected static WebDriver driver = null;
	
	public static void initializeDriver()
	{
		WebDriverManager.chromedriver().setup();		
	//	System.setProperty("webdriver.chrome.driver", "G:\\Automation Softwares\\Selenium\\Drivers\\chromedriver.exe");
		driver = new ChromeDriver();
	}

	public static void closeDriver() {
		driver.quit();
		
	}
	
}
