package lesson5;

import java.util.concurrent.TimeUnit;

import org.hamcrest.core.IsEqual;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import static org.assertj.core.api.Assertions.assertThat;

import com.github.dockerjava.api.model.Driver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Vezba1 {
	
	WebDriver driver;
	
	@BeforeMethod
	public void testSetup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
	}
	
	
	@AfterMethod
	public void testTeardown() {
		//driver.close();
	}
	@Test
	public void test1() {
		Actions a = new Actions(driver);
		a.moveToElement(driver.findElement(By.xpath("(//li/a[@href=\"/apparel\"])[1]"))).perform();
		driver.findElement(By.xpath("(//li/a[@href=\"/clothing\"])[1]")).click();
		driver.findElement(By.id("small-searchterms")).sendKeys("nike");
		//Thread.sleep(3000);
		String text3 = driver.findElement(By.xpath("(//li[@class=\"ui-menu-item\"])[3]")).getText();
		System.out.println(text3);
		driver.findElement(By.id("small-searchterms")).sendKeys(Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);


		String productName = driver.findElement(By.xpath("//div[@class=\"product-name\"]/h1")).getText();
		Assert.assertEquals(text3, productName);
		assertThat(text3.equalsIgnoreCase(productName)).isTrue();
		
		driver.close();
	}
	
	
	
		

}
