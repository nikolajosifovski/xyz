package lesson5;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Frames {

	WebDriver driver;
	
	@BeforeMethod
	public void s() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get("https://bonigarcia.dev/selenium-webdriver-java/frames.html");
		driver.manage().window().maximize();
	}
	
	
	@Test
	public void testFrame() {
		String frameName2 = "frame-body";
		String frameFooter = "frame-footer";
		
		driver.switchTo().frame(frameName2);
		
		
		
		String str = driver.findElement(By.xpath("//p[@class=\"lead\"]/b")).getText();
		System.out.println(str);
		
		
		driver.switchTo().parentFrame();
		driver.switchTo().frame(frameFooter);
		String text2 = driver.findElement(By.xpath("//span[@class=\"text-muted\"]")).getText();
		Assert.assertEquals(text2, "Copyright © 2021-2022 Boni García");
		
		
	}
}
