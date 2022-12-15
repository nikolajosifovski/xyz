package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import io.github.bonigarcia.wdm.WebDriverManager;

public class CheckBoxes {
	
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
		driver.quit();
	}
	
	@Test
	public void testCheckboxes() throws InterruptedException {
		WebElement checkbox1 = driver.findElement(By.name("checkBoxOption1"));
		WebElement checkbox2 = driver.findElement(By.name("checkBoxOption2"));
		checkbox1.click();
		Assert.assertTrue(checkbox1.isSelected());
		Assert.assertFalse(checkbox2.isSelected());
	
		Thread.sleep(5000);
		
		
		
	}

}
