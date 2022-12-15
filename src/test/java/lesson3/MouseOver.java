package lesson3;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class MouseOver {
		
	@Test
	public void testMouseOver() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		
		WebElement mo = driver.findElement(By.xpath("//button[@id=\"mousehover\"]"));
		WebElement top = driver.findElement(By.xpath("//*[@class=\"mouse-hover-content\"]//a[@href=\"#top\"]"));
		
		Actions a = new Actions(driver);
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", mo);
		
		a.moveToElement(mo).perform();
		Assert.assertTrue(top.isDisplayed());
		top.click();
		Assert.assertEquals(driver.getCurrentUrl(), "https://rahulshettyacademy.com/AutomationPractice/#top");
		
		
		
	}
	@Test
	public void testMouseOver2() {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/hovers");
		driver.manage().window().maximize();
		
		WebElement icon2 = driver.findElement(By.xpath("(//img[@src=\"/img/avatar-blank.jpg\"])[2]"));
		
		Actions a = new Actions(driver);
		
		a.moveToElement(icon2).perform();
		
		Assert.assertTrue(driver.findElement(By.xpath("//h5[normalize-space()='name: user2']")).isDisplayed());
		
	}

}
