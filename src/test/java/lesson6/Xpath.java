package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Xpath {
	
	@Test
	public void testXpath() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("http://uitestingplayground.com/dynamictable");
		driver.manage().window().maximize();
		
		WebElement chromeValue = driver.findElement(By.xpath("//span[contains(text(),'Chrome')]//following-sibling::span[contains(text(),'%')]"));
		String tableValue = chromeValue.getText();
		System.out.println(tableValue);
		WebElement second = driver.findElement(By.xpath("//p[@class=\"bg-warning\"]"));
		String secValue = second.getText();
		System.out.println(secValue);
		String replace = secValue.replace("Chrome CPU: ", "");
		System.out.println(replace);
		
		Assert.assertEquals(tableValue, replace);
		
		driver.quit();
	}

}
