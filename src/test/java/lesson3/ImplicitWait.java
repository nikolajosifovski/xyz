package lesson3;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class ImplicitWait {
	
	WebDriver driver;
	
	@Test
	public void implicit() {
		driver = WebDriverManager.chromedriver().create();
		driver.get("https://demoqa.com/dynamic-properties");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		

		WebElement btn = driver.findElement(By.id("visibleAfter"));
		Assert.assertTrue(btn.isDisplayed());
		btn.click();
		
		
		
	}

}
