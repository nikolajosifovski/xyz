package exercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ElementLocators {
	
	WebDriver driver;
	String url = "https://rahulshettyacademy.com/AutomationPractice/";
	
	@BeforeMethod
	public void testSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);
		driver.manage().window().maximize();
		
	}
	@AfterMethod
	public void testTeardown() {
		//driver.quit();
	}
	
	@Test
	public void xpathTest() {
		
	}
	
	

}
