package exercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Clicking {
	
	WebDriver driver;
	String url = "https://demoqa.com/buttons";
	
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
	public void rightClick1() {
		WebElement right = driver.findElement(By.id("rightClickBtn"));
		Actions rightClick = new Actions(driver);
		rightClick.contextClick(right).build().perform();
		
		String rightClickMsg = driver.findElement(By.id("rightClickMessage")).getText();

		Assert.assertEquals("You have done a right click", rightClickMsg);
		
	}
	
	@Test
	public void testDoubleClick() {
		WebElement dobleClickBtn = driver.findElement(By.id("doubleClickBtn"));
		Actions dbClick = new Actions(driver);
		dbClick.doubleClick(dobleClickBtn).build().perform();
		
		String dbClickMsg = driver.findElement(By.id("doubleClickMessage")).getText();
		Assert.assertEquals("You have done a double click", dbClickMsg);
	
	}
	
	@Test
	public void testMouseOver() {
		driver.navigate().to("https://the-internet.herokuapp.com/hovers");
		
		WebElement img1 = driver.findElement(By.xpath("(//img[@alt=\"User Avatar\"])[1]"));
		
		WebElement viewProfile = driver.findElement(By.xpath("//a[@href=\"/users/1\"]"));

		
		Assert.assertFalse(viewProfile.isDisplayed());
		
		Actions hover = new Actions(driver);
		hover.moveToElement(img1).build().perform();
		
		Assert.assertTrue(viewProfile.isDisplayed());
	}
	
	

}
