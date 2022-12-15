package lesson5;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Waits2 {
	
WebDriver driver;

	
	
	@BeforeMethod
	public void s() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/2");
		driver.manage().window().maximize();


		
	}
	
	@AfterMethod 
	public void e(){
		
		driver.quit();
			
	}
	
	@Test
	public void test1() {
		
		
		driver.findElement(By.xpath("//button[normalize-space()='Start']")).click();
		WebDriverWait w = new WebDriverWait(driver, 10);
		w.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id=\"finish\"]/h4")));
		
		String text = driver.findElement(By.xpath("//div[@id=\"finish\"]/h4")).getText();
		Assert.assertEquals(text, "Hello World!");
	}
	

}
