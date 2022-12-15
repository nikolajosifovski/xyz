package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GetValues {
	
	@Test
	public void testGetValueAttribute() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/obey-propaganda-hat");
		driver.manage().window().maximize();
		
		driver.findElement(By.id("product_enteredQuantity_31")).clear();
		driver.findElement(By.id("product_enteredQuantity_31")).sendKeys("3");
		
		WebElement e = driver.findElement(By.id("product_enteredQuantity_31"));
		String t = e.getAttribute("value");
		System.out.println(t);
		driver.quit();
		
	}

}
