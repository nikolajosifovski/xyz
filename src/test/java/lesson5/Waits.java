package lesson5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits {
	
	WebDriver driver;

	
	
	@BeforeMethod
	public void s() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://demoqa.com/dynamic-properties");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

		
	}
	
	@AfterMethod 
	public void e() throws InterruptedException {
		Thread.sleep(3000);
		driver.close();
		
		
	}
	
	
	@Test
	public void testImplictit() {
		//Assert.assertEquals(driver.getCurrentUrl(), "https://www.saucedemo.com/inventory.html");
		
		WebElement btn = driver.findElement(By.id("visibleAfter"));
		Assert.assertEquals(btn.getText(), "Visible After 5 Seconds");
		
		
		
	}
	@Test
	public void testExplicitWait() {

		
		WebDriverWait wait = new WebDriverWait(driver, 20);
		WebElement btn = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("visibleAfter")));
		Assert.assertEquals(btn.getText(), "Visible After 5 Seconds");
	}

}
