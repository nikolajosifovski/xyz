package exercises;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverManager {
	
	WebDriver driver;
	String baseURL = "https://rahulshettyacademy.com/AutomationPractice/";
	
	
	@Test
	public void testOne() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		
		driver.get(baseURL);
		
		
	}
	@Test
	public void testOnFF() {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
		driver.get(baseURL);
	}
	
	@Test
	public void testOnEdge() {
		WebDriverManager.edgedriver().setup();
		driver = new EdgeDriver();
		driver.get(baseURL);
		driver.manage().window().maximize();
	}

}
